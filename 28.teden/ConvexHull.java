// metode, ki jih bomo potrebovalli v programu.. predvsem za branje datotek.
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
Razred, ki bo hranil posamezne tocke.. lazje je delati z objketi. Hranimo x in y koordinato tocke.
*/
class Point {
	private float x;
	private float y;
	
	Point(float X, float Y) {
		this.x = X;
		this.y = Y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public String toString() {
		return "( " + this.x + ", " + this.y + " )" ;
	}
}


public class ConvexHull {
	
	public static void main(String[] args) {
		
		/*
		V te spremenljivke bomo prebrali koordinate točk
		*/
		String[] pointsX1Coordinates;
		String[] pointsY1Coordinates;
		
		String[] pointsX2Coordinates;
		String[] pointsY2Coordinates;
		
		try { // pri branju datotek moramo ujeti error pri branju
			
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String str;

			List<String> output = new LinkedList<String>();

			while((str = in.readLine()) != null){
				output.add(str);
			}

			String[] arr = output.toArray(new String[output.size()]);
			
			// prebrane koordinate tock splitaj po presledkih in jih daj v X, Y tabelo posameznih koordinat
			pointsX1Coordinates = arr[0].strip().split("\\s+"); // regularni izraz za iskanje preslodkov v besedilu. Razkosamo string po presledkih.
			pointsY1Coordinates = arr[1].strip().split("\\s+");
			pointsX2Coordinates = arr[2].strip().split("\\s+");
			pointsY2Coordinates = arr[3].strip().split("\\s+");
			
			// prebrane koordinate tock. Izpis prebranih koordinat tock.
			System.out.println("PREBRANE TOCKE");
			System.out.println(Arrays.toString(pointsX1Coordinates)); // izpis posmaeznih koordinat.
			System.out.println(Arrays.toString(pointsY1Coordinates));
			System.out.println(Arrays.toString(pointsX2Coordinates));
			System.out.println(Arrays.toString(pointsY2Coordinates));
			
			
			/**
			Sedaj je potrebno prebrane tocke urediti od leve proti desni, od najmanjse koordinate X do najvecje,
			nato bomo lahko uporabili algoritem za gradnjo konveksne ovojnice.
			*/
			ArrayList<Point> sortedPoints = createSortedArrayForConvexHull(pointsX1Coordinates, pointsY1Coordinates, pointsX2Coordinates, pointsY2Coordinates);
			
			System.out.println("UREJENE TOCKE");
			// izpis urejenih tock po x in y koordinati.
			for (Point p : sortedPoints) {
				System.out.println(p.toString());
			}
			
			// sedaj bomo izracunali konveksno ovojnico iz danih tock
			CalcConvexHull calcConvexHull = new CalcConvexHull(sortedPoints);
			
			/*
				IZPISEMO RESITEV... OVOJNICA JE PO TOCKAH ENAKA KOT V NAVODILIH... CE ZELITE IZPIS KOT V NAVODILIH
				VAM PREPUSCAM DA SE MALO SAMO POTRUDITE... S TEM JE ALGORITEM ZAKLJUCEN.
			*/ 
			System.out.println("KONVEKSNA OVOJNICA");
			for (Point p : calcConvexHull.getConvexHull()) {
				System.out.println(p.toString());
			}
			
			
		} catch (IOException e) { // ce se pri branju zogdi error ga tukaj ujamemo.
			e.printStackTrace();
		}
	}
	
	// metoda, ki nam bo iz v tabelah ustvarila urejen senzam tock iz leve proti desni, od najmnajsega x do najvecjega x.
	public static ArrayList<Point> createSortedArrayForConvexHull(String[] X1, String[] Y1, String[] X2, String[] Y2) {
		ArrayList<Point> sortedPoints = new ArrayList<Point>(); // ustvarimo arraylist tock... saj ne vemo koliko tock zares bomo imeli.
		
		// urejanje prvega lika
		for (int i = 0; i < X1.length; i++) {
			Point point = new Point(Float.parseFloat(X1[i]), Float.parseFloat(Y1[i])); // iz koordinat naredim objekt tocko.
			sortedPoints = insertPointIntoArrayList(point, sortedPoints);
		}
		
		// urejanje drugega lika
		for (int i = 0; i < X2.length; i++) {
			Point point = new Point(Float.parseFloat(X2[i]), Float.parseFloat(Y2[i])); // iz koordinat naredim objekt tocko.
			sortedPoints = insertPointIntoArrayList(point, sortedPoints);
		}
		
		return sortedPoints;
	}
	
	public static ArrayList<Point> insertPointIntoArrayList(Point point, ArrayList<Point> sortedPoints) {
		
		int position = 0;
		for (Point p : sortedPoints) {
			// pogledamo, ce je trenutna tocka manjsa od tocke, ki jo imammo v tabeli in ce je jo vstavimo odspredaj
			// najprej urejeamo po X koordinati in nato se po Y koordinati
			if (point.getX() < p.getX() || ( point.getX() == p.getX() && point.getY() < p.getY() ) ) {
				sortedPoints.add(position, point);
				return sortedPoints;
			}
			
			position++;
		}
		
		// ce manjsa tocka ni najdena, jo vstavi na konec urejenega senzama..
		sortedPoints.add(point);
		return sortedPoints;
	}
}

// razred, kjer bomo po algoritmu Graham's scan, ki smo ga spoznali prejsni teden izracunali conveksno ovojnico 
// iz urejeni tock
class CalcConvexHull {
	private ArrayList<Point> inputPoints;
	
	private ArrayList<Point> convexHull;
	
	CalcConvexHull(ArrayList<Point> sortedArray) {
		this.inputPoints = sortedArray;
		// ko inicializiramo objekt poklicemo metodo znotraj razreda, ki izracuna konveksno ovojnico.
		this.calc();
	}
	
	public ArrayList<Point> getConvexHull() {
		return this.convexHull;
	}
	
	private void calc() {
		// posebej gradimo zgornjo in spodnjo ovojnico nato ju bomo pa zdruzili na koncu.
		ArrayList<Point> upperConvexHull = new ArrayList<Point>();
		ArrayList<Point> lowerConvexHull = new ArrayList<Point>();
		
		// sprehodimo se cez vse urejene tocke..
		System.out.println("delovanje");
		for (Point p : this.inputPoints) {
			System.out.println(p.toString());
			upperConvexHull.add(p);
			lowerConvexHull.add(p);
			
			/*System.out.println("BEFORE");
			for (Point p1 : upperConvexHull) {
				System.out.println(p1.toString());
			}*/
			
			// zgornja ovojnica ima desno orientacijo tock
			upperConvexHull = this.checkConvexHullOrientation(upperConvexHull, 2);
			/*System.out.println("AFTER");
			for (Point p1 : upperConvexHull) {
				System.out.println(p1.toString());
			}*/
			
			// spodnja ovojnica ima levo orientacijo tock
			lowerConvexHull = this.checkConvexHullOrientation(lowerConvexHull, 1);
			System.out.println("--------------------");
		}
		
		// izpis zgonje konveksen ovojnice
		System.out.println("ZGORNJA OVOJNICA");
		for (Point p : upperConvexHull) {
			System.out.println(p.toString());
		}
		System.out.println("SPODNJA OVOJNICA");
		// izpis spodnje konveksen ovojnice
		for (Point p : lowerConvexHull) {
			System.out.println(p.toString());
		}
		
		/**
		sedaj moramo zgornjo in spodnjo ovojnico zdruziti v eno ovjnico. Tocke bomo orintirali v nasprotni smeri urnega kazalca
		Zatorej lahko za osnovo uporabimo spodnjo ovjnico, ki ma tocke ze tako orientirane in se za nazaj sprehodimo po zgornji ovojnici..
		*/
		
		this.convexHull = lowerConvexHull;
		/**
		cez zgornjo ovojnico se sprehodimo nazaj.. zacnemo na predzadnjem elementu in koncamo na 2 elementu, saj je prvi in zadnji element 
		zgornje ovojnice enak kot na spodnji in ne zelimo da se dam ponavljajo.
		*/
		for (int i = upperConvexHull.size() - 2; i > 0; i--) {
			this.convexHull.add(upperConvexHull.get(i)); // vstavljamo elemente iz zgornje ovojnice v spodnjo.
		}
	}
	
	/**
	poglej orientacijo in in gradi zgornjo ali spodnjo ovojnico glede na podano konstanto orientation
	*/
	private ArrayList<Point> checkConvexHullOrientation(ArrayList<Point> convexHullArray, int orientation /*2 --> upper hull (right turn), 1 --> lowe hull (left turn)*/) {
		
		int lastIndex = convexHullArray.size() - 1;
		
		// sprehajamo se od zadaj naprej in delamo toliko casa dokler so se vsaj tri tocke v konveksni ovojnici.
		while (convexHullArray.size() >= 3) {
			// System.out.println("Last: " + lastIndex);
			// vzamemo zadnje tri tocke... 
			Point p1 = convexHullArray.get(lastIndex - 2);
			Point p2 = convexHullArray.get(lastIndex - 1);
			Point p3 = convexHullArray.get(lastIndex);
			
			// pogledamo njihovo orientacijo.
			int orientationConstant = this.checkOrientation(p1, p2, p3);
			
			// ce se orientacija tock ujema s tisto ovojnico ki jo gradimo, levi ali desni zavoj, so tocke ok urejene
			// v pravilnem vrstnem redu in ne rabimo nic vec naredit, lahko izstopimo iz zanke.
			if (orientationConstant == orientation) {
				// System.out.println("not: " +  p3.toString() );
				break;
			}
			
			// ce se orientacije ne ujemajo, moramo odstraniti srednjo tocko izmed treh tock iz konceksne ovojnice in nato v naslednjem krogu preverjanja preverit nove zadnje tri tocke
			convexHullArray.remove(lastIndex-1);
			
			// nastavimo nov lastIndex iz nove dolzine trenutne konveksne ovojnice.
			lastIndex = convexHullArray.size() - 1;
		}
		
		
		return convexHullArray;
	}
	
	// poglej kaksno orientacijo imajo tri tocke in vrni konstanto orientacije..
	private int checkOrientation(Point p1, Point p2, Point p3) {
		// enacba za pogledat orientacijo, ki jo lahko vidite na pdf in 27.tedna. racunalniskega krozka.
		float orientationCalcValue = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
		
		if (orientationCalcValue > 0) {
			// orientacija v nasprotni smeri urinega kazalca.. lev zavoj
			return 1;
		} else if (orientationCalcValue < 0) {
			// orientacija v smeri urinega kazalca, desni zavoj
			return 2;
		} else {
			return 0;
		}
		
	}
}