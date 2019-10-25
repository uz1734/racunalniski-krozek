import java.util.*;

class Naloga11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int prvaStevila = sc.nextInt();
		int drugaStevilka = sc.nextInt();
		int tretjaStevilka = sc.nextInt();
		
		int max = prvaStevila;
		if (max < drugaStevilka) {
			System.out.println("vecja druga");
			max = drugaStevilka;
		}
		
		if (max < tretjaStevilka) {
			System.out.println("vecja tretjaStevilka");
			max = tretjaStevilka;
		}
		
		
		System.out.println("Max stevilka: " + max);
		
	}
}