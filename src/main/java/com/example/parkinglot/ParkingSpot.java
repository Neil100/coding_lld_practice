package com.example.parkinglot;

import java.util.UUID;

public class ParkingSpot {

	private ParkingSpotStatus status;
	private String id;
	// 
	
	ParkingSpot() {
		this.id = UUID.randomUUID().toString();
		setStatus(ParkingSpotStatus.UNOCCUPIED);
	}

	public ParkingSpotStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingSpotStatus status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}
}
