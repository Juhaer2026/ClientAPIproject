/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.DAO;

import com.mycompany.healthsystem.Appointment;
import com.mycompany.healthsystem.Patient;
import java.util.*;

/**
 *
 * @author Rajit
 */


public class AppointmentDAO {
    private static final List<Appointment> appointments = new ArrayList<>();

    static {
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAllPatients();
        

        DoctorDAO doctorDAO = new DoctorDAO();

        appointments.add(new Appointment(501, "2024-03-26", "10:45", patientDAO.getPatientById(178840), doctorDAO.getDoctorById(0)));
        appointments.add(new Appointment(502, "2024-04-02", "15:30", patientDAO.getPatientById(135353), doctorDAO.getDoctorById(1)));
        appointments.add(new Appointment(503, "2024-04-10", "09:15", patientDAO.getPatientById(177703), doctorDAO.getDoctorById(2)));
        appointments.add(new Appointment(504, "2024-04-10", "10:00", patientDAO.getPatientById(147053), doctorDAO.getDoctorById(3)));
        appointments.add(new Appointment(505, "2024-05-15", "11:00", patientDAO.getPatientById(2005), doctorDAO.getDoctorById(1005)));
        appointments.add(new Appointment(506, "2024-05-16", "14:30", patientDAO.getPatientById(2006), doctorDAO.getDoctorById(1006)));
        appointments.add(new Appointment(507, "2024-05-17", "10:15", patientDAO.getPatientById(2007), doctorDAO.getDoctorById(1007)));
        appointments.add(new Appointment(508, "2024-05-18", "09:30", patientDAO.getPatientById(2008), doctorDAO.getDoctorById(1008)));
        appointments.add(new Appointment(509, "2024-05-19", "13:45", patientDAO.getPatientById(2009), doctorDAO.getDoctorById(1009)));
        
    }

public List<Appointment> getAllAppointments() {
    return appointments;
}

public Appointment getAppointmentById(int id) {
    for (Appointment appointment : appointments) {
        if (appointment.getId() == id) {
            return appointment;
        }
    }
    return null;
}

public void addAppointment(Appointment appointment) {
    int nextId = appointments.isEmpty() ? 1 : appointments.get(appointments.size() - 1).getId() + 1;
    appointment.setId(nextId);
    appointments.add(appointment);
}

public void updateAppointment(Appointment updatedAppointment) {
    for (int i = 0; i < appointments.size(); i++) {
        Appointment existingAppointment = appointments.get(i);
        if (existingAppointment.getId() == updatedAppointment.getId()) {
            appointments.set(i, updatedAppointment);
            System.out.println("Appointment updated: " + updatedAppointment);
            return;
        }
    }
    System.out.println("Appointment not found : " + updatedAppointment);
}

public void deleteAppointment(int id) {
    appointments.removeIf(appointment -> appointment.getId() == id);
}
}

