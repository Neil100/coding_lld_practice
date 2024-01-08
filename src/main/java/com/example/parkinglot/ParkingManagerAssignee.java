package com.example.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingManagerAssignee {
	
	List<ParkingSpotManager> spotsManager;
	
	public ParkingManagerAssignee(List<ParkingSpotManager> spotsManager) {
		this.spotsManager = spotsManager;
	}

	public ParkingSpotManager getSpotManager(VehicleType type) {
		
		Optional<ParkingSpotManager> spotManager = Optional.empty();

		if(type.equals(VehicleType.TWO_WHEELER)) {
			spotManager = spotsManager.stream().filter(manager -> TwoWheelerParkingSpotManager.class.isInstance(manager)).findFirst();
			
		} else if (type.equals(VehicleType.FOUR_WHEELER) ) {
			spotManager = spotsManager.stream().filter(manager -> FourWheelerParkingSpot.class.isInstance(manager)).findFirst();
			
		} else if (type.equals(VehicleType.HEAVY_DUTY)) {
			spotManager = spotsManager.stream().filter(manager -> HeavyDutyParkingSpot.class.isInstance(manager)).findFirst();
			
		}
		
		if(spotManager.isPresent()) {
			return spotManager.get();
		} else {
			// throw exception VehicleType is not supported
		}
		
		return null;
	}
	
}
