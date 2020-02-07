import java.util.Arrays;

public class Krozek {

    // dejavnost krozka this, npr. sah
    private String dejavnost;

    // dan v tednu, ko se kro"zek this izvaja (1: ponedeljek, 2: torek, ...)
    private int dan;

    // ura, ko se kro"zek this pricne
    private int zacUra;

    // "clani krozka this
    private Ucenec[] clani;

    public Krozek(String dejavnost, int dan, int zacUra) {
        this.dejavnost = dejavnost;
        this.dan = dan;
        this.zacUra = zacUra;
    }

    public void nastaviClane(Ucenec[] clani) {
        this.clani = clani;
    }	
	
	// getter, ki vrne dan kdaj se krožek izvaja
	public int vrniDan(){
		return this.dan;
	}
	// getter, ki vrne uro izvajanja krožka
	public int vrniUra(){
		return this.zacUra;
	}
	// vrne vse clane krožka
	public Ucenec[] vrniClane(){
		return this.clani;
	}
	
		// vrni samo razlicne dejavnosti, ki ga obiskujejo clani tega krozka.... 
	public int steviloRazlicnihDejavnosti(){
		int maxDolzina = 0;
		for(int i = 0; i < this.clani.length; i++){
			Krozek [] krozki = this.clani[i].krozki;
			for(int j = 0; j < krozki.length; j++){
				maxDolzina++;
			}
		}
		
		String [] dejavnosti = new String [maxDolzina];
		
		int d = 0;
		
		for(int i = 0; i < this.clani.length; i++){
			Krozek[] krozki = this.clani[i].krozki;
				for(int j = 0; j < krozki.length; j++){
				dejavnosti[d] = krozki[j].dejavnost;
				d++;
			}
		}
		
		Arrays.sort(dejavnosti);
		int stRazlicnih = 1;
		for(int i = 1; i < dejavnosti.length; i++){
			if(! dejavnosti[i].equals(dejavnosti[i - 1])){
				stRazlicnih++;
			}
		}	
		return stRazlicnih;
	}	
	
	
}
