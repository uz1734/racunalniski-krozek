
public class Ucenec {

    // ime in priimek u"cenca this
    private String ip;

    // razred, ki ga u"cenec this obiskuje
    private int razred;

    // kro"zki, v katere je v"clanjen u"cenec this
    private Krozek[] krozki;

    public Ucenec(String ip, int razred) {
        this.ip = ip;
        this.razred = razred;
    }

    public void nastaviKrozke(Krozek[] krozki) {
        this.krozki = krozki;
    }
}
