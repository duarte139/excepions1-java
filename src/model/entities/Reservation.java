package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOn;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOn) throws DomainException {
		 if (!checkOn.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOn = checkOn;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOn() {
		return checkOn;
	}

	public long duration() {
		long diff = checkOn.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkIn, Date checkOn) throws DomainException {

		Date now = new Date();

		if (checkIn.before(now) || checkOn.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");

		} else if (!checkOn.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOn = checkOn;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", CheckIn: " + sdf.format(checkIn) + ", CheckOn: " + sdf.format(checkOn) + ", "
				+ duration() + " nights ";

	}

}
