package nl.zuyd.ec;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/api/metingen")
@Authenticated
public class EnergiemetingenResource {
    @Inject
    EntityManager em;

    @Inject
    SecurityContext context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("huishouden")
    @Log
    public List<Energiemetingen> toonEnergiemetingen(String id) {
        //
        String username = context.getUserPrincipal().getName();
        System.out.printf("User: %s \n", username);

        if(username.substring(username.length() - 1).equals(id)){
            //
            List<Energiemetingen> metingen = em.createNamedQuery("Energiemetingen.findAll", Energiemetingen.class).setParameter("id", id).getResultList();
            //Query query = em.createNativeQuery("SELECT * FROM Energiemetingen WHERE huishoudenID = :id");
            //query.setParameter("id", id);
            //List<Energiemetingen> metingen = query.getResultList();
            return metingen;
        }
        else{
            System.out.printf("Not authorized");
            return null;
        }
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("energiemeter")
    @Transactional
    @Log
    public Response uploadEnergiemeting(Energiemetingen energiemeting){
        //
        em.persist(energiemeting);
        return Response.ok(energiemeting).status(201).build();
    }

    @PUT
    @Path("/aanpassen/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    @Log
    public Energiemetingen energiemetingAanpassen(Integer id, Energiemetingen energiemetingen) {
        if (energiemetingen.getVerbruikKWh() == null || energiemetingen.getOpwekKWh() == null) {
            throw new WebApplicationException("Niet alle gegevens van de energiemeting zijn opgegeven", 422);
        }
        if (energiemetingen.getHuishoudenID() != null || energiemetingen.getDatum() != null) {
            throw new WebApplicationException("Je hebt een ID of datum meegegeven, maar deze zullen niet worden aangepast om de metingen integer te houden.", 422);
        }

        Energiemetingen energiemetingenEntity = em.find(Energiemetingen.class, id);

        if (energiemetingenEntity == null) {
            throw new WebApplicationException("Energiemeting met ID " + id + " bestaat niet.", 404);
        }

        energiemetingenEntity.setVerbruikKWh(energiemetingen.getVerbruikKWh());
        energiemetingenEntity.setOpwekKWh(energiemetingen.getOpwekKWh());

        return energiemetingenEntity;
    }
}
