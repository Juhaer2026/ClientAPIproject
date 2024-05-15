/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Hsys.DAO.PatientDAO;
import com.mycompany.healthsystem.Patient;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rajit
 */

@Path("/patients")
public class PatientResource {

    private static final PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatients(@QueryParam("id") int id) {
        if (id > 0) {
            Patient patient = PatientDAO.getPatientById(id);
            return Response.ok(patient).build();
        } else {
            List<Patient> patients = PatientDAO.getAllPatients();
            return Response.ok(patients).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        patientDAO.addPatient(patient);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {
        Patient existingPatient = PatientDAO.getPatientById(patientId);
        if (existingPatient != null) {
            updatedPatient.setId(patientId);
            PatientDAO.updatePatient(updatedPatient);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{patientId}")
    public Response deletePatient(@PathParam("patientId") int patientId) {
        Patient existingPatient = PatientDAO.getPatientById(patientId);
        if (existingPatient != null) {
            PatientDAO.deletePatient(patientId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
