package com.demo.domain;

import javax.persistence.*;
import javax.validation.Valid;

import com.demo.member.entity.Member;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Reservation {
	public static final double TAX_AMOUNT = 0.10;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private UUID reservationId = UUID.randomUUID();
	@OneToOne(mappedBy = "reservation")
	private Room room;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "reservation_guests", joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"))
	private Set<Guest> guests = new HashSet<>();

	@Embedded
	@Valid
	private ReservationDates dates = new ReservationDates();

	@OneToOne(cascade = CascadeType.ALL)
	private CompletedPayment completedPayment;

	@Column(nullable = false)
	private LocalDateTime createdTime;

	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	/**
	 * @return The time this {@code Reservation} was successfully paid for and
	 *         persisted.
	 */
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public Reservation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public CompletedPayment getCompletedPayment() {
		return completedPayment;
	}

	public void setCompletedPayment(CompletedPayment completedPayment) {
		createdTime = LocalDateTime.now();
		this.completedPayment = completedPayment;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * Use the utility functions add/remove guest to perform changes.
	 *
	 * @return The unmodifiable set of {@code Guest}s.
	 */
	public Set<Guest> getGuests() {
		return Collections.unmodifiableSet(guests);
	}

	/**
	 * Add a guest only if the room has free beds.
	 *
	 * @param guest The guest to add.
	 */
	public void addGuest(Guest guest) {
		if (!isRoomFull()) {
			guests.add(guest);
		}
	}

	public void clearGuests() {
		guests.clear();
	}

	/**
	 * Allows UI to easily remove a {@code Guest} in the 'add guest' page. Its
	 * easier for the UI to 'POST' a guest id rather than provide the full
	 * {@code Guest} details that match {@code Guest.equals/hashCode}.
	 *
	 * @param guestId The temporarily assigned guest id.
	 * @return {@code true} if the {@code Guest} was removed otherwise
	 *         {@code false}.
	 */
	public boolean removeGuestById(UUID guestId) {
		return guests.removeIf(guest -> guest.getTempId().equals(guestId));
	}

	public UUID getReservationId() {
		return reservationId;
	}

	public ReservationDates getDates() {
		return dates;
	}

	public void setDates(ReservationDates dates) {
		this.dates = dates;
	}

	public boolean isRoomFull() {
		return guests.size() >= room.getBeds();
	}

	public boolean hasGuests() {
		return !guests.isEmpty();
	}

	public boolean hasAtLeastOneAdultGuest() {
		return guests.stream().anyMatch(guest -> !guest.isChild());
	}

	/**
	 * Calculates {@code Extra.Type} to correctly charge the food and general
	 * extras.
	 *
	 * @return Depending on the room type, return {@code Extra.Type.Premium/Basic}.
	 */
//    public Extra.Type getExtraPricingType() {
//        switch (room.getRoomType()) {
//            case Luxury:
//            case Business:
//                return Extra.Type.Premium;
//            default:
//                return Extra.Type.Basic;
//        }
//    }
	/**
	 * Calculates the chargeable late fee price only if the user has selected the
	 * late checkout option.
	 */
	public Integer getChargeableLateCheckoutFee() {
		return dates.isLateCheckout() ? getLateCheckoutFee() : 0;
	}

	/**
	 * The late checkout fee depending on the type of room. For the actual
	 * chargeable fee, use {@link #getChargeableLateCheckoutFee()}
	 */
	public Integer getLateCheckoutFee() {
		switch (room.getRoomType()) {
		case "?????????":
		case "?????????":
			return 0;
		default:
			return room.getHotel().getLateCheckoutFee();
		}
	}

	/**
	 * No late fee is considered. Provided separately to allow break down to sub
	 * totals on invoices.
	 *
	 * @return Total nights * per night cost
	 */
	public Integer getTotalRoomCost() {
		long nights = dates.totalNights();
		if (nights == 0) {
			return 0;
		}
		return (int) (room.getCostPerNight() * nights);
	}

	/**
	 * Provided separately to allow break down to sub totals on invoices.
	 *
	 * @return {@link #getTotalRoomCost} + {@link #getChargeableLateCheckoutFee}
	 */
	public Integer getTotalRoomCostWithLateCheckoutFee() {
		return getTotalRoomCost() + getChargeableLateCheckoutFee();
	}

	/**
	 * Calculates the total general extras cost. Provided separately to allow break
	 * down to sub totals on invoices.
	 * <p>
	 * {@code Daily extra cost * total nights}
	 */
	public Integer getTotalGeneralExtrasCost() {
//        long totalNights = dates.totalNights();
//        return generalExtras.stream().reduce(
//                BigDecimal.ZERO,
//                (acc, next) -> acc.add(next.getTotalPrice(totalNights))
//                , BigDecimal::add
//        );
		return 0;
	}

	/**
	 * Provided separately to allow break down to sub totals on invoices.
	 *
	 * @return Total cost of all guests meal plans
	 */
	public void getTotalMealPlansCost() {
//        return mealPlans.stream()
//                .map(MealPlan::getTotalMealPlanCost)
//                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add);
	}

	/**
	 * Total cost including everything! Provided separately to allow break down to
	 * sub totals on invoices.
	 */
	public Integer getTotalCostExcludingTax() {
		return getTotalRoomCostWithLateCheckoutFee() + getTotalGeneralExtrasCost();
	}

	/**
	 * Provided separately to allow break down to sub totals on invoices.
	 *
	 * @return The taxable amount from the total cost. Eg 10% of $100 = $10.
	 */
	public Double getTaxableAmount() {
		return getTotalCostExcludingTax() * (TAX_AMOUNT);
	}

	/**
	 * Provided separately to allow break down to sub totals on invoices.
	 *
	 * @return The total cost including tax.
	 */
	public Integer getTotalCostIncludingTax() {
		return (int) (getTotalCostExcludingTax() + getTaxableAmount());
	}

	/**
	 * Since {@link #createMealPlans} creates a meal plan for each {@code Guest}.
	 * Simply checking the list size is not going to tell you if the meal plans are
	 * empty. Instead empty is defined by the total being zero dollars.
	 *
	 * @return {@code true} if all meal plans add up to 0.
	 */
	public boolean hasEmptyMealPlans() {
//        return mealPlans.stream()
//                .map(MealPlan::getTotalMealPlanCost)
//                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add)
//                .equals(BigDecimal.ZERO);
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Reservation that = (Reservation) o;
		return Objects.equals(reservationId, that.reservationId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reservationId);
	}
}