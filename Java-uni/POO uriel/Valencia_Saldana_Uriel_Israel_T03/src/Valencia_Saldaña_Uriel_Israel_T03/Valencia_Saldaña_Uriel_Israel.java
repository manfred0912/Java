
package Valencia_Saldaña_Uriel_Israel_T03;


public class Valencia_Saldaña_Uriel_Israel {

    
   
    public static void main(String[] args) {
        
        Persona gente1 = new Persona();
        Persona gente2 = new Persona(165, 19, "Maria Lopez");
        
        gente1.desplegarDatos();
        gente2.desplegarDatos();
        
        gente1.setaltura(172);
        gente1.setanios(34);
        gente1.setnombre("Jose Juarez");
        
        gente1.desplegarDatos();


        
        
    }
    
    
    
    
}
