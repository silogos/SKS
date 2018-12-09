package Moduls.Transaksi.Pengembalian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import libs.DBConnect;
import Moduls.Transaksi.Pengembalian.*;

/**
 *
 * @author ThinkPad
 */
public class ControllerPengembalian {
    
    public ModelPengembalian viewByID(int ID, String kembali) {
        ModelPengembalian data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT *, (TO_DAYS('"+kembali+"') - TO_DAYS(tanggal_kembali)) as diff FROM `peminjaman` "
                    + "WHERE id = " + ID;
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelPengembalian(
                    rs.getInt("id"),
                    rs.getString("nis"),
                    rs.getString("code_book"),
                    rs.getString("tanggal_pinjam"),
                    rs.getString("tanggal_kembali"),
                    rs.getInt("quantity"),
                    rs.getInt("diff")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public boolean update(int id) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `peminjaman` SET `status`=0  WHERE id=" + id;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean updateBook(String code_book, int jumlah) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `book` SET `quantity`=`quantity` + "+ jumlah +"  WHERE code_book='" + code_book + "'";
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
