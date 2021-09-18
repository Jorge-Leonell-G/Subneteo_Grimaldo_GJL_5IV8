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
    private int numhost;
    private binaryIP binaryIP;
    
    @Override
    public String toString(){
        return format("Address: ", address, binaryIP.getAddress()) + 
               "Submask: \u001B{34m" + submask + " = " + mask + "\t\u001B[33m" + binaryIP.getMask() + 
               format("Wildcard: ", wildcard, binaryIP.getWildcard()) + 
               "---------\n" + 
               format("Network", network, binaryIP.getNetwork()) + 
               format("MinHost", minhost, binaryIP.getMinhost()) + 
               format("MaxHost", maxhost, binaryIP.getMaxhost()) + 
               format("Broadcast", broadcast, binaryIP.getBroadcast()) +
               "Hosts/Net: \t\u001B[34m" + numhost + "\t\u001B[0m";
    }
    
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
        numhost = calcNumHost();
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

    public int getNumhost() {
        return numhost;
    }

    public void setNumhost(int numhost) {
        this.numhost = numhost;
    }

    public binaryIP getBinaryIP() {
        return binaryIP;
    }

    public void setBinaryIP(binaryIP binaryIP) {
        this.binaryIP = binaryIP;
    }
    
    private String format(String title, String address, String binary){
        return title+": \t\u001B[34m" + address + " \t\t\u001B[33m" + binary + "\n\u001B[0m";
    }
    
    
}
