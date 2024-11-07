package Pb;

import java.io.Serializable;

/**
 * Sisteme de Calcul
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public class SistemeDeCalcul extends EchipamentElectronic implements Serializable {
    //Declarare variabile
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private SistemeDeOperare sistemDeOperare;

    //Constructor
    public SistemeDeCalcul() {
    }

    public SistemeDeCalcul(String denumire, int nr_inventar, int pret, String zona_mag, Situatie situatie,
                           String tip_echipament, String tip_mon, float vit_proc, int c_hdd, SistemeDeOperare sistemDeOperare) {
        super(denumire, nr_inventar, pret, zona_mag, situatie, tip_echipament);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemDeOperare = sistemDeOperare;
    }

    //Getter and Setter
    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public float getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(float vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemeDeOperare getSistemDeOperare() {
        return sistemDeOperare;
    }

    public void setSistemDeOperare(SistemeDeOperare sistemDeOperare) {
        this.sistemDeOperare = sistemDeOperare;
    }

    //Metode
    @Override
    public String toString() {
        return super.toString() + ", " + tip_mon + ", " + vit_proc + ", " + c_hdd + ", " + sistemDeOperare;
    }

    @Override
    public <SistemeDeOperare extends Enum<SistemeDeOperare>> void setEnum(Enum<SistemeDeOperare> sistemDeOperare) {
        this.sistemDeOperare = (Pb.SistemeDeOperare) sistemDeOperare;
    }
}
