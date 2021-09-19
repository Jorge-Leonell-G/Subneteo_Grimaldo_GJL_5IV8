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
            "191.168.10.11", "12.0.0.0", "202.13.45.0", "192.168.10.0", "10.0.0.0", "192.168.21.0", "153.15.0.0", "255.255.192.0", 
            "15.0.0.0", "172.250.0.0", "192.10.10.0", "165.100.0.0", "172.30.0.0/16", "192.168.16.0/24", "172.17.111.0"
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
