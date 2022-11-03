
package hernandez_cruz_victor_hugo_pf;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utils.Rutinas;


public class BtnCarta extends JButton{
    static final private ImageIcon IMAGEN_DEFAULT = Rutinas.AjustarImagen("./src/imagenesMemorama/signo.jpg", 100, 100);
    private ImageIcon imagen;
    private String nombre;
//*********************************CONSTRUCTOR**********************************    
    //constructor
    public BtnCarta(ImageIcon imagen, String nombre){
        this.imagen = imagen;
        this.nombre = nombre;
        setIcon(IMAGEN_DEFAULT);
        setDisabledIcon(imagen);        
    }//fin constructor
//*********************************CONSTRUCTOR**********************************
  
//*********************************GET**********************************
    public ImageIcon getImagen() {
        return imagen;
    }//FIN GETIMAGEN

    public String getNombre() {
        return nombre;
    }//FIN GETNOMBRE
//*********************************GET**********************************

//*********************************MOSTRAR**********************************    
    public void mostrarCarta() {
        //setIcon(imagen);
        setEnabled(false);
    }//FIN DE MOSTRAR
//*********************************MOSTRAR********************************** 
    
//*********************************OCULTAR**********************************     
    public void ocultarCarta() {
        setIcon(IMAGEN_DEFAULT);
        setEnabled(true);
    }//FIN DE OCULTAR
//*********************************OCULTAR**********************************
}//fin de la clase BTN boton
 
