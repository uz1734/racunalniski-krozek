
public class Ucenec {

    // ime in priimek ucenca this
    private String ip;

    // razred, ki ga ucenec this obiskuje
    private int razred;

    // krozki, v katere je vclanjen ucenec this
    public Krozek[] krozki;

    public Ucenec(String ip, int razred) {
        this.ip = ip;
        this.razred = razred;
    }

    public void nastaviKrozke(Krozek[] krozki) {
        this.krozki = krozki;
    }
}
