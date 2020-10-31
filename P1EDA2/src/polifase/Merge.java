package polifase;
import dato.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Merge {
    String folderPath;

    public Merge (){
        FilesDirect ruta = new FilesDirect();
        folderPath = ruta.rutaFolder();
    }

    public void mergeNum(String leerR, String leerL, String escR, String escL, int iteration) throws IOException{        
        FilesDirect admiFilesDirect = new FilesDirect();
        File r = new File(leerR);
        File l = new File(leerL);  
        FileReader rR = new FileReader(r);
        FileReader rL = new FileReader(l);
        BufferedReader checkR = new BufferedReader(rR);
        BufferedReader checkL = new BufferedReader(rL);
        String strR = checkR.readLine();
        String strL = checkL.readLine();
        if(strR!=null&&strL!=null){
            admiFilesDirect.crearArchivo(escR);
            admiFilesDirect.crearArchivo(escL);

            Dato transDato = new Dato();
            boolean archivo = true;
            while(strR!=null&&strL!=null){

                while((strR!=null&&!strR.isEmpty())&&(strL!=null&&!strL.isEmpty())){ //Mientras no se llege al final del bloque o del archivo
                    Alumno alumR;
                    Alumno alumL;
                    alumR = transDato.obtenerDato(strR);
                    alumL = transDato.obtenerDato(strL);

                    if(alumL.getNoCuenta()<=alumR.getNoCuenta()){
                        if(archivo){
    
                            transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                        }
                        strL=checkL.readLine();
                    }else{
                        if(archivo){
                            transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                        }
                        strR=checkR.readLine();
                    }
            
                }
                while(strR!=null&&!strR.isEmpty()){
                    Alumno alumR;
                    alumR = transDato.obtenerDato(strR); 
                    if(archivo){
                        transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                    }
                        strR=checkR.readLine();
                }
                while(strL!=null&&!strL.isEmpty()){
                    Alumno alumL;
                    alumL = transDato.obtenerDato(strL); 
                    if(archivo){
                        transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                    }
                    strL=checkL.readLine();
                }
                if(archivo){
                    transDato.addSalto(this.folderPath+"/"+escL);
                }else{
                    transDato.addSalto(this.folderPath+"/"+escR);
                }
                archivo=!archivo;
                strR = checkR.readLine();
                strL = checkL.readLine();
            }
            while(strR!=null&&!strR.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strR);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                strR=checkR.readLine();
            }
            while(strL!=null&&!strL.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strL);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                    strL=checkL.readLine();
            }
            rL.close();
            rR.close();
            checkL.close();
            checkR.close();
            String nextWriteR ="F1"+"I"+iteration+".txt"; 
            String nextWriteL ="F2"+"I"+iteration+".txt";
            iteration++;

            mergeNum(this.folderPath+"/"+escR,this.folderPath+"/"+escL, nextWriteR, nextWriteL, iteration);        
        }
        rL.close();
        rR.close();
        checkL.close();
        checkR.close();
    }
    public void mergeApe(String leerR, String leerL, String escR, String escL, int iteration) throws IOException{        
        FilesDirect admiFilesDirect = new FilesDirect();
        File r = new File(leerR);
        File l = new File(leerL);  
        FileReader rR = new FileReader(r);
        FileReader rL = new FileReader(l);
        BufferedReader checkR = new BufferedReader(rR);
        BufferedReader checkL = new BufferedReader(rL);
        String strR = checkR.readLine();
        String strL = checkL.readLine();
        if(strR!=null&&strL!=null){
            admiFilesDirect.crearArchivo(escR);
            admiFilesDirect.crearArchivo(escL);

            Dato transDato = new Dato();
            boolean archivo = true;
            while(strR!=null&&strL!=null){

                while((strR!=null&&!strR.isEmpty())&&(strL!=null&&!strL.isEmpty())){ //Mientras no se llege al final del bloque o del archivo
                    Alumno alumR;
                    Alumno alumL;
                    alumR = transDato.obtenerDato(strR);
                    alumL = transDato.obtenerDato(strL);

                    if(alumL.getApellido().toUpperCase().compareTo(alumR.getApellido().toUpperCase())<=0){
                        if(archivo){
                            transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                        }
                        strL=checkL.readLine();
                    }else{
                        if(archivo){
                            transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                        }
                        strR=checkR.readLine();
                    }
            
                }
                while(strR!=null&&!strR.isEmpty()){
                    Alumno alumR;
                    alumR = transDato.obtenerDato(strR); 
                    if(archivo){
                        transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                    }
                        strR=checkR.readLine();
                }
                while(strL!=null&&!strL.isEmpty()){
                    Alumno alumL;
                    alumL = transDato.obtenerDato(strL); 
                    if(archivo){
                        transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                    }
                    strL=checkL.readLine();
                }
                if(archivo){
                    transDato.addSalto(this.folderPath+"/"+escL);
                }else{
                    transDato.addSalto(this.folderPath+"/"+escR);
                }
                archivo=!archivo;
                strR = checkR.readLine();
                strL = checkL.readLine();
            }
            while(strR!=null&&!strR.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strR);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                strR=checkR.readLine();
            }
            while(strL!=null&&!strL.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strL);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                    strL=checkL.readLine();
            }
            rL.close();
            rR.close();
            checkL.close();
            checkR.close();
            String nextWriteR ="F1"+"I"+iteration+".txt"; 
            String nextWriteL ="F2"+"I"+iteration+".txt";
            iteration++;

            mergeApe(this.folderPath+"/"+escR,this.folderPath+"/"+escL, nextWriteR, nextWriteL, iteration);        
        }
        rL.close();
        rR.close();
        checkL.close();
        checkR.close();
    }
        public void mergeNom(String leerR, String leerL, String escR, String escL, int iteration) throws IOException{        
        FilesDirect admiFilesDirect = new FilesDirect();
        File r = new File(leerR);
        File l = new File(leerL);  
        FileReader rR = new FileReader(r);
        FileReader rL = new FileReader(l);
        BufferedReader checkR = new BufferedReader(rR);
        BufferedReader checkL = new BufferedReader(rL);
        String strR = checkR.readLine();
        String strL = checkL.readLine();
        if(strR!=null&&strL!=null){
            admiFilesDirect.crearArchivo(escR);
            admiFilesDirect.crearArchivo(escL);

            Dato transDato = new Dato();
            boolean archivo = true;
            while(strR!=null&&strL!=null){
                while((strR!=null&&!strR.isEmpty())&&(strL!=null&&!strL.isEmpty())){ //Mientras no se llege al final del bloque o del archivo
                    Alumno alumR;
                    Alumno alumL;
             
                    alumR = transDato.obtenerDato(strR);
                    alumL = transDato.obtenerDato(strL);

                    if(alumL.getNombre().toUpperCase().compareTo(alumR.getNombre().toUpperCase())<=0){
                        if(archivo){
                            transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                        }
                        strL=checkL.readLine();
                    }else{
                        if(archivo){
                            transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                        }else{
                            transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                        }
                        strR=checkR.readLine();
                    }
            
                }
                while(strR!=null&&!strR.isEmpty()){
                    Alumno alumR;
                    alumR = transDato.obtenerDato(strR); 
                    if(archivo){
                        transDato.escribirDato(alumR,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumR,this.folderPath+"/"+escR);
                    }
                        strR=checkR.readLine();
                }
                while(strL!=null&&!strL.isEmpty()){
                    Alumno alumL;
                    alumL = transDato.obtenerDato(strL); 
                    if(archivo){
                        transDato.escribirDato(alumL,this.folderPath+"/"+escL);
                    }else{
                        transDato.escribirDato(alumL,this.folderPath+"/"+escR);
                    }
                    strL=checkL.readLine();
                }
                if(archivo){
                    transDato.addSalto(this.folderPath+"/"+escL);
                }else{
                    transDato.addSalto(this.folderPath+"/"+escR);
                }
                archivo=!archivo;
                strR = checkR.readLine();
                strL = checkL.readLine();
            }
            while(strR!=null&&!strR.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strR);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                strR=checkR.readLine();
            }
            while(strL!=null&&!strL.isEmpty()){
                Alumno ultimoBloque = transDato.obtenerDato(strL);
                if(archivo){
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escL);
                }else{
                    transDato.escribirDato(ultimoBloque,this.folderPath+"/"+escR);
                }
                    strL=checkL.readLine();
            }
            rL.close();
            rR.close();
            checkL.close();
            checkR.close();
            String nextWriteR ="F1"+"I"+iteration+".txt"; 
            String nextWriteL ="F2"+"I"+iteration+".txt";
            iteration++;
            
            mergeNom(this.folderPath+"/"+escR,this.folderPath+"/"+escL, nextWriteR, nextWriteL, iteration);        
        }
        rL.close();
        rR.close();
        checkL.close();
        checkR.close();
    }
}
