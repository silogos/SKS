package Moduls.Kunjungan;

import Moduls.Pertanyaan.ModelPertanyaan;
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
public class ControllerKunjungan {
    
    public ArrayList<ModelPertanyaan> view() {
        ArrayList<ModelPertanyaan> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT "
                    + "kunjungan.id, "
                    + "kunjungan.nis, "
                    + "anggota.nama, "
                    + "anggota.kelas, "
                    + "kunjungan.tanggal "
                    + "FROM `kunjungan` "
                    + "LEFT JOIN anggota ON kunjungan.nis = anggota.nis";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelPertanyaan data;
            while (rs.next()) {
                data = new ModelPertanyaan(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas"),
                    rs.getString("tanggal")     
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelPertanyaan viewByID(int ID) {
        ModelPertanyaan data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT "
                    + "kunjungan.id, "
                    + "kunjungan.nis, "
                    + "anggota.nama, "
                    + "anggota.kelas, "
                    + "kunjungan.tanggal "
                    + "FROM `kunjungan` "
                    + "LEFT JOIN anggota ON kunjungan.nis = anggota.nis "
                    + "WHERE id = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelPertanyaan(
                    rs.getInt("id"), 
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas"),
                    rs.getString("tanggal")     
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public boolean create(String nis, String tanggal) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `kunjungan` "
                    + "VALUES "
                    + "(NULL, '"+ nis +"', '"+ tanggal +"')";
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
            String sql = "DELETE FROM `kunjungan` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
