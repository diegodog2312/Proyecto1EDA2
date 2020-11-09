package mezclaEquilibrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author diegoignacionunezhernandez
 */
public abstract class MezclaEquilibrada {      
    
    public void mezcla(String archivo) throws IOException{
        boolean b;
                
        File f = new File(archivo);
        FileReader lector = new FileReader(f);
        BufferedReader reader = new BufferedReader(lector);  
        
        File f0 = new File("f0.txt");                  
        f0.createNewFile(); 
        FileReader fr_f0 = new FileReader(f0);
        BufferedReader lectura_f0 = new BufferedReader(fr_f0);  
        
        File f1 = new File("f1.txt");    
        f1.createNewFile();
        FileReader fr_f1 = new FileReader(f1);
        BufferedReader lectura_f1 = new BufferedReader(fr_f1);          

        File f2 = new File("f2.txt");   
        f2.createNewFile();
        FileReader fr_f2 = new FileReader(f2);
        BufferedReader lectura_f2 = new BufferedReader(fr_f2);
        
        b = mezclaE(reader);    
        do{
            mezclaD(b,lectura_f1,lectura_f2);
            b = mezclaE(lectura_f0);
        } while(b==false);
        
        lectura_f0.close();
        lectura_f1.close();
        lectura_f2.close();
        reader.close();
    }
    
    public abstract boolean mezclaE(BufferedReader reader) throws IOException;
    public abstract void mezclaD(boolean b, BufferedReader lectura_f1, BufferedReader lectura_f2) throws FileNotFoundException, IOException;    
}
