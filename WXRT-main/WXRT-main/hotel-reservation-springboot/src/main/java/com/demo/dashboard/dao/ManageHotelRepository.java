package com.demo.dashboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Hotel;

public interface ManageHotelRepository extends JpaRepository<Hotel, Long> {

}
