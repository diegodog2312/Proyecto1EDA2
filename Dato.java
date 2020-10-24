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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * En esta clase se obtienen los datos de un archivon de texto
 * @author diegoignacionunezhernandez
 */
public class Dato {
    public ArrayList leerDato(int inicio, int fin, String archivoE) throws FileNotFoundException, IOException{
        ArrayList<Alumno> datos = new ArrayList<>();
        String cadena;
        String cadenas[];
        
        File archivo = new File(archivoE);        
        BufferedReader lectura;
        try (FileReader lector = new FileReader(archivo)) {
            lectura = new BufferedReader(lector);
            for(int i=0; i<inicio; i++){
                lectura.readLine();
            }   while(inicio<fin){            
                cadena = lectura.readLine();
                cadenas = cadena.split(",");
                Alumno alumno = new Alumno(cadenas[0], cadenas[1], Integer.valueOf(cadenas[2]));
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
        }
    }
}
