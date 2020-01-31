public class Ulomek{
	
	private int stevec;
	private int imenovalec;
	
	
	public Ulomek(int a, int b){
	}
	
	// great common devisor .... recursion function..
	private static int gcd (int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}