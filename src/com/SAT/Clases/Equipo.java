/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

import com.SAT.Clases.ISistemaOperativo;
import com.SAT.Clases.Linux;
import com.SAT.Clases.MAC;
import com.SAT.Clases.Windows;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author tonovarela
 */
public class Equipo {

    private String _hostname;
    private String _username;
    private ISistemaOperativo _sistemaOperativo;

    public Equipo() {
        this._username = System.getProperty("user.name");
        try {
            this._hostname = InetAddress.getLocalHost().getHostName();
        } catch (IOException ex) {
            System.out.println("No se pudo determinar el nombre del equipo por la siguiente razon :"+ex.getMessage());
        }
        
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            this._sistemaOperativo = new Windows();
        }
        if (OS.contains("nux")) {
            this._sistemaOperativo = new Linux();
        }
        if (OS.contains("mac") || OS.contains("darwin")) {
            this._sistemaOperativo = new MAC();
        }
        
    }
    
    
    public void CerrarSesion(){
        this._sistemaOperativo.CerrarSesion();
    }
    public String getIconOS(){
        return this._sistemaOperativo.getIconOS();
    }

    public String getHostname() {
        return _hostname;
    }

    public String getUsername() {
        return _username;
    }

}
