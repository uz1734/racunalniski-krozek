import java.util.*;

public class MaksimumTrojice {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Preberi prvo: ");
		int a = sc.nextInt();
		System.out.println("Preberi drugo: ");
		int b = sc.nextInt();
		System.out.println("Preberi tretjo: ");
		int c = sc.nextInt();
		
		int maks = a;
		if (b > maks)
			maks = b;
		if (c > maks) {
			maks = c;
		}
		System.out.println(maks);
	}
}