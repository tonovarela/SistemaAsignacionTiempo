package com.SAT.Clases;

import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Contexto {

    private static Contexto contexto = new Contexto();

    private Centinela _centinela;
    private Reloj reloj;
    private boolean _cancelandoTiempo=false;

    public static Contexto getInstance() {
        if (contexto == null) {
            contexto = new Contexto();
        }
        return contexto;
    }

    public Contexto() {
        reloj = new Reloj();
        this._centinela = new Centinela();
    }

    public Reloj getReloj() {
        return reloj;
    }

    public Centinela getCentinela() {
        return _centinela;
    }

    public boolean isCancelandoTiempo() {
        return _cancelandoTiempo;
    }

    public void setCancelandoTiempo(boolean _cancelandoTiempo) {
        this._cancelandoTiempo = _cancelandoTiempo;
    }

    public Stage getStageRenovarTiempo() {
        Stage stage = new StageModal();
        Parent parentRenovarTiempo = null;
        try {
            parentRenovarTiempo = FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLRenovarTiempo.fxml"));
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista de CancelarTiempo");
        }
        Scene SceneModalRenovacionTiempo = new Scene(parentRenovarTiempo);
        stage.setScene(SceneModalRenovacionTiempo);
        return stage;
    }

    public Stage getStageCancelarTiempo() {
        Stage stage = new StageModal();
        Parent parentCancelarTiempo = null;
        try {
            parentCancelarTiempo = FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLCancelarTiempo.fxml"));
        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista de RenovarTiempo");
        }
        Scene SceneModalCancelacionTiempo = new Scene(parentCancelarTiempo);
        stage.setScene(SceneModalCancelacionTiempo);
        return stage;
    }

    public void CerrarStage(ActionEvent e) {
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

}
