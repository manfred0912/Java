package gutierrez_padilla_luis_pablo_t06;

public class Estado extends Pais {

    public Estado() {
        //super();
    }

    public Estado(String nombre) {
        super(nombre);
    }  
    
    @Override
    public String himno() {
        return "himnoEstado.mp3";
    }
    

//    public String desplegarDatos() {
//        return super.desplegarDatos();
//    }
//
//    Esta clase tiene las mismas caracteristicas de la de Pais, por lo mismo es que
//    hereda de Pais y no de InfoGeneral, en este caso no es necesario reescribir
//    el metodo toString    
}
