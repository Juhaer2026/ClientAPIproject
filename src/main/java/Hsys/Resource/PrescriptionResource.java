/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;
import Hsys.DAO.PrescriptionDAO;
import com.mycompany.healthsystem.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rajit
 */


@Path("/prescriptions")
public class PrescriptionResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptions(@QueryParam("id") int id) {
        if (id > 0) {
            Prescription prescription = PrescriptionDAO.getPrescriptionById(id);
            return Response.ok(prescription).build();
        } else {
            List<Prescription> prescriptions = PrescriptionDAO.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        PrescriptionDAO.addPrescription(prescription);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
        Prescription existingPrescription = PrescriptionDAO.getPrescriptionById(prescriptionId);
        if (existingPrescription != null) {
            updatedPrescription.setId(prescriptionId);
            PrescriptionDAO.updatePrescription(updatedPrescription);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        Prescription existingPrescription = PrescriptionDAO.getPrescriptionById(prescriptionId);
        if (existingPrescription != null) {
            PrescriptionDAO.deletePrescription(prescriptionId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
