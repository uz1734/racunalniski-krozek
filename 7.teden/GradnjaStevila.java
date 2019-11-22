
import java.util.Scanner;

public class GradnjaStevila {

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// tekoče število
		int stevilo = 1;
		
		while (sc.hasNextInt()) {			
			// preberi ukaz
			int ukaz = sc.nextInt();
			
			// izvrši ukaz
			switch (ukaz) {
				case 1: {
					int parameter = sc.nextInt();
					stevilo = dodajNaZacetek(stevilo, parameter);
					break;
				}
				
				case 2: {
					int parameter = sc.nextInt();
					stevilo = dodajNaKonec(stevilo, parameter);
					break;
				}
				
				case -1:
					stevilo = odstraniPrvo(stevilo);
					break;
					
				case -2:
					stevilo = odstraniZadnjo(stevilo);
					break;
			}
			
			// izpiši tekoče število
			System.out.println(stevilo);
		}		
    }
	
	// Doda podano števko na začetek podanega števila in vrne rezultat.
	private static int dodajNaZacetek(int stevilo, int stevka) {
		return (stevka * navzdolDoPotence10(stevilo) * 10 + stevilo);
	}
	
	// Doda podano števko na konec podanega števila in vrne rezultat.
	private static int dodajNaKonec(int stevilo, int stevka) {
		return (stevilo * 10 + stevka);
	}
	
	// Odstrani prvo števko podanega števila.
	private static int odstraniPrvo(int stevilo) {
		return (stevilo % navzdolDoPotence10(stevilo));
	}
	
	// Odstrani zadnjo števko podanega števila.
	private static int odstraniZadnjo(int stevilo) {
		return (stevilo / 10);
	}
	
	// Vrne največjo potenco števila 10, ki ni večja od podanega
	// števila.
	private static int navzdolDoPotence10(int stevilo) {
		int potenca = 1;
		while (stevilo >= 10) {
			stevilo /= 10;
			potenca *= 10;
		}
		return potenca;
	}
}
