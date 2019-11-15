import java.util.*;

class Vojaki {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int stVojakov = sc.nextInt();
		
		System.out.println(stVojakov);
		
		int[] vrstaVojakov = new int[stVojakov];
		
		for (int i = 0; i < stVojakov; i++) {
			int prebrano = sc.nextInt();
			vrstaVojakov[i] = prebrano;
		}
		
		izpisTabele(vrstaVojakov);
		
	}
	
		
	public static void izpisTabele(int[] tabelaIzpis) {
		for (int i = 0; i < tabelaIzpis.length; i++) {
			System.out.println(tabelaIzpis[i]);
		}
	}
}