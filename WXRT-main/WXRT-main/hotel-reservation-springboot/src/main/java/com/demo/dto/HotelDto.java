package com.demo.dto;

public class HotelDto {

	private String name;

	private String address;

	private int stars;

	private String website;

	private String earliestCheckInTime;

	private String latestCheckInTime;

	private String standardCheckOutTime;
	
	private String latestCheckOutTime;
	
	private Integer lateCheckoutFee;

	public HotelDto() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEarliestCheckInTime() {
		return earliestCheckInTime;
	}

	public void setEarliestCheckInTime(String earliestCheckInTime) {
		this.earliestCheckInTime = earliestCheckInTime;
	}

	public String getLatestCheckInTime() {
		return latestCheckInTime;
	}

	public void setLatestCheckInTime(String latestCheckInTime) {
		this.latestCheckInTime = latestCheckInTime;
	}

	public String getStandardCheckOutTime() {
		return standardCheckOutTime;
	}

	public void setStandardCheckOutTime(String standardCheckOutTime) {
		this.standardCheckOutTime = standardCheckOutTime;
	}

	public String getLatestCheckOutTime() {
		return latestCheckOutTime;
	}

	public void setLatestCheckOutTime(String latestCheckOutTime) {
		this.latestCheckOutTime = latestCheckOutTime;
	}

	public Integer getLateCheckoutFee() {
		return lateCheckoutFee;
	}

	public void setLateCheckoutFee(Integer lateCheckoutFee) {
		this.lateCheckoutFee = lateCheckoutFee;
	}

	@Override
	public String toString() {
		return "HotelDto [name=" + name + ", address=" + address + ", stars=" + stars + ", website=" + website
				+ ", earliestCheckInTime=" + earliestCheckInTime + ", latestCheckInTime=" + latestCheckInTime
				+ ", standardCheckOutTime=" + standardCheckOutTime + ", latestCheckOutTime=" + latestCheckOutTime
				+ ", lateCheckoutFee=" + lateCheckoutFee + "]";
	}

	
	
	
}
