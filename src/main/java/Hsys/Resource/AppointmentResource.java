/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;

import Hsys.DAO.AppointmentDAO;
import com.mycompany.healthsystem.Appointment;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;

/**
 *
 * @author Rajit
 */


@Path("/appointments")
public class AppointmentResource {

    private static final AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointments(@QueryParam("id") int id) {
        if (id > 0) {
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            return Response.ok(appointment).build();
        } else {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            return Response.ok(appointments).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{appointmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        if (appointmentDAO.getAppointmentById(appointmentId) != null) {
            updatedAppointment.setId(appointmentId);
            appointmentDAO.updateAppointment(updatedAppointment);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        if (appointmentDAO.getAppointmentById(appointmentId) != null) {
            appointmentDAO.deleteAppointment(appointmentId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
