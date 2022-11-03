package crearventana1;

import java.awt.Frame;

public class CrearVentana1 {

    public static void main(String[] args) {
        // Paso 1: Crear el objeto de la ventana AWT
        Frame v = new Frame("Mi primera ventana");
        
        // Paso 2: Establecer posición y tamaño
        v.setLocation(200, 300);
        v.setSize(400, 300);
        
        // Paso 3: Hacer visible la ventana
        v.setVisible(true);
    }
    
}
