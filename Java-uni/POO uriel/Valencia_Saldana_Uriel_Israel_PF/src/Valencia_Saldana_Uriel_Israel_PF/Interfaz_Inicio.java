package Valencia_Saldana_Uriel_Israel_PF;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Interfaz_Inicio extends JFrame {
    
    private JPanel panelBotones;
    private JPanel panelTexto;
    private JPanel Imagen;
    private JLabel inicioTexto;
    private JButton[] botones;
    private JButton botonEstados, botonPaises;
   
    public Interfaz_Inicio(){
        super("Juego de Capitales");
        JLabel imagenMenu = new JLabel(new ImageIcon("mundo.jpg"));
        botones = new JButton[2];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, botones.length));
        Imagen = new JPanel();
        inicioTexto = new JLabel("Bienvenido al juego de adivinar capitales");

        //Crea botones
        botonEstados = new JButton ("Capitales Estados Mexicanos");
        botonPaises = new JButton ("Capitales Paises");

        //Fuente
        inicioTexto.setFont(new Font("Arial", Font.BOLD,30));
        panelTexto = new JPanel();
        panelTexto.add(inicioTexto);

        //Agregar botones JPanel
        panelBotones.add(botonEstados);
        panelBotones.add(botonPaises);
        Imagen.add(imagenMenu);

        add(panelBotones, BorderLayout.SOUTH);
        add(Imagen, BorderLayout.CENTER);
        add(panelTexto, BorderLayout.NORTH);

        //Eventos
        ActionListener accion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuEstados accion1 = new MenuEstados();
                accion1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion1.setBounds(380, 150, 600, 500);
                accion1.setVisible(true);
                dispose();
            }
        }; botonEstados.addActionListener(accion1);

         ActionListener accion2 = new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPaises accion2 = new MenuPaises();
                accion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                accion2.setBounds(380, 20, 600, 730);
                accion2.setVisible(true);
                dispose();
            }
        }; botonPaises.addActionListener(accion2);
    };
}