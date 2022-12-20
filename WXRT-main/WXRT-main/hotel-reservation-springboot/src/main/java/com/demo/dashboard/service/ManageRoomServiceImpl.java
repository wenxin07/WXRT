package com.demo.dashboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.dashboard.dao.ManageRoomRepository;
import com.demo.domain.Room;

@Service
public class ManageRoomServiceImpl implements ManageRoomService {

	@Autowired
	private ManageRoomRepository rDao;

	@Override
	public List<Room> getAllRooms() {
		return rDao.findAll();
	}

	@Override
	public void saveRoom(Room room) {
		this.rDao.save(room);

	}

	@Override
	public Room getRoomById(Long id) {
		Optional<Room> optionalRoom = rDao.findById(id);
		Room room = null;
		if (optionalRoom.isPresent()) {
			room = optionalRoom.get();
		} else {
			throw new RuntimeException("找不到房間id : " + id);
		}
		return room;
	}

	@Override
	public void deleteRoomById(Long id) {
		this.rDao.deleteById(id);
	}

	@Override
	public Page<Room> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.rDao.findAll(pageable);
	}

}
