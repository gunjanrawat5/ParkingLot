package model;

import java.time.LocalDateTime;

public class Bill {
    private int id;
    private LocalDateTime exitTime;
    private ParkingTicket parkingTicket;
    private ParkingGate exitGate;
    private Operator operator;
    private double amount;
    private Payment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", exitTime=" + exitTime +
                ", parkingTicket=" + parkingTicket +
                ", exitGate=" + exitGate +
                ", operator=" + operator +
                ", amount=" + amount +
                ", payment=" + payment +
                '}';
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public ParkingGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ParkingGate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
