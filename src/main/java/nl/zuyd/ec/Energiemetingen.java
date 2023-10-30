package nl.zuyd.ec;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Energiemetingen {
    private Long huishoudenID;
    private Long verbruikKWh;
    private Long opwekKWh;
    private Date datum;

    @Id
    public Long getHuishoudenID() {
        return huishoudenID;
    }

    public void setHuishoudenID(Long huishoudenID) {
        this.huishoudenID = huishoudenID;
    }

    public Long getVerbruikKWh() {
        return verbruikKWh;
    }

    public void setVerbruikKWh(Long verbruikKWh) {
        this.verbruikKWh = verbruikKWh;
    }

    public Long getOpwekKWh() {
        return opwekKWh;
    }

    public void setOpwekKWh(Long opwekKWh) {
        this.opwekKWh = opwekKWh;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
