/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;

import com.mycompany.healthsystem.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rajit
 */

public class PatientDAO {
    private static final List<Patient> patients = new ArrayList<>();

    static {
   

        patients.add(new Patient(2001, "Alice Thompson", 30, "123 Pine Street", "111-222-3333", "Migraine", "Good Condition"));
        patients.add(new Patient(2002, "Robert Johnson", 45, "456 Birch Avenue", "444-555-6666", "Allergies", "Good Condition"));
        patients.add(new Patient(2003, "Emma Harris", 35, "789 Cedar Lane", "777-888-9999", "Asthma", "Good Condition"));
        patients.add(new Patient(2004, "William Taylor", 55, "987 Walnut Road", "999-888-7777", "High Blood Pressure", "Good Condition"));
        patients.add(new Patient(2005, "Sophia Martinez", 25, "321 Oak Street", "555-123-4567", "Eczema", "Good Condition"));
        patients.add(new Patient(2006, "Noah Rodriguez", 38, "654 Pine Avenue", "555-234-5678", "Arthritis", "Good Condition"));
        patients.add(new Patient(2007, "Isabella Lopez", 42, "987 Elm Road", "555-345-6789", "Migraine", "Good Condition"));
        patients.add(new Patient(2008, "Liam Perez", 48, "147 Cedar Lane", "555-456-7890", "High Cholesterol", "Good Condition"));
        patients.add(new Patient(2009, "Olivia Sanchez", 30, "258 Walnut Boulevard", "555-567-8901", "Asthma", "Good Condition"));
    }

public static List<Patient> getAllPatients() {
    return patients;
}

public static Patient getPatientById(int id) {
    for (Patient patient : patients) {
        if (patient.getId() == id) {
            return patient;
        }
    }
    return null;
}

public static void addPatient(Patient patient) {
    int nextId = patients.isEmpty() ? 1 : patients.get(patients.size() - 1).getId() + 1;
    patient.setId(nextId);
    patients.add(patient);
}


public static void updatePatient(Patient updatedPatient) {
    for (int i = 0; i < patients.size(); i++) {
        Patient existingPatient = patients.get(i);
        if (existingPatient.getId() == updatedPatient.getId()) {
            patients.set(i, updatedPatient);
            System.out.println("Patient updated: " + updatedPatient);
            return;
        }
    }
    System.out.println("Patient not found : " + updatedPatient);
}

public static void deletePatient(int id) {
    patients.removeIf(patient -> patient.getId() == id);
}
}







