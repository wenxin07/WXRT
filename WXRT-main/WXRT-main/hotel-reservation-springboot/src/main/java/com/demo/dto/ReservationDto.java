package com.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservationDto {

	Long getid();

	String getGuestName();

	LocalTime getCheckInDate();

	LocalTime getEstimatedCheckInTime();

	LocalDate getCheckOutDate();

}
