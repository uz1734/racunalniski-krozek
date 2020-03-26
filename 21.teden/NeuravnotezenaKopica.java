import java.util.*;


class Kopica{
	
	public int vrednost;
	public Kopica levo;
	Kopica desno;
	
	public Kopica(int stevilo) {
		this.vrednost = stevilo;
		this.levo = null;
		this.desno = null;
	}
}

class DrevoKopice {
	
	public Kopica drevoA;
	
	public DrevoKopice() {
		this.drevoA = null;
	}
	
	// metoda, ki ustvari kopico z enim elementov v korenu drevesa.
	public Kopica narediBDrevo(int vrednost) {
		return new Kopica(vrednost);
	}
	
	public Kopica merge(Kopica kopicaA, Kopica kopicaB) {
		// robni pogoji. Ce je katerakoli kopica null potem vrnemo drugo izmed kopic
		if(kopicaA == null) {
			return kopicaB;
		}
		
		if (kopicaB == null) {
			return kopicaA;
		}
		
		// na vrhu mora biti zmeraj najmanjsi elementov
		if (kopicaA.vrednost > kopicaB.vrednost) {
			// potrebna je zamenjava kopiceA, ki predstavlja manjso izmed kopic
			Kopica tmp = kopicaA;
			kopicaA = kopicaB;
			kopicaB = tmp;
		}
		
		Kopica tmpKopica = new Kopica(kopicaA.vrednost);
		tmpKopica.levo = this.merge(kopicaA.desno, kopicaB);
		tmpKopica.desno = kopicaA.levo;
		
		return tmpKopica;
	}
	
	// dodaj novo vrednost v kopico
	public void push(int stevilo) {
		Kopica kopicaB = this.narediBDrevo(stevilo);
		this.drevoA = this.merge(this.drevoA, kopicaB);
	}
	
	// vrni in odstrani najmanjso vrednost iz kopice.
	public int pop() {
		Kopica tmp = this.drevoA;
		// zdruzi levo in desno poddrevo kopice v novo neuravnotezeno kopico.
		this.drevoA = this.merge(tmp.levo, tmp.desno);
		//System.out.println(this.drevoA);
		return tmp.vrednost;
	}
}


public class NeuravnotezenaKopica {
	
	
	public static void main(String[] args) {
		DrevoKopice kopicaDrevo = new DrevoKopice();
		kopicaDrevo.push(5);
		kopicaDrevo.push(4);
		kopicaDrevo.push(1);
		kopicaDrevo.push(2);
		kopicaDrevo.push(3);
		
		System.out.println("IZPIS PO STRUKTURI KOPICE: ");
		System.out.println("KOREN: " + kopicaDrevo.drevoA.vrednost);
		System.out.println("LEVO: " + kopicaDrevo.drevoA.levo.vrednost);
		System.out.println("LEVO LEVO: " + kopicaDrevo.drevoA.levo.levo.vrednost);
		System.out.println("LEVO LEVO LEVO: " +kopicaDrevo.drevoA.levo.levo.levo.vrednost);
		System.out.println("DESNO: " + kopicaDrevo.drevoA.desno.vrednost);
		
		System.out.println("Urejen izpis stevil iz kopice: ");
		while(kopicaDrevo.drevoA != null) {
			System.out.print(kopicaDrevo.pop() + " ");
		}
		
	}
}