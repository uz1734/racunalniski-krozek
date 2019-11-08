import java.util.*;

public class Piramida {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// System.out.println(Arrays.toString(args));
		
		int stVrstic = sc.nextInt();
		
		
		// stevilo presledkov v trenutni vrstici
		int stPresledkov = stVrstic - 1;
		
		// stevilo zvezdic v trenutni vrstici
		int stZvezdic = 1;
		
		for (int i = 1;  i <= stVrstic;  i++) {
			
			for (int j = 1;  j <= stPresledkov;  j++) {
				System.out.print(" ");
			}
			
			
			for (int j = 1;  j <= stZvezdic;  j++) {
				System.out.print("*");
			}
			
			
			System.out.println();
			
			
			stPresledkov--;
			stZvezdic += 2;
		}
		
	}
	
	
	private static void zaporedjeZnakov(char znak, int stZnakov) {
		for (int i = 1;  i <= stZnakov;  i++) {
			System.out.print(znak);
		}
	}
	
}
