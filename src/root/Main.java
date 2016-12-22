package root;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.SAT.Clases.MoveMouseListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author tonovarela
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLPrincipal.fxml"));
//        Parent renovarTiempo=FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLPrincipal.fxml"));
//        Parent MensajeChat=FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLPrincipal.fxml"));
        Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
        int width= dim.width;        
        Scene scene = new Scene(root);         
        scene.setFill(Color.TRANSPARENT);
//        stage.setScene(scene);
//        stage.show();

       
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setType(Window.Type.UTILITY);
        JFXPanel main= new JFXPanel();
        frame.getContentPane().add(main);       
//        MoveMouseListener mml = new MoveMouseListener(main);
//        main.addMouseListener(mml);
//        main.addMouseMotionListener(mml);
        main.setScene(scene);
        frame.pack();  
       frame.setBackground(new  java.awt.Color(0, 0, 0, 50));
        frame.setLocation(width-330, 0);
        frame.setVisible(true);
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
