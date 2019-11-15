
import java.util.*;

public class Tabele {
	public static void main (String [] args){		
		
		int n = 2;
		int[] tabela = new int[n];
		
		tabela[0] = 1;
		tabela[1] = 2;
		
		System.out.println(tabela);
		System.out.println(tabela[0]);
		System.out.println(tabela[1]);
		
		System.out.println("-----------------");
		int[] tabela2 = new int[] {5, 6, 7};
		System.out.println(tabela2.length);
		System.out.println(tabela2[0]);
		System.out.println((Arrays.toString(tabela2)));
		
	}
    
}