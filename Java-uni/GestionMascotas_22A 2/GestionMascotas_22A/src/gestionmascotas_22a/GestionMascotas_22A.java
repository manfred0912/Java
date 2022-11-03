package gestionmascotas_22a;

public class GestionMascotas_22A {

    public static void main(String[] args) {
        //Mascota m = new Mascota();
        //m.emitirSonido();
        
        Gato g1 = new Gato();
        System.out.println("Nombre de g1: " + g1.getNombre());
        g1.setNombre("Benito");
        String s1 = g1.getNombre();
        System.out.println("Nombre de g1: " + s1);
        
        Gato g2 = new Gato("Demóstenes");
        String s2 = g2.emitirSonido();
        System.out.printf("Sonido emitido por %s: %s%n", g2.getNombre(), s2);
        
        String s3 = g2.toString();
        System.out.println(s3);
        
        // Cuando una variable de objeto se encuentra en contexto donde se
        // espera recibir un String, se manda llamar implícitamente al
        // método toString
        System.out.println(g1); // Llamada implícita a g1.toString()
       
        Perro p1 = new Perro();
        p1.setNombre("Firulais");
        
        String s4 = p1.toString();
        System.out.println(s4);
        
        Perro p2 = new Perro("Solovino");
        System.out.println(p2); // p2.toString()
        
        
        // A una VARIABLE de una superclase es posible asignarle
        // un OBJETO de alguna de sus subclases (directas o indirectas)
        Mascota m1 = new Gato("Cucho");
        Mascota m2 = new Perro("Nerón");
        Mascota m3 = new Perico("Polly");
        //((Gato)m2).x();
        
        //System.out.println("Sonido de m1: " + m1.emitirSonido());
        Object o1 = new Gato("Don Gato");
        Object o2 = new Perro("Figo");
        Object o3 = new Perico("Juanita");
        
        //System.out.println("Nombre de o1: " + ((Mascota)o1).getNombre());
        //Gato g3 = new Object();
        
        System.out.println();
        desplegarInfo(g1);
        desplegarInfo(p1);
        desplegarInfo(m3);
        desplegarInfo((Gato)o1);
        
    } // Fin de main
    
    /**
     * Método polimórfico para mostrar información de una mascota.
     */
    public static void desplegarInfo(Mascota m) {
        System.out.printf("Tipo de mascota: %s\nNombre: %s\nSonido: %s\n\n",
                m.getClass().getSimpleName(),
                m.getNombre(),
                m.emitirSonido() //Llamada polimórfica
                );
    }
    
} // Fin de clase
