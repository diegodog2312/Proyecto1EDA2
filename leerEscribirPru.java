import java.util.ArrayList;
import proyecto1eda2.Alumno;
import proyecto1eda2.Dato;

public class leerEscribirPru {
    public static void main(String[] args){
        String nombreArchivo = args[0];
        Dato lecEsc = new Dato();
        ArrayList<Alumno> alumnos;
        alumnos = lecEsc.leerDato(0, 99, "datos.txt");
        lecEsc.escribirDatos(alumnos, "archivoEscritura.txt");
    }
}
