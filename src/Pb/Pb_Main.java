package Pb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main Function
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public class Pb_Main {
    //Citirea de la tastatura
    public static Scanner sc = new Scanner(System.in);

    public static void displayMeniu() {
        System.out.println(
                """
                        1. Afişarea tuturor echipamentelor
                        2. Afişarea imprimantelor
                        3. Afişarea copiatoarelor
                        4. Afişarea sistemelor de calcul
                        5. Modificarea stării în care se află un echipament
                        6. Setarea unui anumit mod de scriere pentru o imprimantă
                        7. Setarea unui format de copiere pentru copiatoare
                        8. Instalarea unui anumit sistem de operare pe un sistem de calcul
                        9. Afişarea echipamentelor vândute
                        10. Să se realizeze două metode statice pentru serializarea / deserializarea colecției de
                        obiecte în fișierul echip.bin
                        11. Iesire
                        """
        );
    }

    public static void modificareStareEchipament(List<EchipamentElectronic> lista) {
        System.out.print("Nr. Inv: ");
        int nr_inv_cautat = sc.nextInt();

        System.out.print("Noua stare: ");
        String sit = sc.next();

        for (EchipamentElectronic e : lista)
            if (e.getNr_inventar() == nr_inv_cautat)
                if (sit.equals("achizitionat") || sit.equals("expus") || sit.equals("vandut"))
                    e.setSituatie(Situatie.valueOf(sit));
    }

    public static void setareModScriereImprimanta(List<EchipamentElectronic> lista) {
        System.out.print("Nr. Inv: ");
        int nr_inv_cautat = sc.nextInt();

        System.out.print("Nou mod: ");
        String mod = sc.next();

        for (EchipamentElectronic e : lista)
            if (e.getNr_inventar() == nr_inv_cautat && e.getTip_echipament().equals("imprimanta"))
                if (mod.equals("color") || mod.equals("alb_negru"))
                    e.setEnum(ModTiparire.valueOf(mod));
    }

    public static void setareFormatCopiereCopiator(List<EchipamentElectronic> lista) {
        System.out.print("Nr. Inv: ");
        int nr_inv_cautat = sc.nextInt();

        System.out.print("Nou format: ");
        String format = sc.next();

        for (EchipamentElectronic e : lista)
            if (e.getNr_inventar() == nr_inv_cautat && e.getTip_echipament().equals("copiator"))
                if (format.equals("A3") || format.equals("A4"))
                    e.setEnum(FormatCopiere.valueOf(format));
    }

    public static void instalareSOpeSC(List<EchipamentElectronic> lista) {
        System.out.print("Nr. Inv: ");
        int nr_inv_cautat = sc.nextInt();

        System.out.print("Sistem de operare spre instalare: ");
        String so = sc.next();

        for (EchipamentElectronic e : lista)
            if (e.getNr_inventar() == nr_inv_cautat && e.getTip_echipament().equals("sistem de calcul"))
                if (so.equals("windows") || so.equals("linux"))
                    e.setEnum(SistemeDeOperare.valueOf(so));
    }

    static void scrie_serializare(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object citeste_deserializare(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {


        //Citirea din fisier
        BufferedReader br = new BufferedReader(new FileReader("echipamente.txt"));

        //Declarare variabile
        List<EchipamentElectronic> lista_echipamente = new ArrayList<>();
        String linie;

        //Salvarea in lista a echipamentelor din fisier

        while ((linie = br.readLine()) != null) {
            String[] parametrii = linie.split(";");

            //adaugarea unei imprimante
            if (parametrii[5].equals("imprimanta"))
                lista_echipamente.add(new Imprimante(parametrii[0], Integer.parseInt(parametrii[1]),
                        Integer.parseInt(parametrii[2]), parametrii[3], Situatie.valueOf(parametrii[4]),
                        parametrii[5], Integer.parseInt(parametrii[6]), parametrii[7], Integer.parseInt(parametrii[8]),
                        ModTiparire.valueOf(parametrii[9])));

            //adaugarea unei copiator
            if (parametrii[5].equals("copiator"))
                lista_echipamente.add(new Copiatoare(parametrii[0], Integer.parseInt(parametrii[1]),
                        Integer.parseInt(parametrii[2]), parametrii[3], Situatie.valueOf(parametrii[4]),
                        parametrii[5], Integer.parseInt(parametrii[6]), FormatCopiere.valueOf(parametrii[7])));

            //adaugarea unui sistem de calcul
            if (parametrii[5].equals("sistem de calcul"))
                lista_echipamente.add(new SistemeDeCalcul(parametrii[0], Integer.parseInt(parametrii[1]),
                        Integer.parseInt(parametrii[2]), parametrii[3], Situatie.valueOf(parametrii[4]),
                        parametrii[5], parametrii[6], Float.parseFloat(parametrii[7]), Integer.parseInt(parametrii[8]),
                        SistemeDeOperare.valueOf(parametrii[9])));
        }

        /*-------------------- Meniu --------------------*/
        while (true) {
            displayMeniu();
            System.out.print("Optiunea dvs: ");
            int option = sc.nextInt();

            switch (option) {
                case 1: //1. Afişarea tuturor echipamentelor
                    System.out.println("\n\nAfisarea tuturor echipamentelor:\n");
                    for (EchipamentElectronic e : lista_echipamente)
                        System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 2: //2. Afişarea imprimantelor
                    System.out.println("\n\nAfisarea imprimantelor:\n");
                    for (EchipamentElectronic e : lista_echipamente)
                        if (e.getTip_echipament().equals("imprimanta"))
                            System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 3: //3. Afişarea copiatoarelor
                    System.out.println("\n\nAfisarea copiatoarelor:\n");
                    for (EchipamentElectronic e : lista_echipamente)
                        if (e.getTip_echipament().equals("copiator"))
                            System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 4: //4. Afişarea sistemelor de calcul
                    System.out.println("\n\nAfisarea sistemelor de calcul:\n");
                    for (EchipamentElectronic e : lista_echipamente)
                        if (e.getTip_echipament().equals("sistem de calcul"))
                            System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 5: //5. Modificarea stării în care se află un echipament
                    System.out.println("\n\nModificarea starii unui echipament:\n");
                    modificareStareEchipament(lista_echipamente);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 6: //6. Setarea unui anumit mod de scriere pentru o imprimantă
                    System.out.println("\n\nSetarea unui anumit mod de scriere pentru o imprimanta:\n");
                    setareModScriereImprimanta(lista_echipamente);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 7: //7. Setarea unui format de copiere pentru copiatoare
                    System.out.println("\n\nSetarea unui format de copiere pentru copiatoare:\n");
                    setareFormatCopiereCopiator(lista_echipamente);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 8: //8. Instalarea unui anumit sistem de operare pe un sistem de calcul
                    System.out.println("\n\nInstalarea unui anumit sistem de operare pe un sistem de calcul:\n");
                    instalareSOpeSC(lista_echipamente);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 9: //9. Afişarea echipamentelor vândute
                    System.out.println("\n\nAfisarea echipamente vandute:\n");
                    for (EchipamentElectronic e : lista_echipamente)
                        if (e.getSituatie().equals(Situatie.vandut))
                            System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 10: //10. Să se realizeze două metode statice pentru serializarea / deserializarea
                    System.out.println("\n\nSerializare / Deserializare:\n");
                    scrie_serializare(lista_echipamente, "echip.bin");
                    List<EchipamentElectronic> q = (List<EchipamentElectronic>) citeste_deserializare("echip.bin");
                    for (EchipamentElectronic e : q)
                        System.out.println(e);
                    System.out.println("\n--------------------------------\n");
                    break;
                case 11: //11. Iesire
                    System.out.println("\n\nIESIRE...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\nOPTIUNE INVALIDA!!!");
                    break;
            }
        }
    }
}
