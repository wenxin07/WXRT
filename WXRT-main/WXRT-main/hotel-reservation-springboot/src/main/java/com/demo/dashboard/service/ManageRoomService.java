package com.demo.dashboard.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.domain.Room;

public interface ManageRoomService {
	List<Room> getAllRooms();

	void saveRoom(Room room);

	Room getRoomById(Long id);

	void deleteRoomById(Long id);

	Page<Room> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
