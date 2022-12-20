package com.demo.domain.location;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

	@Column(nullable = false)
	@NotEmpty(message = "required")
	@NotNull(message = "required")
	private String streetLine1;

	@Column(nullable = false)
//  @Enumerated(EnumType.STRING)
	private String city; // City city

	public Address(String streetLine1, String city) {
		this.streetLine1 = streetLine1;
		this.city = city;
	}

	public Address() {
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((streetLine1 == null) ? 0 : streetLine1.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Address [streetLine1=" + streetLine1 + ", city=" + city + "]";
	}

}
