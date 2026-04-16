package service.strategy;

import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.constants.ParkingSpotTier;

public interface SpotAssignmentStrategy {

    ParkingSpot findSpotForVehicle(ParkingLot parkingLot,Vehicle vehicle, ParkingSpotTier parkingSpotTier);
}
