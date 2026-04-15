import controller.BillController;
import controller.ParkingLotController;
import controller.TicketController;
import model.Bill;
import model.ParkingTicket;
import model.constants.ParkingSpotTier;
import repository.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BillRepository billRepository = new BillRepository();
        ParkingGateRepository parkingGateRepository = new ParkingGateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingTicketRepository parkingTicketRepository = new ParkingTicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        ParkingLotController parkingLotController = new ParkingLotController();
        TicketController ticketController = new TicketController();
        BillController billController = new BillController();

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
                    ParkingTicket ticket = parkingLotController.generateTicket(number, ParkingSpotTier.NORMAL,1);
                    ticketController.displayTicketDetails(ticket);
                } else{
                    System.out.println("Parking lot is full, please try again later");
                }
            } else{
                System.out.println("Please enter your ticketId");
                int ticketId = sc.nextInt();
                Bill bill = parkingLotController.generateBill(ticketId,2);
                billController.displayBillDetails(bill);
                System.out.println("Choose payment mode - 1. Cash and 2. Online ");
                int paymentMode = sc.nextInt();
                //generate bill object with payment
                parkingLotController.displayParkingLotStatus();
            }
        }


    }
}