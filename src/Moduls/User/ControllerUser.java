package Moduls.User;

import Moduls.User.ModelUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import libs.DBConnect;
import libs.Session;

/**
 *
 * @author ThinkPad
 */
public class ControllerUser {
    
    public ModelUser view(Integer id) {
        ModelUser user = null;
        
        try {
            Connection connection = DBConnect.Conn();
            String query = "SELECT * FROM `user` WHERE user_id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                user = new ModelUser(rs.getInt("user_id"), rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }
    
    public boolean create(String nama) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO `user` VALUES (NULL, ?)";
            PreparedStatement stat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, nama);
            int exe = stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();
            if (rs.next()){
                int inserted_id=rs.getInt(1);
                Session.setID(inserted_id);
                Session.setNama(nama);
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
