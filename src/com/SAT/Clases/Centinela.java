/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class Centinela {

    private final String hostName;
    private boolean _conectado;
    private final Timeline _tiempoRed;
    private final KeyFrame _key;

    public Centinela() {
        this._conectado = false;
        this.hostName = "www.google.com";
        this._tiempoRed = new Timeline();
        //Verifica cada 3 segundos si esta disponible la red
        this._key = new KeyFrame(Duration.seconds(3), (e) -> {            
            this.verificarDisponibilidadRed();
        });
        this._tiempoRed.getKeyFrames().add(_key);
        this._tiempoRed.setCycleCount(Animation.INDEFINITE);
        this._tiempoRed.play();
    }

    public boolean estaConectado() {
        return this._conectado;
    }

    private void verificarDisponibilidadRed() {
        
            try (Socket socket = new Socket()) {
                int port = 80;
                InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
                socket.connect(socketAddress, 3000);
                this._conectado = true;
            } catch (IOException e) {
                this._conectado = false;
            }
        
    }

}
