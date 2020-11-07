/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polifase;

import java.io.IOException;

/**
 *
 * @author ribel
 */
public class MainPrueba {
    public static void main (String [] args) throws IOException{
        Polifase prueba = new Polifase();
        prueba.sortNom("datos.txt");
    }
}
