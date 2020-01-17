
import java.util.Arrays;

public class Krozek {

    // dejavnost kro"zka this, npr. "sah
    private String dejavnost;

    // dan v tednu, ko se kro"zek this izvaja (1: ponedeljek, 2: torek, ...)
    private int dan;

    // ura, ko se kro"zek this pri"cne
    private int zacUra;

    // "clani kro"zka this
    private Ucenec[] clani;

    public Krozek(String dejavnost, int dan, int zacUra) {
        this.dejavnost = dejavnost;
        this.dan = dan;
        this.zacUra = zacUra;
    }

    public void nastaviClane(Ucenec[] clani) {
        this.clani = clani;
    }	
}
