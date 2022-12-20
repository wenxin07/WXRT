package com.demo.dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.dashboard.dao.ManageHotelRepository;
import com.demo.domain.Hotel;

@Service
public class ManageHotelServiceImpl implements ManageHotelService {

	@Autowired
	private ManageHotelRepository mDao;

	@Override
	public List<Hotel> getAllHotels() {
		return mDao.findAll();
	}

	@Override
	public void saveHotel(Hotel hotel) {
		this.mDao.save(hotel);
	}

	@Override
	public Hotel getHotelById(Long id) {
		Optional<Hotel> optionalHotel = mDao.findById(id);
		Hotel hotel = null;
		if (optionalHotel.isPresent()) {
			hotel = optionalHotel.get();
		} else {
			throw new RuntimeException("找不到飯店id : " + id);
		}
		return hotel;
	}

	@Override
	public void deleteHotelById(Long id) {
		this.mDao.deleteById(id);
	}

	@Override
	public Page<Hotel> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.mDao.findAll(pageable);
	}
}
