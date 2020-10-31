package mezclaEquilibrada;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author diegoignacionunezhernandez
 */
public abstract class MezclaEquilibrada {      
    
    public void mezcla(String archivo) throws IOException{
        boolean b;       
         b = mezclaE(archivo);    
        do{
            mezclaD(b);
            b = mezclaE("f0.txt");
        } while(b==false);
    }
    
    public abstract boolean mezclaE(String archivo) throws IOException;
    public abstract void mezclaD(boolean b) throws FileNotFoundException, IOException;    
}
