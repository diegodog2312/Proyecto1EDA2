/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1eda2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author diegoignacionunezhernandez
 */
public class MezclaEquilibrada {
    
    public void mezclaEquilibrada(String archivo) throws IOException{
        boolean b=false;
        while(b==false){
            b = mezclaCuenta(archivo);   
            archivo = mezclaDirecta();
        }
    }
    
    public boolean mezclaCuenta(String archivo) throws IOException{   
        boolean b = true;  
        boolean b2 = false;
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
            
            if(alumnoI.getNoCuenta()<alumnoD.getNoCuenta()){
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
        
        if(f2.length()==0)
           b2 = true;
        
        return b2;
    }

    //Mezcla Directa                              
    public String mezclaDirecta() throws FileNotFoundException, IOException{        
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
        alumnof1 = dato.obtenerDato(cadenaf1);
        cadenaf2=lectura_f2.readLine();   
        alumnof2 = dato.obtenerDato(cadenaf2);
        do{
           if(!(cadenaf1.isEmpty())&&!(cadenaf2.isEmpty())){
                if(alumnof1.getNoCuenta()<alumnof2.getNoCuenta()){
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
                       if(!(cadenaf2.isEmpty())&&cadenaf2!=null){
                         alumnof2 = dato.obtenerDato(cadenaf2);
                        }  
                    } while(cadenaf2!=null&&!(cadenaf2.isEmpty()));                  
                }
            }                   
            
        }while(cadenaf1!=null&&cadenaf2!=null);  
       
        return f0.getName();
    }
}       