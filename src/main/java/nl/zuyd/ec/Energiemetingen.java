package nl.zuyd.ec;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Energiemetingen {
    private Long HuishoudenID;
    private Long VerbruikKWh;
    private Long OpwekKWh;
    private Date Datum;


    @Id
    public Long getHuishoudenID() {
        return HuishoudenID;
    }

    public void setHuishoudenID(Long huishoudenID) {
        HuishoudenID = huishoudenID;
    }




    public Long getVerbruikKWh() {
        return VerbruikKWh;
    }

    public void setVerbruikKWh(Long verbruikKWh) {
        VerbruikKWh = verbruikKWh;
    }




    public Long getOpwekKWh() {
        return OpwekKWh;
    }

    public void setOpwekKWh(Long opwekKWh) {
        OpwekKWh = opwekKWh;
    }




    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }
}
