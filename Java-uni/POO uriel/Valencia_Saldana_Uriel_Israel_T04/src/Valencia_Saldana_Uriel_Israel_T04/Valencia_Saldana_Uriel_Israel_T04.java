
package Valencia_Saldana_Uriel_Israel_T04;

import java.security.SecureRandom;


public class Valencia_Saldana_Uriel_Israel_T04 {

    
    public static void main(String[] args) {


    SecureRandom numerosRandoms = new SecureRandom();

    int frec1 = 0, frec2 = 0, frec3 = 0, frec4 = 0, frec5 = 0, frec6 = 0;
    int frec7 = 0, frec8 = 0, frec9 = 0, frec10 = 0, frec11 = 0, frec12 = 0; 

    int numLanzamientos= 3600000;

    for (int lanz = 1; lanz <= numLanzamientos; lanz++){
        
        int cara1 = 1 + numerosRandoms.nextInt(6); 

        int cara2 = 1 + numerosRandoms.nextInt(6); 

        int resultado = cara1 + cara2;

        switch (resultado) {

            case 1: 
                ++frec1;   
            break;
            case 2: 
                ++frec2;
            break;
            case 3: 
                ++frec3;
            break;
            case 4: 
                ++frec4;
            break;
            case 5: 
                ++frec5;
            break;
            case 6: 
                ++frec6;
            break;
            case 7: 
                ++frec7;
            break;
            case 8: 
                ++frec8;
            break;
            case 9: 
                ++frec9;
            break;
            case 10: 
                ++frec10;
            break;
            case 11: 
                ++frec11;
            break;
            case 12: 
                ++frec12;
            break;
         }
    }

       System.out.println("Cara\tFrec.\tFrec. rel"); 
       
       System.out.printf("1\t%d\t%.4f%n2\t%d\t%.4f%n3\t%d\t%.4f%n4\t%d\t%.4f%n5\t%d\t%.4f%n6\t%d\t%.4f%n7\t%d\t%.4f%n8\t%d\t%.4f%n9\t%d\t%.4f%n10\t%d\t%.4f%n11\t%d\t%.4f%n12\t%d\t%.4f%n", 
           
           frec1,   (float)   frec1/numLanzamientos,  
           frec2,   (float)   frec2/numLanzamientos,
           frec3,   (float)   frec3/numLanzamientos,
           frec4,   (float)   frec4/numLanzamientos,
           frec5,   (float)   frec5/numLanzamientos,
           frec6,   (float)   frec6/numLanzamientos,
           frec7,   (float)   frec7/numLanzamientos,
           frec8,   (float)   frec8/numLanzamientos,
           frec9,   (float)   frec9/numLanzamientos,
           frec10,  (float)   frec10/numLanzamientos,
           frec11,  (float)   frec11/numLanzamientos,
           frec12,  (float)   frec12/numLanzamientos 
       );

    }
    
}
