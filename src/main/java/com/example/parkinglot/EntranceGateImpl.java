package com.example.parkinglot;

public class EntranceGateImpl {
	
	private ParkingManagerAssignee parkingManagerAssignee;
	
	public EntranceGateImpl(ParkingManagerAssignee assignee) {
		this.parkingManagerAssignee = assignee;
	}

	public Ticket getParkingTicket(Vehicle vehicle) {
		/*
		 * To Do
		 */
		
		ParkingSpotManager spotManager = this.parkingManagerAssignee.getSpotManager(vehicle.getType());
		
//		try {
			ParkingSpot spot = spotManager.getEmptyParkingSpot();
		
//		} catch (NoParkingSpotEmptyException ex) {
//			System.out.println("For vehicle type " +vehicle.getType()+" . No empty parking lot was found.");
//			throw ex;
//		}
			
		return createTicket(spot, vehicle);
	}

	private Ticket createTicket(ParkingSpot spot, Vehicle vehicle) {
		Ticket ticket = new Ticket(vehicle, spot);
		return ticket;
	}
}
