import java.util.*;

public class Naloga22 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		int p = sc.nextInt();
		
		int preostalaPot = d;
		int prehodi = p;
		int dan = 1;
		
		while (preostalaPot > 0) {
			if (preostalaPot < prehodi) {
				prehodi = preostalaPot;
			}
			
			int preostalaPotKonec = preostalaPot - prehodi;
			System.out.printf("%d. dan: %d -> %d (prehodil %d)%n",  
				dan, preostalaPot, preostalaPotKonec, prehodi);
			dan++;
			preostalaPot -= prehodi;
			
		}
		
		
	}
}