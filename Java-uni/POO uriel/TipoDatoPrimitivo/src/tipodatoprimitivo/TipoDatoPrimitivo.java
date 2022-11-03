package tipodatoprimitivo;

public class TipoDatoPrimitivo {

    public static void main(String[] args) {
        
        /*No. bits      No. valores    Formula  
        1               2               0,1
        2               4               00,01,10,11
        3               8               000,001,010,100,011,110,
        ...
        8               256
        ...
        16              65536
        ...
        
        */
        
        byte b;
        short s;
        int i;
        long l;
        
        float f;
        double d;        
                
        boolean n;
        char c;
        
        b = 100;
        s = 7000;
        i = 100_000;
        l = 1_000_000_000L;
    
        f = 3.1416F;        
        d = 13.4567;
        
        n = false;
        
        c = 'A';
        
        l = i; //conversion automatica
        
        i = (int)l; //conversion explicita
        
        System.out.println("i: " + 1);
        
        d = f; //conversion automatica
         
        f = (float)d; //conversion explicita
        
        
    }
    
}
