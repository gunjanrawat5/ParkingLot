package repository;

import exception.ParkingFloorNotFoundException;
import exception.ParkingLotNotFoundException;
import model.ParkingFloor;
import model.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> ParkingLotMap;
    private static int counter = 1;

    public ParkingLotRepository() {
        this.ParkingLotMap = new HashMap<>();
    }

    public ParkingLot save(ParkingLot ParkingLot){
        ParkingLot.setId(counter++);
        ParkingLotMap.put(ParkingLot.getId(),ParkingLot);
        return ParkingLotMap.get(ParkingLot.getId());
    }

    public ParkingLot findById(int ParkingLotId){
        if(ParkingLotMap.containsKey(ParkingLotId)){
            return ParkingLotMap.get(ParkingLotId);
        }
        else{
            throw new ParkingLotNotFoundException("Parking lot with given id does not exist");
        }
    }

    public ParkingLot update(int ParkingLotId, ParkingLot newParkingLot){
        if(ParkingLotMap.containsKey(ParkingLotId)){
            return ParkingLotMap.put(ParkingLotId,newParkingLot);
        }
        else{
            throw new ParkingLotNotFoundException("Parking lot with given id does not exist");
        }
    }

    public boolean delete(int ParkingLotId){
        if(ParkingLotMap.containsKey(ParkingLotId)){
            ParkingLotMap.remove(ParkingLotId);
            return true;
        }
        else{
            throw new ParkingLotNotFoundException("Parking lot with given id does not exist");
        }
    }
}
