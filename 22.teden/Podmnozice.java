// program za izpis vseh podmnozic mnozice n
import java.util.*;


public class Podmnozice {
	
	public static void izpisiPodmnozice(boolean[] tabelaPodmnozic, int n, int pozicija) {
		
		// ce smo na koncu tabele jo izpisemo
		if (pozicija == n) {
			for (int i = 0; i < n; i++) {
				// ce je element true je podmnozica..
				if (tabelaPodmnozic[i] == true) {
					System.out.printf("%d ", i + 1);
				}
			}
			System.out.println();
			return;
		}
		
		tabelaPodmnozic[pozicija] = true; // je v podmnozici
		izpisiPodmnozice(tabelaPodmnozic, n, pozicija + 1); // gremo naprej za eno pozicijo
		tabelaPodmnozic[pozicija] = false; // ni v podmnozici
		izpisiPodmnozice(tabelaPodmnozic, n, pozicija + 1); // gremo naprej za eno pozicijo
	}
	
	
	public static void main(String[] args) {
		int n = 4;
		
		boolean[] tabelaPodmnozic = new boolean[n];
		izpisiPodmnozice(tabelaPodmnozic, n, 0);
		
	}
	
}