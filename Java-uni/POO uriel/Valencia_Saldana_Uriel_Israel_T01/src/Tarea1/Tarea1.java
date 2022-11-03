package Tarea1;

import java.util.Scanner;

public class Tarea1 {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        int gradosC;
        double suma;
        
        System.out.println("Escribe los grados C° a convertir a F°: ");
        gradosC = entrada.nextInt();//Lee los grados
    
        suma = (double) ((gradosC * 1.8) + 32);
     
        System.out.println(suma);
    }  
}
