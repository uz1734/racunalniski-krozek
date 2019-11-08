
import java.util.*;

public class Funkcije {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		prvaMetoda(1, 2);
		// System.out.println(a);
		int rs = sestejMetoda(1, 2);
		int rs1 = sestejMetoda(5, 10);
		
		
		System.out.println(rs1);
		System.out.println(rs);

	}
	// public, private, protected..
	// void, int, String, 
	// static 
	// ime
	// ()
	
	public static void prvaMetoda(int a, int b){
		System.out.println(a);
	}
	
	public static int sestejMetoda(int a, int b){
		
		return a + b;
	}
	
}
