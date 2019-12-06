import java.util.*;

class StringSort {
    public static int stringCompare(String str1, String str2) 
    { 
        for (int i = 0; i < str1.length() &&  i < str2.length(); i++) { 
            if ((int)str1.charAt(i) ==  (int)str2.charAt(i)) { 
                continue; 
            }  
            else { 
                int diff = (int)str1.charAt(i) - (int)str2.charAt(i);
                
                // System.out.println("Char1: " + (int)str1.charAt(i) +  "  Char2: " + (int)str2.charAt(i));
                return (int)str1.charAt(i) - (int)str2.charAt(i); 
            } 
        } 
  

        if (str1.length() < str2.length()) {
            System.out.println("Edge case");
            return (str1.length()-str2.length()); 
        }  
        else if (str1.length() > str2.length()) {

            return (str1.length()-str2.length()); 
        } 
          
        else { 
            return 0; 
        } 
    } 

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		int numString = sc.nextInt();
		String[] stringArray = new String[numString];
		
		for(int i = 0; i < numString; i++) {
			stringArray[i] = sc.next();
		}
		
		int n = stringArray.length;  
        for (int i = 0; i < n-1; i++) 
        { 
			String minimalen = stringArray[i];
            int min_idx = i; 
            for (int j = i+1; j < n; j++) {
				int compareRS = stringCompare(minimalen, stringArray[j]);
				if ( compareRS > 0 ) {
					min_idx = j;
					minimalen = stringArray[j];
				} 
			}
   
            String temp = stringArray[min_idx]; 
            stringArray[min_idx] = stringArray[i]; 
            stringArray[i] = temp; 
        } 
		
		for (int i = 0; i < n; i++) {
			System.out.print(stringArray[i] + " ");
		}
		
		// System.out.println(Arrays.toString(stringArray));
		
    }
}