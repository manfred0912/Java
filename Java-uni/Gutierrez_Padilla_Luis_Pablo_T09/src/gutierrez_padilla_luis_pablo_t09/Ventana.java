package gutierrez_padilla_luis_pablo_t09;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    // Campos
    private JLabel intro;
    private JLabel opc;
    private JLabel resultado;
    private JTextField num;
    private JTextField resul;
    private JButton fc;
    private JButton cf;
    
    
    
    public Ventana() {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setTitle("Calculadora de grados");
        opc = new JLabel("Introduce la cantidad a convertir");
        this.add(opc);
        
        num = new JTextField();
        num.setPreferredSize(new Dimension(50, 20));
        this.add(num);
        
        fc = new JButton("ºF -> ºC");
        this.add(fc);
        fc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String g = num.getText();
                try {
                    double grados = Double.parseDouble(g);
                    double c = (double) ((grados - 32) / 1.8);
                    resul.setText(String.valueOf(c));
                }catch(NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un numero valido");
                }catch(IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un numero");
                }
            }
            
        });
        cf = new JButton("ºC -> ºF");
        this.add(cf);
        cf.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String g = num.getText();
                try {
                    double grados = Double.parseDouble(g);
                    double f = (double) ((grados*1.8) + 32);
                    resul.setText(String.valueOf(f));
                }catch(NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Por favor introduzca un numero valido");
                }
            }
            
        });
        
        
        resultado = new JLabel("Resultado:");
        this.add(resultado);
        
        resul = new JTextField();
        resul.setPreferredSize(new Dimension(150, 20));
        resul.setEditable(false);
        this.add(resul);
       
        this.pack();
        this.setVisible(true);
    } 

    
    
}
