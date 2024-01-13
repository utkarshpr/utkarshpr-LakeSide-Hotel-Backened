package com.hotel.springboot.lakeSideHotel.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@AllArgsConstructor

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	private String room_type;
	
	private BigDecimal room_price;
	
	private Boolean isBooked=false;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BookedRoom> bookings;
	
	@Lob
	private Blob photo;

	public Room() {
		this.bookings=new ArrayList<>();
	}
	
	
	public void addBookings(BookedRoom booking) {
		if(bookings == null)
		{
			bookings = new ArrayList<>();
		}
		bookings.add(booking);
		booking.setRoom(this);
		isBooked=true;
		String bookinCode=RandomStringUtils.randomNumeric(10);
		booking.setBookingConfirmationCode(bookinCode);
		
		
	}
}
