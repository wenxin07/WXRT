package com.demo.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.domain.Reservation;
import com.demo.dto.ReservationDto;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query(value = "select reservation.id, guest.first_name+''+guest.last_name as guestName, reservation.check_in_date as checkInDate,\r\n"
			+ "reservation.estimated_check_in_time as estimatedCheckInTime, reservation.check_out_date as checkOutDate\r\n"
			+ "from guest\r\n" + "inner join reservation_guests\r\n" + "on guest.id = reservation_guests.guest_id\r\n"
			+ "inner join reservation\r\n"
			+ "on reservation_guests.reservation_id = reservation.id", nativeQuery = true)
	List<ReservationDto> findAllReservation();

}
