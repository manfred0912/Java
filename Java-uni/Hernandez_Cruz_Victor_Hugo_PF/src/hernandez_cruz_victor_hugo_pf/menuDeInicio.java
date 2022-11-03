
package hernandez_cruz_victor_hugo_pf;
    
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menuDeInicio extends JFrame implements ActionListener{
    MenuMemorama menuMemorama;
    
    //Declaramos nuestras variables para los botones de tipo JButton
    JButton btn8card;
    JButton btn16card;
    JButton btnSalir;
    
    //Declaramos nuestra variable de tipo JLabel para el texto
    JLabel texto;
    
//*********************************CONSTRUCTOR**********************************   
    //Constructor
    public menuDeInicio(){
        super("Memorama");//nombre que aparecera en la ventana del programa
        GUI();
        escuchaAction();
    }//FIN DE CONSTRUCTOR
//*********************************CONSTRUCTOR**********************************     

//*********************************GUI******************************************    
    private void GUI(){
     //
      setLayout(null);
     
      //Agregamos la etiqueta al cuadro del programa
      texto = new JLabel("Escoge la modalidad del juego");
      texto.setBounds(60,20,200,20);//seleccionamos su tamaño
      add(texto);//lo agregamos
      
      //Agregamos los botones
      btn8card = new JButton("8 cartas");//Creamos el boton
      btn8card.setBounds(75, 70, 150, 40);//creamos el tamaño
      add(btn8card);
      
      btn16card = new JButton("16 cartas");//Creamos el boton
      btn16card.setBounds(75, 115, 150, 40);//creamos el tamaño
      add(btn16card);
      
      btnSalir = new JButton("Salir del juego");//Creamos el boton
      btnSalir.setBounds(75, 160, 150, 40);//creamos el tamaño
      add(btnSalir);
      
      //el tamaño de nuestra ventana del programa
      setSize(300,300);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);//
      setLocationRelativeTo(this);//
      setVisible(true);
      
    }//FIN DE GUI
//*********************************GUI******************************************

//*********************************ESCUCHAACTION********************************
    private void escuchaAction(){
        //Una vez seleccionado algun boton madaremoa a llamar al método para que
        //responda segun sea su caso
        btn8card.addActionListener(this);
        btn16card.addActionListener(this);
        btnSalir.addActionListener(this);
    }//FIN DE ESCUCHA
//*********************************ESCUCHAACTION********************************
    
    @Override
    public void actionPerformed(ActionEvent e){
        //
        JButton BtnSeleccionado = (JButton) e.getSource();
        if(BtnSeleccionado == btn8card){
            menuMemorama = new MenuMemorama(8);
        }//fin if btn8card
        else if(BtnSeleccionado == btn16card){
            menuMemorama = new MenuMemorama(16);
        }else{
            System.exit(0);
        }//fin de if-else 
        dispose();
    }
}//FIN DE LA CLASE MENUDE INICIO
