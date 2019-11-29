import java.util.*;

class Sortiranje 
{ 
    public static void sort(int arr[]) 
    { 
        int n = arr.length;  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++){
				if (arr[j] < arr[min_idx]) {
					min_idx = j; 
				} 
			} 
                 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
  
    public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
   
    public static void main(String args[]) 
    {  
	 // int arr[] = new int[]{64,25,12,22,11}; 
		Scanner sc = new Scanner(System.in);
		
		int velikostTabele = sc.nextInt();
		int arr[] = new int[velikostTabele];
		
		for (int i = 0; i < velikostTabele; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("velikost: " + velikostTabele);
		
       
        sort(arr); 
        System.out.println("Sortiran array"); 
        printArray(arr); 
    } 
} 