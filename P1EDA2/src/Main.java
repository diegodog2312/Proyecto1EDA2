
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import mezclaEquilibrada.*;
import polifase.*;
import Radix.*;
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
        
        System.out.println("PROYECTO 1 EDA II");
        System.out.println("Cabello Díaz Sofía Elizabeth"); 
        System.out.println("López Becerra Ricardo");
        System.out.println("Núñez Hernández Diego Ignacio");
         while(true){
            System.out.println("\n\nMENU DE ORDENAMIENTO");
            System.out.println("\nIngrese nombre de archivo a ordenar:   ");  
            Scanner sc = new Scanner(System.in);
            String nombre = sc.nextLine();            
         
            RadixSort radix = new RadixSort();

            System.out.println("\nElegir metodo de ordenamiento:   ");
            System.out.println("\tA. Mezcla equilibrada");
            System.out.println("\tB. Polifase");
            System.out.println("\tC. Radix");
            System.out.println("\tD) Salir");
            String opcion = sc.nextLine();
        
            if(opcion.equals("C")){
                radix.RadixSort(nombre);  
            }
            
            if(opcion.equals("A")){
                System.out.println("\nSeleccione qué quiere ordenar:   ");
                System.out.println("\t1. Nombre");
                System.out.println("\t2. Apellido");
                System.out.println("\t3. NoCuenta");
                int num = Integer.valueOf(sc.nextLine());
                switch(num){
                    case 1:
                        MezclaEquilibrada mn = new MezclaNombre();
                        mn.mezcla(nombre);
                    break;
                    
                    case 2:
                        MezclaEquilibrada ma = new MezclaApellido();
                        ma.mezcla(nombre);
                    break;
                    
                    case 3:
                        MezclaEquilibrada mc = new MezclaCuenta();
                        mc.mezcla(nombre);
                    break;
                }
            }
            
            if(opcion.equals("B")){
                Polifase prueba = new Polifase();
                System.out.println("\nSeleccione qué quiere ordenar:   ");
                System.out.println("\t1. Nombre");
                System.out.println("\t2. Apellido");
                System.out.println("\t3. NoCuenta");
                int num = Integer.valueOf(sc.nextLine());
                switch(num){
                    case 1:

                    break;
                    
                    case 2:
                        prueba.sortStr(nombre);
                    break;
                    
                    case 3:                        
                        prueba.sortNum(nombre);
                    break;
                } 
            }
         
            if(opcion.equals("D")){
                break;
            }
            System.out.println("***   Archivo ordenado   ***");
        }
    }
}
