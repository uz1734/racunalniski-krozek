
public class Test01 {

    public static void main(String[] args) {

        Ucenec[] ucenci = {
            new Ucenec("Ana Anclin",     7),
            new Ucenec("Bojan Bizjak",   5),
            new Ucenec("Cene Cajzek",    6),
            new Ucenec("Dejan Dolenc",   6),
            new Ucenec("Eva Ertl",       5),
            new Ucenec("Franci Finzgar", 6),
            new Ucenec("Gorazd Gornik",  6),
        };

        for (int i = 0;  i < ucenci.length;  i++) {
            System.out.println(ucenci[i].toString());
        }
    }
}
