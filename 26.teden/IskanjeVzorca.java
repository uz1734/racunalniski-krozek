/**
Cilj je sestaviti koncni avtomat za iskanje besed v besedilu kot ga vidite na sliki v direktoriju: automata.PNG
*/

import java.util.HashMap; // uvozimo HashMap objekt, ki ga bomo uporabili za shranjevanje prehodne funkcije koncnega avtomata
import java.util.*; // standardni uvoz javanskih util objektov.

public class IskanjeVzorca {
	
	/**
	vzorec -- predstavlja niz v trenutnem vzorcu (pravi iskalni niz)
	Q      -- trenutni vzorec (predstavlja trenutni niz, ki ga bomo primerjali s pravim iskalnim nizom)
	k 	   -- najvecja dolzina ujmeajoce se predpone vzorca s pripono Q
	*/
	public static int poisciNajdaljsoPredponoKiJePredpona(String vzorec, String Q, int k) {
		/*
			ni nujno, da bomo nasli najvecji ujemajoci niz predpone s pripono od zacetka vzorca Q,
			vendar se to lahko zgodi tudi kasneje v Q, zato si moramo oznacit od kje gledamo.
		*/
		int qStart = 0;
		/*
			poskusamo najti predpono v vzorcu v priponu v Q dokler nismo prisli do konca
			k je na zacetku max dolzine vzorca.
		*/
		while (k > 0) {
			boolean jeNeujemanje = false;
			// pogledamo ujemanje od zacetka do konca vzorca z Q
			// za dolzino nizov uporabljamo metodo <niz>.length()
			for (int i = 0; i < vzorec.length(); i++) {
				// pogoj. Ce presezemo dolzino niza Q, je nesmiselno preverjat, 
				// saj bomo drugace dobili napako, ce smo prisli do tukaj smo nasli.
				if (qStart + i >= Q.length() ) {
					jeNeujemanje = false;
					break; // takoj zakljuci for zanko in pojdi v nadalnje izvajanje while
				}
				
				// ce naslednji pogoj drzi smo nasli neujemanje prepodne vzorca in pripone Q
				if (vzorec.charAt(i) != Q.charAt(qStart + i)) {
					jeNeujemanje = true;
					break; // takoj zakljuci for zanko in pojdi v nadalnje izvajanje while
				}				
			}
			// Ce pri preverjanju predpone vzorca s pripono Q, nismo nasli ujemanja,
			// smo nasli najvecjo predpono v vzorcu, ki je predpona v Q.
			if (!jeNeujemanje) {
				// zakljuceimo metodo in while zanko in vrni rezultat.
				return k;
			}
			
			// ce smo nasli neujemanje moramo zmanjsati najvecje ujemanje in pri Q besedi,
			// zaceti z eno crko kasneje.
			k--;
			qStart++;
		}
		
		// Robmni primer, ce nimamo pripona v Q, ki bi se ujemala s predpono vzorca, bo tukaj k == 0
		return k;
	}
	
	public static void main(String[] args) {
		// Primeri ujemanja nekaj uzorcev.
		System.out.println("PRIMERI");
		String vzorec = "ab";
		String Q = "aa";
		System.out.println(poisciNajdaljsoPredponoKiJePredpona(vzorec, Q, vzorec.length()));  // ujemanje 1
		
		vzorec = "abab";
		Q = "abaa";
		System.out.println(poisciNajdaljsoPredponoKiJePredpona(vzorec, Q, vzorec.length()));  // ujemanje 1
		
		vzorec = "abab";
		Q = "abab";
		System.out.println(poisciNajdaljsoPredponoKiJePredpona(vzorec, Q, vzorec.length()));  // ujemanje 4
		
		vzorec = "ababac";
		Q = "ababaa";
		System.out.println(poisciNajdaljsoPredponoKiJePredpona(vzorec, Q, vzorec.length()));  // ujemanje 1
		
		vzorec = "ababac";
		Q = "ababab";
		System.out.println(poisciNajdaljsoPredponoKiJePredpona(vzorec, Q, vzorec.length()));  // ujemanje 4
		//////////////////////////////////////////////////////////////////////////////
		
		String vzorecP = "ababaca"; // vzorec za katerega bomo sestavili koncni avtomat. --> lahko ga bomo iskali v kateremkoli besedilu
		String abecedaJezika = "abc"; // veliksot abecede jezika m == 3
		String tmpP = ""; // predstavljal bo nas trenutni vzorec pri gradnji avtomata.
		/**
		Za shranjevanje prehodne funckije bomo uporabili tip hash-map: kjuc/vrednost
		kot kljuc bomo shranjevali stanje q, kot vrednsoti bomo shranjevali prehode v naslednja stanja 
		iz sedanjega stanja v obliki tabele, kjer zaporedni indeksi predstavljajo crke nase abecede jezika == abc
		*/
		// Integer je razred, ki vsebuje primitiven tip int in ga potrebujemo za uporaboHasmapa, saj se moramo
		// obnasati kot objekt in ne kot primiten tip.
		HashMap<Integer, Integer[]> prehodnaFunkcija = new HashMap<Integer, Integer[]>();
		// prehodnaFunkcija.put(0, new Integer[]{1, 2, 3});  --> tesni vos ce kdo zeli testirat.
		
		/**
		Izracun prehdone funckije naredimo po algoritmu iz pdf-ja preteklega 25. tedna krozka.
		*/
		int m = vzorecP.length();
		Q = ""; // predstavlja trenutni prebrani vzorec.
		for (int q = 0; q <= m; q++) { // q predstavljajo stanja avtomata... imamo toliko stanj kolikor je velik nas vzorec
			if (q < m) {
				tmpP += vzorecP.charAt(q); // gradimo nas koncni avtomat... s tem da povecujemo velikost trenutnega vzorca.
			}
			
			// prehodv iz enga stanja v drugega imamo toliko kot je velikost jezika -- > zadnji znak v prehodih
			// predstavlja katerokoli crko in bo prehod v stanje 0 --> torej na zacetek.
			Integer[] prehodStanja = new Integer[abecedaJezika.length()];
			for (int aIndex = 0; aIndex < abecedaJezika.length(); aIndex++) {
				String tmpQ = Q + abecedaJezika.charAt(aIndex);
				/**
				Ce smo na koncu moramo za trenutni prebrani q vzeti tisto kar smo imeli od prej za eno zamika pa do konca
				*/
				if (q == m) {
					tmpQ = tmpQ.substring(1);
				}
				
				int k = poisciNajdaljsoPredponoKiJePredpona(tmpP, tmpQ, tmpP.length());
				prehodStanja[aIndex] = k; // v prehodnih stanjih iz trenutnega stanja si oznacimo kam se bo avtomat
										// premaknil.. glede na predpono pripone --> algoritem.
				
			}
			
			Q = tmpP;
			prehodnaFunkcija.put(q, prehodStanja);
		}
		System.out.println("PREHODNA FUNCKIJA KONCNEGA AVTOMATA");
		// Izpis prehodne funkcije: izpis hash-map objekta.
		for (Map.Entry<Integer, Integer[]> vnos : prehodnaFunkcija.entrySet()) {
			System.out.println(vnos.getKey()+" : "+ Arrays.asList(vnos.getValue()));
		}
		
		/**
		v TEJ FAZI IMAMO NARACUNANO PREHODNO FUNKCIJO KONCNEGA AVTOMATA.
		Sedaj nam preostane samo se iskanje vzorca "ababaca" v besedilu s pomocjo naracunane prehodne funckije.
		za bsedilo bomo uporabili kar primer iz slike automata.PDF: "abababacaba" --> na mestu 3 v besedilu
		se nahaja iskani vzorec. Algoritem v linearnem času -- kot smo to sponzali v prejsnem tednu -- teden 25
		pred pocitnicami najde vse pojavitve vzorca v besedilu.. za primer bomo imeli kratko besedilo, da lahko
		rocno preverimo rezultate.
		*/
		
		System.out.println("VZOREC: " + vzorecP);
		String besedilo = "abababacaba";
		System.out.println("BESEDILO: " + besedilo);
		int q = 0;
		for (int i = 0; i < besedilo.length(); i++) {
			if (abecedaJezika.indexOf(besedilo.charAt(i)) >= 0 ) {
				// prehod v naslednje stanje glede na prehodno funckijo.
				q = prehodnaFunkcija.get(q)[abecedaJezika.indexOf(besedilo.charAt(i))];
			} else {
				q = 0;
			}
			
			if (q == m) {
				// izzpis najdenega polozajo vzorca v bsedilu.
				// (i - (m - 1))  --> dobimo indekx zacetka vzorca v besedulu, ki se zacne s stetnjem 0
				// (i - (m - 1)) + 1  --> stetnje od 1 naprej..
				System.out.println( (i - (m - 1)) + 1 );
			}
		}
		
	}
}