package mezclaEquilibrada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import dato.*;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class MezclaCuenta extends MezclaEquilibrada{    
    
    @Override
    public boolean mezclaE(BufferedReader reader) throws IOException {                                
        boolean b = true;  
        boolean isSorted = true;
        String cadena;
        
        Alumno alumnoI;
        Alumno alumnoD;
        
        Dato dato = new Dato();                     
        
        cadena=reader.readLine();       
        if(cadena==null){            
            isSorted = false;
            return isSorted;
        }
        if(cadena.equals("#"))
            cadena = reader.readLine();
        if(cadena.isEmpty())
            return isSorted;
        
        do{           
            alumnoI = dato.obtenerDato(cadena);
            cadena = reader.readLine();            
            if(cadena!=null&&!(cadena.equals("#"))){
                alumnoD = dato.obtenerDato(cadena);
            } else {
                if(b==true){                                                                                                       
                    dato.escribirDato2(alumnoI, "f1.txt");
                    b=false;
                } else{
                    dato.escribirDato2(alumnoI, "f2.txt");                                                                    
                    b=true;
                }
                break;
            }
            
            if(alumnoI.getNoCuenta()<=alumnoD.getNoCuenta()){
                if(b==true){
                    dato.escribirDato(alumnoI, "f1.txt");
                } else {
                    dato.escribirDato(alumnoI, "f2.txt"); 
                    isSorted = false;
                }                
                
            } else {                
                if(b==true){                                                                                                       
                    dato.escribirDato2(alumnoI, "f1.txt");
                    b=false;
                } else{
                    dato.escribirDato2(alumnoI, "f2.txt");    
                    isSorted = false;
                    b=true;
                }
            }    
        }while(cadena!=null);     
        
        dato.addHash("f1.txt");
        dato.addHash("f2.txt");                        
                           
        return isSorted;
    }

    @Override
    public void mezclaD(boolean b,BufferedReader lectura_f1, BufferedReader lectura_f2) throws FileNotFoundException, IOException {
        if(b==true) return;
        String cadenaf1;
        String cadenaf2;
  
        Alumno alumnof1;
        Alumno alumnof2;
        
        Dato dato = new Dato();                                           

        cadenaf1=lectura_f1.readLine();   
        cadenaf2=lectura_f2.readLine(); 
        if(cadenaf1==null||cadenaf2==null){
            return;
        }
        
        if(cadenaf2.equals("#")){
            while(!(cadenaf1.isEmpty())){
                alumnof1 = dato.obtenerDato(cadenaf1);
                dato.escribirDato(alumnof1, "f0.txt");
                cadenaf1=lectura_f1.readLine();
            }
           return; 
        }
        
        alumnof1 = dato.obtenerDato(cadenaf1);   
        alumnof2 = dato.obtenerDato(cadenaf2);                                         
        
        do{
           if(!(cadenaf1.isEmpty())&&!(cadenaf2.isEmpty())){
                if(alumnof1.getNoCuenta()<=alumnof2.getNoCuenta()){
                    dato.escribirDato(alumnof1, "f0.txt");
                    cadenaf1=lectura_f1.readLine();   
                    if(!(cadenaf1.isEmpty())&&!(cadenaf1.equals("#")))
                        alumnof1 = dato.obtenerDato(cadenaf1);                                  
                }else{
                    dato.escribirDato(alumnof2,"f0.txt");
                    cadenaf2=lectura_f2.readLine();   
                    if(!(cadenaf2.isEmpty())&&!(cadenaf2.equals("#")))
                        alumnof2 = dato.obtenerDato(cadenaf2);                                 
                }
            } else{  //Lo deja al inicio del nuevo bloque              
                while(cadenaf1.isEmpty()&&!(cadenaf1.equals("#"))){                        
                   cadenaf1=lectura_f1.readLine();   
                   if(!(cadenaf1.isEmpty())&&!(cadenaf1.equals("#")))
                        alumnof1 = dato.obtenerDato(cadenaf1);
                }                     
                while(cadenaf2.isEmpty()&&!(cadenaf2.equals("#"))){
                   cadenaf2=lectura_f2.readLine();   
                   if(!(cadenaf2.isEmpty())&&!(cadenaf2.equals("#")))
                        alumnof2 = dato.obtenerDato(cadenaf2);
                }
                if(cadenaf1.equals("#")&&cadenaf2.equals("#")) break;
            }           
            
            //Escribir los elementos sobrantes                       
            if(cadenaf2.equals("#")||cadenaf2.isEmpty()){ 
                do{
                    dato.escribirDato(alumnof1, "f0.txt");
                    cadenaf1=lectura_f1.readLine();
                    if(cadenaf1!=null&&!(cadenaf1.isEmpty())&&!(cadenaf1.equals("#"))){
                        alumnof1 = dato.obtenerDato(cadenaf1);
                    }  
                } while(cadenaf1!=null&&!(cadenaf1.isEmpty())&&!(cadenaf1.equals("#")));  
            } else {
                if(cadenaf1.equals("#")||cadenaf1.isEmpty()){
                    do{
                       dato.escribirDato(alumnof2, "f0.txt");
                       cadenaf2=lectura_f2.readLine();
                       if(cadenaf2!=null&&!(cadenaf2.isEmpty())&&!(cadenaf2.equals("#"))){
                         alumnof2 = dato.obtenerDato(cadenaf2);
                        }  
                    } while(cadenaf2!=null&&!(cadenaf2.isEmpty())&&!(cadenaf2.equals("#"))); 
                }
            } 
        }while(cadenaf1!=null&&cadenaf2!=null&&!(cadenaf1.equals("#"))&&!(cadenaf2.equals("#")));   
        
        if(cadenaf2.isEmpty()) cadenaf2=lectura_f2.readLine();
        if(cadenaf1.isEmpty()) cadenaf1=lectura_f1.readLine();
        
        dato.addHash("f0.txt");                
    }   
}