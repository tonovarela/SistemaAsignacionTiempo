package root;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.SAT.utils.MoveMouseListener;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.swing.JFrame;

/**
 *
 * @author tonovarela
 */
public class Main extends Application {

    @Override
    public void start(Stage stage)  {
      
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/SAT/Views/FXMLPrincipal.fxml"));
        } catch (IOException ex) {
            System.out.println("Exception "+ex);
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int width = dim.width;
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
//        stage.setScene(scene);
//        stage.show();

        JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(0);
      
        frame.setUndecorated(true);
      
       frame.setType(Window.Type.UTILITY);
        JFXPanel main = new JFXPanel();
        frame.getContentPane().add(main);
        MoveMouseListener mml = new MoveMouseListener(main);
        main.addMouseListener(mml);
        main.addMouseMotionListener(mml);
        main.setScene(scene);
        frame.pack();
        frame.setBackground(new java.awt.Color(0, 0,0, 90));
        frame.setLocation(width - 330, 50);
        
      
        frame.setVisible(true);
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
