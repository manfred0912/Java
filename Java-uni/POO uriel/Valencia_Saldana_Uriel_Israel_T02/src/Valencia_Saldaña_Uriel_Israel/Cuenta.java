package Valencia_Saldaña_Uriel_Israel;

public class Cuenta {
    
    private String nombre, direccion;
    private double saldo;
    
    public Cuenta (String nombre, double saldo, String direccion){ 
        
        this.nombre = nombre;
        
        if  (saldo>0.0)
                this.saldo = saldo;
        
        this.direccion = direccion;
    }  
    
   public void depositar(double montoDeposito){
       
       if (montoDeposito > 0.0)
           saldo = saldo + montoDeposito;
   }
   
   public double obtenerSaldo(){
       return saldo;
   }
   
   public void establecerNombre (String nombre){
       this.nombre = nombre;
   }
   
   public String obtenerNombre(){
       return nombre;
       
   }
   
   public void setDireccion(String nuevaDireccion){
        direccion = nuevaDireccion;
    }
    public String getDireccion(){
        return direccion;
    }
    
      public void retirar(double montoRetiro){
        if(saldo > montoRetiro)
        {
            saldo -= montoRetiro;
        }
    }
}
