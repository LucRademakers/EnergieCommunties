package nl.zuyd.ec;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

import java.util.List;

@Path("/api/rapport")
@Authenticated

public class RapportResource {
    @Inject
    EntityManager em;


    @Inject
    SecurityContext context;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("huishouden")
    public Rapport toonVerbruikRapport(String id) {
        //
        String username = context.getUserPrincipal().getName();
        System.out.printf("username: %s \n", username);
        //todo compare username met id, if not equal dan geen rapport
        Rapport rapport = new Rapport();
        rapport.setVerbruikKWh(em.find(Energiemetingen.class, id).getVerbruikKWh());
        rapport.setOpwekKWh(em.find(Energiemetingen.class, id).getOpwekKWh());
        rapport.setDatum(em.find(Energiemetingen.class, id).getDatum());
       return rapport;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("totaal/{id}")
    @RolesAllowed("huishouden")
    @Log
    public List<Energiemetingen> toonVerbruikRapportVolledig(String id) {
        //
        String username = context.getUserPrincipal().getName();
        System.out.printf("username: %s \n", username);
        //todo compare username met id, if not equal dan geen rapport
        List<Energiemetingen> metingen = em.createNamedQuery("Energiemetingen.findAll", Energiemetingen.class)
                .getResultList();
        return metingen;
    }

}
