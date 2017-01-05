package com.SAT.Clases;

import com.SAT.Model.InfoAsignacion;
import com.SAT.utils.StageModal;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Contexto {

    private static Contexto contexto;
    private final Centinela _centinela;
    private final Reloj _reloj;
    private final Equipo _equipo;
    private final InfoAsignacion _infoAsignacion;

    private boolean _cancelandoTiempo = false;
    private boolean _renovandoTiempo = false;

    public static Contexto getInstance() {
        if (contexto == null) {
            contexto = new Contexto();
        }
        return contexto;
    }

    public Contexto() {

        _equipo = new Equipo();

        _reloj = new Reloj();
        this._centinela = new Centinela();
        this._infoAsignacion = new InfoAsignacion();        
        this._infoAsignacion.Nombre().setValue("Marco Antonio Varela");
        this._infoAsignacion.LugarEquipoAsignado().setValue("10");
        this._infoAsignacion.TiempoAsignado().setValue(150);
        this._infoAsignacion.TiempoMaximoServicio().setValue(50);
        this._infoAsignacion.TiempoServicio().setValue(8655);
        this._infoAsignacion.Usuario().setValue(_equipo.getUsername());

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

    public InfoAsignacion getInfoAsignacion() {
        return _infoAsignacion;
    }

    public Stage getStage(String vista) {

        Stage stage = new StageModal();
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXML" + vista + ".fxml"));

        } catch (IOException ex) {
            System.out.println("No se puede cargar la vista" + ex);
        }
        Scene SceneModal = new Scene(parent);
        stage.setScene(SceneModal);
        return stage;

    }

    public String GetOSIconName() {
        return this._equipo.getIconOS();
    }

    public void CerrarStage(ActionEvent e) {
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }

    public void CerrarSesion() {
        this._equipo.CerrarSesion();
    }

    public boolean isCancelandoTiempo() {
        return _cancelandoTiempo;
    }

    public void setCancelandoTiempo(boolean CancelandoTiempo) {
        this._cancelandoTiempo = CancelandoTiempo;
    }

    public boolean isRenovandoTiempo() {
        return _renovandoTiempo;
    }

    public void setRenovandoTiempo(boolean RenovandoTiempo) {
        this._renovandoTiempo = RenovandoTiempo;
    }

}
