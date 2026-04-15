package repository;

import exception.ParkingGateNotFoundException;
import model.ParkingGate;

import java.util.HashMap;

public class ParkingGateRepository {
    private HashMap<Integer, ParkingGate> ParkingGateMap;
    private static int counter = 1;

    public ParkingGateRepository() {
        this.ParkingGateMap = new HashMap<>();
    }

    public ParkingGate save(ParkingGate ParkingGate){
        ParkingGate.setId(counter++);
        ParkingGateMap.put(ParkingGate.getId(),ParkingGate);
        return ParkingGateMap.get(ParkingGate.getId());
    }

    public ParkingGate findById(int ParkingGateId){
        if(ParkingGateMap.containsKey(ParkingGateId)){
            return ParkingGateMap.get(ParkingGateId);
        }
        else{
            throw new ParkingGateNotFoundException("Parking gate with given id does not exist");
        }
    }

    public ParkingGate update(int ParkingGateId, ParkingGate newParkingGate){
        if(ParkingGateMap.containsKey(ParkingGateId)){
            return ParkingGateMap.put(ParkingGateId,newParkingGate);
        }
        else{
            throw new ParkingGateNotFoundException("Parking gate with given id does not exist");
        }
    }

    public boolean delete(int ParkingGateId){
        if(ParkingGateMap.containsKey(ParkingGateId)){
            ParkingGateMap.remove(ParkingGateId);
            return true;
        }
        else{
            throw new ParkingGateNotFoundException("Parking gate with given id does not exist");
        }
    }
}
