
/**
Program, ki zgradi Binarno iskalno oblike: 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 
	   
in izpise elemente drevesa v inorder nacinu: 
IZHOD:
20
30
40
50
60
70
80

--> Na ključnih mestih v kodi so komentarji glede na novadila v datoteki: 20.teden_navodila_in_teorija.txt
*/

public class BST { // Binarno iskalno drevo
	
	class Vozlisce {
		int kljuc;
		Vozlisce levo;
		Vozlisce desno;
		
		Vozlisce(int novKluc) {
			this.kljuc = novKluc;
			this.levo = null;
			this.desno = null;
		}
	}
	
	Vozlisce koren;
	BST() {
		this.koren = null;
	}
	
	public void vstaviVozlisce(int novaVrednost) {
		this.koren = this.vstaviVozlisceRekurzivno(this.koren, novaVrednost);
	}
	
	private Vozlisce vstaviVozlisceRekurzivno(Vozlisce koren,  int novaVrednost) {
		if (koren == null) {
			/**
			Ko smo v listu drevesa ustvarimo novo vozlisce in vrnemo drevo.
			*/
			koren = new Vozlisce(novaVrednost);
			return koren;
		}
		
		/**
			Uredimo vozlisca tako, da so vozlisca v levem poddrevesu manjša od trenutnega vozlisca int
			vozlisca v desnem poddrevesu vecja od trenutnega vozlisca
		*/
		if (koren.kljuc > novaVrednost) {
			// Ce je nova vrednost manjsa od trenutne vrednosti, gremo v levo poddrevo
			koren.levo = this.vstaviVozlisceRekurzivno(koren.levo, novaVrednost); 
		} else if (koren.kljuc < novaVrednost) {
			// ce je trenutna vrednsot vecja od trenutne vrednsoti gremo v desno poddrevo
			koren.desno = this.vstaviVozlisceRekurzivno(koren.desno, novaVrednost);
		}
		// ko se vrnemo iz rekurzije vracamo vrednosti drevesa.
		return koren;	
	}
	
	
	// Izpis drevesa v INORDER obliki
	public void izpisiDrevoINORDER() {
		System.out.println("IZHOD: ");
		this.izpisiDrevoINORDERrekurzivno(this.koren);
		
	}
	
	private void izpisiDrevoINORDERrekurzivno(Vozlisce koren) {
		
		// ce smo prisli do konca drevesa po eni izmed vej, se mora vrnit nazaj
		if (koren == null) {
			return;
		}
		
		// po inorder izpisu pravila gremo najprej v levo poddrevo trenutnega vozlisca 
		this.izpisiDrevoINORDERrekurzivno(koren.levo);
		
		// ko se vracamo iz levega podrevesa izpisemo trenutno vozlisce (trenutni koren vozlisca)
		System.out.println(koren.kljuc);
		
		// po inorder pravilu gremo na koncu v desno podrevo trenutnega vozlisca
		this.izpisiDrevoINORDERrekurzivno(koren.desno);
	}
	
	
	
	public void poisciKljuc(int iskalniKljuc) {
		Vozlisce najdenoVozlisce = this.poisciRekurzivno(this.koren, iskalniKljuc);
		if (najdenoVozlisce == null) {
			System.out.println("Iskalni kljuc: " + iskalniKljuc + "  ne obstaja v drevesu");
			return;
		}

		System.out.println("Najdeno: " + najdenoVozlisce.kljuc);
		
	}
	
	/**
	metoda, ki v BST poisce dano vozlisce, ce obstaja. Poglej teorijo v navodilih 20.teden_navodila_in_teorija.txt
	*/
	private Vozlisce poisciRekurzivno(Vozlisce koren, int iskalniKLjuc) 
	{ 
		// Ce je trenutni koren null ali pa se kljuc ujema vrnemo trenutni kljuc
		if (koren == null || koren.kljuc==iskalniKLjuc) 
			return koren; 
	  
		// Ce je iskalni kljuc manjsi od trenutnega kljuca trenutnega vozlisca, gremo v njegovo levo poddrevo
		if (koren.kljuc > iskalniKLjuc) 
			return poisciRekurzivno(koren.levo, iskalniKLjuc); 
	  
		// Drugace pa je iskalni kljuc večji od kljuca trenutnega vozlisca, zato gremo v njegovo desno poddrevo
		return poisciRekurzivno(koren.desno, iskalniKLjuc); 
	} 
	
	
	public static void main(String[] args){
		BST binarnoIskalnoDrevo = new BST();

		binarnoIskalnoDrevo.vstaviVozlisce(50);
		binarnoIskalnoDrevo.vstaviVozlisce(30);
		binarnoIskalnoDrevo.vstaviVozlisce(20);
		binarnoIskalnoDrevo.vstaviVozlisce(40);
		binarnoIskalnoDrevo.vstaviVozlisce(70);
		binarnoIskalnoDrevo.vstaviVozlisce(60);
		binarnoIskalnoDrevo.vstaviVozlisce(80);
		
		System.out.println("KOREN: " + binarnoIskalnoDrevo.koren.kljuc);
		System.out.println("LEVO: " + binarnoIskalnoDrevo.koren.levo.kljuc);
		System.out.println("LEVO LEVO: " + binarnoIskalnoDrevo.koren.levo.levo.kljuc);
		System.out.println("LEVO DESNO: " + binarnoIskalnoDrevo.koren.levo.desno.kljuc);
		System.out.println("DESNO: " + binarnoIskalnoDrevo.koren.desno.kljuc);
		System.out.println("DESNO LEVO: " + binarnoIskalnoDrevo.koren.desno.levo.kljuc);
		System.out.println("DESNO DESNO: " + binarnoIskalnoDrevo.koren.desno.desno.kljuc);
		
		binarnoIskalnoDrevo.izpisiDrevoINORDER();
		
		System.out.println();
		System.out.println("ISKANJE");
		binarnoIskalnoDrevo.poisciKljuc(70);
		binarnoIskalnoDrevo.poisciKljuc(71);
	
	}
}