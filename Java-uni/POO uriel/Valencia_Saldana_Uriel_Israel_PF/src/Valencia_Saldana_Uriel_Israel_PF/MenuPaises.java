package Valencia_Saldana_Uriel_Israel_PF;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPaises extends JFrame {
    
    private JPanel PanelBotones;
    private JPanel panelTexto;
    private JPanel PanelImagen;
    private JButton botonAmerica, botonEuropa, botonOceania, regresar;
    private JButton[] botones;
    private JLabel inicioTexto;
    
    public MenuPaises(){
        super("Modo de juego Paises del Mundo");
        JLabel planeta = new JLabel(new ImageIcon("planeta.jpg")); //Imagen
        PanelBotones = new JPanel();
        botones = new JButton[4];
        PanelBotones.setLayout(new GridLayout(2, botones.length));
        PanelImagen = new JPanel();
        PanelImagen.add(planeta);
        inicioTexto = new JLabel("Elige el continente donde quieres jugar");
        
        //Diseño de letra
        inicioTexto.setFont(new Font("Arial", Font.BOLD,20));
        panelTexto = new JPanel();
        panelTexto.add(inicioTexto);
        
        //Crear Botones
        botonAmerica = new JButton("America");
        botonEuropa = new JButton("Europa");
        botonOceania = new JButton("Oceania");
        regresar = new JButton("Regresar");
        
        //Agregar botones JPanel
        PanelBotones.add(botonAmerica);
        PanelBotones.add(botonEuropa);
        PanelBotones.add(botonOceania);
        PanelBotones.add(regresar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        add(panelTexto, BorderLayout.NORTH);
        add(PanelImagen, BorderLayout.CENTER);
        
        ActionListener accion1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste el Continente America");
               PaisesAmerica accion1 = new PaisesAmerica();
               accion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion1.setBounds(180, 80, 1000, 600);
               accion1.setVisible(true);
               dispose();
            }
        }; botonAmerica.addActionListener(accion1);
        
        ActionListener accion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste el Continente Europa");
               PaisesEuropa accion2 = new PaisesEuropa();
               accion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion2.setBounds(380, 50, 600, 700);
               accion2.setVisible(true);
               dispose();
            }
        }; botonEuropa.addActionListener(accion2);
        
        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste el Continente Oceania");
               PaisesOceania accion3 = new PaisesOceania();
               accion3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion3.setBounds(380, 150, 600, 500);
               accion3.setVisible(true);
               dispose();
            }
        }; botonOceania.addActionListener(accion3);
        
        ActionListener accion4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro de regresar al menu principal?","Atento!", JOptionPane.YES_NO_OPTION);
               if(resp == 0){
                   Interfaz_Inicio accion4  = new Interfaz_Inicio();
                   accion4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   accion4.setBounds(320, 120, 750, 550);
                   accion4.setVisible(true);
                   dispose();
               }
            } 
        }; regresar.addActionListener(accion4);
    }
}
