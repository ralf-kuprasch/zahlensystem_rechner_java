package Uebungen._100_OOP;

import java.util.Arrays;

public class ZahlenSystemRechner {

    private static int basis;
    private static int count;

    private int zahlDecimal;
    private String zahlXBasis;

    ZahlenSystemRechner(int zahlDecimal, String zahlXBasis, int basis) {
        this.zahlDecimal = zahlDecimal;
        this.zahlXBasis = zahlXBasis;
        this.basis = basis;
        ZahlenSystemRechner.count++;
    }

    ZahlenSystemRechner() {
        this(123456789, "0sMOIN", 34);
    }

    ZahlenSystemRechner(int zahlDecimal, int basis) {
        this.zahlDecimal = zahlDecimal;
        this.basis = basis;
        ZahlenSystemRechner.count++;
    }

    ZahlenSystemRechner(int zahlDecimal) {
        this(zahlDecimal, 34);
    }

    ZahlenSystemRechner(String zahlXBasis, int basis) {
        this.zahlXBasis = zahlXBasis;
        this.basis = basis;
        ZahlenSystemRechner.count++;
    }

    ZahlenSystemRechner(String zahlXBasis) {
        this(zahlXBasis, 34);
    }

    public int getBasis() {
        return basis;
    }

    public void setBasis(int basis) {
        this.basis = basis;
    }

    public int getCount() {
        return count;
    }

    public int getZahlDecimal() {
        return zahlDecimal;
    }

    public void setZahlDecimal(int zahlDecimal) {
        this.zahlDecimal = zahlDecimal;
    }

    public String getZahlXBasis() {
        return zahlXBasis;
    }

    public void setZahlXBasis(String zahlXBasis) {
        this.zahlXBasis = zahlXBasis;
    }

    private String[] macheZahlenRaum(int laenge) {
        String[] zahlenRaum = new String[laenge];
        char zeichen = 65;

        for (int i = 0; i < zahlenRaum.length; i++) {
            if (i < 10) zahlenRaum[i] = String.valueOf(i);
            else {
                zahlenRaum[i] = String.valueOf(zeichen);
                zeichen++;
            }
            System.out.print(zahlenRaum[i] + " ");
        }
        System.out.println();
        return zahlenRaum;
    }

    private int berechneArrayLaenge(int zahl, int basis) {
        this.basis = basis;
        if (zahl == 0) return 1; // Sonderfall für die Null

        // Formel: Klammerwert wird durch den int-Cast automatisch abgerundet
        return (int) (Math.log(zahl) / Math.log(basis)) + 1;
    }

    public String dezimalZuXBasis() {
        int zahl = this.zahlDecimal;
        String[] zahlenRaum = this.macheZahlenRaum(this.basis);
        String ergebnis = "0s";
        int laenge = this.berechneArrayLaenge(zahl, this.basis);
        int[] rest = new int[laenge];
        int n = 0;

        do {
            rest[n] = zahl % this.basis;
            n += 1;
            zahl = zahl / this.basis;
        } while (zahl > 0);

        for (int i = rest.length-1; i >= 0; i--) {
            for (int j = 0; j < zahlenRaum.length; j++) {
                if (rest[i] == j) ergebnis += zahlenRaum[j];
            }
        }

        return ergebnis;
    }


    public int xbasisZuDezimal() {
        String text = this.zahlXBasis;
        if (text.charAt(0) == '0' && (text.charAt(1) == 's' || text.charAt(1) == 'S')) {
            text = text.substring(2);
        }
        String invertStr = new StringBuilder(text).reverse().toString();
        //int basis = 34;
        String[] zahlenRaum = this.macheZahlenRaum(this.basis);
        int ergebnis = 0;

        for (int i = 0; i < invertStr.length(); i++) {
            String zeichen = String.valueOf(invertStr.charAt(i));
            boolean gefunden = Arrays.asList(zahlenRaum).contains(zeichen);
            if (gefunden == true) {
                for (int j = 0; j < zahlenRaum.length; j++) {
                    if (zeichen.equals(zahlenRaum[j])) {
                        int temp = (int) Math.pow(basis, i) * j;
                        ergebnis += temp;
                    }
                }
            }
            else {
                System.out.println("Ungültiges Zeichen, bitte ein Zeichen aus dem gültigen Zahlenraum eingeben.");
                return 0;
            }
        }

        return ergebnis;
    }

}
