/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem;

/**
 *
 * @author Rajit
 */

public class Prescription {
    private String medicationName;
    private String medsdosage;
    private String instructions;
    private String prepduration;
    private int id;
    private String prepDoctor;
    private String patientName;

    public Prescription(int id, String medicationName, String medsdosage, String instructions) {
        this.id = id;
        this.medicationName = medicationName;
        this.medsdosage = medsdosage;
        this.instructions = instructions;
        this.prepduration = "Not prescribed";
    }

    public Prescription(int id, String medicationName, String medsdosage, String instructions, String prepduration, String prescribingDoctor, String patientName) {
        this.id = id;
        this.medicationName = medicationName;
        this.medsdosage = medsdosage;
        this.instructions = instructions;
        this.prepduration = prepduration;
        this.prepDoctor = prescribingDoctor;
        this.patientName = patientName;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedsDosage() {
        return medsdosage;
    }

    public void setMedsDosage(String medsdosage) {
        this.medsdosage = medsdosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPrepDuration() {
        return prepduration;
    }

    public void setPrepDuration(String prepduration) {
        this.prepduration = prepduration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrepDoctor() {
        return prepDoctor;
    }

    public void setPrepDoctor(String prescribingDoctor) {
        this.prepDoctor = prescribingDoctor;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

