package poo;

import java.util.Scanner;


public class Operacion {
    //  Atributos
    int numero1;
    int numero2;
    int suma;
    int resta;
    int multiplicacion;
    int division;
            
    // Metodos
    
    // Metodos para pedirle al usuario que nos digite 2 numeros
    public void leerNumeros(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite un numero: ");
        numero1 = entrada.nextInt();
        System.out.println("Digite el segundo numero: ");
        numero2 = entrada.nextInt();
 }
    
 //Metodo para sumar ambos numeros
    public void sumar(){
        suma = numero1+numero2; 
    }
//Metodo para restar ambos numeros
    public void restar(){
        resta = numero1-numero2;
    }
    
//Metodo para multiplicar ambos numeros
    public void multiplicar(){
        multiplicacion = numero1*numero2;
    }
  
//Metodo para dividir ambos numeros    
    public void dividir(){
        division = numero1/numero2; 
    }
    
    public void mostrarResultados(){
        System.out.println("La suma es: "+suma);
        System.out.println("La resta es: "+resta);
        System.out.println("La multiplicacion: "+multiplicacion);
        System.out.println("La division es: "+division);
    }
}