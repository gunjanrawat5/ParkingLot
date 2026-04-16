package service.strategy;

import model.constants.ParkingSpotTier;
import model.constants.VehicleType;

public class LinearBillCalculationStrategy implements BillCalculationStrategy {

    @Override
    public double generateOverallBill(int duration, VehicleType vehicleType, ParkingSpotTier parkingSpotTier) {
        return 10 * duration;
    }
}
