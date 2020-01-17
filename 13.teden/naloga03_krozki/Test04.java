
public class Test04 {

    public static void main(String[] args) {

        Ucenec[] ucenci = {
            new Ucenec("Ana Anclin",     7),
            new Ucenec("Bojan Bizjak",   5),
            new Ucenec("Cene Cajzek",    6),
            new Ucenec("Dejan Dolenc",   6),
            new Ucenec("Eva Ertl",       5),
            new Ucenec("Franci Finžgar", 6),
            new Ucenec("Gorazd Gornik",  6),
        };

        Krozek[] krozki = {
            new Krozek("šah",         2, 15),
            new Krozek("planinstvo",  3, 14),
            new Krozek("rokodelstvo", 4, 12),
            new Krozek("fizika",      2, 12),
            new Krozek("matematika",  2, 14),
            new Krozek("fizika",      3, 15),
        };

        ucenci[0].nastaviKrozke(new Krozek[]{krozki[0], krozki[1]});
        ucenci[1].nastaviKrozke(new Krozek[]{krozki[0], krozki[5]});
        ucenci[2].nastaviKrozke(new Krozek[]{krozki[0], krozki[1], krozki[2]});
        ucenci[3].nastaviKrozke(new Krozek[]{krozki[0], krozki[2], krozki[3]});
        ucenci[4].nastaviKrozke(new Krozek[]{krozki[3], krozki[5]});
        ucenci[5].nastaviKrozke(new Krozek[]{krozki[4], krozki[5]});
        ucenci[6].nastaviKrozke(new Krozek[]{krozki[0], krozki[5]});

        krozki[0].nastaviClane(new Ucenec[]{ucenci[0], ucenci[2], ucenci[3], ucenci[1], ucenci[6]});
        krozki[1].nastaviClane(new Ucenec[]{ucenci[0], ucenci[2]});
        krozki[2].nastaviClane(new Ucenec[]{ucenci[2], ucenci[3]});
        krozki[3].nastaviClane(new Ucenec[]{ucenci[3], ucenci[4]});
        krozki[4].nastaviClane(new Ucenec[]{ucenci[5]});
        krozki[5].nastaviClane(new Ucenec[]{ucenci[1], ucenci[4], ucenci[5], ucenci[6]});

        System.out.println(ucenci[5].imaCasZa(krozki[0]));
        System.out.println(ucenci[5].imaCasZa(krozki[1]));
        System.out.println(ucenci[5].imaCasZa(krozki[2]));
        System.out.println(ucenci[5].imaCasZa(krozki[3]));
        System.out.println("----------");

        System.out.println(ucenci[6].imaCasZa(krozki[1]));
        System.out.println(ucenci[6].imaCasZa(krozki[2]));
        System.out.println(ucenci[6].imaCasZa(krozki[3]));
        System.out.println(ucenci[6].imaCasZa(krozki[4]));
    }
}
