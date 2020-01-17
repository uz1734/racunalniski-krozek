import java.util.*;

public class FloodFill {
	
	public static void floodfill(int[][] zaslon, int x, int y, int prejsnaBarva, int novaBarva, int dolzina, int visina) {
		System.out.println("x: " + x + " y: " + y);
		
		// poglej meje polja
		if (x < 0 || y < 0 || x >= dolzina || y >= visina) {
			System.out.println("izven meja");
			return;
		}
		
		if (zaslon[y][x] != prejsnaBarva) {
			System.out.println("ni ista barva");
			return;
		}
		
		zaslon[y][x] = novaBarva;
		izpis(zaslon);
		
		floodfill(zaslon, x + 1, y, prejsnaBarva, novaBarva, dolzina, visina);
		floodfill(zaslon, x - 1, y, prejsnaBarva, novaBarva, dolzina, visina);
		floodfill(zaslon, x, y + 1, prejsnaBarva, novaBarva, dolzina, visina);
		floodfill(zaslon, x, y - 1, prejsnaBarva, novaBarva, dolzina, visina);
		
	}
	
	public static void izpis(int[][] zaslon) {
		for (int i = 0; i < zaslon.length; i++) {
			for (int j = 0; j < zaslon[i].length; j++) {
				System.out.print(zaslon[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
	
	
	public static void main(String[] args) {		
		int zaslon [][] = {
					{1, 1, 1, 1, 1, 1, 1, 1}, 
					{1, 1, 1, 1, 1, 1, 0, 0}, 
					{1, 0, 0, 1, 1, 0, 1, 1}, 
					{1, 2, 2, 2, 2, 0, 1, 0}, 
					{1, 1, 1, 2, 2, 0, 1, 0}, 
					{1, 1, 1, 2, 2, 2, 2, 0}, 
					{1, 1, 1, 1, 1, 2, 1, 1}, 
					{1, 1, 1, 1, 1, 2, 2, 1}, 
				}; 
				
		int x = 4, y = 4, novaBarva = 3;
		
		int prejsnaBarva = zaslon[y][x];
		
		izpis(zaslon);
		floodfill(zaslon, x, y, prejsnaBarva, novaBarva, zaslon[0].length, zaslon.length);
		izpis(zaslon);
		
	}
	
}