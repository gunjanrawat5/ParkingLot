package service;

import model.Bill;
import model.ParkingLot;
import model.ParkingSpot;
import model.ParkingTicket;
import model.constants.ParkingSpotStatus;
import repository.*;
import service.strategy.BillCalculationStrategy;
import service.strategy.BillCalculationStrategyFactory;

import java.time.LocalDateTime;

public class BillService {
    private ParkingTicketRepository parkingTicketRepository;
    private BillRepository billRepository;
    private ParkingGateRepository parkingGateRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;

    public BillService(ParkingTicketRepository parkingTicketRepository, BillRepository billRepository, ParkingGateRepository parkingGateRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository) {
        this.parkingTicketRepository = parkingTicketRepository;
        this.billRepository = billRepository;
        this.parkingGateRepository = parkingGateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Bill generateBill(ParkingLot parkingLot, int ticketId, int exitGateId){
        ParkingTicket ticket = parkingTicketRepository.findById(ticketId);


        Bill bill = new Bill();
        bill.setExitTime(LocalDateTime.now());
        bill.setParkingTicket(ticket);
        bill.setExitGate(parkingGateRepository.findById(exitGateId));
        bill.setOperator(parkingGateRepository.findById(exitGateId).getOperator());

        int duration = LocalDateTime.now().getSecond() - ticket.getEntryTime().getSecond();

        BillCalculationStrategy strategy = BillCalculationStrategyFactory.getBillCalculationStrategy();
        double amount = strategy.generateOverallBill(duration,ticket.getVehicle().getVehicleType(),ticket.getParkingSpot().getParkingSpotTier());
        bill.setAmount(amount);

        ParkingSpot spot = ticket.getParkingSpot();
        spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        spot = parkingSpotRepository.update(spot.getId(),spot);

        parkingLot.setAvailableSlots(parkingLot.getAvailableSlots()+1);
        parkingLot = parkingLotRepository.update(parkingLot.getId(),parkingLot);

        return  billRepository.save(bill);


    }
}
