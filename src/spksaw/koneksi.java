    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spksaw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ultras45
 */
public class koneksi {
    static Connection Koneksi;
    static Connection getKoneksi() {
        if(Koneksi == null);
           try{
               String url="jdbc:mysql://localhost:3306/db_skp_saw";
               String user="root";
               String password="";
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               Koneksi=DriverManager.getConnection(url,user,password);
                
            }catch(SQLException t){
                JOptionPane.showMessageDialog(null, "Koneksi Bermasalah !","Connection Database", JOptionPane.ERROR_MESSAGE);
            }
        return Koneksi;
        }   
}
