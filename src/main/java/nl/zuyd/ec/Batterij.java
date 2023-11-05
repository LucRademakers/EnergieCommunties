package nl.zuyd.ec;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Batterij")
@NamedQuery(name = "Batterij.EnergieBeschikbaar", query = "SELECT f FROM Batterij f WHERE koperID = null", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))


public class Batterij {
    private Long verkoperID;
    private Long koperID;
    private Long aantalKWh;
    private Float prijs;

    @Id
    public Long getVerkoperID() {
        return verkoperID;
    }

    public void setVerkoperID(Long verkoperID) {
        this.verkoperID = verkoperID;
    }

    public Long getKoperID() {
        return koperID;
    }

    public void setKoperID(Long koperID) {
        this.koperID = koperID;
    }

    public Long getAantalKWh() {
        return aantalKWh;
    }

    public void setAantalKWh(Long aantalKWh) {
        this.aantalKWh = aantalKWh;
    }

    public Float getPrijs() {
        return prijs;
    }

    public void setPrijs(Float prijs) {
        this.prijs = prijs;
    }
}
