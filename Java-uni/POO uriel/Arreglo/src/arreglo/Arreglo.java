/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglo;

import java.util.ArrayList;



public class Arreglo {

    private static int TAM_ARR = 5;
    
    public static void main(String[] args) {
        int[] arrInt;
        
        //crear el objeto del arreglo
        arrInt = new int[TAM_ARR];
        
        arrInt[0]=100;
        //Introducir al arreglo los valores 100, 200...
        for(int i=0; i<arrInt.length; ++i){
            arrInt[i] = arrInt[i-1]+100;
        }
       
        for(int i=0; i<arrInt.length; ++i){
            System.out.println("arrInt{ " +i+ "}: " + arrInt[i]);
            
        }
        
        System.out.println();
        
        String[] nombres = new String[5];
        
        nombres[0]="Juan";
        nombres[1]="Maria";
        nombres[2]="Pedro";
        nombres[3]="Ana";
        nombres[4]="Rodrigo";
   
        for(int i=0; i<nombres.length; ++i){
            System.out.println(nombres[i]);
        }
        
        //areglo dinamico
        
        ArrayList<String> arrDinamico;
        
        arrDinamico = new ArrayList<String>();
        
        arrDinamico.add("Jimena");
        arrDinamico.add("Enrique");
        arrDinamico.add("Luis");
        
        
        System.out.println();
         for(int i=0; i<arrDinamico.size(); ++i){
            System.out.println(arrDinamico.get(i));
        }
        
        //ciclo for mejorado
        
        //for(tipo_objeto variable: variable_Arreglo)
        //La variable es asignada el contenido del elemento en la interacion
        for(String s: arrDinamico){
            System.out.println(s);
        }
    }
    
}
