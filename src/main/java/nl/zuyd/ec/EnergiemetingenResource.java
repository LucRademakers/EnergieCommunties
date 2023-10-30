package nl.zuyd.ec;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("/api")
public class EnergiemetingenResource {
    @Inject
    EntityManager em;

    @POST
    @Path("/energiemeting")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response uploadMeting(Energiemetingen energiemetingen){
        //
        em.persist(energiemetingen);
        return Response.ok(energiemetingen).status(201).build();
    }
}
