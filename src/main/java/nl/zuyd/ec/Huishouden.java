package nl.zuyd.ec;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Huishouden {
    private Long huishoudenID;
    private String straat;
    private Long huisnummer;
    private String postcode;
    private String woonplaats;


    @Id
    public Long getHuishoudenID() {
        return huishoudenID;
    }

    public void setHuishoudenID(Long huishoudenID) {
        this.huishoudenID = huishoudenID;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public Long getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(Long huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
