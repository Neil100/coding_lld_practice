package com.example.parkinglot;

import java.util.List;
import java.util.Optional;

public class TwoWheelerParkingSpotManager implements ParkingSpotManager {

	private List<TwoWheelerParkingSpot> spots;

	@Override
	public ParkingSpot getEmptyParkingSpot() {
		Optional<TwoWheelerParkingSpot> parkingSpot = spots.stream().filter(spot -> spot.getStatus().equals(ParkingSpotStatus.UNOCCUPIED)).findFirst();
		
		if(parkingSpot.isPresent()) {
			parkingSpot.get().setStatus(ParkingSpotStatus.OCCUPIED);
			return parkingSpot.get();
		} else {
//			throw new ParkingSpotNotAvailableException
		}
		
		return null;
	}

	@Override
	public void emptyParkingSpot(ParkingSpot spot) {
		spot.setStatus(ParkingSpotStatus.UNOCCUPIED);
	}

	@Override
	public ParkingSpot getParkingSpot(String id) {
		Optional<TwoWheelerParkingSpot> parkingSpot = spots.stream().filter(spot -> spot.getId().equals(id)).findFirst();
		
		if(parkingSpot.isPresent()) {
			return parkingSpot.get();
		} else {
			// thow new ParkingSpotNotFoundException
		}
		return null;
	}

	@Override
	public void addParkingSpots(List<ParkingSpot> spots) {
		// can also do type check for ParkingSpot
		spots.addAll(spots);
	}
}
