import java.util.*;

class Factorial {
	
	
	public static int factorial(int stevilo) {
		if (stevilo <= 1) {
			return 1;
		}
		return stevilo * factorial(stevilo - 1);
	}
	
	
	public static void main(String[] args) {
		System.out.println("dela");
		
		int factorial = factorial(5);
		System.out.println(factorial);
		
	}
}