/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class JenisModel {
    public ResultSet getDataJenis() {
        ResultSet result = null;
        
        String query = "SELECT nama FROM `jenis_barang`";
        
        try {
            result = (ResultSet) Koneksi.getKoneksi().createStatement().executeQuery(query);
        } catch( SQLException ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return result;
    }
}
