/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;
import com.mycompany.healthsystem.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rajit
 */


public class DoctorDAO {
    private static final List<Doctor> doctors = new ArrayList<>();

    static {
        Doctor doctor1 = new Doctor(1001, "Dr. Michael Johnson", "123-456-7890", "15 Maple Avenue", "Neurology");
        Doctor doctor2 = new Doctor(1002, "Dr. Emily Anderson", "987-654-3210", "7 Willow Street", "Oncology");
        Doctor doctor3 = new Doctor(1003, "Dr. Christopher Lee", "555-123-4567", "22 Elm Road", "Gastroenterology");
        Doctor doctor4 = new Doctor(1004, "Dr. Samantha White", "321-654-9870", "10 Oak Lane", "Endocrinology");
        Doctor doctor5 = new Doctor(1005, "Dr. Jessica Martinez", "555-789-1234", "30 Pine Avenue", "Cardiology");
        Doctor doctor6 = new Doctor(1006, "Dr. Alexander Garcia", "789-456-1230", "25 Cedar Street", "Dermatology");
        Doctor doctor7 = new Doctor(1007, "Dr. Olivia Rodriguez", "333-222-1111", "8 Birch Boulevard", "Pediatrics");
        Doctor doctor8 = new Doctor(1008, "Dr. Ethan Brown", "444-777-8888", "5 Walnut Lane", "Orthopedics");
        Doctor doctor9 = new Doctor(1009, "Dr. Sophia Lopez", "222-888-5555", "12 Elmwood Drive", "Psychiatry");


        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        doctors.add(doctor5);
        doctors.add(doctor6);
        doctors.add(doctor7);
        doctors.add(doctor8);
        doctors.add(doctor9);
        
    }

public static List<Doctor> getAllDoctors() {
    return doctors;
}

public static Doctor getDoctorById(int id) {
    for (Doctor doctor : doctors) {
        if (doctor.getId() == id) {
            return doctor;
        }
    }
    return null;
}

public static void addDoctor(Doctor doctor) {
    int nextId = doctors.isEmpty() ? 1 : doctors.get(doctors.size() - 1).getId() + 1;
    doctor.setId(nextId);
    doctors.add(doctor);
}

public static void updateDoctor(Doctor updatedDoctor) {
    for (int i = 0; i < doctors.size(); i++) {
        Doctor existingDoctor = doctors.get(i);
        if (existingDoctor.getId() == updatedDoctor.getId()) {
            doctors.set(i, updatedDoctor);
            System.out.println("Doctor updated: " + updatedDoctor);
            return;
        }
    }
    System.out.println("Doctor not found: " + updatedDoctor);
}

public static void deleteDoctor(int id) {
    doctors.removeIf(doctor -> doctor.getId() == id);
}
}
