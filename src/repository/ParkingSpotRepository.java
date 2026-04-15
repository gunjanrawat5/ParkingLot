package repository;

import exception.ParkingSpotNotFoundException;
import model.ParkingSpot;

import java.util.HashMap;

public class ParkingSpotRepository {
    private HashMap<Integer, ParkingSpot> ParkingSpotMap;
    private static int counter = 1;

    public ParkingSpotRepository() {
        this.ParkingSpotMap = new HashMap<>();
    }

    public ParkingSpot save(ParkingSpot ParkingSpot){
        ParkingSpot.setId(counter++);
        ParkingSpotMap.put(ParkingSpot.getId(),ParkingSpot);
        return ParkingSpotMap.get(ParkingSpot.getId());
    }

    public ParkingSpot findById(int ParkingSpotId){
        if(ParkingSpotMap.containsKey(ParkingSpotId)){
            return ParkingSpotMap.get(ParkingSpotId);
        }
        else{
            throw new ParkingSpotNotFoundException("Parking spot with given id does not exist");
        }
    }

    public ParkingSpot update(int ParkingSpotId, ParkingSpot newParkingSpot){
        if(ParkingSpotMap.containsKey(ParkingSpotId)){
            return ParkingSpotMap.put(ParkingSpotId,newParkingSpot);
        }
        else{
            throw new ParkingSpotNotFoundException("Parking spot with given id does not exist");
        }
    }

    public boolean delete(int ParkingSpotId){
        if(ParkingSpotMap.containsKey(ParkingSpotId)){
            ParkingSpotMap.remove(ParkingSpotId);
            return true;
        }
        else{
            throw new ParkingSpotNotFoundException("Parking spot with given id does not exist");
        }
    }
}
