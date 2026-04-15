package controller;

import model.Bill;
import model.ParkingTicket;
import model.Payment;
import model.Vehicle;
import model.constants.ParkingSpotTier;
import model.constants.VehicleType;

public class ParkingLotController {

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


}
