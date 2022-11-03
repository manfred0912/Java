
package hernandez_cruz_victor_hugo_pf;

import utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class MenuMemorama extends JFrame implements ActionListener{
   
    //declaramos un arreglo en donde contendra el nombre de las cartas
    private final String[] CARTAS = {"Goku.jpg","Puro_Hueso.jpg", "Coraje.jpg", "Dexter.jpg", "Johny.jpg","Goku2.jpg","Krilin.jpg", "Numero1.jpg"};
    
    private BtnCarta[] cartasMemorama;
    private BtnCarta cartaAuxiliar;
    private int puntuacion;
    private int numeroCartas;
    private int numeroPares;

//*********************************CONSTRUCTOR**********************************    
    //Constructor
    public MenuMemorama(int numeroCartas){
        super("Memorama Proyecto Final");
        this.numeroCartas = numeroCartas;
        puntuacion = 0;
        
        setLayout(new GridLayout(0, 4, 4, 4));
        setSize(650, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        generarCartas();
        setVisible(true);
    }//FIN DE CONSTRUCTOR
//*********************************CONSTRUCTOR**********************************
    
    public int getNumeroCartas(){
        return numeroCartas;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        BtnCarta cartaSeleccionada = (BtnCarta) e.getSource();//
        cartaSeleccionada.mostrarCarta();
        
        //Si la carta auxiliar no tiene valor estonces se regresara
        if(cartaAuxiliar == null){
            cartaAuxiliar = cartaSeleccionada;
            return;
        }//fiin del if
        
        if(cartaAuxiliar.getNombre().compareTo(cartaSeleccionada.getNombre()) == 0 ){
            puntuacion ++;
            cartaAuxiliar = null;
                if(puntuacion == numeroPares){
                    Toolkit.getDefaultToolkit().beep();
                    new finDeJuego(this);
                    //JOptionPane.showMessageDialog(null,"¡Felicidades, ganaste!");
                    return;
                }//fin del if
           return;
        }//fin del if
     
     update(getGraphics());
     try {
         Thread.sleep(1000);
     }catch (InterruptedException ex) {
        Logger.getLogger(MenuMemorama.class.getName()).log(Level.SEVERE, null, ex);
     }//fin try catch
     
         //si la carta no encuentra su par se llamara al metodo de ocultar carta
         //para que el usuario vuelva a intentarlo
    cartaAuxiliar.ocultarCarta();
    cartaAuxiliar = null;
    cartaSeleccionada.ocultarCarta();
    }
//******************************GENERAR CARTAS*********************************        
    public void generarCartas(){
        numeroPares = numeroCartas/2; //el numero de cartas lo dividimos entre 2
        cartasMemorama = new BtnCarta[numeroCartas];
        String archivo;
        ImageIcon imagenCarta;
        BtnCarta btnCarta;
        
        //Añadimos 2 veces de cada uno y buscamos la direcion en donde se encuentran
        //nuestras imagenes
        int contaMemorama =0;
        for(int i = 0; i<numeroPares; i++, contaMemorama++){
            archivo = "./src/imagenesMemorama/" + CARTAS[i] + ".jpg";
            imagenCarta = Rutinas.AjustarImagen(archivo, 100, 100);
            btnCarta = new BtnCarta(imagenCarta, CARTAS[i]);//Ojo btn es la variable y Btn con mayuscula es el objeto
            btnCarta.addActionListener(this);
            cartasMemorama[contaMemorama] = btnCarta;
        }//fin del for
        
        for(int i = 0; i<numeroPares; i++, contaMemorama++){
            archivo = "./src/imagenesMemorama/" + CARTAS[i] + ".jpg";
            imagenCarta = Rutinas.AjustarImagen(archivo, 100, 100);
            btnCarta = new BtnCarta(imagenCarta, CARTAS[i]);//Ojo btn es la variable y Btn con mayuscula es el objeto
            btnCarta.addActionListener(this);
            cartasMemorama[contaMemorama] = btnCarta;
        }//fin del for
//******************************GENERAR CARTAS********************************* 

//******************************BARAJEAR CARTAS*********************************
    //Barajear las cartas
    barajear(cartasMemorama);
    // las añadimos
    for(int i= 0; i < cartasMemorama.length; i++){
        add(cartasMemorama[i]);
     }//FIN DE FOR PARA BARAJEAR
}
//******************************BARAJEAR CARTAS*********************************
    
//**********************MÉTODO BARAJEAR CARTAS*********************************
    private void barajear(BtnCarta[] cartasMemorama){
        BtnCarta auxiliar;
        int posicionA, posicionB;
        for(int i= 0; i< 30; i++){
            posicionA = new Random().nextInt((cartasMemorama.length - 1) + 1); //limiteSuperior - limiteInferior + 1) + limiteInferior
            posicionB = new Random().nextInt((cartasMemorama.length - 1) + 1);
            
            //ahora las intercambiara
            auxiliar = cartasMemorama[posicionA];
            cartasMemorama[posicionA] = cartasMemorama[posicionB];
            cartasMemorama[posicionB] = auxiliar;
        }
    }
//**********************MÉTODO BARAJEAR CARTAS*********************************
}//fin de la clase del menu del memorama
