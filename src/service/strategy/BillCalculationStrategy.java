package service.strategy;

import model.constants.ParkingSpotTier;
import model.constants.VehicleType;

public interface BillCalculationStrategy {
    double generateOverallBill(int duration, VehicleType vehicleType, ParkingSpotTier parkingSpotTier);
}
