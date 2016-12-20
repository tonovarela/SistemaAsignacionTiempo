/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

/**
 *
 * @author tonovarela
 */
public class Centinela {
    private final String hostName;

    public Centinela() {
        
        this.hostName="www.google.com";
    }
    

    public  boolean estaDisponibleRed() throws IOException {
        try (Socket socket = new Socket()) {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);
            return true;
        } catch (UnknownHostException unknownHost) {
            return false;
        }
    }



}
