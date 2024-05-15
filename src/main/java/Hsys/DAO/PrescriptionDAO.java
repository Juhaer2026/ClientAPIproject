/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;

import com.mycompany.healthsystem.Doctor;
import com.mycompany.healthsystem.Patient;
import com.mycompany.healthsystem.Prescription;
import java.util.*;

/**
 *
 * @author Rajit
 */

public class PrescriptionDAO {
    private static final List<Prescription> prescriptions = new ArrayList<>();

static {
    Doctor doctor1 = new Doctor(1001, "Dr. Michael Johnson", "123-456-7890", "15 Maple Avenue", "Neurology");
    Doctor doctor2 = new Doctor(1002, "Dr. Emily Anderson", "987-654-3210", "7 Willow Street", "Oncology");
    Doctor doctor3 = new Doctor(1003, "Dr. Christopher Lee", "555-123-4567", "22 Elm Road", "Gastroenterology");
    Doctor doctor4 = new Doctor(1004, "Dr. Samantha White", "321-654-9870", "10 Oak Lane", "Endocrinology");

    Patient patient1 = new Patient(2001, "Alice Thompson", 30, "123 Pine Street", "111-222-3333", "Migraine", "Good Condition");
    Patient patient2 = new Patient(2002, "Robert Johnson", 45, "456 Birch Avenue", "444-555-6666", "Allergies", "Good Condition");
    Patient patient3 = new Patient(2003, "Emma Harris", 35, "789 Cedar Lane", "777-888-9999", "Asthma", "Good Condition");
    Patient patient4 = new Patient(2004, "William Taylor", 55, "987 Walnut Road", "999-888-7777", "High Blood Pressure", "Good Condition");
    Patient patient5 = new Patient(2005, "Sophia Martinez", 25, "321 Oak Street", "555-123-4567", "Eczema", "Good Condition");
    Patient patient6 = new Patient(2006, "Noah Rodriguez", 38, "654 Pine Avenue", "555-234-5678", "Arthritis", "Good Condition");
    Patient patient7 = new Patient(2007, "Isabella Lopez", 42, "987 Elm Road", "555-345-6789", "Migraine", "Good Condition");
    Patient patient8 = new Patient(2008, "Liam Perez", 48, "147 Cedar Lane", "555-456-7890", "High Cholesterol", "Good Condition");
    Patient patient9 = new Patient(2009, "Olivia Sanchez", 30, "258 Walnut Boulevard", "555-567-8901", "Asthma", "Good Condition");
    

    prescriptions.add(new Prescription(3001, "Ibuprofen", "Two tablets a day", "Take with food", "1 month", "Dr. Johnson", patient4.getName()));
    prescriptions.add(new Prescription(3002, "Loratadine", "One tablet once daily", "Take in the morning", "3 months", "Dr. Lee", patient3.getName()));
    prescriptions.add(new Prescription(3003, "Acetaminophen", "One tablet every 4-6 hours", "Do not exceed 4 tablets in 24 hours", "1 week", "Dr. Anderson", patient3.getName()));
    prescriptions.add(new Prescription(3004, "Cetirizine", "One tablet daily", "Take before bedtime", "2 weeks", "Dr. White", patient4.getName()));
    prescriptions.add(new Prescription(3001, "Ranitidine", "One tablet twice daily", "Take before meals", "2 weeks", "Dr. Patel", patient5.getName()));
    prescriptions.add(new Prescription(3002, "Diazepam", "Take one tablet as needed for anxiety", "Do not exceed 3 tablets in 24 hours", "1 month", "Dr. Khan", patient6.getName()));
    prescriptions.add(new Prescription(3003, "Omeprazole", "Take one capsule daily", "Take before breakfast", "3 months", "Dr. Brown", patient7.getName()));
    prescriptions.add(new Prescription(3004, "Simvastatin", "Take one tablet daily at bedtime", "Do not take with grapefruit juice", "6 months", "Dr. Patel", patient8.getName()));
    prescriptions.add(new Prescription(3005, "Metformin", "Take one tablet with each meal", "Take with food", "Indefinitely", "Dr. Khan", patient9.getName()));
}

    public static List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

 public static Prescription getPrescriptionById(int id) {
    for (Prescription prescription : prescriptions) {
        if (prescription.getId() == id) {
            return prescription;
        }
    }
    return null;
}

public static void addPrescription(Prescription prescription) {
    int nextId = prescriptions.isEmpty() ? 1 : prescriptions.get(prescriptions.size() - 1).getId() + 1;
    prescription.setId(nextId);
    prescriptions.add(prescription);
}

public static void updatePrescription(Prescription updatedPrescription) {
    for (int i = 0; i < prescriptions.size(); i++) {
        Prescription prescription = prescriptions.get(i);
        if (prescription.getId() == updatedPrescription.getId()) {
            prescriptions.set(i, updatedPrescription);
            System.out.println("Prescription updated: " + updatedPrescription);
            return;
        }
    }
    System.out.println("Prescription not found : " + updatedPrescription);
}

public static void deletePrescription(int id) {
    prescriptions.removeIf(prescription -> prescription.getId() == id);
}
}
