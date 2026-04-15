package repository;

import exception.VehicleNotFoundException;
import model.Vehicle;

import java.util.HashMap;

public class VehicleRepository {
    private HashMap<Integer, Vehicle> VehicleMap;
    private static int counter = 1;

    public VehicleRepository() {
        this.VehicleMap = new HashMap<>();
    }

    public Vehicle save(Vehicle Vehicle){
        Vehicle.setId(counter++);
        VehicleMap.put(Vehicle.getId(),Vehicle);
        return VehicleMap.get(Vehicle.getId());
    }

    public Vehicle findById(int VehicleId){
        if(VehicleMap.containsKey(VehicleId)){
            return VehicleMap.get(VehicleId);
        }
        else{
            throw new VehicleNotFoundException("Vehicle with given id does not exist");
        }
    }

    public Vehicle update(int VehicleId, Vehicle newVehicle){
        if(VehicleMap.containsKey(VehicleId)){
            return VehicleMap.put(VehicleId,newVehicle);
        }
        else{
            throw new VehicleNotFoundException("Vehicle with given id does not exist");
        }
    }

    public boolean delete(int VehicleId){
        if(VehicleMap.containsKey(VehicleId)){
            VehicleMap.remove(VehicleId);
            return true;
        }
        else{
            throw new VehicleNotFoundException("Vehicle with given id does not exist");
        }
    }
}
