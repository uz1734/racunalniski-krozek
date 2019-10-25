import java.util.*;

public class Naloga1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int stevilo1 = sc.nextInt();
		int stevilo2 = sc.nextInt();
		int stevilo3 = sc.nextInt();
		
		
		int maxStevilo = stevilo1;
		
		if (stevilo2 >= maxStevilo) {
			maxStevilo = stevilo2;
		}
		
		if (stevilo3 >= maxStevilo) {
			maxStevilo = stevilo3;
		}
		
		System.out.println("Max stevilo: " +  Integer.toString(maxStevilo));
		
	}
}