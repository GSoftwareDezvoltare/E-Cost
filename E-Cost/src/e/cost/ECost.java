/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.cost;

import MainForm.MainForm;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JFrame;

/**
 *
 * @author TechSolutions
 */
public class ECost extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        MainForm mf = new MainForm();
        mf.setExtendedState(mf.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mf.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
