/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Characteristic;
import Moduls.Characteristic.CharacteristicModul;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import libs.DBConnect;
/**
 *
 * @author ThinkPad
 */
public class CharacteristicController {
    
    public ArrayList<CharacteristicModul> getList() {
        ArrayList<CharacteristicModul> data = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM characteristic";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                CharacteristicModul cm = null;
                cm.setId(rs.getInt("id"));
                cm.setType(rs.getInt("type"));
                cm.setText(rs.getString("text"));
                data.add(cm);
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public CharacteristicModul getByID(Integer id) {
        CharacteristicModul data = null;
        try {
            Connection connection = DBConnect.Conn();
            String query = "SELECT * FROM characteristic where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                data = new CharacteristicModul(
                        rs.getInt("id"), 
                        rs.getInt("type"), 
                        rs.getString("text")
                );
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean create(CharacteristicModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO characteristic (type, text) VALUES (?,?)";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer type = data.getType();
            String text = data.getText();
            stat.setInt(1, type);
            stat.setString(2, text);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(CharacteristicModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "UPDATE characteristic SET type=?, text=? where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            Integer type = data.getType();
            String text = data.getText();
            stat.setInt(1, type);
            stat.setString(2, text);
            stat.setInt(3, id);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(CharacteristicModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "DELETE FROM characteristic where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            stat.setInt(1, id);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
