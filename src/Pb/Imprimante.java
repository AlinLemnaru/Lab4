package Pb;

import java.io.Serializable;

/**
 * Imprimante
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public class Imprimante extends EchipamentElectronic implements Serializable {
    //Declarare variabile
    private int ppm;
    private String rezolutie;
    private int p_car;
    private ModTiparire modTiparire;

    //Constructor
    public Imprimante() {
    }

    public Imprimante(String denumire, int nr_inventar, int pret, String zona_mag, Situatie situatie,
                      String tip_echipament, int ppm, String rezolutie, int p_car, ModTiparire modTiparire) {
        super(denumire, nr_inventar, pret, zona_mag, situatie, tip_echipament);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    //Getter and Setter
    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getModTiparire() {
        return modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    //Metode
    @Override
    public String toString() {
        return super.toString() + ", " + ppm + ", " + rezolutie + ", " + p_car + ", " + modTiparire;
    }

    @Override
    public <ModTiparire extends Enum<ModTiparire>> void setEnum(Enum<ModTiparire> modTiparire) {
        this.modTiparire = (Pb.ModTiparire) modTiparire;
    }
}
