import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Polifase {
    
    public void poliSort(String nombreArch) throws IOException{

        File lista = new File("datos.txt");
        Scanner contar = new Scanner(lista);
        int contador = 0;
        while(contar.hasNextLine()) 
        { 
            contar.nextLine(); 
            contador++; 
        }
        System.out.println(contador);
    }
}
