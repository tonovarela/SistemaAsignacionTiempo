/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Model;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author tonovarela
 */
public class Equipo {

    private String _hostname;
    private String _username;

    public Equipo() {
        this._username = System.getProperty("user.name");
        try {
            this._hostname = InetAddress.getLocalHost().getHostName();
        } catch (IOException ex) {
            System.out.println("No se pudo determinar el nombre del equipo por la siguiente razon :"+ex.getMessage());
        }
    }

    public String getHostname() {
        return _hostname;
    }

    public String getUsername() {
        return _username;
    }

}
