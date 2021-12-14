package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Integer rommNumber, Date checkin, Date checkout) {
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

	//calculando datas;
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //Diferença em milliseconds
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //Coverte o valor que estava em milliseconds para dias;
//		Integer differenceDays = checkOut.compareTo(checkIn);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ " , check-in "
				+ sdf.format(checkIn)
				+ " , check-out"
				+ sdf.format(checkOut)
				+ " , "
				+ duration()
				+ " nights.";
				
	}
}
