package Valencia_Saldana_Uriel_Israel_T05;

public class Valencia_Saldana_Uriel_Israel_T05 {

    public static void main(String[] args) {
       
        TuristClass t1 = new TuristClass();
        TuristClass t2 = new TuristClass ("Maria", "Lopez", "Guzman", 15 , 21);
        
        System.out.println("Aerolinea 'Star' ");
        System.out.println("Nombre: "+t1.getNombre());
        System.out.println("Apellido Paterno: "+t1.getApellidoP());
        System.out.println("Apellido Materno: "+t1.getApellidoM());
        System.out.println("Edad: "+t1.getEdad());
        System.out.println("No. Asiento: "+t1.getnumAsiento());
        System.out.println("Clase: "+t1.clienteClase());
        System.out.println("Comida de la clase: "+t1.comidaClase());
        
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
        
        //Informacion predeterminada
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
    }
}
