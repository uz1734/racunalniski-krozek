
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
	
		
	public String toString(){
		return this.ip+", "+this.razred+". razred";
	}
	
	// ali ima ucenec se cas za dolocen podani krozek. Upostevamo da vsak krozek traja 2uri
	public boolean imaCasZa(Krozek k){
		for(int i = 0; i < this.krozki.length; i++){
			if(this.krozki[i].vrniDan() == k.vrniDan()){
				if(Math.abs(krozki[i].vrniUra() - k.vrniUra()) < 2)
					return false;
			}
		}
		return true;
	}
	
	public int steviloSosolcevVKrozku(Krozek k) {
		Ucenec[] ucenciKrozka = k.vrniClane();
		
		int stSosolcev = 0;
		
		for (int i = 0; i < ucenciKrozka.length; i++) {
			
			if (ucenciKrozka[i].razred == this.razred && ucenciKrozka[i] != this) {
				stSosolcev++;
			}
			
		}
		
		return stSosolcev;
	}
	
}
