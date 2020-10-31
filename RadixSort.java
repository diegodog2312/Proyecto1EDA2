/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import dato.*;

/**
 *
 * @author Sofía Elizabeth Cabello Díaz
 */
public class RadixSort {
        
        
        /*public int getMax(ArrayList <Alumno> list){
            int max = 0;
            for (Alumno al : list) {
                if(al.getNoCuenta() > max)
                    max = al.getNoCuenta();
            }
            return max;
        }*/
        
        public void RadixSort(String archivo) throws IOException{
            
            int i, max, n;

            File f0 = new File("f0.txt");
            File f1 = new File("f1.txt");
            File f2 = new File("f2.txt");
            File f3 = new File("f3.txt");
            File f4 = new File("f4.txt");
            File f5 = new File("f5.txt");
            File f6 = new File("f6.txt");
            File f7 = new File("f7.txt");
            File f8 = new File("f8.txt");
            File f9 = new File("f9.txt");
            File list = new File("list.txt");
            File dO = new File("datosordenados.txt");
            
            f0.delete();
            f1.delete();
            f2.delete();
            f3.delete();
            f4.delete();
            f5.delete();
            f6.delete();
            f7.delete();
            f8.delete();
            f9.delete();
            list.delete();
            dO.delete();
            
            f0.createNewFile();
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            f4.createNewFile();
            f5.createNewFile();
            f6.createNewFile();
            f7.createNewFile();
            f8.createNewFile();
            f9.createNewFile();
            list.createNewFile();
            //dO.createNewFile();
            
            FileReader reader_f0 = new FileReader(f0);
            BufferedReader read_f0 = new BufferedReader(reader_f0);
            
            FileReader reader_f1 = new FileReader(f1);
            BufferedReader read_f1 = new BufferedReader(reader_f1);
            
            FileReader reader_f2 = new FileReader(f2);
            BufferedReader read_f2 = new BufferedReader(reader_f2);
            
            FileReader reader_f3 = new FileReader(f3);
            BufferedReader read_f3 = new BufferedReader(reader_f3);
            
            FileReader reader_f4 = new FileReader(f4);
            BufferedReader read_f4 = new BufferedReader(reader_f4);
            
            FileReader reader_f5 = new FileReader(f5);
            BufferedReader read_f5 = new BufferedReader(reader_f5);
            
            FileReader reader_f6 = new FileReader(f6);
            BufferedReader read_f6 = new BufferedReader(reader_f6);
            
            FileReader reader_f7 = new FileReader(f7);
            BufferedReader read_f7 = new BufferedReader(reader_f7);
            
            FileReader reader_f8 = new FileReader(f8);
            BufferedReader read_f8 = new BufferedReader(reader_f8);
            
            FileReader reader_f9 = new FileReader(f9);
            BufferedReader read_f9 = new BufferedReader(reader_f9);
            
            FileReader reader_list = new FileReader(list);
            BufferedReader read_list = new BufferedReader(reader_list);
           
            Dato dato = new Dato();
            ArrayList<Alumno> lista = new ArrayList<>();
            lista = dato.leerDato(0,100,archivo);
            //max = getMax(lista);
            n = lista.size();
            //n = 100;
            Alumno alumno;
            String string;
            dato.escribirDato(lista, "list.txt");


            for (int powerOf10 = 1; powerOf10 <= 300000; powerOf10 = powerOf10 * 10) {

                for(i=0; i<10;i++){
                    String a = String.valueOf("f"+i+".txt");
                    printIte(a,powerOf10);
                }
                
                for (i = 0; i < lista.size(); i++) {
                    string = read_list.readLine();
                    if(null != string){
                        alumno = dato.obtenerDato(string);
                        int digit = (alumno.getNoCuenta()/powerOf10)%10;
                        dato.escribirDato(alumno, "f"+digit+".txt");
                    }
                }  

                    printIte("list.txt",powerOf10);
                    
                    read_f0.readLine();
                    read_f0.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f0.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f1.readLine();
                    read_f1.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f1.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f2.readLine();
                    read_f2.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f2.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f3.readLine();
                    read_f3.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f3.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f4.readLine();
                    read_f4.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f4.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f5.readLine();
                    read_f5.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f5.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f6.readLine();
                    read_f6.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f6.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f7.readLine();
                    read_f7.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f7.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f8.readLine();
                    read_f8.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f8.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                    
                    read_f9.readLine();
                    read_f9.readLine();
                    for(i = 0; i<n;i++){
                        string = read_f9.readLine();
                        if(null != string){
                        alumno = dato.obtenerDato(string);
                        dato.escribirDato(alumno, "list.txt");
                        }
                    }
                read_list.readLine();
                read_list.readLine();
            } 
            for(i = 0; i<n;i++){
                string = read_list.readLine();
                if(null != string){
                    alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, "datosordenados.txt");
                }
            }
        }
        
        public void printIte(String archivoD, int ite) throws IOException{
            File archivo = new File(archivoD);     
            try (FileWriter escribir = new FileWriter(archivo,true)) {
            escribir.write("\n   *** ITERACION DE "+ite+"'s   ***   \n");
            }
        }
    }
    
