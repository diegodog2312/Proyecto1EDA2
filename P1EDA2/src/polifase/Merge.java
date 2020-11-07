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
        File wr = new File(escR);
        File wl = new File(escL);
        FileReader rR = new FileReader(r);
        FileReader rL = new FileReader(l);
        FileReader rWR = new FileReader(wr);
        FileReader rWL = new FileReader (wl);
        BufferedReader checkR = new BufferedReader(rR);
        BufferedReader checkL = new BufferedReader(rL);
        BufferedReader checkWR = new BufferedReader(rWR);
        BufferedReader checkWL = new BufferedReader(rWL);
        String strR = checkR.readLine();
        String strL = checkL.readLine();
        String strWR = checkWR.readLine();
        String strWL = checkWL.readLine();
        
             //No se crearán archivos ahora
            
        /*
        Si strL, strR ,strWL o strWR son nulos, significa que se llegó al final
        de su respectivo archivo.
        
        Si strL , strR, strWL o strWR son "@" Se llego al inicio de una
             iteración

        si strL, strR, strWL o strWR están vacías, se llegó al final de 
        un bloque.
        */     
        int numeroArrobas;
        if(iteration%2==0){
            numeroArrobas = iteration;
        }
             
        Dato transDato = new Dato();
        boolean archivo = true;
        while(strR!=null&&strL!=null){
            /*
            Mientras no se llege al final de del bloque o de la iteración
            */
            while((strR!=null&&!strR.isEmpty())&&(strL!=null&&!strL.isEmpty())){
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
                transDato.addString(this.folderPath+"/"+escL,"\n");
            }else{
                transDato.addString(this.folderPath+"/"+escR,"\n");
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

        //mergeNum(this.folderPath+"/"+escR,this.folderPath+"/"+escL, nextWriteR, nextWriteL, iteration);        
        
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
                    transDato.addString(this.folderPath+"/"+escL,"\n");
                }else{
                    transDato.addString(this.folderPath+"/"+escR,"\n");
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
                    transDato.addString(this.folderPath+"/"+escL,"\n");
                }else{
                    transDato.addString(this.folderPath+"/"+escR,"\n");
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
