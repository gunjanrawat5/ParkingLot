package controller;

import model.Bill;
import model.ParkingLot;
import service.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public void displayBillDetails(Bill bill){
        System.out.println(bill);
    }

    public Bill generateBill(ParkingLot parkingLot,int ticketId, int exitGateId){
        return billService.generateBill(parkingLot, ticketId, exitGateId);
    }
}
