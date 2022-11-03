package Valencia_Saldana_Uriel_Israel_PF;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuEstados extends JFrame {
    
    private JPanel PanelBotones;
    private JPanel panelTexto;
    private JPanel PanelImagen;
    private JButton botonFacil, botonMedio, botonDificil, regresar;
    private JButton[] botones;
    private JLabel inicioTexto;
    
    public MenuEstados(){
        super("Modo de juego Estados de la Republica Mexicana");
        JLabel mexico = new JLabel(new ImageIcon("mexico.jpg")); //Imagen
        PanelBotones = new JPanel();
        botones = new JButton[4];
        PanelBotones.setLayout(new GridLayout(2, botones.length));
        PanelImagen = new JPanel();
        PanelImagen.add(mexico);
        inicioTexto = new JLabel("Elige la dificultad que deseas");
        
        //Diseño de letra
        inicioTexto.setFont(new Font("Arial", Font.BOLD,20));
        panelTexto = new JPanel();
        panelTexto.add(inicioTexto);
        
        //Crear Botones
        botonFacil = new JButton("Nivel Facil");
        botonMedio = new JButton("Nivel Medio");
        botonDificil = new JButton("Nivel Dificil");
        regresar = new JButton("Regresar");
        
        //Agregar botones JPanel
        PanelBotones.add(botonFacil);
        PanelBotones.add(botonMedio);
        PanelBotones.add(botonDificil);
        PanelBotones.add(regresar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        add(panelTexto, BorderLayout.NORTH);
        add(PanelImagen, BorderLayout.CENTER);
        
        ActionListener accion1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste Nivel Facil");
               NivelFacilEstados accion1 = new NivelFacilEstados();
               accion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion1.setBounds(180, 80, 1000, 600);
               accion1.setVisible(true);
               dispose();
            }
        }; botonFacil.addActionListener(accion1);
        
        ActionListener accion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste Nivel Medio");
               NivelMedioEstados accion2 = new NivelMedioEstados();
               accion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion2.setBounds(380, 200, 600, 400);
               accion2.setVisible(true);
               dispose();
            }
        }; botonMedio.addActionListener(accion2);
        
        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               JOptionPane.showMessageDialog(null,"Elegiste Nivel Dificil");
               NivelDificilEstados accion3 = new NivelDificilEstados();
               accion3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               accion3.setBounds(380, 150, 600, 500);
               accion3.setVisible(true);
               dispose();
            }
        }; botonDificil.addActionListener(accion3);
        
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
