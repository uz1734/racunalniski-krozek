import java.util.*;


public class Kombinacije {
	
	public static void izpisiKombinacije(int n, int k, int[] tabelaKombinacij, int pozicijaVTabeli) {
		
		// ce smo prisli do konca velikosti kombinacije.
		if (pozicijaVTabeli == k) {
			// izpisi kombinacijo
			for (int i = 0; i < k; i++) {
				System.out.printf("%d ", tabelaKombinacij[i]);
			}
			System.out.println();
			return;
		}
		 
		int uporabiStevilo; // moramo slediti katero stevilo smo ze uporabili in katero se bomo, da se v rekurziji ne ponavljamo
		if (pozicijaVTabeli == 0) {  // ce smo na zacetku v tabeli, zacnemo pri stevilu ena
			 uporabiStevilo = 1;
		} else {
			// ce nismo v zacetku v tabeli, moramo uporabiti za eno večjo število, kot smo jo uporabili na zadnje
			uporabiStevilo = tabelaKombinacij[pozicijaVTabeli - 1] + 1;
		}
		
		// gremo po vseh stevilih od trenutnega stevila pa do števila n
		for (int i = uporabiStevilo; i <= n; i++) { 
			tabelaKombinacij[pozicijaVTabeli] = i;  // zapisemo trenutno stevilo na pozivijo v tabeli
			// povecamo pozicijo kamor bomo v naslednjem rekurzivnem klicu pisali v tabelo
			izpisiKombinacije(n, k, tabelaKombinacij, pozicijaVTabeli + 1); 
		}
	}
	
	public static void main(String[] args) {
		int n = 5; // delamo kombinacije stevila od 1...5
		int k = 3; // velikost kombinacije je 3
		
		int[] tabelaKombinacij = new int[k];
		
		izpisiKombinacije(n, k, tabelaKombinacij, 0); // pri prvem klicu zacnemo pisat v tabelo kombinacij na poziciji 0	
	}
} 