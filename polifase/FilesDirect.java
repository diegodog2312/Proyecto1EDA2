package polifase;

import java.io.File;
import java.io.IOException;

public class FilesDirect {
    private String folderpath;

    public FilesDirect(){
        folderpath = new File("").getAbsolutePath()+"/polifaseFiles";
    }
    
    public String rutaFolder(){
        return folderpath;
    }

    public void crearDirectorio(){
        System.out.println(folderpath);
        File directorio = new File(folderpath);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }else{
            System.out.println("El directorio existe");
        }
    }

    public void crearArchivo(String nombre) throws IOException{
        String filePath = folderpath+ "/" + nombre;
        File file = new File(filePath);
        // Si el archivo no existe es creado
        file.delete();
        if (!file.exists()) {
            System.out.println(filePath);
            file.createNewFile();
        }else{
            System.out.println("El archivo no se pudo limpiar! el algoritmo procederá con errores");
        }
    }
}
