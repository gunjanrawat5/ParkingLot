import controller.BillController;
import controller.ParkingLotController;
import controller.TicketController;
import model.Bill;
import model.ParkingLot;
import model.ParkingTicket;
import model.constants.ParkingSpotTier;
import repository.*;
import service.BillService;
import service.ParkingLotService;
import service.TicketService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BillRepository billRepository = new BillRepository();
        ParkingGateRepository parkingGateRepository = new ParkingGateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository,parkingFloorRepository, parkingSpotRepository, parkingGateRepository);

        TicketService ticketService = new TicketService(parkingGateRepository,parkingTicketRepository,parkingSpotRepository,parkingLotRepository,vehicleRepository);

        BillService billService = new BillService(parkingTicketRepository,billRepository,parkingGateRepository,parkingSpotRepository,parkingLotRepository);

        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);
        TicketController ticketController = new TicketController(ticketService);
        BillController billController = new BillController(billService);

        ParkingLot parkingLot = parkingLotController.intialiseParkingLot(2,10);
        parkingLotController.displayParkingLot(parkingLot);



        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the parking lot");

        while(true){
            System.out.println("Choose one of the following");
            System.out.println("1. Enter new vehicle");
            System.out.println("2. Exit vehicle");
            int option = sc.nextInt();
            if(option == 1){
                if(parkingLotController.isSlotAvailable()){
                    System.out.println("Please enter vehicle number");
                    String number = sc.next();
                    ParkingTicket ticket = ticketController.generateTicket(number,parkingLot, ParkingSpotTier.NORMAL,1);
                    ticketController.displayTicketDetails(ticket);
                    parkingLotController.displayParkingLot(parkingLot);
                } else{
                    System.out.println("Parking lot is full, please try again later");
                }
            } else{
                System.out.println("Please enter your ticketId");
                int ticketId = sc.nextInt();
                Bill bill = billController.generateBill(parkingLot,ticketId,2);
                billController.displayBillDetails(bill);
                //generate bill object with payment
                parkingLotController.displayParkingLot(parkingLot);

            }
        }


    }
}