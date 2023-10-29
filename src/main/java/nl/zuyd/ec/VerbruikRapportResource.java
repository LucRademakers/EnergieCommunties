package nl.zuyd.ec;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;

@Path("/api/verbruik/huishouden")
//@Authenticated

public class VerbruikRapportResource {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    //@RolesAllowed("report")

    public VerbruikRapport toonVerbruikRapport(String id) {
        //
        VerbruikRapport verbruikRapport = new VerbruikRapport();
        verbruikRapport.setVerbruikKWh(em.find(Energiemetingen.class, id).getVerbruikKWh());
        verbruikRapport.setOpwekKWh(em.find(Energiemetingen.class, id).getOpwekKWh());
        verbruikRapport.setDatum(em.find(Energiemetingen.class, id).getDatum());
       return verbruikRapport;
    }

}
