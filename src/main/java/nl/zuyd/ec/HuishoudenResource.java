package nl.zuyd.ec;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/api/huishouden")
@Authenticated
public class HuishoudenResource {
    @Inject
    EntityManager em;

    @Inject
    SecurityContext context;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("huishouden")
    //@Transactional
    public Huishouden huishoudenGegevensInzien(String id) {
        //
        String username = context.getUserPrincipal().getName();
        System.out.printf("User: %s \n", username);

        if(username.substring(username.length() - 1).equals(id)){
            //
            Huishouden huishouden = em.find(Huishouden.class, id);
            return huishouden;
        }
        else{
            System.out.printf("Not authorized");
            return null;
        }
    }

    @POST
    @Path("/aanmaken")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    @Log
    public Response maakHuishouden(Huishouden huishouden){
        //
        em.persist(huishouden);
        return Response.ok(huishouden).status(201).build();
    }

    @DELETE
    @Path("/verwijderen/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    @Log
    public Response verwijderHuishouden(Integer id) {
        Huishouden huishouden = em.getReference(Huishouden.class, id);
        if (huishouden == null) {
            throw new WebApplicationException("Huishouden met ID " + id + " bestaat niet", 404);
        }
        em.remove(huishouden);
        return Response.status(204).build();
    }

    @PUT
    @Path("/aanpassen/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    @Log
    public Huishouden updateHuishouden(Integer id, Huishouden huishouden) {
        if (huishouden.getHuishoudenID() == null || huishouden.getHuisnummer() == null || huishouden.getPostcode() == null || huishouden.getStraat() == null || huishouden.getWoonplaats()== null) {
            throw new WebApplicationException("Niet alle gegevens van het huishouden zijn opgegeven", 422);
        }

        Huishouden huishoudenEntity = em.find(Huishouden.class, id);

        if (huishoudenEntity == null) {
            throw new WebApplicationException("Huishouden met ID " + id + " bestaat niet.", 404);
        }

        huishoudenEntity.setHuishoudenID(huishouden.getHuishoudenID());
        huishoudenEntity.setStraat(huishouden.getStraat());
        huishoudenEntity.setHuisnummer(huishouden.getHuisnummer());
        huishoudenEntity.setPostcode(huishouden.getPostcode());
        huishoudenEntity.setWoonplaats(huishouden.getWoonplaats());
        em.persist(huishoudenEntity);

        return huishoudenEntity;
    }

}
