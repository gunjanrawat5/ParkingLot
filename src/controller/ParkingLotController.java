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

    public Bill generateBill(int ticketId, int exitGateId){
        return null;
    }

    public Bill billPayment(Bill bill){
        return null;
    }


    public ParkingLot intialiseParkingLot(int noOfFloors, int noOfSpotsOnAFloor){
        return  parkingLotService.intialiseParkingLot(noOfFloors, noOfSpotsOnAFloor);
    }

    public void displayParkingLot(ParkingLot parkingLot){
        parkingLotService.showParkingLot(parkingLot);
    }


}
