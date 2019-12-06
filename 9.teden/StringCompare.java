import java.util.*;

class StringCompare {
	
    public static int stringCompare(String str1, String str2) 
    { 
        for (int i = 0; i < str1.length() &&  i < str2.length(); i++) { 
            if ((int)str1.charAt(i) ==  (int)str2.charAt(i)) { 
                continue; 
            }  
            else { 
                int diff = (int)str1.charAt(i) - (int)str2.charAt(i);
                
                System.out.println("Char1: " + (int)str1.charAt(i) +  "  Char2: " + (int)str2.charAt(i));
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
		
		String firstString = sc.next();
		String secondString = sc.next();
		
		
        // String firstString = "acd";
        // String secondString = "bcd";

        // String string3 = "Geeks";
        // String string4 = "Geeksforgeeks"; 
        // System.out.println((int)firstString.charAt(1));
		
		int compareRS = stringCompare(firstString, secondString);
		System.out.println(compareRS);
		// prvi je večji od drugega in ju je potrebno zamenjat
		if (compareRS > 0) {
			System.out.println("Vrstni red: " + secondString + " " + firstString);
		} else if (compareRS < 0) {
			System.out.println("Vrstni red: " + firstString + " " + secondString);
		} else {
			System.out.println("ENAKO");
		}



    }
}