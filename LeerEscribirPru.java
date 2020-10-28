import java.io.IOException;
import java.util.ArrayList;



public class LeerEscribirPru {
    public static void main(String[] args)throws IOException{
        String nombreArchivo = args[0];
        Dato lecEsc = new Dato();
        ArrayList<Alumno> alumnos;
        alumnos = lecEsc.leerDato(0,104, "datos.txt");
        lecEsc.escribirDatos(alumnos, nombreArchivo);
        Polifase sort = new Polifase();
        sort.poliSort("datos.txt");
    }
}
