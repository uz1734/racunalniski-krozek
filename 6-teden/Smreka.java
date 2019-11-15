import java.util.*;

public class Smreka {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stPiramid = sc.nextInt();
		
		
		for (int i = 1; i <= stPiramid; i++) {	
			izpisiPiramido(i, -1, 2, stPiramid - i);
		}
		
		// izpisiPiramido(stVrstic, 1, -2);
		
		
	}
	
	private static void izpisiPiramido(int steviloVrstic, int stDodanihPresledkov, 
									int steviloDodanihZvezdic, int dodatniZamik){
		int stPresledkov = 0;
		int stZvezdic = steviloVrstic * 2 - 1;
		
		if (stDodanihPresledkov < 0) {
			stZvezdic = 1;
			stPresledkov = steviloVrstic - 1;
		}
		
		for (int i = 1;  i <= steviloVrstic;  i++) {
			zaporedjeZnakov(' ', dodatniZamik);
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
