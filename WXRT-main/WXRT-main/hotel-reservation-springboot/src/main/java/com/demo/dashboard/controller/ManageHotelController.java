package com.demo.dashboard.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dashboard.service.ManageHotelService;
import com.demo.domain.Hotel;
import com.demo.domain.location.Address;
import com.demo.dto.HotelDto;

@Controller
public class ManageHotelController {

	@Autowired
	private ManageHotelService manageHotelservice;

	@GetMapping("/manage_hotel")
	public String getManageHotelPage(Model model) { // 顯示所有飯店
		model.addAttribute("listHotels", manageHotelservice.getAllHotels());
		return "dashboard/hotel/manage_hotel";
	}
	
	
//	Rest Api
//	@GetMapping("/hotel")
//	@ResponseBody
//	public List<Hotel> getAllHotels(){
//		return manageHotelservice.getAllHotels();
//	}
	
	@GetMapping("hotel/add")
	public String showNewHotelForm(Model model) { // 送空白表單
		Hotel hotel = new Hotel();
		model.addAttribute("hotel", hotel);
		return "dashboard/hotel/new_hotel";
	}

	@ResponseBody
	@PostMapping("hotel/save")
	public Hotel saveHotel(@RequestBody HotelDto hotelDto) {
//		檢查收到的資料
		System.out.println("-----------------------------------------------------");
		System.out.println(hotelDto.toString());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String city = hotelDto.getAddress().substring(0, 3);
		String location = hotelDto.getAddress().substring(3, hotelDto.getAddress().length());
		Address address = new Address(location, city);
		Hotel hotel = new Hotel(hotelDto.getName(), address, hotelDto.getStars(), hotelDto.getWebsite(),
				LocalTime.parse(hotelDto.getEarliestCheckInTime(), formatter),
				LocalTime.parse(hotelDto.getLatestCheckInTime(), formatter),
				LocalTime.parse(hotelDto.getStandardCheckOutTime(), formatter),
				LocalTime.parse(hotelDto.getLatestCheckOutTime(), formatter), hotelDto.getLateCheckoutFee());

		manageHotelservice.saveHotel(hotel);

		return hotel;
	}

	@GetMapping("hotel/update/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		Hotel hotel = manageHotelservice.getHotelById(id);
		model.addAttribute("hotel", hotel);
		return "dashboard/hotel/edit_hotel";
	}

	@PostMapping("hotel/update/{id}")
	public String update(@PathVariable(value = "id") Long id, @RequestBody HotelDto hotelDto) {
		System.out.println("---------------------------------------------------------------");
		System.out.println(hotelDto.toString());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String city = hotelDto.getAddress().substring(0, 3);
		String location = hotelDto.getAddress().substring(3, hotelDto.getAddress().length());
		Address address = new Address(location, city);
		Hotel hotel = new Hotel(hotelDto.getName(), address, hotelDto.getStars(), hotelDto.getWebsite(),
				LocalTime.parse(hotelDto.getEarliestCheckInTime(), formatter),
				LocalTime.parse(hotelDto.getLatestCheckInTime(), formatter),
				LocalTime.parse(hotelDto.getStandardCheckOutTime(), formatter),
				LocalTime.parse(hotelDto.getLatestCheckOutTime(), formatter), hotelDto.getLateCheckoutFee());

		hotel.setId(id);
		System.out.println("---------------------------------------------------------------");
		System.out.println(hotel);

		manageHotelservice.saveHotel(hotel);

//		靠window.location才跳轉
		return "redirect:/manage_hotel";
	}

	@GetMapping("hotel/delete/{id}")
	public String deleteHotel(@PathVariable(value = "id") long id) {
		this.manageHotelservice.deleteHotelById(id);
		return "redirect:/manage_hotel";
	}

//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir, Model model) {
//		int pageSize = 5;
//
//		Page<Hotel> page = manageHotelservice.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<Hotel> listHotels = page.getContent();
//
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//		model.addAttribute("listHotels", listHotels);
//		return "dashboard/hotel/manage_hotel";
//	}
}
