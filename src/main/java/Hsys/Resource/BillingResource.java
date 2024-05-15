/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hsys.Resource;
import Hsys.DAO.BillingDAO;
import com.mycompany.healthsystem.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rajit
 */

@Path("/billings")
public class BillingResource {

    private static final BillingDAO billingDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillings(@QueryParam("id") int id) {
        if (id > 0) {
            Billing billing = billingDAO.getBillingById(id);
            return Response.ok(billing).build();
        } else {
            List<Billing> billings = billingDAO.getAllBillings();
            return Response.ok(billings).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        billingDAO.addBilling(billing);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") int billingId, Billing updatedBilling) {
        Billing existingBilling = billingDAO.getBillingById(billingId);
        if (existingBilling != null) {
            updatedBilling.setId(billingId);
            billingDAO.updateBilling(updatedBilling);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") int billingId) {
        Billing existingBilling = billingDAO.getBillingById(billingId);
        if (existingBilling != null) {
            billingDAO.deleteBilling(billingId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}