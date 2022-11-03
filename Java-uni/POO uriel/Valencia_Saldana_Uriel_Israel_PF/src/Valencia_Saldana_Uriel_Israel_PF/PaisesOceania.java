package Valencia_Saldana_Uriel_Israel_PF;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PaisesOceania extends JFrame {
   
    private JPanel PanelBotones;
    private JPanel panelTexto;
    private JPanel PanelImagen;
    private JButton boton1, boton2, boton3, regresar;
    private JButton[] botones;
    private JLabel pregunta;
    
        public PaisesOceania(){
        super("Pais Continente Oceania 1");
        JLabel australia = new JLabel(new ImageIcon("australia.jpg")); //Imagen
        PanelBotones = new JPanel();
        botones = new JButton[4];
        PanelBotones.setLayout(new GridLayout(2, botones.length));
        PanelImagen = new JPanel();
        PanelImagen.add(australia); //Modificar en todo lo demas
        
        //Pregunta       
        pregunta = new JLabel("¿Cuál la Capital de Australia");
        
        //Diseño de letra
        pregunta.setFont(new Font("Arial", Font.BOLD,20));
        panelTexto = new JPanel();
        panelTexto.add(pregunta);
        
        //Crear Botones
        boton1 = new JButton("Sydney");
        boton2 = new JButton("Canberra");
        boton3 = new JButton("Melbourne");
        regresar = new JButton("Regresar");
        
        //Agregar botones JPanel
        PanelBotones.add(boton1);
        PanelBotones.add(boton2);
        PanelBotones.add(boton3);
        PanelBotones.add(regresar);
        
        add(PanelBotones, BorderLayout.SOUTH);
        add(panelTexto, BorderLayout.NORTH);
        add(PanelImagen, BorderLayout.CENTER);
        
        ActionListener accion1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
                JOptionPane.showMessageDialog(null,"Respuesta Incorrecta, Intentalo de nuevo");
                MenuPaises accion1  = new MenuPaises();
                accion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion1.setBounds(380, 20, 600, 730);
                accion1.setVisible(true);
                dispose();     
            }
        }; boton1.addActionListener(accion1);
        
        ActionListener accion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent AE) {
                JOptionPane.showMessageDialog(null,"Respuesta Correcta");
                PaisesOceania2 accion2 = new PaisesOceania2();
                accion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion2.setBounds(320, 200, 730, 450);
                accion2.setVisible(true);
                dispose();
            }
        }; boton2.addActionListener(accion2);
        
        ActionListener accion3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
                JOptionPane.showMessageDialog(null,"Respuesta Incorrecta, Intentalo de Nuevo");
                MenuPaises accion3  = new MenuPaises();
                accion3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion3.setBounds(380, 20, 600, 730);
                accion3.setVisible(true);
                dispose();
            }
        }; boton3.addActionListener(accion3);
        
        ActionListener accion4 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent AE) {
               int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de regresar al menu de Paises?","Atencion!", JOptionPane.YES_NO_OPTION);
               if(resp == 0){
                   MenuPaises accion4  = new MenuPaises();
                   accion4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   accion4.setBounds(380, 20, 600, 730);
                   accion4.setVisible(true);
                   dispose();
               }
            }    
        }; regresar.addActionListener(accion4);
    }
}
