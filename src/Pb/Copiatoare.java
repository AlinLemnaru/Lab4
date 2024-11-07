package Pb;

import java.io.Serializable;

/**
 * Copiatoare
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public class Copiatoare extends EchipamentElectronic implements Serializable {
    //Declarare variabile
    private int p_ton;
    private FormatCopiere formatCopiere;

    //Constructor
    public Copiatoare() {
    }

    public Copiatoare(String denumire, int nr_inventar, int pret, String zona_mag, Situatie situatie,
                      String tip_echipament, int p_ton, FormatCopiere formatCopiere) {
        super(denumire, nr_inventar, pret, zona_mag, situatie, tip_echipament);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }

    //Getter and Setter
    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public FormatCopiere getFormatCopiere() {
        return formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    //Metode
    @Override
    public String toString() {
        return super.toString() + ", " + p_ton + ", " + formatCopiere;
    }

    @Override
    public <FormatCopiere extends Enum<FormatCopiere>> void setEnum(Enum<FormatCopiere> formatCopiere) {
        this.formatCopiere = (Pb.FormatCopiere) formatCopiere;
    }
}
