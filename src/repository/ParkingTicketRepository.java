package repository;

import exception.ParkingTicketNotFoundException;
import model.ParkingTicket;

import java.util.HashMap;

public class ParkingTicketRepository {
    private HashMap<Integer, ParkingTicket> ParkingTicketMap;
    private static int counter = 1;

    public ParkingTicketRepository() {
        this.ParkingTicketMap = new HashMap<>();
    }

    public ParkingTicket save(ParkingTicket ParkingTicket){
        ParkingTicket.setId(counter++);
        ParkingTicketMap.put(ParkingTicket.getId(),ParkingTicket);
        return ParkingTicketMap.get(ParkingTicket.getId());
    }

    public ParkingTicket findById(int ParkingTicketId){
        if(ParkingTicketMap.containsKey(ParkingTicketId)){
            return ParkingTicketMap.get(ParkingTicketId);
        }
        else{
            throw new ParkingTicketNotFoundException("Parking ticket with given id does not exist");
        }
    }

    public ParkingTicket update(int ParkingTicketId, ParkingTicket newParkingTicket){
        if(ParkingTicketMap.containsKey(ParkingTicketId)){
            return ParkingTicketMap.put(ParkingTicketId,newParkingTicket);
        }
        else{
            throw new ParkingTicketNotFoundException("Parking ticket with given id does not exist");
        }
    }

    public boolean delete(int ParkingTicketId){
        if(ParkingTicketMap.containsKey(ParkingTicketId)){
            ParkingTicketMap.remove(ParkingTicketId);
            return true;
        }
        else{
            throw new ParkingTicketNotFoundException("Parking ticket with given id does not exist");
        }
    }
}
