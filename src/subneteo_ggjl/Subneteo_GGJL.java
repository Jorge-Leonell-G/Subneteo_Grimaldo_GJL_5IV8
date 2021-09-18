/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subneteo_ggjl;

import javax.swing.JOptionPane;

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
        String[] s = {
            "10.0.0.0/25", "10.0.0.0"
        };
        //instancia de la funcion principal de la calculadora
        IP[] ips = CalculadoraIP.calc(s);
        for (int i = 0; i < ips.length; i++){
            IP ip = ips[i];
            System.out.println(ip);
            if (ips.length != 1 && i != ips.length - 1)
                System.out.println("\n-------Next IP------");
        }
        
    }
    
}
