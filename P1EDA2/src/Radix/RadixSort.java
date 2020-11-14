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
        
        public int getMaxLength(Alumno alumno, int max){
            String s = alumno.getApellido();
            if(s.length() > max){
                max = s.length();
            }
            return max;
        }
        
        public int getMaxLength2(Alumno alumno, int max){
            String s = alumno.getNombre();
            if(s.length() > max){
                max = s.length();
            }
            return max;
        }
        
        
        public void RadixSortC(String archivo) throws IOException{
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
            
            
            File file2 = rF.crearArchivo(archivo);
            br_list.readLine();
            string = br_list.readLine();
            while(null != string && !string.isBlank()){
                string = br_list.readLine();
                if(null != string && !string.isBlank()){
                    alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, folderpath+"/"+archivo+".txt");
                }
            }
            
            System.out.println("Información de iteraciones y archivo ordenado: "+folderpath);
            
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
        
        
        
        
        
        public void RadixSortA(String archivo) throws IOException {
            RadixFiles rF = new RadixFiles(archivo);
            folderpath = rF.rutaFolder();
            rF.crearDirectorio();
            
            int i, maxLength = 0, n= 0;
            
            BufferedReader br_fA = files("fA",archivo);
            BufferedReader br_fB = files("fB",archivo);
            BufferedReader br_fC = files("fC",archivo);
            BufferedReader br_fD = files("fD",archivo);
            BufferedReader br_fE = files("fE",archivo);
            BufferedReader br_fF = files("fF",archivo);
            BufferedReader br_fG = files("fG",archivo);
            BufferedReader br_fH = files("fH",archivo);
            BufferedReader br_fI = files("fI",archivo);
            BufferedReader br_fJ = files("fJ",archivo);
            BufferedReader br_fK = files("fK",archivo);
            BufferedReader br_fL = files("fL",archivo);
            BufferedReader br_fM = files("fM",archivo);
            BufferedReader br_fN = files("fN",archivo);
            BufferedReader br_fO = files("fO",archivo);
            BufferedReader br_fP = files("fP",archivo);
            BufferedReader br_fQ = files("fQ",archivo);
            BufferedReader br_fR = files("fR",archivo);
            BufferedReader br_fS = files("fS",archivo);
            BufferedReader br_fT = files("fT",archivo);
            BufferedReader br_fU = files("fU",archivo);
            BufferedReader br_fV = files("fV",archivo);
            BufferedReader br_fW = files("fW",archivo);
            BufferedReader br_fX = files("fX",archivo);
            BufferedReader br_fY = files("fY",archivo);
            BufferedReader br_fZ = files("fZ",archivo);
            
            BufferedReader br_list = files("list",archivo);
            
            Dato dato = new Dato();
            Alumno alumno;
            String string;
            
            
            File file = new File(archivo);
            FileReader reader_file = new FileReader(file);
            BufferedReader br = new BufferedReader(reader_file);
            
            string = br.readLine();
            int aux = string.length();
            while(null != string && !string.isBlank() ){
                  alumno = dato.obtenerDato(string);
                  maxLength = getMaxLength(alumno, maxLength);
                  dato.escribirDato(alumno, folderpath+"/list.txt");  
                  string = br.readLine();
                  n++;
            }
            br.close();

            for(int pos = maxLength ; pos >= 0; pos--){
                
                for(char b = 'A'; b< 'Z';b++){
                    String a = String.valueOf("f"+b+".txt");
                    printIte(folderpath+"/f"+b+".txt",pos);
                }
                printIte(folderpath+"/list.txt",pos);
                    br_list.readLine();
                    string = br_list.readLine();
                    while(null != string && !string.isBlank()){
                        alumno = dato.obtenerDato(string);
                        if(alumno.getApellido().length() > pos){
                            char charValue = (alumno.getApellido().toUpperCase().charAt(pos));
                            
                            if(!Character.isLetter(charValue)){
                                charValue = (alumno.getApellido().toUpperCase().charAt(pos-1));
                            }
                            
                            dato.escribirDato(alumno,folderpath+"/f"+ charValue +".txt");
                        }
                        
                        else{
                            dato.escribirDato(alumno,folderpath+"/list.txt");
                        }
                        string = br_list.readLine();
                    }
                
                readWrite(n,br_fA);
                readWrite(n,br_fB);
                readWrite(n,br_fC);
                readWrite(n,br_fD);
                readWrite(n,br_fE);
                readWrite(n,br_fF);
                readWrite(n,br_fG);
                readWrite(n,br_fH);
                readWrite(n,br_fI);
                readWrite(n,br_fJ);
                readWrite(n,br_fK);
                readWrite(n,br_fL);
                readWrite(n,br_fM);
                readWrite(n,br_fN);
                readWrite(n,br_fO);
                readWrite(n,br_fP);
                readWrite(n,br_fQ);
                readWrite(n,br_fR);
                readWrite(n,br_fS);
                readWrite(n,br_fT);
                readWrite(n,br_fU);
                readWrite(n,br_fV);
                readWrite(n,br_fW);
                readWrite(n,br_fX);
                readWrite(n,br_fY);
                readWrite(n,br_fZ);
                
            }

            

            File file2 = rF.crearArchivo(archivo);
            br_list.readLine();
            string = br_list.readLine();
            while(null != string && !string.isBlank()){
                string = br_list.readLine();
                if(null != string && !string.isBlank()){
                    alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, folderpath+"/"+archivo+".txt");
                }
            }
            
            System.out.println("Información de iteraciones y archivo ordenado: "+folderpath);
            
            br_list.close();
            br_fA.close();
            br_fB.close();
            br_fC.close();
            br_fD.close();
            br_fE.close();
            br_fF.close();
            br_fG.close();
            br_fH.close();
            br_fI.close();
            br_fJ.close();
            br_fK.close();
            br_fL.close();
            br_fM.close();
            br_fN.close();
            br_fO.close();
            br_fP.close();
            br_fQ.close();
            br_fR.close();
            br_fS.close();
            br_fT.close();
            br_fU.close();
            br_fV.close();            
            br_fW.close();
            br_fX.close();
            br_fY.close();
            br_fZ.close();
 
        }
        
        public void RadixSortN(String archivo) throws IOException {
            RadixFiles rF = new RadixFiles(archivo);
            folderpath = rF.rutaFolder();
            rF.crearDirectorio();
            
            int i, maxLength = 0, n= 0;
            
            BufferedReader br_fA = files("fA",archivo);
            BufferedReader br_fB = files("fB",archivo);
            BufferedReader br_fC = files("fC",archivo);
            BufferedReader br_fD = files("fD",archivo);
            BufferedReader br_fE = files("fE",archivo);
            BufferedReader br_fF = files("fF",archivo);
            BufferedReader br_fG = files("fG",archivo);
            BufferedReader br_fH = files("fH",archivo);
            BufferedReader br_fI = files("fI",archivo);
            BufferedReader br_fJ = files("fJ",archivo);
            BufferedReader br_fK = files("fK",archivo);
            BufferedReader br_fL = files("fL",archivo);
            BufferedReader br_fM = files("fM",archivo);
            BufferedReader br_fN = files("fN",archivo);
            BufferedReader br_fO = files("fO",archivo);
            BufferedReader br_fP = files("fP",archivo);
            BufferedReader br_fQ = files("fQ",archivo);
            BufferedReader br_fR = files("fR",archivo);
            BufferedReader br_fS = files("fS",archivo);
            BufferedReader br_fT = files("fT",archivo);
            BufferedReader br_fU = files("fU",archivo);
            BufferedReader br_fV = files("fV",archivo);
            BufferedReader br_fW = files("fW",archivo);
            BufferedReader br_fX = files("fX",archivo);
            BufferedReader br_fY = files("fY",archivo);
            BufferedReader br_fZ = files("fZ",archivo);
            
            BufferedReader br_list = files("list",archivo);
            
            Dato dato = new Dato();
            Alumno alumno;
            String string;
            
            
            File file = new File(archivo);
            FileReader reader_file = new FileReader(file);
            BufferedReader br = new BufferedReader(reader_file);
            
            string = br.readLine();
            int aux = string.length();
            while(null != string && !string.isBlank() ){
                  alumno = dato.obtenerDato(string);
                  maxLength = getMaxLength2(alumno, maxLength);
                  dato.escribirDato(alumno, folderpath+"/list.txt");  
                  string = br.readLine();
                  n++;
            }
            br.close();

            for(int pos = maxLength ; pos >= 0; pos--){
                
                for(char b = 'A'; b< 'Z';b++){
                    String a = String.valueOf("f"+b+".txt");
                    printIte(folderpath+"/f"+b+".txt",pos);
                }
                printIte(folderpath+"/list.txt",pos);
                    br_list.readLine();
                    string = br_list.readLine();
                    while(null != string && !string.isBlank()){
                        alumno = dato.obtenerDato(string);
                        if(alumno.getNombre().length() > pos){
                            char charValue = (alumno.getNombre().toUpperCase().charAt(pos));
                            
                            if(!Character.isLetter(charValue)){
                                charValue = (alumno.getNombre().toUpperCase().charAt(pos-1));
                            }
                            
                            dato.escribirDato(alumno,folderpath+"/f"+ charValue +".txt");
                        }
                        
                        else{
                            dato.escribirDato(alumno,folderpath+"/list.txt");
                        }
                        string = br_list.readLine();
                    }
                
                readWrite(n,br_fA);
                readWrite(n,br_fB);
                readWrite(n,br_fC);
                readWrite(n,br_fD);
                readWrite(n,br_fE);
                readWrite(n,br_fF);
                readWrite(n,br_fG);
                readWrite(n,br_fH);
                readWrite(n,br_fI);
                readWrite(n,br_fJ);
                readWrite(n,br_fK);
                readWrite(n,br_fL);
                readWrite(n,br_fM);
                readWrite(n,br_fN);
                readWrite(n,br_fO);
                readWrite(n,br_fP);
                readWrite(n,br_fQ);
                readWrite(n,br_fR);
                readWrite(n,br_fS);
                readWrite(n,br_fT);
                readWrite(n,br_fU);
                readWrite(n,br_fV);
                readWrite(n,br_fW);
                readWrite(n,br_fX);
                readWrite(n,br_fY);
                readWrite(n,br_fZ);
                
            }
            

            File file2 = rF.crearArchivo(archivo);
            br_list.readLine();
            string = br_list.readLine();
            while(null != string && !string.isBlank()){
                string = br_list.readLine();
                if(null != string && !string.isBlank()){
                    alumno = dato.obtenerDato(string);
                    dato.escribirDato(alumno, folderpath+"/"+archivo+".txt");
                }
            }
            
            System.out.println("Información de iteraciones y archivo ordenado: "+folderpath);
            
            br_list.close();
            br_fA.close();
            br_fB.close();
            br_fC.close();
            br_fD.close();
            br_fE.close();
            br_fF.close();
            br_fG.close();
            br_fH.close();
            br_fI.close();
            br_fJ.close();
            br_fK.close();
            br_fL.close();
            br_fM.close();
            br_fN.close();
            br_fO.close();
            br_fP.close();
            br_fQ.close();
            br_fR.close();
            br_fS.close();
            br_fT.close();
            br_fU.close();
            br_fV.close();            
            br_fW.close();
            br_fX.close();
            br_fY.close();
            br_fZ.close();
 
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
    
