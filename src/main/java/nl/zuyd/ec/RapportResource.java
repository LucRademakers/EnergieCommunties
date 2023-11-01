package nl.zuyd.ec;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/verbruik/huishouden")
@Authenticated

public class RapportResource {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @RolesAllowed("huishouden")
    public Rapport toonVerbruikRapport(String id) {
        //
        Rapport rapport = new Rapport();
        rapport.setVerbruikKWh(em.find(Energiemetingen.class, id).getVerbruikKWh());
        rapport.setOpwekKWh(em.find(Energiemetingen.class, id).getOpwekKWh());
        rapport.setDatum(em.find(Energiemetingen.class, id).getDatum());
       return rapport;
    }

}
