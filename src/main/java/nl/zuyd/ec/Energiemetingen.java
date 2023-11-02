package nl.zuyd.ec;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Energiemetingen")
@NamedQuery(name = "Energiemetingen.findAll", query = "SELECT f FROM Energiemetingen f WHERE huishoudenID = :id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))

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
