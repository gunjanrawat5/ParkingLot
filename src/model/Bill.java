package model;

import java.util.Date;

public class Bill {
    private int id;
    private Date exitTime;
    private ParkingTicket parkingTicket;
    private ParkingGate parkingGate;
    private Operator operator;
    private double amount;
    private Payment payment;
}
