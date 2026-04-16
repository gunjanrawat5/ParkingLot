package controller;

import model.ParkingLot;
import model.ParkingTicket;
import model.Vehicle;
import model.constants.ParkingSpotTier;
import service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void displayTicketDetails(ParkingTicket parkingTicket){
        System.out.println(parkingTicket);
    }

    public ParkingTicket generateTicket(String vehicleNumber, ParkingLot parkingLot, ParkingSpotTier parkingSpotTier, int entryGateId){
        return ticketService.generateTicket(vehicleNumber,parkingLot, parkingSpotTier,entryGateId);
    }

}
