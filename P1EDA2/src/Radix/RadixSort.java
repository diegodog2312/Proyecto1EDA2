/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package proyecto1eda2;
package Radix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import dato.*;
import java.io.RandomAccessFile;

/**
 *
 * @author Sofía Elizabeth Cabello Díaz
 */
public class RadixSort {
        String folderpath;    
        
        public int getMax(Alumno alumno, int max){
            int n = alumno.getNoCuenta();
            if(alumno.getNoCuenta() > max){
                max = alumno.getNoCuenta();
            }
            return max;
        }
        
        
        public void RadixSort(String archivo) throws IOException{
            RadixFiles rF = new RadixFiles(archivo);
            folderpath = rF.rutaFolder();
            rF.crearDirectorio();
            
            int i, max = 0, n= 0;
            
            BufferedReader br_f0 = files("f0",archivo);
            BufferedReader br_f1 = files("f1",archivo);
            BufferedReader br_f2 = files("f2",archivo);
            BufferedReader br_f3 = files("f3",archivo);
            BufferedReader br_f4 = files("f4",archivo);
            BufferedReader br_f5 = files("f5",archivo);
            BufferedReader br_f6 = files("f6",archivo);
            BufferedReader br_f7 = files("f7",archivo);
            BufferedReader br_f8 = files("f8",archivo);
            BufferedReader br_f9 = files("f9",archivo);
            BufferedReader br_list = files("list",archivo);
            
            Dato dato = new Dato();
            Alumno alumno;
            String string;
            
            File file = new File(archivo);
            FileReader reader_file = new FileReader(file);
            BufferedReader br = new BufferedReader(reader_file);
            for(i = 0; i<100;i++){
                string = br.readLine();
                if(null != string){
                  alumno = dato.obtenerDato(string);
                  max = getMax(alumno, max);
                  dato.escribirDato(alumno, folderpath+"/list.txt");  
                  n++;
                }
            }
            br.close();
      
            for (int powerOf10 = 1; powerOf10 <= max; powerOf10 = powerOf10 * 10) {
                
                printIte(folderpath+"/list.txt",powerOf10);
                for(i=0; i<10;i++){
                    String a = String.valueOf("f"+i+".txt");
                    printIte(folderpath+"/f"+i+".txt",powerOf10);
                }
                
                for (i = 0; i < n; i++) {
                    string = br_list.readLine();
                    if(null != string){
                        alumno = dato.obtenerDato(string);
                        int digit = (alumno.getNoCuenta()/powerOf10)%10;
                        dato.escribirDato(alumno,folderpath+"/f"+digit+".txt");
                    }
                }  
                
                readWrite(n,br_f0);
                readWrite(n,br_f1);
                readWrite(n,br_f2);
                readWrite(n,br_f3);
                readWrite(n,br_f4);
                readWrite(n,br_f5);
                readWrite(n,br_f6);
                readWrite(n,br_f7);
                readWrite(n,br_f8);
                readWrite(n,br_f9);
                
                br_list.readLine();
                br_list.readLine();
            } 
            
            RandomAccessFile rFile = new  RandomAccessFile(archivo,"rw");
            rFile.setLength(0);
            for(i = 0; i<n;i++){
                string = br_list.readLine();
                if(null != string){
                    alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, archivo);
                }
            }
            
            System.out.println("Información de iteraciones: "+folderpath);
            System.out.println("\n***   Archivo ordenado   ***");
            
            br_list.close();
            br_f1.close();
            br_f2.close();
            br_f3.close();
            br_f4.close();
            br_f5.close();
            br_f6.close();
            br_f7.close();
            br_f8.close();
            br_f9.close();
            br_f0.close();
        }
        

        public void printIte(String archivoD, int ite) throws IOException{
            File archivo = new File(archivoD);     
            try (FileWriter escribir = new FileWriter(archivo,true)) {
            escribir.write("\n   *** ITERACION DE "+ite+"'s   ***   \n");
            }
        }
        
        public BufferedReader files(String filename,String archivo) throws IOException{
            RadixFiles rF = new RadixFiles(archivo);
            folderpath = rF.rutaFolder();
            rF.crearDirectorio();
            File file = rF.crearArchivo(filename);
            FileReader reader_file = new FileReader(file);
            BufferedReader read_file = new BufferedReader(reader_file);
            return read_file;
        }
        
        public void readWrite(int n, BufferedReader read_file) throws IOException{
            Dato dato = new Dato();
            read_file.readLine();
            read_file.readLine();
            
            int k = 0;
            for(int i = 0; i<n;i++){
                String string = read_file.readLine();
                if(null != string && !string.isBlank()){
                    Alumno alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, folderpath+"/list.txt");
                    k++;
                }
                else{
                    return;
                }
            }
        }  
    }
    

