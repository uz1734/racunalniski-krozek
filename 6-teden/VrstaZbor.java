
import java.util.Scanner;

public class VrstaZbor {
	public static void main (String [] args){
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		int[] visine = new int[n];
		for(int i = 0; i < visine.length; i++){
			visine[i] = sc.nextInt();
		}
		
		boolean najden = false;
		for(int i = 0; i < visine.length; i++){
			if(i == 0){
				if(visine[i] <= visine[i + 1]){
					najden = true;
					System.out.println(i);
				}
			}
			else if(i == n - 1){
				if(visine[i] >= visine[i - 1]){
					najden = true;
					System.out.println(i);
				}
			}
			else{
				if(visine[i] <= visine[i + 1] && visine[i] >= visine[i - 1]){
					najden = true;
					System.out.println(i);
				}
			}
		}
		
		if(najden == false){
			System.out.println("NOBEDEN");
		}
	}
    
}