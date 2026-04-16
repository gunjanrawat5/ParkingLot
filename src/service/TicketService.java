package service;

import exception.VehicleNotFoundException;
import model.ParkingLot;
import model.ParkingSpot;
import model.ParkingTicket;
import model.Vehicle;
import model.constants.ParkingSpotStatus;
import model.constants.ParkingSpotTier;
import model.constants.VehicleType;
import repository.*;
import service.strategy.SpotAssignmentStrategy;
import service.strategy.SpotAssignmentStrategyFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TicketService {
    private ParkingGateRepository parkingGateRepository;
    private ParkingTicketRepository parkingTicketRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(ParkingGateRepository parkingGateRepository, ParkingTicketRepository parkingTicketRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository) {
        this.parkingGateRepository = parkingGateRepository;
        this.parkingTicketRepository = parkingTicketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
    }

    private ParkingTicket generateTicket(ParkingLot parkingLot, Vehicle vehicle, ParkingSpotTier parkingSpotTier, int entryGateId){
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy();
        ParkingSpot spot = spotAssignmentStrategy.findSpotForVehicle(parkingLot,vehicle, parkingSpotTier);

        ParkingTicket ticket = new ParkingTicket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(spot);
        ticket.setVehicle(vehicle);
        ticket.setParkingGate(parkingGateRepository.findById(entryGateId));
        ticket.setOperator(parkingGateRepository.findById(entryGateId).getOperator());

        ticket = parkingTicketRepository.save(ticket);

        spot.setParkingSpotStatus(ParkingSpotStatus.TAKEN);
        spot = parkingSpotRepository.update(spot.getId(),spot);

        parkingLot.setAvailableSlots(parkingLot.getAvailableSlots()-1);
        parkingLot = parkingLotRepository.save(parkingLot);

        return ticket;

    }

    public ParkingTicket generateTicket(String vehicleNumber, ParkingLot parkingLot, ParkingSpotTier parkingSpotTier, int entryGateId){
        Vehicle vehicle = null;
        try{
            vehicle = vehicleRepository.getVehicleByNumber(vehicleNumber);
        } catch (VehicleNotFoundException ve){
            Scanner sc = new Scanner(System.in);
            System.out.println("Vehicle does not exist with this number, please enter details");
            System.out.println("Please enter vehicle type - 1. 2 wheeler 2. 4 wheeler");
            int vehicleType = sc.nextInt();
            System.out.println("Please enter vehicle info");
            String vehicleInfo = sc.next();

            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleInfo(vehicleInfo);
            //TODO : Change type based on user input
            vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
            vehicle = vehicleRepository.save(vehicle);
        }
        return generateTicket(parkingLot,vehicle, parkingSpotTier, entryGateId);
    }
}
