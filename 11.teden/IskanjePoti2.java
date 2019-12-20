import java.util.*;

class IskanjePoti2 {
	
	public static boolean poisciPot(char[][] labirint, int x, int y,  int visina, int dolzina, String smer) {
		
		System.out.println(smer);
		
		if (x >= dolzina || x < 0) {
			System.out.println("x out");
			return false;
		}
		
		if (y >= visina || y < 0) {
			System.out.println("Y out");
			return false;
		}
		
		if (labirint[y][x] == 'C') {
			System.out.println("C");
			return true;
		}
		
		if (labirint[y][x] == '#') {
						System.out.println("ZID");
			return false;
		}
		
		if (labirint[y][x] == '.') {
						System.out.println("Ze prehojo");
			return false;
		}
		
		labirint[y][x] = '.';
		izpis(labirint);
		
		if ( poisciPot(labirint, x - 1, y, visina, dolzina, "Zahod") ) {
			return true;
		}
		
		if ( poisciPot(labirint, x + 1, y, visina, dolzina, "Vzhod") ) {
			return true;
		}
		
		if ( poisciPot(labirint, x, y - 1, visina, dolzina, "Sever") ) {
			return true;
		}
		
		if ( poisciPot(labirint, x, y + 1, visina, dolzina, "JUG") ) {
			return true;
		}
		
		labirint[y][x] = ' ';
		return false;
		
	}
	
	
	public static void izpis(char[][] labirint) {
		
		for(int i = 0; i < labirint.length; i++) {
			for (int j = 0; j < labirint[i].length; j++) {
				System.out.print(labirint[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		char[][] labirint = {	{'#','#','#','#','#','#','#','#','#'},
			{'#',' ',' ',' ',' ',' ','#',' ','#'},
			{'#',' ','#','#','#',' ','#',' ','#'},
			{'#',' ','#','#','#',' ','#',' ','#'},
			{'#',' ',' ',' ','#','#','#',' ','#'},
			{'#',' ','#',' ','#',' ',' ',' ','#'},
			{'#',' ','#',' ',' ',' ','#',' ','#'},
			{'#',' ','#','#','#','#','#',' ','#'},
			{'#',' ',' ',' ','#',' ',' ','C','#'},
			{'#','#','#','#','#','#','#','#','#'}};
			
		// izpis(labirint);
		
		poisciPot(labirint, 5, 3, labirint.length, labirint[0].length, "Smer");
		
	}
	
}