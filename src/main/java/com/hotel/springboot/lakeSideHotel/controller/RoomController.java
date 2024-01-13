package com.hotel.springboot.lakeSideHotel.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotel.springboot.lakeSideHotel.model.Room;
import com.hotel.springboot.lakeSideHotel.response.RoomResponse;
import com.hotel.springboot.lakeSideHotel.service.RoomService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {
	
	
	private final RoomService roomService;
	
	@PostMapping("/add/new-room")
	public ResponseEntity<RoomResponse> addNewRoom(
			@RequestParam("Photo") MultipartFile photo,
			@RequestParam("RoomType") String room_type,
			@RequestParam("RoomPrice") BigDecimal room_price){
		Room savedRoom = roomService.addNewRoom(photo,room_type,room_price);
		
		RoomResponse response=new RoomResponse(savedRoom.getId(),savedRoom.getRoom_type(),savedRoom.getRoom_price());
		return ResponseEntity.ok(response);
	}

}
