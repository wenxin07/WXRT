package com.demo.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dashboard.service.ManageHotelService;
import com.demo.dashboard.service.ManageRoomService;
import com.demo.domain.Hotel;
import com.demo.domain.Room;
import com.demo.dto.RoomDto;

@Controller
public class ManageRoomController {

	@Autowired
	private ManageHotelService manageHotelService;

	@Autowired
	private ManageRoomService manageRoomService;

	@GetMapping("/manage_room")
	public String getManageRoomPage(Model model) {
		model.addAttribute("listRooms", manageRoomService.getAllRooms());
		return "dashboard/room/manage_room";
	}

	@GetMapping("room/add")
	public String showRoomForm(Model model) { // 送空白表單
//		Room room = new Room();
//		model.addAttribute("room", room);
		model.addAttribute("hotels", manageHotelService.getAllHotels());
		return "dashboard/room/new_room";
	}

	@ResponseBody
	@PostMapping("room/save")
	public RoomDto saveRoom(@RequestBody RoomDto roomDto) {
//		檢查收到的資料
		System.out.println("-----------------------------------------------------");
		System.out.println(roomDto.toString());
		Hotel hotel = manageHotelService.getHotelById(roomDto.getHotelId());
		Room room = new Room(roomDto.getRoomNumber(), roomDto.getRoomType(), roomDto.getBeds(), roomDto.getCostPerNight());
		hotel.addRoom(room);
		
		// 新增進Hotel
		manageHotelService.saveHotel(hotel);
		return roomDto;
	}

	@GetMapping("room/update/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		Room room = manageRoomService.getRoomById(id);
		model.addAttribute("room", room);
		return "dashboard/room/edit_room";
	}

	@PostMapping("room/update/{id}")
	public String update(@PathVariable(value = "id") Long id, @RequestBody RoomDto roomDto) {
//		檢查資料
//		System.out.println(roomDto.toString());

		Room room = manageRoomService.getRoomById(id);
		room.setId(id);
		room.setRoomType(roomDto.getRoomType());
		room.setRoomNumber(roomDto.getRoomNumber());
		room.setBeds(roomDto.getBeds());
		room.setCostPerNight(roomDto.getCostPerNight());
		manageRoomService.saveRoom(room);

//		靠window.location才跳轉
		return "redirect:/manage_room";
	}

	@GetMapping("room/delete/{id}")
	public String deleteHotel(@PathVariable(value = "id") long id) {
		this.manageRoomService.deleteRoomById(id);
		return "redirect:/manage_room";
	}

//	@GetMapping("room/page/{pageNo}")
//	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir, Model model) {
//		int pageSize = 5;
//
//		Page<Room> page = manageRoomService.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<Room> listRooms = page.getContent();
//
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//		model.addAttribute("listRooms", listRooms);
//		return "dashboard/room/manage_room";
//	}
}
