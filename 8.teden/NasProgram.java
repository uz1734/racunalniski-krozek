import java.util.*;

class NasProgram {
	
	public static void main(String[] args){
		String toJeString = "nas string";
		// int
		// float, double 
		// int[]  
		
		System.out.println(toJeString);
		prvaMetoda(5);
		prvaMetoda(10);
		
		int[] imeTabele = new int[5];
		System.out.println(imeTabele[0]);
		imeTabele[0] = 9;
		System.out.println(imeTabele[0]);
		System.out.println("dolzina: " + imeTabele.length);
		// izpisiTabelo(imeTabele);
		
		int[] novaTabela = izpisiTabelo(imeTabele);
		
		System.out.println("nova tabela: " + novaTabela[0]);
		
		int[] t = new int[]{64, 25, 88, 11};
		System.out.println(izpisiTabelo(t));
	}
	
	
	public static void prvaMetoda(int num) {
		
		System.out.println(num);
	}
	
	public static int[] izpisiTabelo(int[] imeTabele123) {
		
		for (int i = 0; i < imeTabele123.length; i = i +1) {
			System.out.print(imeTabele123[i]);
			imeTabele123[i] = imeTabele123[i] + 1;
		}
		
		return imeTabele123;
	}
}