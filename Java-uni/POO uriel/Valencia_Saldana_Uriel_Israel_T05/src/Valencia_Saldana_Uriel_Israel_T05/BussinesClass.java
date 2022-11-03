package Valencia_Saldana_Uriel_Israel_T05;

public class BussinesClass extends AvionBoletos{
    
    public BussinesClass(){   
    }

    public BussinesClass(String nombre, String apellidoP, String apellidoM, int edad, int numAsiento) {
        super(nombre, apellidoP, apellidoM, edad, numAsiento);
    }
    
    @Override
    
    public String clienteClase() {
        return "Bussines Class";
    }
    
    @Override
    public String comidaClase(){
        return "Filete de res";
    }
    
}
