package Uebungen._100_OOP;

public class Main {
    public static void main(String[] args) {


        ZahlenSystemRechner zahlenRechner = new ZahlenSystemRechner(123456789,"0sMOIN", 34);
        System.out.println(zahlenRechner.dezimalZuXBasis());  // 0s2OD2I1
        System.out.println(zahlenRechner.xbasisZuDezimal());   // 893067

        ZahlenSystemRechner zahlenRechner2 = new ZahlenSystemRechner(4095,"0sFF", 16);
        System.out.println(zahlenRechner2.dezimalZuXBasis());  // 0sFFF
        System.out.println(zahlenRechner2.xbasisZuDezimal());   // 255

        ZahlenSystemRechner zahlenRechner3 = new ZahlenSystemRechner(255,"0s100000000", 2);
        System.out.println(zahlenRechner3.dezimalZuXBasis());  // 0sFFF
        System.out.println(zahlenRechner3.xbasisZuDezimal());   // 255

        System.out.println("Es sind " + zahlenRechner.getCount() + " Rechner vorhanden!");
    }
}
