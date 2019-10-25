import java.util.*;

class Naloga33 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stevilo = sc.nextInt();
		
		while(stevilo > 0) {				
			int ostanek = stevilo % 10;
			stevilo = stevilo / 10;
		
			System.out.println("Ostanek: " + ostanek);
		}
		
		
	}
}