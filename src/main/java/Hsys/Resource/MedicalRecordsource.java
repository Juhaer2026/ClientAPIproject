/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;
import Hsys.DAO.MedicalRecordDAO;
import com.mycompany.healthsystem.MedicalRecord;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rajit
 */

@Path("/medicalRecords")
public class MedicalRecordsource {

    private static final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecords(@QueryParam("id") int id) {
        if (id > 0) {
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            return Response.ok(medicalRecord).build();
        } else {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            return Response.ok(medicalRecords).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId, MedicalRecord updatedMedicalRecord) {
        MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        if (existingMedicalRecord != null) {
            updatedMedicalRecord.setId(medicalRecordId);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{medicalRecordId}")
    public Response deleteMedicalRecord(@PathParam("medicalRecordId") int medicalRecordId) {
        MedicalRecord existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        if (existingMedicalRecord != null) {
            medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
