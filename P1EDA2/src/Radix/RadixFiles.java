/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radix;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Sofía Elizabeth Cabello Díaz
 */
public class RadixFiles {
        private String folderpath;

    public RadixFiles(String archivoD){
        folderpath = new File("").getAbsolutePath()+"/radixFiles/"+archivoD;
    }
    
    public String rutaFolder(){
        return folderpath;
    }

    public void crearDirectorio(){
        //System.out.println(folderpath);
        File directorio = new File(folderpath);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                //System.out.println("Directorio creado");
            } else {
                //System.out.println("Error al crear directorio");
            }
        }else{
            //System.out.println("El directorio existe");
        }

    }

    public File crearArchivo(String nombre) throws IOException{
        String filePath = folderpath+ "/" + nombre+".txt";
        File file = new File(filePath);
        file.delete();
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }else{
            System.out.println("El archivo no se pudo limpiar! el algoritmo procederá con errores");
        }
        return null;
    }
}
