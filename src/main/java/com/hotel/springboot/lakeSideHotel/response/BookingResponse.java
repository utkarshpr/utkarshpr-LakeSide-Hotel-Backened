package com.hotel.springboot.lakeSideHotel.response;

import java.time.LocalDate;

import com.hotel.springboot.lakeSideHotel.model.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingResponse {

	private int bookingId;

	private LocalDate checkedInDate;

	private LocalDate checkedOutDate;

	private String guestName;

	private String guestEmail;

	private int NumberOfAdults;

	private int NumberOfChildren;

	private int TotalNumberOfGust;

	private String BookingConfirmationCode;

	private Room room;

	public BookingResponse(int bookingId, LocalDate checkedInDate, LocalDate checkedOutDate,
			String bookingConfirmationCode) {
		super();
		this.bookingId = bookingId;
		this.checkedInDate = checkedInDate;
		this.checkedOutDate = checkedOutDate;
		BookingConfirmationCode = bookingConfirmationCode;
	}

}
