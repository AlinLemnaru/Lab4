package Pb;

import java.io.Serializable;

/**
 * Clasa parinte a echipamentelod electronice: imprimante, copiatoare si sisteme de calcul
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public abstract class EchipamentElectronic implements Serializable {
    //Declarare variabile
    protected String denumire;
    protected int nr_inventar;
    protected int pret;
    protected String zona_mag;
    protected Situatie situatie;
    protected String tip_echipament;

    //Constructor
    public EchipamentElectronic() {
    }

    public EchipamentElectronic(String denumire, int nr_inventar, int pret, String zona_mag, Situatie situatie,
                                String tip_echipament) {
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
        this.tip_echipament = tip_echipament;
    }

    //Getter and Setter
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNr_inventar() {
        return nr_inventar;
    }

    public void setNr_inventar(int nr_inventar) {
        this.nr_inventar = nr_inventar;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public void setZona_mag(String zona_mag) {
        this.zona_mag = zona_mag;
    }

    public Situatie getSituatie() {
        return situatie;
    }

    public void setSituatie(Situatie situatie) {
        this.situatie = situatie;
    }

    public String getTip_echipament() {
        return tip_echipament;
    }

    public void setTip_echipament(String tip_echipament) {
        this.tip_echipament = tip_echipament;
    }

    //Metode
    @Override
    public String toString() {
        return denumire + ", " + nr_inventar + ", " + pret + ", " + zona_mag + ", " + situatie;
    }

    public abstract <T extends Enum<T>> void setEnum(Enum<T> tEnum);
}
