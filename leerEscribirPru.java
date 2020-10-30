
import java.io.*;
public class LeerEscribirPru {
    public static void main(String[] args)throws IOException {
        String nombreArchivo = args[0];
        Polifase prueba = new Polifase();
        //prueba.sortNum(nombreArchivo);
        prueba.sortStr(nombreArchivo);
    }
}
