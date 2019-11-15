import java.util.*;

public class SmrekaSPiramido {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stPiramid = sc.nextInt();
		
		for (int i = 1;  i <= stPiramid;  i++) {
			izpisiPiramido(i, -1, 2, stPiramid-i);
		}
	}
	
	private static void izpisiPiramido(int steviloVrstic, int stDodanihPresledkov, int steviloDodanihZvezdic, int zamik){
		int stPresledkov = 0;
		int stZvezdic = steviloVrstic * 2 - 1;
		
		if (stDodanihPresledkov < 0) {
			stZvezdic = 1;
			stPresledkov = steviloVrstic - 1;
		}
		
		for (int i = 1;  i <= steviloVrstic;  i++) {
			
			zaporedjeZnakov(' ', zamik);
			zaporedjeZnakov(' ', stPresledkov);
			zaporedjeZnakov('*', stZvezdic);
			
			System.out.println();
				
			stPresledkov +=  stDodanihPresledkov;
			stZvezdic += steviloDodanihZvezdic;
		}
	}
	
	
	private static void zaporedjeZnakov(char znak, int stZnakov) {
		for (int i = 1;  i <= stZnakov;  i++) {
			System.out.print(znak);
		}
	}
	
}
