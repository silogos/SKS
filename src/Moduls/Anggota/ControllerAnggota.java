package Moduls.Anggota;

import Moduls.Anggota.ModelAnggota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import libs.DBConnect;

/**
 *
 * @author ThinkPad
 */
public class ControllerAnggota {
    
    public ArrayList<ModelAnggota> view() {
        ArrayList<ModelAnggota> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `anggota`";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelAnggota data;
            while (rs.next()) {
                data = new ModelAnggota(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<ModelAnggota> viewWithSearch(String search) {
        ArrayList<ModelAnggota> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `anggota`"
                    + "WHERE "
                    + "nis LIKE '%"+ search +"%' "
                    + "OR "
                    + "nama LIKE '%"+ search +"%'";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelAnggota data;
            while (rs.next()) {
                data = new ModelAnggota(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelAnggota viewByID(int ID) {
        ModelAnggota data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `anggota` where id = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelAnggota(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public ModelAnggota viewByNIS(String nis) {
        ModelAnggota data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `anggota` where nis = '" + nis + "'";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelAnggota(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas")
                );
            } else {
                data = new ModelAnggota(0, "", "", "");
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public boolean create(String nis, String nama, String kelas) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `anggota` "
                    + "VALUES "
                    + "(NULL, '"+ nis +"', '"+ nama +"', '"+ kelas +"')";
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(int ID, String nis, String nama, String kelas) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `anggota` SET "
                    + "`nis` = '"+ nis +"', "
                    + "`nama` = '"+ nama +"', "
                    + "`kelas` = '"+ kelas +"' "
                    + "WHERE `id` = " + ID;
            System.out.println(sql);
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
        
    public boolean delete(int ID) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "DELETE FROM `anggota` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
