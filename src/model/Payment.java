package model;

import model.constants.PaymentMode;
import model.constants.PaymentStatus;

public class Payment {
    private int id;
    private double amount;
    private String transactionReferenceNumber;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
