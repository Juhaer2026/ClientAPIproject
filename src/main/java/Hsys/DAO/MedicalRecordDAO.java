/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;
import com.mycompany.healthsystem.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rajit
 */

public class MedicalRecordDAO {
    private static final List<MedicalRecord> medicalRecords = new ArrayList<>();

    static {
        medicalRecords.add(new MedicalRecord(3001, "Sophia Martinez", "Fever", "Rest and medication"));
        medicalRecords.add(new MedicalRecord(3002, "Noah Rodriguez", "Broken leg", "Surgery and cast"));
        medicalRecords.add(new MedicalRecord(3003, "Isabella Lopez", "Migraine", "Painkillers and rest"));
        medicalRecords.add(new MedicalRecord(3004, "Liam Perez", "Concussion", "Rest and monitoring"));
        medicalRecords.add(new MedicalRecord(3005, "Olivia Sanchez", "Allergic reaction", "Epinephrine and antihistamines"));
        medicalRecords.add(new MedicalRecord(3006, "Emma Thompson", "Fever", "Prescribed antibiotics and plenty of rest"));
        medicalRecords.add(new MedicalRecord(3007, "James Smith", "Fractured arm", "Underwent surgery followed by physical therapy"));
        medicalRecords.add(new MedicalRecord(3008, "Emily Johnson", "Pneumonia", "Administered antibiotics and advised bed rest"));
        medicalRecords.add(new MedicalRecord(3009, "Daniel Harris", "Appendicitis", "Emergency appendectomy surgery performed"));
        medicalRecords.add(new MedicalRecord(3000, "Sophia Taylor", "Ankle sprain", "Applied ice, compression, and elevation, followed by physiotherapy"));
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null; 
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        int newId = getNextMedicalRecordId();
        medicalRecord.setId(newId);
        medicalRecords.add(medicalRecord);
    }

    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord existingMedicalRecord = medicalRecords.get(i);
            if (existingMedicalRecord.getId() == updatedMedicalRecord.getId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                System.out.println("Medical record updated: " + updatedMedicalRecord);
                return;
            }
        }
        System.out.println("Medical records not found: " + updatedMedicalRecord);
    }

    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }

    private int getNextMedicalRecordId() {
        int maxMedicalRecordId = Integer.MIN_VALUE;
        for (MedicalRecord medicalRecord : medicalRecords) {
            int medicalRecordId = medicalRecord.getId();
            if (medicalRecordId > maxMedicalRecordId) {
                maxMedicalRecordId = medicalRecordId;
            }
        }
        return maxMedicalRecordId + 1;
    }
}


