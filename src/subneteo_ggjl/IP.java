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
public class IP {
    //A continuación declaramos todos los atributos que conforman a una red
    private String address;
    private int mask;
    private String submask;
    private String wildcard;
    private String network;
    private String minhost;
    private String maxhost;
    private String broadcast;
    private String numhost;
    private binaryIP binaryIP;
    
    //metodo constructor con address y mask como parametros
    public IP(String address, int mask){
        this.address = address;
        this.mask = mask;
        //Instancia de la clase binaryIP
        binaryIP = new binaryIP(this);
        
        submask = b2d(binaryIP.getSubmask());
        wildcard = b2d(binaryIP.getNetwork());
        network = b2d(binaryIP.getNetwork());
        minhost = b2d(binaryIP.getMinhost());
        maxhost = b2d(binaryIP.getMaxhost());
        broadcast = b2d(binaryIP.getBroadcast());
    }
    
    private int calcNumHost(){
        int restBytes = 32 - mask % 8;
        
        return 0;
    }
    
    private String b2d(String binaryIP){
        return CalculadoraIP.binaryIPToDecimal(binaryIP);
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

    public binaryIP getBinaryIP() {
        return binaryIP;
    }

    public void setBinaryIP(binaryIP binaryIP) {
        this.binaryIP = binaryIP;
    }
    
            
    @Override
    public String toString(){
        return "Address:    " + address + "      " + binaryIP.getAddress();
    }
    
}
