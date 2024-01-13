package com.hotel.springboot.lakeSideHotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotel.springboot.lakeSideHotel.model.Room;
import com.hotel.springboot.lakeSideHotel.repositary.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
	
	private final RoomRepository roomRepository;

	@Override
	public Room addNewRoom(MultipartFile photo, String room_type, BigDecimal room_price) {
		Room room = new Room();
		room.setRoom_type(room_type);
		room.setRoom_price(room_price);
		// converting MultipartFile to Blob 
		if (!photo.isEmpty()) {
			
			byte[] photobyte = null;
			try {
				photobyte = photo.getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Blob pic = new SerialBlob(photobyte);
				room.setPhoto(pic);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return roomRepository.save(room);
	}

}
