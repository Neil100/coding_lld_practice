package com.example.parkinglot;

public class Vehicle {
	private VehicleType type;
	private String vehicleNumber;
	
	Vehicle(VehicleType type, String vehicleNumber) {
		this.type = type;
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public VehicleType getType() {
		return type;
	}
}
