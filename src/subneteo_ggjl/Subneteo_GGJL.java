/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subneteo_ggjl;

/**
 *
 * @author leone
 */
public class Subneteo_GGJL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creacion de array String [] para el almacenamiento de los ejemplos de IP que se piden en la tarea
        String [] s = {
            "192.168.1.1/24", "124.0.0.0/16"
        };
        //instancia de la funcion principal de la calculadora
        CalculadoraIP.calc(s);
        
    }
    
}
