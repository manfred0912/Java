package gutierrez_padilla_luis_pablo_pf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static gutierrez_padilla_luis_pablo_pf.Gutierrez_Padilla_Luis_Pablo_PF.puntajes;
import static gutierrez_padilla_luis_pablo_pf.PantallaMenu.salidaArch;
import java.util.Formatter;

public class PantallaJuego extends JFrame {

    private static ArrayList<JButton> botones = new ArrayList<>();
    ImageIcon hoyo = new ImageIcon(getClass().getResource("hoyo.png"));
    ImageIcon castor = new ImageIcon(getClass().getResource("castor.png"));
    public JLabel puntuacion;
    public JLabel vidas;
    int puntos;
    int vids = 3;
    boolean pts = false;
    int rand;

    public PantallaJuego() {
        JOptionPane.showMessageDialog(null, "Instrucciones:\ndeberas de marcar el mayor numero de puntos posibles.\ncuentas con 3 vidas\nNo hay perdida de puntos si no presionas los botones antes de que el castor cambie de posicion\nNo hay limite de tiempo\nDiviertete!", "inicio", JOptionPane.INFORMATION_MESSAGE);
        this.setLayout(null);
        this.setTitle("Whack-a-mole!");
        inicializarComponentes();
        setSize(1100, 1200);
        setVisible(true);
    }

    public PantallaJuego(int v, int p) {
        vids = v;
        puntos = p;
        this.setLayout(null);
        this.setTitle("Whack-a-mole!");
        inicializarComponentes();
        setSize(1100, 1200);
        setVisible(true);
    }

    private void inicializarComponentes() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1100, 1000);
        panel.setLayout(new FlowLayout());
        add(panel, BorderLayout.CENTER);//        
        puntuacion = new JLabel("Puntuacion: " + puntos);
        puntuacion.setBounds(100, 1050, 550, 50);
        add(puntuacion, BorderLayout.SOUTH);
        vidas = new JLabel("Vidas: " + vids);
        vidas.setBounds(450, 1050, 550, 50);
        add(vidas, BorderLayout.SOUTH);

        for (int i = 0; i < 9; ++i) {
            JButton boton = new JButton();
            boton.setSize(300, 300);
            boton.setIcon(hoyo);
            botones.add(boton);
            panel.add(boton);
        }

        tiempo();

        for (JButton boton : botones) {
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (rand == botones.indexOf(boton)) {
                        puntos += 10;
                        puntuacion.setText("Puntuacion: " + puntos);
                        salvarParametros();
                    } else {
                        vids -= 1;
                        vidas.setText("Vidas: " + vids);
                        salvarParametros();
                        if (vids == 0) {
                            setVisible(false);
                            if (puntos != 0) {
                                String nombre = JOptionPane.showInputDialog(null, "Juego finalizado, el puntaje es de: " + puntos + ", escriba el nombre del jugador: ", "Game over", JOptionPane.PLAIN_MESSAGE);
                                if (nombre != null) {
                                    Jugadores jugador = new Jugadores(puntos, nombre);
                                    puntajes.add(jugador);
                                }
                                salvarParametros();
                                new PantallaMenu();
                            } else {
                                JOptionPane.showMessageDialog(null, "Has perdido, tu puntuacion ha sido de 0 puntos", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                                new PantallaMenu();
                            }
                            botones.clear();
                        }
                    }
                }

            });
        }

    }

    private void juego() {
        for (JButton boton : botones) {
            if (rand == botones.indexOf(boton)) {
                boton.setIcon(castor);
            } else if (rand != botones.indexOf(boton)) {
                boton.setIcon(hoyo);
            }
        }
    }

    private void tiempo() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int min = 0;
                int max = 8;
                int rand2 = rand;
                rand = (int) Math.floor(Math.random() * (max - min + 1) + min);
                while (rand == rand2) {
                    rand = (int) Math.floor(Math.random() * (max - min + 1) + min);
                }
                juego();
                if (vids == 0) {
                    timer.cancel();
                }
            }

        };
        timer.schedule(task, 1500, 700);

    }

    private void salvarParametros() {
        try {
            salidaArch = new Formatter("partida.txt");
        } catch (Exception x) {
            System.err.println("Error al crear archivo.");
            return;
        }

        if (vids == 0) {
            try {
                salidaArch.format("%s%n", 0);
                salidaArch.format("%s%n", 0);
            } catch (Exception x) {
                System.err.println("Error al escribir en el archivo.");
                return;
            }
            if (salidaArch != null) {
                salidaArch.close();
            }

        } else {
            try {
                salidaArch.format("%s%n", vids);
                salidaArch.format("%s%n", puntos);
            } catch (Exception x) {
                System.err.println("Error al escribir en el archivo.");
                return;
            }
            if (salidaArch != null) {
                salidaArch.close();
            }
        }
    }
}
