package com.demo.dashboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Room;

public interface ManageRoomRepository extends JpaRepository<Room, Long> {

}
