package nl.zuyd.ec;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

@Path("/api/verbruik/community")
//@Authenticated

public class CommunityVerbruikResource {
    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed("report")

    public CommunityVerbruik toonVerbruikRapport() {
        //
        /*Date date = java.sql.Date.valueOf(LocalDate.now());

        Query query = em.createNativeQuery("SELECT * FROM Energiemetingen WHERE Datum = :datum");
        query.setParameter("datum", date);
        List<Energiemetingen> alleEnergiemetingen = query.getResultList();

        Integer meting = 0;
        Long totaleOpwek = 0L;
        // Bereken de totale opwek
        while (meting+1 != alleEnergiemetingen.size()) {
            totaleOpwek = totaleOpwek + alleEnergiemetingen.get(meting).getOpwekKWh();
            meting++;
        }

        meting = 0;
        Long totaleVerbruik = 0L;
        // Breken het totale verbruik
        while (meting+1 != alleEnergiemetingen.size()){
            totaleVerbruik = totaleVerbruik + alleEnergiemetingen.get(meting).getVerbruikKWh();
            meting++;
        }*/


        CommunityVerbruik verbruikRapport = new CommunityVerbruik();
        //verbruikRapport.setCommunityVerbruik(totaleVerbruik);
        //verbruikRapport.setCommunityOpwek(totaleOpwek);
        //verbruikRapport.setDatum(date);

        return verbruikRapport;
    }

}
