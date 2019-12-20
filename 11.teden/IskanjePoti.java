import java.util.*;

public class IskanjePoti {
	
	public static boolean najdiPot(char[][] labirint, int x, int y, String smer) {
		
		System.out.println(smer);
		
		if (y < 0 || y >= labirint.length) {
			return false;
		}
		if (x < 0 || x >= labirint[y].length) {
			return false;
		}
		if (labirint[y][x] == 'C') {
			return true;
		}
		if (labirint[y][x] == '#') {
			return false;
		}
		if (labirint[y][x] == '.') {
			return false;
		}
		
		izpis(labirint);
		labirint[y][x] = '.';
		
		
		if (najdiPot(labirint, x + 1, y, "Vhod")) {
			return true;
		}
		
		if (najdiPot(labirint, x, y - 1, "Sever")) {
			return true;
		}
		
		if (najdiPot(labirint, x - 1, y, "Zahod")) {
			return true;
		}
		
		if (najdiPot(labirint, x , y + 1, "Jug")) {
			return true;
		}
		
		labirint[y][x] = ' ';
		
		return false;
	}
	
	
	public static void izpis(char[][] labirint) {
		for (int i = 0; i < labirint.length; i++) {
			for (int j = 0; j < labirint[i].length; j++) {
				System.out.print(labirint[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[][] labirint = {
				{'#','#','#','#','#','#','#','#','#'},
				{'#',' ',' ',' ',' ',' ','#',' ','#'},
				{'#',' ','#','#','#',' ','#',' ','#'},
				{'#',' ','#','#','#',' ','#',' ','#'},
				{'#',' ',' ',' ','#','#','#',' ','#'},
				{'#',' ','#',' ','#',' ',' ',' ','#'},
				{'#',' ','#',' ',' ',' ','#',' ','#'},
				{'#',' ','#','#','#','#','#',' ','#'},
				{'#',' ',' ',' ','#',' ',' ','C','#'},
				{'#','#','#','#','#','#','#','#','#'}
			};

		System.out.println("Izgled labirinta:");
		izpis(labirint);
		
		System.out.println("\nNajdena pot skozi labirint:");
		if (najdiPot(labirint, 5, 3, "Smer"))
			izpis(labirint);
		else
			System.out.println("Ne najdem poti skozi labirint!");
		
	}
	
}