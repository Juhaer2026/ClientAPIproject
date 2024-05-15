/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;

import com.mycompany.healthsystem.Billing;
import com.mycompany.healthsystem.Patient;
import java.util.*;


/**
 *
 * @author Rajit
 */

public class BillingDAO {
    private static final List<Billing> billings = new ArrayList<>();

    static {
        Patient patient1 = new Patient(2001, "Alice Thompson", 30, "123 Pine Street", "111-222-3333", "Migraine", "Good Condition");
        Patient patient2 = new Patient(2002, "Robert Johnson", 45, "456 Birch Avenue", "444-555-6666", "Allergies", "Good Condition");
        Patient patient3 = new Patient(2003, "Emma Harris", 35, "789 Cedar Lane", "777-888-9999", "Asthma", "Good Condition");
        Patient patient4 = new Patient(2004, "William Taylor", 55, "987 Walnut Road", "999-888-7777", "High Blood Pressure", "Good Condition");
        Patient patient5 = new Patient(2005, "Sophia Martinez", 25, "321 Oak Street", "555-123-4567", "Eczema", "Good Condition");
        Patient patient6 = new Patient(2006, "Noah Rodriguez", 38, "654 Pine Avenue", "555-234-5678", "Arthritis", "Good Condition");
        Patient patient7 = new Patient(2007, "Isabella Lopez", 42, "987 Elm Road", "555-345-6789", "Migraine", "Good Condition");
        Patient patient8 = new Patient(2008, "Liam Perez", 48, "147 Cedar Lane", "555-456-7890", "High Cholesterol", "Good Condition");
        Patient patient9 = new Patient(2009, "Olivia Sanchez", 30, "258 Walnut Boulevard", "555-567-8901", "Asthma", "Good Condition");

        Billing billing1 = new Billing(patient1, 100.0);
        Billing billing2 = new Billing(patient2, 250.0);
        Billing billing3 = new Billing(patient3, 300.0);
        Billing billing4 = new Billing(patient4, 400.0);
        Billing billing5 = new Billing(patient5, 500.0);
        Billing billing6 = new Billing(patient6, 650.0);
        Billing billing7 = new Billing(patient7, 700.0);
        Billing billing8 = new Billing(patient8, 800.0);
        Billing billing9 = new Billing(patient9, 400.0);
     

        billings.add(billing1);
        billings.add(billing2);
        billings.add(billing3);
        billings.add(billing4);
        billings.add(billing5);
        billings.add(billing6);
        billings.add(billing7);
        billings.add(billing8);
        billings.add(billing9);
   
    }

   public List<Billing> getAllBillings() {
    return billings;
}

public Billing getBillingById(int id) {
    for (Billing billing : billings) {
        if (billing.getId() == id) {
            return billing;
        }
    }
    return null;
}

public void addBilling(Billing billing) {
    int nextId = billings.isEmpty() ? 1 : billings.get(billings.size() - 1).getId() + 1;
    billing.setId(nextId);
    billings.add(billing);
}

public void updateBilling(Billing updatedBilling) {
    for (int i = 0; i < billings.size(); i++) {
        Billing existingBilling = billings.get(i);
        if (existingBilling.getId() == updatedBilling.getId()) {
            billings.set(i, updatedBilling);
            System.out.println("Billing updated: " + updatedBilling);
            return;
        }
    }
    System.out.println("Billing not found: " + updatedBilling);
}

public void deleteBilling(int id) {
    billings.removeIf(billing -> billing.getId() == id);
}
}

