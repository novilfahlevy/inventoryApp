/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import Database.Koneksi;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class BarangModel {
    public ResultSet getDataBarang() {
        ResultSet result = null;
        
        String query = "SELECT `barang`.kode_barang, `barang`.merk, `jenis_barang`.nama AS jenis, `barang`.jumlah, `barang`.harga, `pemasok`.nama AS pemasok, `staff`.nama AS staff, DATE_FORMAT(`barang`.created_at, '%d/%m/%Y') AS created_at FROM `barang`, `jenis_barang`, `pemasok`, `staff`";
        
        query += " WHERE `jenis_barang`.id = `barang`.id_jenis AND";
        query += " `pemasok`.id = `barang`.id_pemasok AND";
        query += " `staff`.id = `barang`.id_staff";
        
        try {
            result = (ResultSet) Koneksi.getKoneksi().createStatement().executeQuery(query);
        } catch( SQLException ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return result;
    }
    
    public ResultSet getDataBarangByKodeBarang(String kodeBarang) {
        ResultSet result = null;
        
        String query = "SELECT `barang`.merk, `jenis_barang`.nama AS jenis, `barang`.jumlah, `barang`.harga, `pemasok`.nama AS pemasok, `staff`.nama AS staff, DATE_FORMAT(`barang`.created_at, '%d/%m/%Y') AS created_at FROM `barang`, `jenis_barang`, `pemasok`, `staff`";
        
        query += " WHERE `jenis_barang`.id = `barang`.id_jenis AND";
        query += " `pemasok`.id = `barang`.id_pemasok AND";
        query += " `staff`.id = `barang`.id_staff AND";
        query += " `barang`.kode_barang = '" + kodeBarang + "'";
        
        try {
            result = (ResultSet) Koneksi.getKoneksi().createStatement().executeQuery(query);
        } catch( SQLException ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return result;
    }
    
    /**
     *
     */
    
    public ResultSet getDataBarangByFilter(String filter, String keyword) {
        ResultSet result = null;
        
        String query = "SELECT `barang`.kode_barang, `barang`.merk, `jenis_barang`.nama AS jenis, `barang`.jumlah, `barang`.harga, `pemasok`.nama AS pemasok, `staff`.nama AS staff, DATE_FORMAT(`barang`.created_at, '%d/%m/%Y') AS created_at FROM `barang`, `jenis_barang`, `pemasok`, `staff`";
        
        query += " WHERE `jenis_barang`.id = `barang`.id_jenis AND";
        query += " `pemasok`.id = `barang`.id_pemasok AND";
        query += " `staff`.id = `barang`.id_staff ";
        
        switch( filter ) {
            case "Kode Barang" :
                query += "AND `barang`.kode_barang = '" + keyword + "'";
            break;
                
            case "Nama / Merk" :
                query += "AND `barang`.merk LIKE '%" + keyword + "%'";
            break;
                
            case "Pemasok" :
                query += "AND `barang`.id_pemasok = (SELECT id FROM `pemasok` WHERE `pemasok`.nama LIKE '%" + keyword + "%')";
            break;
                
            case "Harga" :
                if( !keyword.equals("") ) query += "AND `barang`.harga = " + keyword;
            break;
                
            case "Jumlah" :
                if( !keyword.equals("") ) query += "AND `barang`.jumlah = " + keyword;
            break;
                
            case "Staff" :
                query += "AND `barang`.id_staff = (SELECT id FROM `staff` WHERE `staff`.nama LIKE '%" + keyword + "%')";
            break;
        }
        
        try {
            result = (ResultSet) Koneksi.getKoneksi().createStatement().executeQuery(query);
        } catch( SQLException ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return result;
    }
    
    public boolean edit(String[] dataBarang) {
        boolean editSuccess = false;
        
        String query = "UPDATE `barang` SET ";
        
        query += "merk = ?, ";
        query += "id_pemasok = (SELECT id FROM `pemasok` WHERE nama = ?), ";
        query += "jumlah = ?, ";
        query += "harga = ?, ";
        query += "id_jenis = (SELECT id FROM `jenis_barang` WHERE nama = ?), ";
        query += "id_staff = (SELECT id FROM `staff` WHERE nama = ?) WHERE kode_barang = ?";
        
        try {
            PreparedStatement ps = Koneksi.getKoneksi().prepareStatement(query);
            
            ps.setString(1, dataBarang[0]);
            ps.setString(2, dataBarang[1]);
            ps.setString(3, dataBarang[2]);
            ps.setString(4, dataBarang[3]);
            ps.setString(5, dataBarang[4]);
            ps.setString(6, dataBarang[5]);
            ps.setString(7, dataBarang[6]);
            
            editSuccess = ps.executeUpdate() > 0;
        } catch( SQLException ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return editSuccess;
    }
}
