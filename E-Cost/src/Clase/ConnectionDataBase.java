/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechSolutions
 */
public class ConnectionDataBase {
    public Connection connect;
    public static ConnectionDataBase db;
    
    
    private ConnectionDataBase(){
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "e-cost";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "medsoft";
        String password = "frac2009M#";
        try{
            try {
                Class.forName(driver).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ConnectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConnectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.connect = (Connection)DriverManager.getConnection(url+dbName,userName,password);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
       
    }
     public static synchronized ConnectionDataBase getDbCon(){
        if ( db == null ) {
            db = new ConnectionDataBase();
        }
        return db;
        
        
 
    }

}
