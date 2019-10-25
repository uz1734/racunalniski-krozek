import java.util.*;

public class Naloga2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dolzinaPoti = sc.nextInt();
		int potNaDan = sc.nextInt();
		int utrjenost = sc.nextInt();
		
		int preostalaPot = dolzinaPoti;
		int prehodi = potNaDan;
		int dan = 1;
		
		while(preostalaPot > 0 && prehodi > 0) {
			
			if (prehodi > preostalaPot) {
				prehodi = preostalaPot;
			}
			
			int preostalaPotNaKoncuDneva = preostalaPot - prehodi;
			
			System.out.println(dan + ". dan: " + 
							preostalaPot + " -> " + 
							preostalaPotNaKoncuDneva + 
							"( prehodil: " + prehodi + " )");
			
			// System.out.printf("%d. dan: %d -> %d ( prehodil %d ) %n", dan, preostalaPot, preostalaPotNaKoncuDneva, prehodi);
			
			dan += 1;
			preostalaPot = preostalaPotNaKoncuDneva;
			prehodi = prehodi - utrjenost;
		}
		
	}
}