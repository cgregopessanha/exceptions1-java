package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	public Reservation() {
	}

	public Reservation(Integer rommNumber, Date checkin, Date checkout) throws DomainException {
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date!") ;
		}
		
		this.roomNumber = rommNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRommNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	// calculando datas;
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // Diferença em milliseconds
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Coverte o valor que estava em milliseconds para
																	// dias;
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || (checkOut.before(now))) {
			throw new DomainException("Reservations dates for updates must be future date!") ;
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date!") ;
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + 
				" , check-in " + sdf.format(checkIn) + 
				" , check-out" + sdf.format(checkOut)
				+ " , " + duration() + " nights.";

	}
}
