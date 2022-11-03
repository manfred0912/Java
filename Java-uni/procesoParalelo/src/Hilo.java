import javax.swing.JProgressBar;

public class Hilo extends Thread {      

    private final Paralelo PARALELO;
    private final JProgressBar BARRA;
    private final short CICLOS;
    private final int SEGUNDOS;
    private boolean detener = false;
    
    public Hilo (Paralelo paralelo, JProgressBar barra, short ciclos, short milisegundos) {
        PARALELO = paralelo;
        BARRA = barra;
        CICLOS = ciclos;
        SEGUNDOS = milisegundos * 1000;
        
        BARRA.setMinimum(0);
        BARRA.setMaximum(ciclos);
    }
    
    @Override
    public void run () {
        try {
            procesar();
            if (!detener)                    
                PARALELO.setResultado(true, "oK");
            else                                   
                PARALELO.setResultado(false, "CANCELADO");                    
        } catch (InterruptedException e) {
            PARALELO.setResultado(false, e.getMessage());
        }            
    }
    
    private void procesar () throws InterruptedException {
        for (int i = 0; i <= CICLOS && !detener; i++) {
            BARRA.setValue(i);            
            Thread.sleep(SEGUNDOS);    
        }
    }
    
    public void detener () {
        detener = true;
    }
}