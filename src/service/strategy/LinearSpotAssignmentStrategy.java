package service.strategy;

import exception.ParkingSpotNotAvailableException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.constants.ParkingSpotStatus;
import model.constants.ParkingSpotTier;

public class LinearSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot findSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle, ParkingSpotTier parkingSpotTier) {
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            for(ParkingSpot spot : floor.getParkingSpots()){
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)  && spot.getVehicleTypeSupported().equals(vehicle.getVehicleType()) && spot.getParkingSpotTier().equals(parkingSpotTier)){
                    return spot;

                }
            }
        }
        throw new ParkingSpotNotAvailableException("No parking spot found");
    }
}
