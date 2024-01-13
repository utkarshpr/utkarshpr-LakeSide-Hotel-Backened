package com.hotel.springboot.lakeSideHotel.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookedRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@Column(name = "check_in")
	private LocalDate checkedInDate;
	@Column(name = "check_out")
	private LocalDate checkedOutDate;
	@Column(name = "guest_fullName")
	private String guestName;
	@Column(name = "guest_email")
	private String guestEmail;
	@Column(name = "adults")
	private int NumberOfAdults;
	@Column(name = "children")
	private int NumberOfChildren;
	@Column(name = "total_guest")
	private int TotalNumberOfGust;
	@Column(name = "confirmation_code")
	private String BookingConfirmationCode;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	public void calculateNumberOfGuest() {
		this.TotalNumberOfGust = this.NumberOfAdults + this.NumberOfChildren;
	}

	/**
	 * @return the numberOfAdults
	 */
	public int getNumberOfAdults() {
		return NumberOfAdults;
	}

	/**
	 * @param numberOfAdults the numberOfAdults to set
	 */
	public void setNumberOfAdults(int numberOfAdults) {
		NumberOfAdults = numberOfAdults;
		calculateNumberOfGuest();
	}

	/**
	 * @return the numberOfChildren
	 */
	public int getNumberOfChildren() {
		return NumberOfChildren;
	}

	/**
	 * @param numberOfChildren the numberOfChildren to set
	 */
	public void setNumberOfChildren(int numberOfChildren) {
		NumberOfChildren = numberOfChildren;
		calculateNumberOfGuest();
	}

	/**
	 * @return the bookingConfirmationCode
	 */
	public String getBookingConfirmationCode() {
		return BookingConfirmationCode;
	}

	/**
	 * @param bookingConfirmationCode the bookingConfirmationCode to set
	 */
	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		BookingConfirmationCode = bookingConfirmationCode;
	}

}
