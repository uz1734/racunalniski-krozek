
import java.util.Scanner;

public class StPoti {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int visina = sc.nextInt();
        int sirina = sc.nextInt();
		
		System.out.println(stPoti(visina, sirina));
    }
	
	// osnovna rekurzivna različica
	private static long stPoti(int visina, int sirina) {
		if (visina <= 1 || sirina <= 1) {
			return 1;
		}
		return stPoti(visina - 1, sirina) + stPoti(visina, sirina - 1);
	}
}
