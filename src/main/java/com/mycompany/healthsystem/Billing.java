/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author Rajit
 */

public class Billing {
    private Patient patient;
    private double invoiceAmount;
    private double amount;
    private double outstandingBalance;
    private double paymentStatus;
    private int id;

    public Billing(Patient patient, double invoiceAmount) {
        this.patient = patient;
        this.invoiceAmount = invoiceAmount;
        this.paymentStatus = 0; 
        this.outstandingBalance = invoiceAmount;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(double paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
