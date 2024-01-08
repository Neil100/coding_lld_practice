package com.example.parkinglot;

public class ExitGateImpl {

	private ParkingManagerAssignee parkingManagerAssignee;
	
	
	public ExitGateImpl(ParkingManagerAssignee parkingManagerAssignee) {
		this.parkingManagerAssignee = parkingManagerAssignee;
	}
	
	public Boolean processTicket(Ticket ticket) {
		// do transactional stuff
		
		// free the parking spot
		ParkingSpotManager spotManager = parkingManagerAssignee.getSpotManager(ticket.getVehicle().getType());
		spotManager.emptyParkingSpot(ticket.getParkingSpot());
		
		
		// updateTicket
		
		// kill the ticket object
		
		return true;
	}
}
