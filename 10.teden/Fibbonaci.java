import java.util.*;

class Fibbonaci {
	
	
	public static int fibb(int stevilo) {
		
		if (stevilo <= 1) {
			return stevilo;
		}
		
		return fibb(stevilo - 1) + fibb(stevilo - 2);
		
	}
	
	public static void main(String[] args) {
		
		// System.out.println("dela fib");
		int fibbStevilo =   fibb(9);
		System.out.println("fibbStevilo: " + fibbStevilo);
		
	}
	
}