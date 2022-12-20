package com.demo.dto;

public class RoomDto {

	Long hotelId;

	String roomType;

	String roomNumber;

	Integer beds;

	Integer costPerNight;

	public RoomDto() {

	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(Integer costPerNight) {
		this.costPerNight = costPerNight;
	}

	@Override
	public String toString() {
		return "RoomDto [hotelId=" + hotelId + ", roomType=" + roomType + ", roomNumber=" + roomNumber + ", beds="
				+ beds + ", costPerNight=" + costPerNight + "]";
	}

}
