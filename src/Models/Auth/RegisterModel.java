/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Auth;

import Database.Koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class RegisterModel {
    public boolean checkEmail(String email) {
        boolean emailSudahTerdaftar = false;
        
        try {
            ResultSet result = Koneksi.getKoneksi().createStatement().executeQuery("SELECT id FROM `users` WHERE email = '" + email + "'");
            emailSudahTerdaftar = result.next();
        } catch( Exception ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return emailSudahTerdaftar;
    }
    
    public boolean register(String namaLengkap, String email, String password) {
        boolean registerBerhasil = false;
        
        try {
            PreparedStatement ps = Koneksi.getKoneksi().prepareStatement("INSERT INTO `users` VALUES (?, ?, ?, ?)");
            
            ps.setString(1, null);
            ps.setString(2, namaLengkap);
            ps.setString(3, email);
            ps.setString(4, password);
            
            registerBerhasil = ps.executeUpdate() > 0;
        } catch( Exception ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return registerBerhasil;
    }
}
