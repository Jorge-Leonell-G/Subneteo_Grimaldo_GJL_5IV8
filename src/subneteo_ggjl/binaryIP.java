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
public class binaryIP {
    
    private String address;
    private int mask;
    private String submask;
    private String wildcard;
    private String network;
    private String minhost;
    private String maxhost;
    private String broadcast;
    private String numhost;
    
    public binaryIP(IP ip){
        int mask = ip.getMask();
        address = CalculadoraIP.decimalIPtoBinary(ip.getAddress());
        submask = CalculadoraIP.binMask(mask);
        wildcard = CalculadoraIP.wildcard(submask);
        network = CalculadoraIP.binaryNetwork(address, ip.getMask());
        minhost = CalculadoraIP.binaryHostMin(network);
        maxhost = CalculadoraIP.binaryHostMax(network, ip.getMask());
        broadcast = CalculadoraIP.binaryHostMin(maxhost);
    }
    
    //getters & setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public String getSubmask() {
        return submask;
    }

    public void setSubmask(String submask) {
        this.submask = submask;
    }

    public String getWildcard() {
        return wildcard;
    }

    public void setWildcard(String wildcard) {
        this.wildcard = wildcard;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getMinhost() {
        return minhost;
    }

    public void setMinhost(String minhost) {
        this.minhost = minhost;
    }

    public String getMaxhost() {
        return maxhost;
    }

    public void setMaxhost(String maxhost) {
        this.maxhost = maxhost;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getNumhost() {
        return numhost;
    }

    public void setNumhost(String numhost) {
        this.numhost = numhost;
    }
    
}
