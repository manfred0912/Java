
package Valencia_Saldaña_Uriel_Israel_T03;


public class Persona {
    private int altura;
    private int anios;
    private String nombre;
    
    Persona (){
        altura= 170;
        anios = 20;
        nombre = "Miguel Gomez";
    }
    
    Persona (int altura, int anios, String nombre){
        this.altura = altura;
        this.anios = anios;
        this.nombre = nombre;
    }

    public int getaltura() {
        return altura;
    }

    public void setaltra(int altura) {
        this.altura = altura;
    }

    public int getanios() {
        return anios;
    }

    public void setanios(int anios) {
        this.anios = anios;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    
    public void desplegarDatos(){
        System.out.printf("Datos: Altura de persona = %d, Anios = %d, Nombre= %s %n", this.altura, this.anios, this.nombre);

    }

    void setaltura(int i) {
        throw new UnsupportedOperationException(); 
    }
    
}
