package libs;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnect {
    public static Connection conn = null;
  
    public static Connection Conn(){
        if(conn != null) {
            return conn;
        }
        try {
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/artificial_intelegen";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("koneksi sudah terhubung");
//            Connection koneksi = DriverManager.getConnection(url);
//            Statement stm = koneksi.createStatement();
//            JOptionPane.showMessageDialog(null, "koneksi berhasil");
        } catch (SQLException e) {
            String message = "error: " + e.getMessage();
            System.err.println(message);
            JOptionPane.showMessageDialog(null, message);
        }catch (ClassNotFoundException cnfe) {
            String message = "error: " + cnfe.getMessage();
            System.err.println(message);
            return null;
        }
        
        return conn;
    }
    
}

