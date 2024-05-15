/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author Rajit
 */

public class Patient extends Person {
   
    private int id;
    private int age;
    private String medicalHistory;
    private String Conditions;
    private Doctor doctor;
    
    public Patient() {
        super("", "", ""); 
    }

    public Patient(int id, String name, int age, String address, String ContactInfo, String medicalHistory, String Conditions) {
        super(name, ContactInfo, address);
        this.id = id;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.Conditions = Conditions;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getConditions() {
        return Conditions;
    }

    public void setConditions(String Conditions) {
        this.Conditions = Conditions;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}





