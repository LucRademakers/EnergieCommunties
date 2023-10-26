package nl.zuyd.ec;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Huishouden {
    private Long HuishoudenID;
    private String Straat;
    private Long Huisnummer;
    private String Postcode;
    private String Woonplaats;
    @Id
    public Long getHuishoudenID() {
        return HuishoudenID;
    }

    public void setHuishoudenID(Long huishoudenID) {
        HuishoudenID = huishoudenID;
    }

    public String getStraat() {
        return Straat;
    }

    public void setStraat(String straat) {
        Straat = straat;
    }

    public Long getHuisnummer() {
        return Huisnummer;
    }

    public void setHuisnummer(Long huisnummer) {
        Huisnummer = huisnummer;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getWoonplaats() {
        return Woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        Woonplaats = woonplaats;
    }
}
