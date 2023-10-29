package nl.zuyd.ec;

import java.sql.Date;

public class CommunityVerbruik {
    private Long CommunityVerbruik;
    private Long CommunityOpwek;
    private Date Datum;



    public Long getCommunityVerbruik() {
        return CommunityVerbruik;
    }

    public void setCommunityVerbruik(Long communityVerbruik) {
        CommunityVerbruik = communityVerbruik;
    }



    public Long getCommunityOpwek() {
        return CommunityOpwek;
    }

    public void setCommunityOpwek(Long communityOpwek) {
        CommunityOpwek = communityOpwek;
    }




    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }
}
