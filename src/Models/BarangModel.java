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
}
