/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subneteo_ggjl;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author leone
 */
public class CalculadoraIP {
    //metodo para realizar la iteracion for:each de las IP
    public static void calc(String[] ips){ //ips: {124.0.0.45/24}
        String [] binaryIps;
        for(int i = 0; i < ips.length; i++){
            String ip = ips[i];
            binaryIps = segmentIP(getIP(ip));
            System.out.println(Arrays.toString(binaryIps));
            
            //segundo ciclo for
            for (int j = 0; j < binaryIps.length; j++){
                binaryIps[j] = decimalBin(Integer.parseInt(binaryIps[j]));
            }
            int mask = getMask(ip);
            String maskIP = binMask(mask);
            String wildcardMask = wildcard(maskIP);
            String decimalMask = binaryIPToDecimal(wildcardMask);
        }
        
    }
    
    /*------------- Máscaras de red -----------------*/
    
    //metodo exclusivo pare el retornado de la mascara de red, de igual forma, con un String ip como argumento
    public static int getMask(String ip){
        int index = ip.indexOf('/') + 1;
        if (index == 0) return 24;
        return Integer.parseInt(ip.substring(index));
    }
    
    public static String binMask(int mask){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mask; i++){
            s.append(1);
            if (i % 8 == 7){
                s.append('.');
            }
            
        }
        
        for (int i = 0; i < 32 - mask; i++){
            s.append(1);
            if (i % 8 == 7 && i != 32 - mask - 1){
                s.append('.');
            }
            
        }
        
        return s.toString();
    }
    
    
     public static String wildcard(String binaryIP){
        
        binaryIP = binaryIP.replace('1', '2');
        binaryIP = binaryIP.replace('0', '1');
        binaryIP = binaryIP.replace('2', '0');
        
        return binaryIP;
    }
    
    public static String wildcard(int mask){
        
        String binaryIP = binMask(mask);
        
        binaryIP = binaryIP.replace('1', '2');
        binaryIP = binaryIP.replace('0', '1');
        binaryIP = binaryIP.replace('2', '0');
        
        return binaryIP;
    }
    
    /*------------- Direccion IP -----------------*/
    
    public static String[] segmentIP(String ip){
        //
        List<String> segments = new ArrayList<>();
        //
        while(true){
            int index = ip.indexOf('.');
            
            if(index == -1) index = ip.length();
            segments.add(ip.substring(0, index));
            if(index == ip.length()) break;
            ip = ip.substring(index + 1);  
        }
        return segments.toArray(new String[0]);
    }
    
    //metodo para el retornado de la IP, con un String ip como argumento
    public static String getIP(String ip){
        int index = ip.indexOf('/');
        if (index == -1) return ip;
        return ip.substring(0,index);
    }
    
    
    public static String decimalBin(int n){
        if(n == 0) return "00000000";
        StringBuilder bin = new StringBuilder();
        //
        while(n != 0){
            int res = n % 2;
            n = n / 2;
            
            bin.append(res);
        }
        bin = bin.reverse();
        System.out.println(bin.length());
        if(bin.length() < 8){
            for (int i = bin.length(); i < 8; i++){
                bin.append(0);
            }
        }
        return bin.reverse().toString();
    }
    
    public static String binaryIPToDecimal(String binaryIP){
        StringBuilder s = new StringBuilder();
        String[] segments = segmentIP(binaryIP);
        
        for(int i = 0; i<segments.length; i++){
            s.append(byteToDecimal(segments[i]));
            if( i < segments.length - 1){
                s.append('.');
            }
        }
        
        return s.toString();
    }
    
    public static int byteToDecimal(String byt){
        int res = 0;
        for(int i = 8-1, j = 0; i >= 0; i--, j++){
            int mult = intPow(2, i);
            res += Character.getNumericValue(byt.charAt(j)) * mult;
        }
        return res;
    }
    
    public static String decimalIPtoBinary(String ip){
        String res = "";
        String [] binaryIps = segmentIP(getIP(ip));
        for (int j = 0; j < binaryIps.length; j++){
            res += decimalBin(Integer.parseInt(binaryIps[j]));
        }
        return res;
    }
    
    /* --------- Network (red) ----------------- */
    
    public static String binaryNetwork(String binaryIP, int mask){
        for (int i = mask; i < binaryIP.length(); i++){
            
        }
        return null;
    }
    
    public static int intPow(int b, int c){
        return (int) Math.pow(b, c);
    }
}
    
    
    
    
