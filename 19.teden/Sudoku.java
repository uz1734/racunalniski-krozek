public class Sudoku {

	// Rekurzivna funkcija
    static boolean resi(int i, int j, int[][] polje) 
    {
		/**Izpis klucnh lastnosi programa.  // pri zagonu odkomentiraj da se prepričaš kako se indeksi spreminjajo pri delovanju programa.
		System.out.println("i: " + i + " j: " + j);
		izpisiPolje(polje);*/
    	// ce smo prisli do konca tabele, vrni pozitiven rezultat
    	if (i >= polje.length)
    		return true;
    	// ce pridem do konca vrstice po vseh stolpcih se premaknem naprej...
    	if (j >= polje[i].length)
    		return resi(i+1, 0, polje); // rekurzivno reši naslednjo vrstico
    	// ce je vsebina celice polje[i][j] ze podana, rekurzivno poisci resitev za naslednjo celico
    	if (polje[i][j] != 0)
    		return resi(i, j+1, polje);
    	
    	// za vse mozne vrednosti celice polje[i][j] preveri, ali je situacija dovoljena
    	// ce je, rekurzivno poisci resitev za naslednjo celico
    	for (int v = 1; v <= 9; v++)
		{
			/** Izpis ključnih lastnosti programa.		// odkomentiraj da se prepričaš kako se spreminjajo števila 1 do 9 pri danih indeksih skozi delovanje programa.		
				System.out.println("V: " + v + " i: " + i + " j: " + j);
			*/
    		if (veljavno(i, j, v, polje))
    		{
    			polje[i][j] = v;
    			if (resi(i,j+1,polje)){	
					return true;
				}
    		}
		}
    	
    	// ce nobena vrednost ni dovoljena, razveljavi vsebino celice polje[i][j] in vrni negativen rezultat
    	polje[i][j] = 0;
		// System.out.println("vracam se nazaj"); // odkomentiraj, da se prepričaš na kateri točki program vrne negativen rezultat
		// program vrne negativen rezultat takrat ko za dano vrstico i in stolpec j ni našel veljavne vstavitve vrednosti med 1 in 9
        return false;
    }

    // Funkcija preveri, ali je dovoljeno postaviti vrednost "val" v polje[i][j]
    static boolean veljavno(int i, int j, int val, int[][] polje) 
    {
    	// preveri j-ti stolpec
        //   ce se vrednost "val" ze nahaja v j-tem stolpcu, potem je situacija neveljavna
       for (int k=0; k < polje.length; k++)
    	   if (polje[k][j] == val)
    		   return false;
       
    	// preveri i-to vrstico
        //   ce se vrednost "val" ze nahaja v i-ti vrstici, potem je situacija neveljavna
       for (int k=0; k < polje[i].length; k++)
    	   if (polje[i][k] == val)
    		   return false;
       
    	// preveri ustrezni kvadrat
        //   ce se vrednost "val" ze nahaja v kvadratu, potem je situacija neveljavna
        
		// dolocanje kvadranta 3x3 glede na trenutno vrstico i in stolpec j
		int vrstOd = (i/3)*3; 
        int stolpOd = (j/3)*3;
        
        for (int m = 0; m < 3; m++)
        	for (int n = 0; n < 3; n++)
        		if (polje[vrstOd + m][stolpOd + n] == val)
         		   return false;
        
        // vse pogoje smo preverili, je situacija veljavna
        return true;
    }

    static void izpisiPolje(int[][] polje) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (polje[i][j] == 0)
                	System.out.print(" ");
                else
                    System.out.print(polje[i][j]);

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public static void main(String[] args) {
		// Nereseno 9x9 SUDOKU polje. 0-cle predstavljajo prazna mesta, ki jih je potrebno se resiti po SUDOKU pravilih.
        int[][] polje = {
        		{0,8,0,4,0,2,0,6,0},
        		{0,3,4,0,0,0,9,1,0},
        		{9,6,0,0,0,0,0,8,4},
        		{0,0,0,2,1,6,0,0,0},
        		{0,0,0,0,0,0,0,0,0},
        		{0,0,0,3,5,7,0,0,0},
        		{8,4,0,0,0,0,0,7,5},
        		{0,2,6,0,0,0,1,3,0},
        		{0,9,0,7,0,1,0,4,0}
        };
        
        izpisiPolje(polje); // izpis zacetnega stanja polja
		
        if (resi(0,0,polje)){ // resimo polje, ce je mozno. Zacnemo v vrstici i = 0 in stolpcu j = 0
			izpisiPolje(polje);
		}    
        else {
			// ce reistve za dan SUDOKU problem ni resitve, to uporabniku tudi sporocimo.
			System.out.println("Ni resitve");
		}
    }
}
