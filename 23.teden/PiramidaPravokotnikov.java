import java.util.*;

public class PiramidaPravokotnikov {
	
	// Insertion sort: https://www.geeksforgeeks.org/insertion-sort/
	public static int[][] uredi(int[][] tabela) {
		
		for (int i = 1; i < tabela.length; i++) {
			int tmp0 = tabela[i][0];
			int tmp1 = tabela[i][1];
			int j = i;
			
			while (j>0 && ( tmp0 > tabela[j - 1][0] || (tmp0 == tabela[j-1][0] && tmp1>tabela[j-1][1] )  ) ) {
				tabela[j][0] = tabela[j-1][0];
				tabela[j][1] = tabela[j-1][1];
				j--;
			}
			
			tabela[j][0] = tmp0;
			tabela[j][1] = tmp1;
		}
		
		return tabela;
	}
	
	public static int poisciVisino(int tmpPolozaj, int visinaPiramide, int sirina, int dolzina, int[][] tabelaPravokotnikov) {
		// ce smo na koncu samo se vrnemo visino.
		if (tmpPolozaj >= tabelaPravokotnikov.length) {
			return visinaPiramide;
		}
		
		// ce je trenutni pravokonitk v tabelci vecji ali enak po sirini ali visini od najbolj zgornje ploskve piramide se pramaknemo naprej
		if (tabelaPravokotnikov[tmpPolozaj][0] >= sirina || tabelaPravokotnikov[tmpPolozaj][1] >= dolzina ){
			return poisciVisino(tmpPolozaj + 1, visinaPiramide, sirina, dolzina, tabelaPravokotnikov);
		} else {
			// pravokotnik lahko ne dam ali dam na kup in se premaknem naprej po tabelci
			int nevzamemPravokotnik = poisciVisino(tmpPolozaj + 1, visinaPiramide, sirina, dolzina, tabelaPravokotnikov); // ne dam na kup
			int vzamemPravokotnik = poisciVisino(tmpPolozaj + 1, visinaPiramide + 1, tabelaPravokotnikov[tmpPolozaj][0], tabelaPravokotnikov[tmpPolozaj][1], tabelaPravokotnikov); // dam na kup
			
			// iz rekurzije vračam večjo izmed obeh opcij;
			return (nevzamemPravokotnik < vzamemPravokotnik) ? vzamemPravokotnik : nevzamemPravokotnik;	
		}
	}
	
	
	public static void main(String[] args) {
		// staticno definirana in prebrana tabela pravokotnikov iz vhoda
		int[][] tabelaPravokotnikov = new int[][]{
			new int []{2, 7},
			new int []{6, 9},
			new int []{3, 2},
			new int []{6, 6},
			new int []{1, 2}
		};
		
		/**
		KORAK 1 IZ NAVODIL
		*/
		System.out.println("PREBRANI PRAVOKOTNIKI");
		for (int i = 0; i < tabelaPravokotnikov.length; i++) {
			System.out.println(tabelaPravokotnikov[i][0] + " " + tabelaPravokotnikov[i][1]);
		}
		
		// na prvo mesto v tabelci dam večjo izmed dveh stranic
		for (int i = 0; i < tabelaPravokotnikov.length; i++) {
		
			if (tabelaPravokotnikov[i][0] < tabelaPravokotnikov[i][1]) {
				int tmp = tabelaPravokotnikov[i][0];
				tabelaPravokotnikov[i][0] = tabelaPravokotnikov[i][1];
				tabelaPravokotnikov[i][1] = tmp;
			}
		}
		
		System.out.println("PRAVOKOTNIKI PO VECJI STRANICI");
		for (int i = 0; i < tabelaPravokotnikov.length; i++) {
			System.out.println(tabelaPravokotnikov[i][0] + " " + tabelaPravokotnikov[i][1]);
		}		
		
		int[][] urejenaTabela = uredi(tabelaPravokotnikov);
		
		System.out.println("UREJENA TABELA PRAVOKOTNIKOV");
		for (int i = 0; i < urejenaTabela.length; i++) {
			System.out.println(urejenaTabela[i][0] + " " + urejenaTabela[i][1]);
		}
		
		
		/**
		KORAK 2 IZ NAVODIL
		*/
		int najvecjaVisina = 0;  // najvecja visina piramide pravokotnikov
		
		for (int i = 0; i < urejenaTabela.length; i++) {
			// zacni sestavljanje piramide na vseh moznih polozajih.
			int tmpNajvecji = poisciVisino( i +1, 1, urejenaTabela[i][0], urejenaTabela[i][1], urejenaTabela);
			if (tmpNajvecji > najvecjaVisina) {
				najvecjaVisina = tmpNajvecji;
			}
		}
		
		System.out.println("Najvecja piramida pravokotnikov: " + najvecjaVisina);
	}
	
}