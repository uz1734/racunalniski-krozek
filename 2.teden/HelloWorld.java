public class HelloWorld{

     public static void main(String[] args){
        System.out.println("Hello World");
        
        System.out.println("ena");
        
        int ena = 3;
        int dva = 5;
        
        int rs = ena + dva;
        
        boolean jeRes = ena > dva && (dva > ena  || true);
        
        dva = 3;
        ena = 1;
        
        System.out.println( dva ^ ena); 
        
        boolean boPrav = true;
        boolean jeNarobe = false;
        
        System.out.println( boPrav ^ jeNarobe);
        ena = 3;
        int zmnozek = dva * ena;
        System.out.println(zmnozek);
        
        int vsota = 0;
        for (int i = 1; i < 10; i = i + 1) {
            System.out.println(i);
            vsota = vsota + i;
        }
        
        System.out.println();
        int j = 1;
        System.out.println("while");
        while(j < 0){
            System.out.println(j);
            j = j+1;
        }
        System.out.println("do while");        
        int z = 1;
        do {
            System.out.println(z);
            z = z + 1;
        } while(z < 0);
        
        
        if(!jeRes){
            System.out.println("v if zanki");
        } else if (2 > 1) {
            
        } else {
            
        }
        
        System.out.println(vsota);
        
     }
     
}