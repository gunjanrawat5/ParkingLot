package service;

import model.*;
import model.constants.ParkingGateType;
import model.constants.ParkingSpotStatus;
import model.constants.ParkingSpotTier;
import model.constants.VehicleType;
import repository.ParkingFloorRepository;
import repository.ParkingGateRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    ParkingLotRepository parkingLotRepository;
    ParkingFloorRepository parkingFloorRepository;
    ParkingSpotRepository parkingSpotRepository;
    ParkingGateRepository parkingGateRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, ParkingGateRepository parkingGateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingGateRepository = parkingGateRepository;
    }

    public ParkingLot intialiseParkingLot(int noOfFloors, int noOfSpotsOnAFloor){
        Operator operator = new Operator(1,"Operator","op1@gmail.com");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("200 ABC Ave, Jersey City,54671");

        ParkingGate entryGate = new ParkingGate();
        entryGate.setGateNumber("G01");
        entryGate.setGateType(ParkingGateType.ENTRY);
        entryGate.setOperator(operator);

        ParkingGate exitGate = new ParkingGate();
        exitGate.setGateNumber("G02");
        exitGate.setGateType(ParkingGateType.EXIT);
        exitGate.setOperator(operator);

        entryGate = parkingGateRepository.save(entryGate);
        exitGate = parkingGateRepository.save(exitGate);

        parkingLot.setGates(List.of(entryGate,exitGate));

        List<ParkingFloor> floors = new ArrayList<>();
        for(int i =0;i<noOfFloors;i++){
            ParkingFloor floor = new ParkingFloor();
            floor.setFloorNumber(i);
            List<ParkingSpot> spots = new ArrayList<>();
            for(int j =1 ; j<=noOfSpotsOnAFloor;j++){
                ParkingSpot spot = new ParkingSpot();
                spot.setParkingSportNumber(i +"0"+ j);
                spot.setVehicleTypeSupported(VehicleType.FOUR_WHEELER);
                spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
                spot.setParkingSpotTier(ParkingSpotTier.NORMAL);
                spot = parkingSpotRepository.save(spot);
                spots.add(spot);
            }
            floor.setParkingSpots(spots);
            floor = parkingFloorRepository.save(floor);
            floors.add(floor);
        }
        parkingLot.setParkingFloors(floors);
        int capacity = noOfFloors * noOfSpotsOnAFloor;
        parkingLot.setTotalCapacity(capacity);
        parkingLot.setAvailableSlots(capacity);

        return parkingLotRepository.save(parkingLot);
    }

    public void showParkingLot(ParkingLot parkingLot){
        for(int i = 0 ; i<parkingLot.getParkingFloors().size();i++){
            ParkingFloor floor = parkingLot.getParkingFloors().get(i);
            System.out.println("FLOOR : "+ floor.getFloorNumber());
            System.out.println("-----------------------------------");
            for(ParkingSpot spot : floor.getParkingSpots()){
                System.out.print("|");
                if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.TAKEN)){
                    System.out.print("X");
                }
                else if(spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    System.out.print(" ");
                } else{
                    System.out.print("-");
                }
                System.out.print("| ");
                System.out.print(" ");

            }
            System.out.println();
            System.out.println("------------------------------------");
        }
    }

}
