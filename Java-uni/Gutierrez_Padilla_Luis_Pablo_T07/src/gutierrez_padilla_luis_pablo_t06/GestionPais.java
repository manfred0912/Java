package gutierrez_padilla_luis_pablo_t06;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionPais {
    
    private static ArrayList<InfoGeneral> gestion = new ArrayList<>();
    
    // Constantes de opciones para el menú principal
    private static final int OPC_PAIS = 1;
    private static final int OPC_EST = 2;
    private static final int OPC_MUNI = 3;
    private static final int OPC_LIST = 4;
    private static final int OPC_SALI = 5;

    public static void main(String[] args) {
        gestion.add(new Pais("Mexico", "Estado de Mexico", 32));
        gestion.add(new Estado("Jalisco", "Guadalajara", 125));
        gestion.add(new Municipio("Zapopan", "Juan Jose Frangie", 3));
        
        int opc;
        
        do {
            opc = desplegarMenuPrincipal();
            
            System.out.println();
            switch(opc) {
                case OPC_PAIS:
                    System.out.println("ALTA DE PAISES\n");
                    Pais p =capturarDatosPais();
                    gestion.add(p);
                    break;
                case OPC_EST:
                    System.out.println("ALTA DE ESTADOS\n");
                    Estado s =capturarDatosEstado();
                    gestion.add(s);
                    break;
                case OPC_MUNI:
                    System.out.println("ALTA DE MUNICIPIOS\n");
                    Municipio m = capturarDatosMunicipio();
                    gestion.add(m);
                    break;
                case OPC_LIST:
                    System.out.println("LISTADO DE PAISES, ESTADOS Y MUNICIPIOS\n");
                    listarGestion();
                    break;
                case OPC_SALI:
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
            System.out.println();
        } while(opc != OPC_SALI);
        
        }
    
    public static int desplegarMenuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(OPC_PAIS + ") Alta de Paises");
        System.out.println(OPC_EST + ") Alta de Estados");
        System.out.println(OPC_MUNI + ") Alta de Municipios");
        System.out.println(OPC_LIST + ") Listado de paises, estados o municipios");
        System.out.println(OPC_SALI + ") Salir");
        System.out.println();
        System.out.print("Opción: ");
        
        opcion = entrada.nextInt();
        
        // Validar que la opción capturada esté en el rango correcto
        // Pedir el valor hasta que esté correcto (mientras la opción sea
        // incorrecta, pedirla de nuevo)
        while(!(opcion >= 1 && opcion <= OPC_SALI)) {
            System.out.println("Opción incorrecta.");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
        }
        
        return opcion;
    }
        
    public static Pais capturarDatosPais() {
        boolean continuar = true;
        // Se utizará un objeto de tipo Scanner que permite leer datos del teclado
        Scanner sc = new Scanner(System.in);
        Pais p = new Pais();
        
        // Pedir los valores de todos los campos
        //System.out.println("Código:");
        //String cod = entrada.nextLine();
        do{
            try{
              System.out.print("Nombre: ");
              String nom = sc.nextLine();
              System.out.print("Capital: ");
              String cap = sc.nextLine(); 
              System.out.print("Numero de estados: ");
              int num = sc.nextInt();

              // Guardar los valores en los campos correspondientes
              p.setNombre(nom);
              p.setCapital(cap);
              p.setNumDeEstados(num);
              continuar = false;
            } catch(InputMismatchException e){
                System.out.println("Es necesario introducir un numero entero.");
                sc.nextLine(); // Consumir el "Introducir"
            }
        }while(continuar);
        
        // Regresar referencia del objeto con sus datos capturados
        return p;
    }
 

public static Estado capturarDatosEstado() {
        boolean continuar = true;
        // Se utizará un objeto de tipo Scanner que permite leer datos del teclado
        Scanner sc = new Scanner(System.in);
        Estado s = new Estado();
        
        // Pedir los valores de todos los campos
        //System.out.println("Código:");
        //String cod = entrada.nextLine();
        do{
            try{
              System.out.print("Nombre: ");
              String nom = sc.nextLine();
              System.out.print("Capital: ");
              String cap = sc.nextLine(); 
              System.out.print("Numero de municipios: ");
              int num = sc.nextInt();

              // Guardar los valores en los campos correspondientes
              s.setNombre(nom);
              s.setCapital(cap);
              s.setNumDeMunicipios(num);
              continuar = false;
            } catch(InputMismatchException e){
                System.out.println("Es necesario introducir un numero entero.");
                sc.nextLine(); // Consumir el "Introducir"
            }
        }while(continuar);
        
        // Regresar referencia del objeto con sus datos capturados
        return s;
    }
 

public static Municipio capturarDatosMunicipio() {
        boolean continuar = true;
        // Se utizará un objeto de tipo Scanner que permite leer datos del teclado
        Scanner sc = new Scanner(System.in);
        Municipio m = new Municipio();
        
        // Pedir los valores de todos los campos
        //System.out.println("Código:");
        //String cod = entrada.nextLine();
        do{
            try{
              System.out.print("Nombre: ");
              String nom = sc.nextLine();
              System.out.print("Alcalde: ");
              String alc = sc.nextLine(); 
              System.out.print("Numero de distritos: ");
              int num = sc.nextInt();

              // Guardar los valores en los campos correspondientes
              m.setNombre(nom);
              m.setAlcalde(alc);
              m.setNumDeDistritos(num);
              continuar = false;
            } catch(InputMismatchException e){
                System.out.println("Es necesario introducir un numero entero.");
                sc.nextLine(); // Consumir el "Introducir"
            }
        }while(continuar);
        
        // Regresar referencia del objeto con sus datos capturados
        return m;
    }

/**
     * Método que lista todos los paises, estados o municipios.
     */
    public static void listarGestion() {
        // Verificar si el arreglo contiene estudiantes
        if(gestion.isEmpty()) {
            System.out.println("No hay paises, estados o muinicipios en gestión.");
            return; // Salir del método
        }
        
        int cont = 1;
        for(InfoGeneral i : gestion) {
            System.out.println("Pais, Municipio o Ciudad: " + cont++);
            System.out.println(i.desplegarDatos());
            System.out.println();
        }
        
        
        
    } // Fin de listarGestion
}



