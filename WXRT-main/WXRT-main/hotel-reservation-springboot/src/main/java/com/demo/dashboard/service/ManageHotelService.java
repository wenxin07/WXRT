package com.demo.dashboard.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.domain.Hotel;

public interface ManageHotelService {
	List<Hotel> getAllHotels();

	void saveHotel(Hotel hotel);

	Hotel getHotelById(Long id);
	
	void deleteHotelById(Long id);

	Page<Hotel> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
