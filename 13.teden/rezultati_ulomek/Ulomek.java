public class Ulomek{
	
	private int stevec;
	private int imenovalec;
	
	
	public Ulomek(int a, int b){
	}

	
	// Metoda, ki izračuna največji skupni delitelj dveh števil
	private static int gcd (int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}