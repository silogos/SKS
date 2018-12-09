package Moduls.Transaksi.Peminjaman;

import Moduls.Kunjungan.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import libs.DBConnect;
import libs.FormatDate;

/**
 *
 * @author ThinkPad
 */
public class ControllerPeminjaman {
    
    public ArrayList<ModelViewPeminjaman> viewTemplate(String search, String dari, String sampai) {
        ArrayList<ModelViewPeminjaman> list = new ArrayList<>();
        try {
            Date date = new Date();
            String dateNow = new FormatDate().format(date, "YYYY-MM-dd");
            Connection connection = DBConnect.Conn();
            String sql = "SELECT "
                    + "peminjaman.nis, peminjaman.tanggal_pinjam, "
                    + "anggota.nama, anggota.kelas, "
                    + "sum(peminjaman.quantity) AS total, "
                    + "sum(IF(peminjaman.tanggal_kembali > '"+dateNow+"', peminjaman.quantity, 0)) AS late, "
                    + "GROUP_CONCAT(book.code_book SEPARATOR ', ') AS code_books "
            + "FROM `peminjaman` "
            + "LEFT JOIN "
            + "`anggota` ON peminjaman.nis = anggota.nis "
            + "LEFT JOIN "
            + "`book` ON peminjaman.code_book = book.code_book "
            + "WHERE peminjaman.nis != '' AND peminjaman.status = 1 ";
            if (!(search == "")) {
                sql += "AND (peminjaman.nis LIKE '%"+search+"%' OR anggota.nama LIKE '%"+search+"%') ";
            }
            if (!(dari == "")&& !(sampai == "")) {
                sql += "AND peminjaman.tanggal_pinjam BETWEEN '"+dari+"' AND '"+sampai+"' ";
            }
            sql += "GROUP BY peminjaman.nis";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelViewPeminjaman data;
            while (rs.next()) {
                data = new ModelViewPeminjaman(                        
                    rs.getString("tanggal_pinjam"),
                    rs.getString("nis"),
                    rs.getString("nama"),
                    rs.getString("kelas"),
                    rs.getString("code_books"),
                    rs.getInt("total"),
                    rs.getInt("late")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ArrayList<ModelPeminjaman> viewPeminjaman(String nis) {
        ArrayList<ModelPeminjaman> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT "
                    + "peminjaman.*, "
                    + "book.title, "
                    + "book.author, "
                    + "book.publisher, "
                    + "category.title as category "
                    + "FROM `peminjaman` "
                    + "LEFT JOIN `book` "
                    + "ON peminjaman.code_book = book.code_book "
                    + "LEFT JOIN `category` "
                    + "ON book.code_category = category.code_category "
                    + "WHERE peminjaman.nis = '"+nis+"'  AND peminjaman.status = 1";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelPeminjaman data;
            while (rs.next()) {
                data = new ModelPeminjaman(
                    rs.getInt("id"), 
                    rs.getString("code_book"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("category"),
                    rs.getString("tanggal_pinjam"),   
                    rs.getString("tanggal_kembali"),
                    rs.getInt("quantity")
                );
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelPeminjaman viewByID(int ID) {
        ModelPeminjaman data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT "
                    + "peminjaman.*, "
                    + "book.title, "
                    + "book.author, "
                    + "book.publisher, "
                    + "category.title as category "
                    + "FROM `peminjaman` "
                    + "LEFT JOIN `book` "
                    + "ON peminjaman.code_book = book.code_book "
                    + "LEFT JOIN `category` "
                    + "ON book.code_category = category.code_category "
                    + "WHERE peminjaman.id = " + ID;
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelPeminjaman(
                    rs.getInt("id"), 
                    rs.getString("code_book"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("category"),
                    rs.getString("tanggal_pinjam"),   
                    rs.getString("tanggal_kembali"),
                    rs.getInt("quantity")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public boolean create(String nis, String code_book, int quantity, String tanggal_pinjam, String tanggal_kembali) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `peminjaman` "
                    + "VALUES "
                    + "(NULL, '"+ nis +"', '"+ code_book +"', '"+ quantity +"', '"+ tanggal_pinjam +"', '"+ tanggal_kembali +"', 1)";
            System.err.println(sql);
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(String code_book, int jumlah) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `book` SET `quantity`=`quantity` - "+ jumlah +"  WHERE code_book='" + code_book + "'";
            System.err.println(sql);
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
            String sql = "DELETE FROM `peminjaman` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
