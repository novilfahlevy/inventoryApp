/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Auth;

import Models.Auth.LoginModel;
import Views.Auth.Login;
import Views.Home;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class LoginController {

    static LoginModel modelLogin = new LoginModel();

    public void login(Login form) {
        String email = form.textEmail.getText();
        String password = form.textPassword.getText();

        ResultSet result = modelLogin.cekAkun(email);

        try {
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    new Home().setVisible(true);
                    form.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password anda salah!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Akun tidak ditemukan.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
