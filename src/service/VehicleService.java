package service;

import model.Vehicle;
import repository.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleDetails(String number){
        return vehicleRepository.getVehicleByNumber(number);
    }
}
