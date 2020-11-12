
import java.io.IOException;
import java.util.Scanner;
import mezclaEquilibrada.*;
import polifase.*;
import Radix.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sofia
 */
public class Main {
    public static void main(String[] args) throws IOException{                
       MezclaEquilibrada mc = new MezclaCuenta();
       mc.mezcla("datos.txt");                           
        
//        File f = new File("datos.txt");
//        FileReader lector = new FileReader(f);
//        BufferedReader reader = new BufferedReader(lector); 
//        
//        File f0 = new File("f0.txt");                  
//        f0.delete();
//        f0.createNewFile();
//        FileReader fr_f0 = new FileReader(f0);
//        BufferedReader lectura_f0 = new BufferedReader(fr_f0);  
//        
//        File f1 = new File("f1.txt");    
//        f1.delete();
//        f1.createNewFile();
//        FileReader fr_f1 = new FileReader(f1);
//        BufferedReader lectura_f1 = new BufferedReader(fr_f1);          
//
//        File f2 = new File("f2.txt");   
//        f2.delete();
//        f2.createNewFile();
//        FileReader fr_f2 = new FileReader(f2);        
//        BufferedReader lectura_f2 = new BufferedReader(fr_f2);
//        
//        MezclaCuenta cuenta = new MezclaCuenta();
//        boolean b = cuenta.mezclaE(reader);
//        System.out.println("b = "+ b);
//        cuenta.mezclaD(b, lectura_f1, lectura_f2);
//        
//        b = cuenta.mezclaE(lectura_f0);
//        System.out.println("b = "+ b);        
//        cuenta.mezclaD(b, lectura_f1, lectura_f2);
//        
//        b = cuenta.mezclaE(lectura_f0);        
//        System.out.println("b = "+ b);
    }  
}