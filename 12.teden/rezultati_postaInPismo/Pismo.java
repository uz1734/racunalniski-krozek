public class Pismo{
	
	private Posta izvorna;
	private Posta ciljna;
	private boolean jePriporoceno;
	private int razdalja;
	
	private static int s_priporocnina;
	private static int s_enotaRazdalje;
	private static int s_enotaCene;
	
	public Pismo(Posta izvorna, Posta ciljna, boolean jePriporoceno, int razdalja){
		this.izvorna = izvorna;
		this.ciljna = ciljna;
		this.jePriporoceno = jePriporoceno;
		this.razdalja = razdalja;
	}
	public String toString(){
		char vrsta;
		if(this.jePriporoceno){
			vrsta = 'P';
		}
		else{
			vrsta = 'N';
		}
		// return "";
		return this.izvorna.toString()+" -> "+this.ciljna.toString()+" ("+this.razdalja+" km) ["+vrsta+"]";
	}
	public boolean izviraOd(Posta posta){
		if(this.izvorna.toString().equals(posta.toString())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean staIzvorInCiljIsta(){
		if(this.izvorna.equals(this.ciljna)) return true;
		return false;
	}
	
	public boolean imaIstiCiljKot(Pismo pismo){
		if(this.ciljna.equals(pismo.ciljna)) return true;
		return false;
	}
	
	public static boolean imataIstiCilj(Pismo p1, Pismo p2){
		if(p1.ciljna.equals(p2.ciljna)) return true;
		return false;
	}

	
	public int cena (){
		int p = 0;
		if (jePriporoceno) p =s_priporocnina;
		int izracun = ((this.razdalja / s_enotaRazdalje) + 1) * s_enotaCene +p;
		return izracun;
	}
	public static void nastaviKonstanteZaCeno (int enotaRazdalje, int enotaCene, int priporocnina){
		s_priporocnina = priporocnina;
		s_enotaRazdalje = enotaRazdalje;
		s_enotaCene = enotaCene;
	}
	
	public boolean jeDrazjeOd(Pismo pismo){
		if(this.cena() > pismo.cena()) return true;
		return false;
	}
	
	public static Pismo vrniDrazje(Pismo p1, Pismo p2){
		if(p1.cena() > p2.cena()) return p1;
		return p2;
	}
	public Pismo izdelajPovratno(){
		return new Pismo (this.ciljna, this.izvorna, this.jePriporoceno, this.razdalja);
	}
}

