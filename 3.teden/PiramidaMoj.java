import java.util.Scanner;
public class PiramidaMoj{
	
	public static void main(String [] args){
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		int stPresledkov = n - 1;
		int stZvezdic = 1;
		
		for(int i = 1; i <= n; i++){
			
			for(int j = 1; j <= stPresledkov; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= stZvezdic; j++){
				System.out.print("*");
			}
			System.out.println();
			stZvezdic +=2;
			stPresledkov--;
		}
	}
}