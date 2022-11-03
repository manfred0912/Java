package Valencia_Saldana_Uriel_Israel_T06;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Valencia_Saldana_Uriel_Israel_T06 {
    
     //Creación del ArrayList
    private static ArrayList <AvionBoletos> lista = new ArrayList<AvionBoletos>();
    
    //Opciones del menú
    private static final int OPC_ALTA_TURISTA = 1;
    private static final int OPC_ALTA_EJECUTIVA = 2;
    private static final int OPC_LISTA = 3;
    private static final int OPC_SALIR = 4;

    public static void main(String[] args) {
        
        TuristClass t1 = new TuristClass();
        TuristClass t2 = new TuristClass ("Maria", "Lopez", "Guzman", 21 , 10);

        System.out.println("Aerolinea 'Star");
        System.out.println("Nombre: "+t1.getNombre());
        System.out.println("Apellido Paterno: "+t1.getApellidoP());
        System.out.println("Apellido Materno: "+t1.getApellidoM());
        System.out.println("Edad: "+t1.getEdad());
        System.out.println("No. Asiento: "+t1.getnumAsiento());
        System.out.println("Clase: "+t1.clienteClase());
        System.out.println("Tipo de Lonche: "+t1.comidaClase());
        
        System.out.println();
        System.out.println("Nombre: "+t2.getNombre());
        System.out.println("Apellido Paterno: "+t2.getApellidoP());
        System.out.println("Apellido Materno: "+t2.getApellidoM());
        System.out.println("Edad: "+t2.getEdad());
        System.out.println("No. Asiento: "+t2.getnumAsiento());
        System.out.println("Clase: "+t1.clienteClase());
        System.out.println("Tipo de Lonche: "+t1.comidaClase());
       
        BussinesClass e1 = new BussinesClass(); 
        BussinesClass e2 = new BussinesClass("Miguel", "Moreno", "Ortiz", 32, 4);
        
        System.out.println();
        System.out.println("Nombre: "+e1.getNombre());
        System.out.println("Apellido Paterno: "+e1.getApellidoP());
        System.out.println("Apellido Materno: "+e1.getApellidoM());
        System.out.println("Edad: "+e1.getEdad());
        System.out.println("No. Asiento: "+e1.getnumAsiento());
        System.out.println("Clase: "+e1.clienteClase());
        System.out.println("Tipo de Lonche: "+e1.comidaClase());
        
        System.out.println();
        System.out.println("Nombre: "+e2.getNombre());
        System.out.println("Apellido Paterno: "+e2.getApellidoP());
        System.out.println("Apellido Materno: "+e2.getApellidoM());
        System.out.println("Edad: "+e2.getEdad());
        System.out.println("No. Asiento: "+e2.getnumAsiento());
        System.out.println("Clase: "+e2.clienteClase());
        System.out.println("Tipo de Lonche: "+e2.comidaClase());
        
        //Metodo toString
        System.out.println();
        System.out.println("-- Metodo toString --");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(e1);
        System.out.println(e2);
        
        System.out.println("****Metodo polimórfico****");
        desplegarInfo(t1);
        desplegarInfo(t2);
        desplegarInfo(e1);
        desplegarInfo(e2);
        
        //Creación del Menu
       int opcion;
       do{
           opcion = despegarMenu();
           System.out.println();
           
           //Creamos un switch
           switch(opcion){
               
               case 1:
                   System.out.println("Dar de alta boleto Turist Class");
                   boletoTurista();
                   break;
               case 2:
                   System.out.println("Dar de alta boleto en Bussines Class");
                   boletoEjecutivo();
                   break;
               case 3:
                   System.out.println("Lista de boletos");
                   listaBoleto();
                   break;
               case 4:
                   System.out.println("Salir");
                   break; 
               default:
                   System.out.println("Opcion invalida");
                   break;
           } //Fin del switch
           
       } while (opcion != OPC_SALIR); //Fin de opciones
        
    } //Fin del public
    
    //Metodo polimórfico
    public static void desplegarInfo(AvionBoletos m){
        System.out.printf("El nombre del clientes es: %s ,su apellido paterno es: %s y "
                + "el apellido Materno es: %s , tiene la edad de %d, su asiento es: %d, "
                + "la clase es: %s y su lonche es: %s \n", m.getNombre(),m.getApellidoP(),m.getApellidoM(),m.getEdad(),m.getnumAsiento(),
                m.clienteClase(),m.comidaClase());
    }
    
    //Metodo para desplegar el menu 
    public static int despegarMenu(){
        int opc = 0;
        Scanner entrada = new Scanner (System.in);
        
        //Desplegar Menu
        System.out.println(OPC_ALTA_TURISTA +") Dar de alta boleto turist class");
        System.out.println(OPC_ALTA_EJECUTIVA +") Dar de alta boleto bussines class");
        System.out.println(OPC_LISTA + ") Lista de boletos");
        System.out.println(OPC_SALIR + ") Salir");
        System.out.println();
        System.out.print("Opciones: ");
        
        try {
            // Leer opción del teclado
            opc = entrada.nextInt();

            // Seguir pidiendo la opción si el rango no es válido
            while(opc < 1 || opc > OPC_SALIR) {
                System.out.println("Opción no válida");

                System.out.print("Opción: ");
                // Leer opción del teclado
                opc = entrada.nextInt();
            }
        } catch(InputMismatchException e) {
            System.out.println("Es necesario que la opción sea entero.");
        }
        
        return opc;
    } //fin despegar menu
    
    public static void boletoTurista() {
        Scanner capturarDatos = new Scanner (System.in);
        String nom, apP, apM;
        int edad, numAsiento;
        System.out.print("Ingresa nombre: ");
        nom = capturarDatos.nextLine();
        System.out.print("Ingrese Apellido Paterno: ");
        apP = capturarDatos.nextLine();
        System.out.print("Ingrese Apellido Materno: ");
        apM = capturarDatos.nextLine();
        System.out.print("Ingrese edad: ");
        edad = capturarDatos.nextInt();
        System.out.print("Ingrese numero de asiento: ");
        numAsiento = capturarDatos.nextInt();
        
        //Capturar linea de codigo
        lista.add(new TuristClass(nom, apP, apM, edad, numAsiento));
    }
    
    public static void boletoEjecutivo() {
        Scanner capturarDatos = new Scanner (System.in);
        String nom, apP, apM;
        int edad, numAsiento;
        System.out.print("Ingresa nombre: ");
        nom = capturarDatos.nextLine();
        System.out.print("Ingrese Apellido Paterno: ");
        apP = capturarDatos.nextLine();
        System.out.print("Ingrese Apellido Materno: ");
        apM = capturarDatos.nextLine();
        System.out.print("Ingrese edad: ");
        edad = capturarDatos.nextInt();
        System.out.print("Ingrese numero de asiento: ");
        numAsiento = capturarDatos.nextInt();
        
        //Capturar linea de codigo
        lista.add(new BussinesClass(nom, apP, apM, edad, numAsiento));
    }
    
    public static void listaBoleto (){
        System.out.println();
        for(AvionBoletos e : lista) { 
            System.out.println(e);
            System.out.println();
        }
    }// Fin de listarBoleto  
    
} //Fin de la clase
