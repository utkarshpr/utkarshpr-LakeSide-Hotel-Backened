package com.hotel.springboot.lakeSideHotel.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.hotel.springboot.lakeSideHotel.model.Room;


public interface RoomService {

	Room addNewRoom(MultipartFile photo, String room_type, BigDecimal room_price);

}
