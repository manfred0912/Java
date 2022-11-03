package Valencia_Saldana_Uriel_Israel_T09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    
    private JLabel Texto1;
    private JLabel Texto2;
    private JButton CF;
    private JButton FC;
    private JTextField field1;
    private JTextField field2;

    
    public Ventana (){
        
        this.setLayout(new FlowLayout());               
        
        Texto1 = new JLabel("Convertidor de grados Centígrados a Farenheit y grados Farenheit a Centígrados");
        Texto2 = new JLabel("Elige una opción:");
        
        this.add(Texto1);
        this.add(Texto2);
                
        field1 = new JTextField();
        field2 = new JTextField();
        field1.setToolTipText("C°");
        field2.setToolTipText("F°");
        field1.setColumns(5);
        field2.setColumns(20);
        
        
        this.add(field1);
        this.add(field2);  
        field2.setEditable(false);
        
        CF = new JButton("ºC -> ºF.");
        FC = new JButton("ºF -> ºC.");
        
        this.add(CF);
        this.add(FC);
        
        CF.addActionListener(new EventoCaF());
        FC.addActionListener(new EventoFaC());             
}
    
    private class EventoFaC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

           
            String primerNumero  = field1.getText();
            try{
                double c = Double.parseDouble(primerNumero);
                double f;

                f = (double) ((c*1.8) + 32);

                JOptionPane.showMessageDialog(null, "El resultado es " + f + "°C", "Calculadora °F a °C", JOptionPane.PLAIN_MESSAGE);
                field2.setText(String.valueOf(f));
                
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    } //Fin de evento
    
    private class EventoCaF implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            String primerNumero  = field1.getText();
            try{
                double f = Double.parseDouble(primerNumero);
                double c;

                c = (double) ((f - 32) / 1.8);

                JOptionPane.showMessageDialog(null, "El resultado es " + c + "°F", "Calculadora °C a °F", JOptionPane.PLAIN_MESSAGE);
                field2.setText(String.valueOf(c));
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    } //Fin de evento  
}
    

