package com.SAT.Clases;

import com.SAT.Model.Equipo;
import com.SAT.utils.StageModal;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Contexto {

    private static Contexto contexto = new Contexto();
    private final Centinela _centinela;
    private final Reloj _reloj;
    private final Equipo _equipo;

    private ISistemaOperativo _sistemaOperativo;

    private boolean _cancelandoTiempo = false;

    public static Contexto getInstance() {
        if (contexto == null) {
            contexto = new Contexto();
        }
        return contexto;
    }

    public Contexto() {
        _reloj = new Reloj();
        this._centinela = new Centinela();

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

        _equipo = new Equipo();

    }

    public Reloj getReloj() {
        return _reloj;
    }

    public Centinela getCentinela() {
        return _centinela;
    }

    public Equipo getEquipo() {
        return _equipo;
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

    public String GetOSIconName() {
        return this._sistemaOperativo.getNameIcon();
    }

    public void CerrarStage(ActionEvent e) {
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

    public void CerrarSesion() {
        this._sistemaOperativo.CerrarSesion();
    }

}
