package Valencia_Saldana_Uriel_Israel_T05;

public class TuristClass extends AvionBoletos {
    
    public TuristClass(){
        
    }

    public TuristClass(String nombre, String apellidoP, String apellidoM, int edad, int numAsiento) {
        
        super(nombre, apellidoP, apellidoM, edad, numAsiento);
    }

    @Override
    public String clienteClase() {
        return "Turist Class";
    }
    
    @Override
    public String comidaClase(){
        return "Botana";
    }
}
