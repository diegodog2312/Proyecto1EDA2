/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * En esta clase se obtienen los datos de un archivon de texto
 * @author diegoignacionunezhernandez
 */
public class Dato {
    public ArrayList<Alumno> leerDato(int inicio, int fin, String archivoE) throws FileNotFoundException, IOException{ //Faltaba especificar el tipo de dato de la lista
        ArrayList<Alumno> datos = new ArrayList<>();
        String cadena;
        
        File archivo = new File(archivoE);        
        BufferedReader lectura;
        try (FileReader lector = new FileReader(archivo)) {
            lectura = new BufferedReader(lector);
            for(int i=0; i<inicio; i++){
                lectura.readLine();
            }   
            while(inicio<fin){            
                cadena = lectura.readLine();                
                Alumno alumno = obtenerDato(cadena);
                datos.add(alumno);
                inicio++;
            }
        }
        lectura.close();
        return datos;
    }
    
    public void escribirDatos(ArrayList<Alumno> alumnos, String archivoD) throws IOException{
        File archivo = new File(archivoD);     
        try (FileWriter escribir = new FileWriter(archivo)) {
            for(int i=0; i<alumnos.size(); i++){
                escribir.write(alumnos.get(i).getNombre().concat(",")
                        .concat(alumnos.get(i).getApellido().concat(",")
                                .concat(String.valueOf(alumnos.get(i).getNoCuenta())).concat("\n")));                       
            }
            escribir.flush();            
        }
    }
    
    public void escribirDatos2(ArrayList<Alumno> alumnos, String archivoD) throws IOException{
        File archivo = new File(archivoD);     
        try (FileWriter escribir = new FileWriter(archivo,true)) { //Agregué true
            for(int i=0; i<alumnos.size(); i++){
                escribir.write(alumnos.get(i).getNombre().concat(",")
                        .concat(alumnos.get(i).getApellido().concat(",")
                                .concat(String.valueOf(alumnos.get(i).getNoCuenta())).concat("\n")));                       
            }
            escribir.write("\n");  
            escribir.flush();          //Linea extra entre bloques
        }
        
    }


    public Alumno obtenerDato(String cadena){
        String datos[] = cadena.split(",");
        Alumno alumno = new Alumno(datos[0], datos[1], Integer.valueOf(datos[2]));
        return alumno;
    }
    public void addString(String archivoD,String string)throws IOException{
        File archivo = new File(archivoD);     
        try(FileWriter escribir = new FileWriter(archivo,true)){       
            escribir.write(string);
            
        }

    }

    public void escribirDato(Alumno alumno, String archivoD) throws IOException{
        File archivo = new File(archivoD);     
        try(FileWriter escribir = new FileWriter(archivo,true)){       
            escribir.write(alumno.getNombre().concat(",")
                        .concat(alumno.getApellido().concat(",")
                                .concat(String.valueOf(alumno.getNoCuenta())).concat("\n")));
            escribir.flush();
        }
        
    }
    
    public void escribirDato2(Alumno alumno, String archivoD) throws IOException{
        File archivo = new File(archivoD);     
        try(FileWriter escribir = new FileWriter(archivo,true)){       
            escribir.write(alumno.getNombre().concat(",")
                        .concat(alumno.getApellido().concat(",")
                                .concat(String.valueOf(alumno.getNoCuenta())).concat("\n")));    
            escribir.write("\n");
        }
    }
}
