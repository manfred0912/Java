package gestionestudiantes_22a;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class GestionEstudiantes_22A {
    // Constructor por omisión
    public GestionEstudiantes_22A() {
        super(); // Llamada al constructor de la clase madre (superclase)
    }
    
    // Campos
    // Arreglo dinámico de objetos de tipo Estudiante
    private static ArrayList<Estudiante> grupo = new ArrayList<>();
    
    // Constantes de opciones para el menú principal
    private static final int OPC_ALTA = 1;
    private static final int OPC_MODI = 2;
    private static final int OPC_BAJA = 3;
    private static final int OPC_BUSQ = 4;
    private static final int OPC_LIST = 5;
    private static final int OPC_SALI = 6;
    
    // Constantes de opciones para el menú de modificación de datos
    private static final int OPCM_CODI = 1; // Código
    private static final int OPCM_NOMB = 2; // Nombre(s)
    private static final int OPCM_APPA = 3; // Apellido paterno
    private static final int OPCM_APMA = 4; // Apellido materno
    private static final int OPCM_EDAD = 5; // Edad
    private static final int OPCM_PROM = 6; // Promedio
    private static final int OPCM_REGR = 7; // Regresar

    private static String nombreArch = "grupo.txt";
    private static String nombreArchBin = "grupo.bin"; // El nombre de la extensión es arbitraria
     
    public static void main(String[] args) {
//        // Declarar la variable del objeto (referencia)
//        Estudiante e1;
//        
//        // Crear el objeto
//        e1 = new Estudiante();
//        
//        //e1.
//        
////        e1.desplegarDatos();
////        
////        int i=10;
////        System.out.println("i:" + i);
////        
////        System.out.println("");
//        
//        //e1.codigo = "E001";
//        e1.setCodigo("E001");
//        
////        String s1 = e1.getCodigo();
////        
////        // Atajo para System.out.println : sout<Tab>
////        System.out.println("Código de e1: " + s1); // "+" : concatena Strings   
//        
//        e1.setNombre("Juan");
//        
////        System.out.println("Nombre de e1: " + e1.getNombre());
//        
//        e1.setApPaterno("López");
//        e1.setApMaterno("Martínez");
//        e1.setEdad(21);
//        e1.setPromedio(94.3);
//        
//        e1.desplegarDatos();
//        System.out.println(""); // Salto de líneaE00
//        
////        Estudiante e2 = capturarDatos();
////
////        System.out.println(""); // Salto de líneaE00
////
////        e2.desplegarDatos();
//        
//        Estudiante e3 = new Estudiante("E003", "María", "Jiménez", "Yañez", 23, 93.2);
//        System.out.println();
//        e3.desplegarDatos();

//        // Agregar tres objetos de tipo Estudiante para que el arreglo no comience vacío
//        // para propósitos de prueba del proyecto
//        grupo.add(new Estudiante("E001", "Juan", "Ramírez", "Dueñas", 21, 94.2));
//        grupo.add(new Estudiante("E002", "Ana", "Martínez", "Zúñiga", 24, 96.2));
//        grupo.add(new Estudiante("E003", "María", "Jiménez", "Yañez", 23, 93.2));
        
        // Recuperar los objetos del archivo
        //recuperarObjetos();
        recuperarObjetosBin();

        int opc;
        
        do {
            opc = desplegarMenuPrincipal();
            
            System.out.println();
            switch(opc) {
                case OPC_ALTA:
                    System.out.println("ALTA DE ESTUDIANTES\n");
                    altaDeEstudiantes();
                    //guardarObjetos();
                    guardarObjetosBin();
                    break;
                case OPC_MODI:
                    System.out.println("MODIFICACIÓN DE DATOS\n");
                    modificacionDeDatos();
                    //guardarObjetos();
                    guardarObjetosBin();
                    break;
                case OPC_BAJA:
                    System.out.println("BAJA DE ESTUDIANTES\n");
                    bajaDeEstudiantes();
                    //guardarObjetos();
                    guardarObjetosBin();
                    break;
                case OPC_BUSQ:
                    System.out.println("BÚSQUEDA DE ESTUDIANTES\n");
                    busquedaDeEstudiantes();
                    break;
                case OPC_LIST:
                    System.out.println("LISTADO DE ESTUDIANTES\n");
                    listarEstudiantes();
                    break;
                case OPC_SALI:
                    //guardarObjetos();
                    guardarObjetosBin();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
            System.out.println();
        } while(opc != OPC_SALI);
        
    } // Fin de main
    
    /**
     * Método para listar el menú principal. Se debe validar que el usuario
     * seleccione una opción dentro del rango permitido, y regresar la opción
     * seleccionada.
     * 
     * 1) Alta de estudiantes
     * 2) Modificación de datos
     * 3) Baja de estudiantes
     * 4) Búsqueda de estudiantes
     * 5) Listado de estudiantes
     * 6) Salir
     * 
     * Opción: 
     * 
     */
    public static int desplegarMenuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.println("MENÚ PRINCIPAL");
        System.out.println(OPC_ALTA + ") Alta de estudiantes");
        System.out.println(OPC_MODI + ") Modificación de datos");
        System.out.println(OPC_BAJA + ") Baja de estudiantes");
        System.out.println(OPC_BUSQ + ") Búsqueda de estudiantes");
        System.out.println(OPC_LIST + ") Listado de estudiantes");
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
    
    /**
     * Método que lista todos los estudiantes.
     */
    public static void listarEstudiantes() {
        // Verificar si el arreglo contiene estudiantes
        if(grupo.isEmpty()) {
            System.out.println("No hay estudiantes en el grupo.");
            return; // Salir del método
        }
        
        int cont = 1;
        for(Estudiante e : grupo) {
            System.out.println("ESTUDIANTE " + cont++);
            e.desplegarDatos();
            System.out.println();
        }
        
    } // Fin de listarEstudiantes
        
    /**
     * Método para capturar los datos de un objeto de tipo Estudiante. El
     * método regresa una referencia del objeto con sus valores capturados.
     */
    public static Estudiante capturarDatos(String cod) {
        // Se utizará un objeto de tipo Scanner que permite leer datos del teclado
        Scanner entrada = new Scanner(System.in);
        Estudiante e = new Estudiante();
        
        // Pedir los valores de todos los campos
//        System.out.println("Código:");
//        String cod = entrada.nextLine();
        System.out.print("Nombre(s): ");
        String nom = entrada.nextLine();
        System.out.print("Apellido paterno: ");
        String apPat = entrada.nextLine();
        System.out.print("Apellido materno: ");
        String apMat = entrada.nextLine();
        System.out.print("Edad: ");
        int ed = entrada.nextInt();
        System.out.print("Promedio: ");
        double prom = entrada.nextDouble();
        
        // Guardar los valores en los campos correspondientes
        e.setCodigo(cod);
        e.setNombre(nom);
        e.setApPaterno(apPat);
        e.setApMaterno(apMat);
        e.setEdad(ed);
        e.setPromedio(prom);
        
        // Regresar referencia del objeto con sus datos capturados
        return e;
    }

    private static void busquedaDeEstudiantes() {
        Scanner entrada = new Scanner(System.in);
        String cod;
        System.out.print("Introduce el código del estudiante: ");
        cod = entrada.nextLine();
        // Eliminar posibles espacios en blanco antes y después
        cod = cod.trim();
        // Verificar que no quede la cadena vacía
        if(cod.isEmpty()) {
            System.out.println("No se introdujo ningún código.");
            return; // Salir del método
        }
        
        // Buscar estudiante con el código dado
        int idx = buscarEstudiante(cod);
        
        if(idx >= 0) {
            grupo.get(idx).desplegarDatos();
        } else {
            System.out.println("El estudiante de código " +  cod + 
                    " no fue localizado.");
        }
        
    }
    
    /**
     * Método que busca un estudiante a partir de su código y si lo encuentra,
     * regresa el índice en el arreglo del objeto del estudiante; de lo contrario
     * regresa -1.
     */
    private static int buscarEstudiante(String codigo) {
        int idx = -1;
        
        // Recorrer el arreglo buscando el estudiante con el código dado
        for(int i=0; i<grupo.size(); ++i) {
            // Verificar si el código del estudiante i-ésimo es igual al
            // código buscado
            if(grupo.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                idx = i;
                break; // Salir del ciclo for
            }
        }
        
        return idx;
    }

    /**
     * Método que permite dar de alta un estudiante.
     */
    private static void altaDeEstudiantes() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduzca los siguientes valores:");
        System.out.print("Código: ");
        String cod = entrada.nextLine().trim();
        
        // Verificar si ya existe un estudiante con ese código
        int idx = buscarEstudiante(cod);
        
        // Mientras el código esté repetido, seguirlo pidiendo
        while(idx != -1) {
            System.out.println("Ya existe un estudiante con el código " + cod);
            System.out.print("Introduzca un nuevo código: ");
            cod = entrada.nextLine().trim();
            idx = buscarEstudiante(cod);
        }
        
        // Verificar que el código capturado no esté vacío
        if(cod.isEmpty()) {
            System.out.println("Es necesario introducir un código.");
            return; // Regresar al menú principal
        }
        
        // Capturar los valores del resto de los campos
        Estudiante e = capturarDatos(cod);
        
        // Agregar objeto al arreglo
        grupo.add(e);
        
        //grupo.add(capturarDatos(cod));
    }

    private static void bajaDeEstudiantes() {
        Scanner entrada = new Scanner(System.in);
        String cod;
        System.out.print("Introduce el código del estudiante: ");
        cod = entrada.nextLine();
        // Eliminar posibles espacios en blanco antes y después
        cod = cod.trim();
        // Verificar que no quede la cadena vacía
        if(cod.isEmpty()) {
            System.out.println("No se introdujo ningún código.");
            return; // Salir del método
        }
        
        // Buscar estudiante con el código dado
        int idx = buscarEstudiante(cod);
        
        if(idx >= 0) {
            grupo.get(idx).desplegarDatos();
            System.out.println();
            System.out.print("¿Realmente desea dar de baja a este estudiante (s/n)? ");
            String resp = entrada.nextLine();
            if(resp.equalsIgnoreCase("s")) {
                grupo.remove(idx);
                System.out.println("Estudiante dado de baja exitosamente.");
            }
        } else {
            System.out.println("El estudiante de código " +  cod + 
                    " no fue localizado.");
        }
    }
    
    public static int desplegarMenuModificacion() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.println("MENÚ DE MODIFICACIÓN");
        System.out.println(OPCM_CODI + ") Código");
        System.out.println(OPCM_NOMB + ") Nombre(s)");
        System.out.println(OPCM_APPA + ") Apellido paterno");
        System.out.println(OPCM_APMA + ") Apellido materno");
        System.out.println(OPCM_EDAD + ") Edad");
        System.out.println(OPCM_PROM + ") Promedio");
        System.out.println(OPCM_REGR + ") Regresar");
        System.out.println();
        System.out.print("Opción: ");
        
        opcion = entrada.nextInt();
        
        // Validar que la opción capturada esté en el rango correcto
        // Pedir el valor hasta que esté correcto (mientras la opción sea
        // incorrecta, pedirla de nuevo)
        while(!(opcion >= 1 && opcion <= OPCM_REGR)) {
            System.out.println("Opción incorrecta.");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
        }
        
        return opcion;
    }

    private static void modificacionDeDatos() {
        Scanner entrada = new Scanner(System.in);
        String cod;
        System.out.print("Introduce el código del estudiante: ");
        cod = entrada.nextLine();
        // Eliminar posibles espacios en blanco antes y después
        cod = cod.trim();
        // Verificar que no quede la cadena vacía
        if(cod.isEmpty()) {
            System.out.println("No se introdujo ningún código.");
            return; // Salir del método
        }
        
        // Buscar estudiante con el código dado
        int idx = buscarEstudiante(cod);
        
        if(idx >= 0) {
            grupo.get(idx).desplegarDatos();
            System.out.println();
            System.out.print("¿Realmente desea modificar los datos de este estudiante (s/n)? ");
            String resp = entrada.nextLine();
            if(resp.equalsIgnoreCase("s")) {
                modificarDatos(idx);
            }
        } else {
            System.out.println("El estudiante de código " +  cod + 
                    " no fue localizado.");
        }
    }

    private static void modificarDatos(int idx) {
        int opc;
        Scanner entrada = new Scanner(System.in);
        String resp;
        
        do {
            System.out.println();
            opc = desplegarMenuModificacion();
            
            switch(opc) {
                case OPCM_CODI: 
                    System.out.println("Introduzca el nuevo código:");
                    String cod = entrada.nextLine().trim();
                    if(cod.isEmpty()) {
                        System.out.print("Es necesario introducir un código.");
                        System.out.println();
                        return;
                    }
                    while(buscarEstudiante(cod) != -1) {
                        System.out.println("Ya existe un estudiante con el código " +
                                cod + ".");
                        System.out.print("Introduzca otro código: ");
                        cod = entrada.nextLine().trim();
                        if(cod.isEmpty()) {
                            System.out.print("Es necesario introducir un código.");
                            System.out.println();
                            return;
                        }
                    }
                    // Pedir confirmación de la modificación
                    System.out.print("¿Desea reemplazar el código " +
                            grupo.get(idx).getCodigo() + " por " + cod + " (s/n)? " );
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setCodigo(cod);
                        System.out.println("Código cambiado exitosamente.");
                    }
                    break; // Código
                case  OPCM_NOMB: 
                    System.out.print("Introduzca el nuevo nombre(s): ");
                    String nom = entrada.nextLine().trim();
                    if(nom.isEmpty()) {
                        System.out.print("Es necesario introducir un nombre.");
                        System.out.println();
                        return;
                    }
                    System.out.print("¿Desea reemplazar " + 
                            grupo.get(idx).getNombre() + " por " + nom + " (s/n)? ");
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setNombre(nom);
                        System.out.println("Nombre cambiado exitosamente.");
                    }                   
                    break; // Nombre(s)
                case  OPCM_APPA: 
                    System.out.print("Introduzca el nuevo apellido paterno: ");
                    String apPat = entrada.nextLine().trim();
                    if(apPat.isEmpty()) {
                        System.out.print("Es necesario introducir un apellido paterno.");
                        System.out.println();
                        return;
                    }
                    System.out.print("¿Desea reemplazar " + 
                            grupo.get(idx).getApPaterno() + " por " + apPat + " (s/n)? ");
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setApPaterno(apPat);
                        System.out.println("Apellido paterno cambiado exitosamente.");
                    }                   
                    break; // Apellido paterno
                case  OPCM_APMA: 
                    System.out.print("Introduzca el nuevo apellido materno: ");
                    String apMat = entrada.nextLine().trim();
                    if(apMat.isEmpty()) {
                        System.out.print("Es necesario introducir un apellido materno.");
                        System.out.println();
                        return;
                    }
                    System.out.print("¿Desea reemplazar " + 
                            grupo.get(idx).getApMaterno() + " por " + apMat + " (s/n)? ");
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setApMaterno(apMat);
                        System.out.println("Apellido materno cambiado exitosamente.");
                    }                   
                    break; // Apellido materno
                case  OPCM_EDAD: 
                    System.out.print("Introduzca la nueva edad: ");
                    int ed = entrada.nextInt();
                    entrada.nextLine(); // Consumir el "Enter" que quedó en memoria
                    if(ed == 0) {
                        System.out.print("Es necesario introducir una edad.");
                        System.out.println();
                        return;
                    }
                    System.out.print("¿Desea reemplazar " + 
                            grupo.get(idx).getEdad() + " por " + ed + " (s/n)? ");
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setEdad(ed);
                        System.out.println("Edad cambiada exitosamente.");
                    }                   
                    break; // Edad
                case  OPCM_PROM: 
                    System.out.print("Introduzca el nuevo promedio: ");
                    double prom = entrada.nextDouble();
                    entrada.nextLine(); // Consumir el "Enter" que quedó en memoria
                    if(prom == 0) {
                        System.out.print("Es necesario introducir un promedio.");
                        System.out.println();
                        return;
                    }
                    System.out.print("¿Desea reemplazar " + 
                            grupo.get(idx).getPromedio() + " por " + prom + " (s/n)? ");
                    resp = entrada.nextLine();
                    if(resp.equalsIgnoreCase("s")) {
                        grupo.get(idx).setPromedio(prom);
                        System.out.println("Promedio cambiado exitosamente.");
                    }                                      
                    break; // Promedio
                case  OPCM_REGR: break; // Regresar     
            }
            
            
        } while(opc != OPCM_REGR);
    } // Fin de modificarDatos
    
    /**
     * Método que guarda en archivo el estado de los objetos de tipo Estudiante.
     * Los tres pasos (crear, escribir y cerrar archivo) se harán en este método.
     */
    private static void guardarObjetos() {
         Formatter salidaArch;
         
        // Crear y abrir archivo
        try {
            salidaArch = new Formatter(nombreArch);
        } catch(Exception e) {
            System.err.println("Error al crear archivo.");
            return;
        }
        
        // Escribir en el archivo
        try {
            // Recorrer todo el arreglo
            for(int i=0; i<grupo.size(); ++i) {
                // Obtener referencia al objeto i-ésimo en el arreglo
                Estudiante e = grupo.get(i);
                // Guardar el valor de cada campo en el archivo
                salidaArch.format("%s%n", e.getCodigo());
                salidaArch.format("%s%n", e.getNombre());
                salidaArch.format("%s%n", e.getApPaterno());
                salidaArch.format("%s%n", e.getApMaterno());
                salidaArch.format("%d%n", e.getEdad());
                salidaArch.format("%.2f%n", e.getPromedio());
                salidaArch.format("%n"); // Salto de línea en el archivo               
            }
        } catch(Exception e) {
            System.err.println("Error al escribir en el archivo.");
            return;
        }
        
        // Cerrar el archivo
        if(salidaArch != null) {
            salidaArch.close();
        }
        
    } // Fin de guardarObjetos
    
    /**
     * Método para recuperar el estado de los objetos del archivo e introducir
     * los objetos de tipo Estudiante al arreglo.
     */
    private static void recuperarObjetos() {
        Scanner entradaArch;
        
        // Abrir archivo
        try {
            entradaArch = new Scanner(Paths.get(nombreArch));
        } catch(Exception e) {
            System.err.println("Error al abrir archivo.");
            return;
        }
        
        // Leer objetos del archivo
        try {
            while(entradaArch.hasNext()) {
                // Crear objeto (vacío) de tipo estudiante
                Estudiante e = new Estudiante();
                // Leer el valor de cada campo e introducirlo al objeto
                e.setCodigo(entradaArch.nextLine());
                e.setNombre(entradaArch.nextLine());
                e.setApPaterno(entradaArch.nextLine());
                e.setApMaterno(entradaArch.nextLine());
                e.setEdad(entradaArch.nextInt());
                e.setPromedio(entradaArch.nextDouble());
                entradaArch.nextLine(); // Consumir el "Introducir" después del promedio1
                entradaArch.nextLine(); // Línea en blanco en el archivo
                
                // Agregar objeto al arreglo
                grupo.add(e);
            }           
        } catch(Exception e) {
            System.err.println("Error al leer archivo.");
            return;
        }
        
        // Cerrar archivo
        if(entradaArch != null) {
            entradaArch.close();
        }
        
    } // Fin de recuperarObjetos
    
    /**
     * Método que guarda los objetos de tipo Estudiante en formato binario.
     */
    private static void guardarObjetosBin() {
        ObjectOutputStream salidaArchBin;
        
        // Crear y abrir archivo binario
        try {
            salidaArchBin = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(nombreArchBin)));
        } catch(IOException | SecurityException e) {
            System.err.println("Error al abrir archivo.");
            return;
        } catch(Exception e) {
            System.err.println("Error.");
            return;
            
        }
        
        // Escribir en el archivo
        try {
            for(int i=0; i<grupo.size(); ++i) {
                salidaArchBin.writeObject(grupo.get(i));
            }
        } catch(IOException e){
            System.err.println("Error al escribir en archivo.");
            return;
        } catch(Exception e) {
            System.err.println("Error de escritura en archivo.");
            return;
        }
        
        // Cerrar archivo
        try {
            salidaArchBin.close();
        } catch(IOException e) {
            System.err.println("Error al cerrar archivo.");
        }
        
    } // Fin de guardarObjetosBin
    
    
    /**
     * Método para recuperar los objetos binarios del archivo para guardarlos
     * en el arreglo grupo.
     */
    private static void recuperarObjetosBin() {
        ObjectInputStream entradaArchBin;
        
        // Abrir el archivo
        try {
            entradaArchBin = new ObjectInputStream(Files.newInputStream(
                Paths.get(nombreArchBin)));
        } catch(IOException e) {
            System.err.println("Error al abrir archivo para lectura.");
            return;
        } catch(Exception e) {
            System.err.println("Error al abrir archivo.");
            return;
        }
        
        // Leer el archivo
        try {
            while(true) {
                Estudiante e = new Estudiante();
                // Leer objeto del archivo
                e = (Estudiante)entradaArchBin.readObject();
                // Introducir objeto al arreglo
                grupo.add(e);
            }            
        } catch(EOFException e) {
            // Se lanza cuando se llega al fin del archivo
        }catch(IOException e) {
            System.err.println("Error al leer archivo.");
            return;
        } catch(Exception e) {
            System.err.println("Error de lectura de archivo.");
            return;
        }
        
        // Cerrar archivo
        try {
            entradaArchBin.close();
        } catch(IOException e) {
            System.err.println("Error al cerrar archivo.");
        }
         
    } // Fin de recuperarObjetosBin
                 
} // Fin de clase













