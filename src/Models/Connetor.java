/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RANDA
 */
public class Connetor {
        private static Connection MYSQLConfig;
    public static Connection configDB() throws SQLException{
        try {
            String url ="jdbc:mysql://localhost:3306/toothsome";
            String user="root";
            String pass="";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MYSQLConfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
             JOptionPane.showMessageDialog(null,"Koneksi gagal bang/kak: "+e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
        return MYSQLConfig;
    }
}

