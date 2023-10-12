package nl.zuyd.ec;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/report")
//@Authenticated

public class ReportResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}")
    @RolesAllowed("report")
    public Report dailyReport(String id) {
        //
        Report myreport = new Report();
        myreport.setVerbruik("todo");
        myreport.setUserid(id);
       return myreport;
    }

    public String weeklyReport(){
        //
        return null;
    }

}
