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

@Path("/api/batterij")
@Authenticated
public class BatterijResource {
    @Inject
    EntityManager em;

    @Inject
    SecurityContext context;

    @GET
    @Path("/beschikbaar")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("huishouden")
    @Log
    public List<Batterij> toonBatterijEnergie(String id) {
        //
        String username = context.getUserPrincipal().getName();
        System.out.printf("User: %s \n", username);

        List<Batterij> batterijEnergie = em.createNamedQuery("Batterij.EnergieBeschikbaar", Batterij.class).getResultList();
        return batterijEnergie;
    }

    @POST
    @Path("/verkoop")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("huishouden")
    @Transactional
    @Log
    public Response verkoopEnergie(Batterij batterij){
        //
        em.persist(batterij);
        return Response.ok(batterij).status(201).build();
    }

    @PUT
    @Path("/koop/{verkoperId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("huishouden")
    @Transactional
    @Log
    public Batterij energieKopen(String verkoperId, Batterij batterij) {
        if (batterij.getKoperID() == null) {
            throw new WebApplicationException("Er moet een koper worden opgegeven om de energie te kopen.", 422);
        }

        Batterij batterijEntity = em.find(Batterij.class, verkoperId);

        if (batterijEntity == null) {
            throw new WebApplicationException("Verkoper met ID " + verkoperId + " heeft geen stroom te koop.", 404);
        }

        batterijEntity.setKoperID(batterij.getKoperID());

        return batterijEntity;
    }
}
