package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        int num2;
        int res;
        boolean continuar = true;
        
        do{
            try {
                System.out.println("Introduzca el número entero: ");
                num1 = entrada.nextInt();
                if(num1 % 2 != 0){
                    res = 5.00;
                }else if(num1 > 500){
                    res = 5.00;
                }

                res = num1;
                System.out.println("El numero es menor a 500 y es par");
                continuar = false;
            }  catch(Exception e){
                System.out.println("Es necesario introducir un numero par y menor a 500");
                entrada.nextLine(); // Consumir el "Introducir"
            } 
        } while(continuar);
    }
    }
    

