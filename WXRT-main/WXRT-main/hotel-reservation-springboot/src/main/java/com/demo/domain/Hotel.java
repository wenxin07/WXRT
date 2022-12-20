package com.demo.domain;

import com.demo.domain.location.Address;
import com.demo.util.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private String website;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    // Stop bidirectional relationship which cause a cycle.
    @JsonIgnore
    private Set<Room> rooms;

    @Column(nullable = false)
    private LocalTime earliestCheckInTime;

    @Column(nullable = false)
    private LocalTime latestCheckInTime;

    @Column(nullable = false)
    private LocalTime standardCheckOutTime;

    @Column(nullable = false)
    private LocalTime latestCheckOutTime;

    @Column(nullable = false)
    private Integer lateCheckoutFee;

    private final static LocalTime DEFAULT_EARLIEST_CHECK_IN = LocalTime.of(7, 0);
    private final static LocalTime DEFAULT_LATEST_CHECK_IN = LocalTime.of(22, 0);
    private final static LocalTime DEFAULT_STANDARD_CHECKOUT = LocalTime.of(11, 0);
    private final static LocalTime DEFAULT_LATEST_CHECKOUT = LocalTime.of(22, 0);
    private final static Integer DEFAULT_LATE_CHECKOUT_FEE = Integer.valueOf(300);

    public Hotel(String name, Address address, int stars, String website) {
        this(name, address, stars, website,
                DEFAULT_EARLIEST_CHECK_IN,
                DEFAULT_LATEST_CHECK_IN,
                DEFAULT_STANDARD_CHECKOUT,
                DEFAULT_LATEST_CHECKOUT,
                DEFAULT_LATE_CHECKOUT_FEE);
    }

    public Hotel(String name, Address address, int stars, String website,
                 LocalTime earliestCheckInTime,
                 LocalTime latestCheckInTime,
                 LocalTime standardCheckOutTime,
                 LocalTime latestCheckOutTime,
                 Integer defaultLateCheckoutFee) {
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.website = website;
        this.rooms = new HashSet<>();
        this.earliestCheckInTime = earliestCheckInTime;
        this.latestCheckInTime = latestCheckInTime;
        this.standardCheckOutTime = standardCheckOutTime;
        this.latestCheckOutTime = latestCheckOutTime;
        this.lateCheckoutFee = defaultLateCheckoutFee;
    }

    public Hotel() {
    }

    /**
     * Adds the {@code Room} to this {@code Hotel} and sets the bidirectional relationship
     * of the {@code Room}.
     */
    public void addRoom(Room room) {
        rooms.add(room);
        room.setHotel(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAddress(Address address) {
    	this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public LocalTime getEarliestCheckInTime() {
        return earliestCheckInTime;
    }

    public void setEarliestCheckInTime(LocalTime earliestCheckInTime) {
        this.earliestCheckInTime = earliestCheckInTime;
    }

    public LocalTime getLatestCheckInTime() {
        return latestCheckInTime;
    }

    public void setLatestCheckInTime(LocalTime latestCheckInTime) {
        this.latestCheckInTime = latestCheckInTime;
    }

    public LocalTime getStandardCheckOutTime() {
        return standardCheckOutTime;
    }

    public void setStandardCheckOutTime(LocalTime standardCheckOutTime) {
        this.standardCheckOutTime = standardCheckOutTime;
    }

    public LocalTime getLatestCheckOutTime() {
        return latestCheckOutTime;
    }

    public void setLatestCheckOutTime(LocalTime latestCheckOutTime) {
        this.latestCheckOutTime = latestCheckOutTime;
    }

    public Integer getLateCheckoutFee() {
        return lateCheckoutFee;
    }

    public void setLateCheckoutFee(Integer lateCheckoutFee) {
        this.lateCheckoutFee = lateCheckoutFee;
    }

    /**
     * Generates range of allowable check in times spanning from the earliest to latest times for this hotel.
     * <p>This provides an estimated check in time to help staff organise the room.</p>
     */
    public List<LocalTime> allowableCheckInTimes() {
        long span = ChronoUnit.HOURS.between(earliestCheckInTime, latestCheckInTime) + 1;

        return Stream.iterate(earliestCheckInTime, time -> time.plusHours(1))
                .limit(span)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(address, hotel.address) &&
                Objects.equals(website, hotel.website);
    }

    @Override
    public int hashCode() {

        return Objects.hash(address, website);
    }

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", stars=" + stars + ", website="
				+ website + ", rooms=" + rooms + ", earliestCheckInTime=" + earliestCheckInTime + ", latestCheckInTime="
				+ latestCheckInTime + ", standardCheckOutTime=" + standardCheckOutTime + ", latestCheckOutTime="
				+ latestCheckOutTime + ", lateCheckoutFee=" + lateCheckoutFee + "]";
	}

   
}
