package nl.zuyd.ec;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
//@Authenticated

public class HuishoudenResource {

    @Inject
    EntityManager em;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("huishouden/{id}")
    //@RolesAllowed("user")


    //@Transactional
    public Huishouden getHuishouden(String id) {
        //
        Huishouden huishouden = new Huishouden();
        huishouden.setHuishoudenID(25L);
        huishouden.setHuisnummer(17L);
        huishouden.setPostcode("asjdhak");
        huishouden.setStraat("sdsd");
        huishouden.setWoonplaats("sdhsjkfh");
        //em.persist(huishouden);
        Huishouden entity = em.find(Huishouden.class, 25L);
       return entity;
    }

}
