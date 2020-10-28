/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diegoignacionunezhernandez
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private int noCuenta;

    public Alumno(String nombre, String apellido, int noCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.noCuenta = noCuenta;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }        
}
