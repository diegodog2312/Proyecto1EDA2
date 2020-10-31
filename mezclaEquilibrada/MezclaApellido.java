package mezclaEquilibrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import dato.*;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class MezclaApellido extends MezclaEquilibrada{

    @Override
    public boolean mezclaE(String archivo) throws IOException {
       boolean b = true;  
        String cadena;
        
        Alumno alumnoI;
        Alumno alumnoD;
        
        Dato dato = new Dato(); 
                  
        File f1 = new File("f1.txt");
        File f2 = new File("f2.txt");

        f1.delete();
        f2.delete();
       
        f1.createNewFile();
        f2.createNewFile();
        
        File f = new File(archivo);
        FileReader lector = new FileReader(f);
        BufferedReader lectura = new BufferedReader(lector);                                                                
                                        
        cadena=lectura.readLine();       
        do{           
            alumnoI = dato.obtenerDato(cadena);
            cadena = lectura.readLine();            
            if(cadena!=null){
                alumnoD = dato.obtenerDato(cadena);
            } else {
                alumnoD=alumnoI;
            }
            
            if(alumnoI.getApellido().compareTo(alumnoD.getApellido())<=0){
                if(b==true){
                    dato.escribirDato(alumnoI, f1.getName());
                } else {
                    dato.escribirDato(alumnoI, f2.getName()); 
                }                
                
            } else {                
                if(b==true){                                                                                                       
                    dato.escribirDato2(alumnoI, f1.getName());
                    b=false;
                } else{
                    dato.escribirDato2(alumnoI, f2.getName());                                                                    
                    b=true;
                }
            }    
        }while(cadena!=null);                           
        
        lectura.close();
        
        if(f2.length()==0) return true; 
                         
        return false;
    }

    @Override
    public void mezclaD(boolean b) throws FileNotFoundException, IOException {
        if(b==true) return;
        String cadenaf1;
        String cadenaf2;
  
        Alumno alumnof1;
        Alumno alumnof2;
        Dato dato = new Dato();  
        
        File f0 = new File("f0.txt");          
        f0.delete();
        f0.createNewFile();
                        
        File f1 = new File("f1.txt");
        File f2 = new File("f2.txt");

        FileReader fr_f1 = new FileReader(f1);
        BufferedReader lectura_f1 = new BufferedReader(fr_f1);  

        FileReader fr_f2 = new FileReader(f2);
        BufferedReader lectura_f2 = new BufferedReader(fr_f2);


        cadenaf1=lectura_f1.readLine();        
        if(cadenaf1==null){
            lectura_f1.close();
            lectura_f2.close();
            return;
        }
        alumnof1 = dato.obtenerDato(cadenaf1);
        cadenaf2=lectura_f2.readLine();
        if(cadenaf2==null){
        lectura_f1.close();
        lectura_f2.close();
            return;
        }
        alumnof2 = dato.obtenerDato(cadenaf2);               
        
        do{
           if(!(cadenaf1.isEmpty())&&!(cadenaf2.isEmpty())){
                if(alumnof1.getApellido().compareTo(alumnof2.getApellido())<0){
                    dato.escribirDato(alumnof1, f0.getName());
                    cadenaf1=lectura_f1.readLine();   
                    if(cadenaf1!=null&&!(cadenaf1.isEmpty()))
                        alumnof1 = dato.obtenerDato(cadenaf1);                                  
                }else{
                    dato.escribirDato(alumnof2,f0.getName());
                    cadenaf2=lectura_f2.readLine();   
                    if(cadenaf2!=null&&!(cadenaf2.isEmpty()))
                        alumnof2 = dato.obtenerDato(cadenaf2);                                 
                }
            } else{  //Lo deja al inicio del nuevo bloque              
                while(cadenaf1!=null&&cadenaf1.isEmpty()){                        
                   cadenaf1=lectura_f1.readLine();   
                   if(cadenaf1!=null&&!(cadenaf1.isEmpty()))
                        alumnof1 = dato.obtenerDato(cadenaf1);
                }                     
                while(cadenaf2!=null&&cadenaf2.isEmpty()){
                   cadenaf2=lectura_f2.readLine();   
                   if(cadenaf2!=null&&!(cadenaf2.isEmpty()))
                        alumnof2 = dato.obtenerDato(cadenaf2);
                }
            }
            
            //Escribir los elementos sobrantes
            if(cadenaf2==null||cadenaf2.isEmpty()){                              
                do{
                    dato.escribirDato(alumnof1, f0.getName());
                    cadenaf1=lectura_f1.readLine();
                    if(cadenaf1!=null&&!(cadenaf1.isEmpty())){
                        alumnof1 = dato.obtenerDato(cadenaf1);
                    }  
                } while(cadenaf1!=null&&!(cadenaf1.isEmpty()));                    
            }else{
                if(cadenaf1.isEmpty()||cadenaf1==null){
                    do{
                       dato.escribirDato(alumnof2, f0.getName());
                       cadenaf2=lectura_f2.readLine();
                       if(cadenaf2!=null&&!(cadenaf2.isEmpty())){
                         alumnof2 = dato.obtenerDato(cadenaf2);
                        }  
                    } while(cadenaf2!=null&&!(cadenaf2.isEmpty()));                  
                }
            }                               
        }while(cadenaf1!=null&&cadenaf2!=null);       
        
        lectura_f1.close();
        lectura_f2.close();
    }    
}