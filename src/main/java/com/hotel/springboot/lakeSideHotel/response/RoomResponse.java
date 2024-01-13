package com.hotel.springboot.lakeSideHotel.response;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;

import com.hotel.springboot.lakeSideHotel.model.BookedRoom;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor


public class RoomResponse {
	
private Long  id;
	
	private String room_type;
	
	private BigDecimal room_price;
	
	private Boolean isBooked=false;
	
	private String photo;
	
	private List<BookingResponse> bookings;

	public RoomResponse(Long id, String room_type, BigDecimal room_price) {
		super();
		this.id = id;
		this.room_type = room_type;
		this.room_price = room_price;
	}

	public RoomResponse(Long id, String room_type, BigDecimal room_price, Boolean isBooked, byte [] photoByte,
			List<BookingResponse> bookings) {
		super();
		this.id = id;
		this.room_type = room_type;
		this.room_price = room_price;
		this.isBooked = isBooked;
		this.photo = photoByte != null ?org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(photoByte):null;
		this.bookings = bookings;
	}
	
	
	
}
