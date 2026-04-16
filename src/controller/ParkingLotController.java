package controller;

import model.*;
import model.constants.ParkingSpotTier;
import model.constants.VehicleType;
import service.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService;
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }



    public boolean isSlotAvailable(){
        return true;
    }

    public boolean isSlotAvailable(VehicleType vehicleType){
        //TODO: Implement this for per vehicle type
        return true;
    }

    public ParkingTicket generateTicket(Vehicle vehicle, ParkingSpotTier parkingSpotTier, int parkingGateId){
        return null;
    }

    public ParkingTicket generateTicket(String vehicleNumber, ParkingSpotTier parkingSpotTier, int parkingGateId){
        return null;
    }

    public Bill generateBill(int ticketId, int exitGateId){
        return null;
    }

    public Bill billPayment(Bill bill){
        return null;
    }

    public void displayParkingLotStatus(){
        return;
    }

    public ParkingLot intialiseParkingLot(int noOfFloors, int noOfSpotsOnAFloor){
        return  parkingLotService.intialiseParkingLot(noOfFloors, noOfSpotsOnAFloor);
    }

    public void displayParkingLot(ParkingLot parkingLot){
        parkingLotService.showParkingLot(parkingLot);
    }


}
