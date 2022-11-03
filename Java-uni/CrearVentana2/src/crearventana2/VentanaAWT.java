package crearventana2;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaAWT extends Frame {

    public VentanaAWT(String  titulo, int x, int y, int ancho, int alto) {
        // Llamada al constructor de Frame que establece el titulo de la ventana
        super(titulo);
        
        // Paso 2: Establecer posición y tamaño de la ventana
        this.setBounds(x, y, ancho, alto);
        
        // Paso 3: Hacer visible la ventana
        this.setVisible(true);
    }
    
   
    
}// Fin de clase externa
