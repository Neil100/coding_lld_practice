package com.example.parkinglot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Ticket {

	private String ticketNumber;
	private long timeOfAllocation;
	private Vehicle vehicle;
	private ParkingSpot parkingSpot;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Ticket(Vehicle vehicle, ParkingSpot spot) {
		ticketNumber = UUID.randomUUID().toString();
		timeOfAllocation = System.currentTimeMillis();
		this.vehicle = vehicle;
		this.parkingSpot = spot; 
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public long getTimeOfAllocation() {
		return timeOfAllocation;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	@Override
	public String toString() {
		Date date = new Date(this.timeOfAllocation);
		String dateBeautified = dateFormat.format(date);
		String str;

		str = "TicketNumber: " + this.ticketNumber + "\n";
		str = str + "Entry Time: " + dateBeautified + "\n";
		str = str + "Parking Spot Id: " + parkingSpot.getId() + "\n";

		return str;
	}
}
