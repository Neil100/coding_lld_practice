package com.example.parkinglot;

import java.util.List;

public interface ParkingSpotManager {
	public ParkingSpot getEmptyParkingSpot();
	public ParkingSpot getParkingSpot(String id);
	public void emptyParkingSpot(ParkingSpot spot);
	public void addParkingSpots(List<ParkingSpot> spots);
}
