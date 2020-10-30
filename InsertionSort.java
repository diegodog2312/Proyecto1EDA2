import java.util.ArrayList;

public class InsertionSort {

    public static void inSortNum(ArrayList<Alumno> alumnos) {  
            
        int n = alumnos.size();  
        for (int j = 1; j < n; j++) {  
            Alumno key = alumnos.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( alumnos.get(i).getNoCuenta() > key.getNoCuenta() ) ){  
                alumnos.set(i+1,alumnos.get(i));  
                i--;  
            }  
            alumnos.set(i+1 , key); //array[i+1] = key;  
        }  
    }

    public static void inSortStr(ArrayList<Alumno> alumnos) {  
        int n = alumnos.size();  
        for (int j = 1; j < n; j++) {  
            Alumno key = alumnos.get(j);  
            int i = j-1;  
            while ( (i > -1) && ( alumnos.get(i).getApellido().toUpperCase().compareTo(key.getApellido().toUpperCase())>0 ) ){  
                alumnos.set(i+1,alumnos.get(i));  
                i--;  
            }  
            alumnos.set(i+1 , key); //array[i+1] = key;  
        }  
    }


}
