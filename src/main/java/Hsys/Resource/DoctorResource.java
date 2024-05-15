/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;
import Hsys.DAO.DoctorDAO;
import com.mycompany.healthsystem.Doctor;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rajit
 */

@Path("/doctors")
public class DoctorResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctors(@QueryParam("id") int id) {
        if (id > 0) {
            Doctor doctor = DoctorDAO.getDoctorById(id);
            return Response.ok(doctor).build();
        } else {
            List<Doctor> doctors = DoctorDAO.getAllDoctors();
            return Response.ok(doctors).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        DoctorDAO.addDoctor(doctor);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = DoctorDAO.getDoctorById(doctorId);
        if (existingDoctor != null) {
            updatedDoctor.setId(doctorId);
            DoctorDAO.updateDoctor(updatedDoctor);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId) {
        Doctor existingDoctor = DoctorDAO.getDoctorById(doctorId);
        if (existingDoctor != null) {
            DoctorDAO.deleteDoctor(doctorId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
