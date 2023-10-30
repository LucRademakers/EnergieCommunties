package nl.zuyd.ec;

import java.sql.Date;

public class Rapport {
    private Long VerbruikKWh;
    private Long OpwekKWh;
    private Date Datum;


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

    public Long getVerbruikKWh() {
        return VerbruikKWh;
    }

    public void setVerbruikKWh(Long VerbruikKWh) {
        this.VerbruikKWh = VerbruikKWh;
    }
}
