/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Result;
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
public class ResultController {
    
    public ArrayList<ResultModul> getList() {
        ArrayList<ResultModul> data = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM result";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                ResultModul cm = null;
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
    
//    public ResultModul getByID(Integer id) {
////        ResultModul data = null;
////        try {
////            Connection connection = DBConnect.Conn();
////            String query = "SELECT * FROM characteristic where id=?";
////            PreparedStatement stat = connection.prepareStatement(query);
////            stat.setInt(1, id);
////            ResultSet rs = stat.executeQuery();
//////            while (rs.next()) {
//////                data = new ResultModul(
//////                        rs.getInt("id"), 
////////                        rs.getInt("type"), 
//////                        rs.getString("text")
//////                );
////            }
////            return data;
////        } catch (SQLException e) {
////            System.err.println(e.getMessage());
////            return null;
////        }
//    }
    
    public boolean create(ResultModul data) {
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
    
    public boolean update(ResultModul data) {
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
    
    public boolean delete(ResultModul data) {
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
