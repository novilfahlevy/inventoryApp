/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Auth;

import Database.Koneksi;
import java.sql.ResultSet;

import Models.Auth.RegisterModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class LoginModel {

    public ResultSet cekAkun(String email) {
        ResultSet result = null;

        String query = "SELECT password FROM `users` WHERE email = '" + email + "'";

        try {
            result = (ResultSet) Koneksi.getKoneksi().createStatement().executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return result;
    }
}
