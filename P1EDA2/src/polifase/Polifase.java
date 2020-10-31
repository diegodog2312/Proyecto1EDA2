package polifase;
import dato.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Polifase {
    String folderpath;    
    
    public void sortNum(String nombreArch) throws IOException{
        FilesDirect admiFiles = new FilesDirect();
        folderpath = admiFiles.rutaFolder();
        File lista = new File(nombreArch);
        FileReader lectura = new FileReader(lista);
        BufferedReader contar = new BufferedReader(lectura);
        String cadena = contar.readLine();
        int contador = 0;
        boolean bandera = true;
        int linea=0;
        boolean archivo = true;
        Merge merge = new Merge();
        Dato getDatos = new Dato();
        admiFiles.crearDirectorio();
        admiFiles.crearArchivo("F1.txt");
        admiFiles.crearArchivo("F2.txt"); 
        do{
        
            while(cadena!=null&&!cadena.isEmpty()&&contador<10) { 
                cadena = contar.readLine(); 
                contador++;
            }
            ArrayList <Alumno> bloque = getDatos.leerDato(linea,linea+contador,nombreArch);
            InsertionSort.inSortNum(bloque);
            if(archivo){
                getDatos.escribirDatos2(bloque,folderpath+"/F1.txt");
            }else{
                getDatos.escribirDatos2(bloque,folderpath+"/F2.txt");
            }
            archivo=!archivo; //En la siguiente iteración escribira en el otro archivo 
            linea += contador;
            contador=0;
            if(cadena==null||cadena.isEmpty()){
                bandera=!bandera; //l archivo acabó y se sale del ciclo
            }

        }while(bandera);


        merge.mergeNum(folderpath+"/F1.txt",folderpath+"/F2.txt","F1I0.txt","F2I0.txt", 1);
        
        contar.close();
        lectura.close();
    }
    public void sortAppe(String nombreArch) throws IOException{
        FilesDirect admiFiles = new FilesDirect();
        folderpath = admiFiles.rutaFolder();
        File lista = new File(nombreArch);
        FileReader lectura = new FileReader(lista);
        BufferedReader contar = new BufferedReader(lectura);
        String cadena = contar.readLine();
        int contador = 0;
        boolean bandera = true;
        int linea=0;
        boolean archivo = true;
        Merge merge = new Merge();
        Dato getDatos = new Dato();
        admiFiles.crearDirectorio();
        admiFiles.crearArchivo("F1.txt");
        admiFiles.crearArchivo("F2.txt"); 
        do{
        
            while(cadena!=null&&!cadena.isEmpty()&&contador<10) { 
                cadena = contar.readLine(); 
                contador++;
            }
            ArrayList <Alumno> bloque = getDatos.leerDato(linea,linea+contador,nombreArch);
            InsertionSort.inSortApe(bloque);
            if(archivo){
                getDatos.escribirDatos2(bloque,folderpath+"/F1.txt");
            }else{
                getDatos.escribirDatos2(bloque,folderpath+"/F2.txt");
            }
            archivo=!archivo; //En la siguiente iteración escribira en el otro archivo 
            linea += contador;
            contador=0;
            if(cadena==null||cadena.isEmpty()){
                bandera=!bandera; //l archivo acabó y se sale del ciclo
            }

        }while(bandera);


        merge.mergeApe(folderpath+"/F1.txt",folderpath+"/F2.txt","F1I0.txt","F2I0.txt", 1);
        
        contar.close();
        lectura.close();
    }
        public void sortNom(String nombreArch) throws IOException{
        FilesDirect admiFiles = new FilesDirect();
        folderpath = admiFiles.rutaFolder();
        File lista = new File(nombreArch);
        FileReader lectura = new FileReader(lista);
        BufferedReader contar = new BufferedReader(lectura);
        String cadena = contar.readLine();
        int contador = 0;
        boolean bandera = true;
        int linea=0;
        boolean archivo = true;
        Merge merge = new Merge();
        Dato getDatos = new Dato();
        admiFiles.crearDirectorio();
        admiFiles.crearArchivo("F1.txt");
        admiFiles.crearArchivo("F2.txt"); 
        do{
        
            while(cadena!=null&&!cadena.isEmpty()&&contador<10) { 
                cadena = contar.readLine(); 
                contador++;
            }
            ArrayList <Alumno> bloque = getDatos.leerDato(linea,linea+contador,nombreArch);
            InsertionSort.inSortNom(bloque);
            if(archivo){
                getDatos.escribirDatos2(bloque,folderpath+"/F1.txt");
            }else{
                getDatos.escribirDatos2(bloque,folderpath+"/F2.txt");
            }
            archivo=!archivo; //En la siguiente iteración escribira en el otro archivo 
            linea += contador;
            contador=0;
            if(cadena==null||cadena.isEmpty()){
                bandera=!bandera; //l archivo acabó y se sale del ciclo
            }

        }while(bandera);


        merge.mergeNom(folderpath+"/F1.txt",folderpath+"/F2.txt","F1I0.txt","F2I0.txt", 1);
        
        contar.close();
        lectura.close();
    }


}
