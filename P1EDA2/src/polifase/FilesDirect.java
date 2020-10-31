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

    public void crearDirectorio() throws IOException{
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
            eliminarDirectorio(directorio);
             if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public void crearArchivo(String nombre) throws IOException{
        String filePath = folderpath+ "/" + nombre;
        File file = new File(filePath);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            System.out.println(filePath);
            file.createNewFile();
        }
    }
    void eliminarDirectorio(File archivo) throws IOException {
        if (archivo.isDirectory()) {
            File[] entries = archivo.listFiles();
                if (entries != null) {
                    for (File entry : entries) {
                        eliminarDirectorio(entry);
                    }
            }
        }
        if (!archivo.delete()) {
          throw new IOException("Error al eliminar " + archivo);
        }
    }
}
