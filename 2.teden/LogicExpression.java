import java.util.*;

class LogicExpression {
    public static void main(String[] args) {
        int a = 100;

        System.out.println((a % 4 == 0) && (a % 100 != 0));

        System.out.println( ( (a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0));

        boolean one = true;
        boolean second = false;

        System.out.println("XOR: " + (one ^ second ));

        int ena = 1;
        int tri = 3;

        System.out.println(ena ^ tri);
        System.out.println("Bitno množenje: " + (ena << 1) );

        int rs = ena << 2;
        int rs1 = ena << 1;

        int mnozeno6 = rs + rs1;
        
        System.out.println("Bitno množenje: " + mnozeno6 );
        System.out.println(mnozeno6); 

        int dva = 2;
        System.out.println("Bitno deljenje: " + (dva >> 1) );


        System.out.println((int)Math.pow(3, 3));
        System.out.println(  Math.floor(3.0/2)   );

        
        /*
        int[] myArray = new int[]{1, 2};
        System.out.println(myArray);
        System.out.println(Arrays.toString(myArray));*/


    }
}