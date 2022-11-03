
package hernandez_cruz_victor_hugo_pf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class finDeJuego extends JDialog implements ActionListener{
    MenuMemorama menuMemorama;
    JButton btnMenuPrincipal, btnReiniciar, btnSalir;
    JLabel texto;
    
//******************************************************************************
    public finDeJuego(MenuMemorama menuMemorama){
        this.menuMemorama = menuMemorama;
        setSize(300,300);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //Mostramos una etiqueta con su respectivo tamaño y los centramos
        texto = new JLabel("Juego Terminado", SwingConstants.CENTER);
        texto.setBounds(40, 20, 200, 20);
        add(texto);
        
        //creamos y le asiganmos tamaño al boton para despues agretarlo
        btnMenuPrincipal = new JButton("Menú Principal");
        btnMenuPrincipal.addActionListener(this);
        btnMenuPrincipal.setBounds(70, 70, 150, 40);
        add(btnMenuPrincipal);
        
        btnReiniciar = new JButton("Reiniciar juego");
        btnReiniciar.addActionListener(this);
        btnReiniciar.setBounds(70, 120, 150, 40);
        add(btnReiniciar);
        
        btnSalir = new JButton("Salir del juego");
        btnSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        btnSalir.setBounds(70, 170, 150, 40);
        add(btnSalir); 
        
        setModal(true);//
        setVisible(true);
        
    }//fin del constructor
//******************************************************************************
    
    @Override
    public void actionPerformed(ActionEvent e){
        JButton botonSeleccionado = (JButton) e.getSource();
        if(botonSeleccionado == btnMenuPrincipal){
            dispose();//
            menuMemorama.dispose();//
            new menuDeInicio();
            dispose();
            return;
        }//fin de if
        if (botonSeleccionado == btnReiniciar) {
            dispose();
            menuMemorama.dispose();
            new MenuMemorama(menuMemorama.getNumeroCartas());
            return;
        }
    }//fin del metodo de los eventos
}//Fin de clase fin de juego
