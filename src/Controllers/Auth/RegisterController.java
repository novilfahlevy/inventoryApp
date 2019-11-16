/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Auth;

import Models.Auth.RegisterModel;

import Views.Auth.*;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 *
 * @author Novil F
 */
public class RegisterController {
    
    RegisterModel modelRegister = new RegisterModel();
    
    public void index(Register form) {
        String namaLengkap = form.textNamaLengkap.getText();
        String email = form.textEmail.getText();
        String password = form.textPassword.getText();
        String konfirmasiPassword = form.textKonfirmasiPassword.getText();
        
        if( validasi(namaLengkap, email, password, konfirmasiPassword) && modelRegister.register(namaLengkap, email, password) ) {
            JOptionPane.showMessageDialog(null, "Registrasi berhasil.");
            form.dispose();
            new Login().setVisible(true);
        }
    }
    
    public boolean validasi(String namaLengkap, String email, String password, String konfirmasiPassword) {
        if( namaLengkap.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi nama lengkap anda.");
            return false;
        }
        
        if( email.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi email anda.");
            return false;
        }
        
        if( isEmailNotValid(email) ) {
            JOptionPane.showMessageDialog(null, "Email tidak valid, mohon masukan email yang tepat.");
            return false;
        }
        
        if( modelRegister.checkEmail(email) ) {
            JOptionPane.showMessageDialog(null, "Email sudah terdaftar");
            return false;
        }
        
        if( password.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi password anda.");
            return false;
        }
        
        if( password.length() < 8 ) {
            JOptionPane.showMessageDialog(null, "Password minimal harus berisi 8 karakter!");
            return false;
        }
        
        if( konfirmasiPassword.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon konfirmasi password anda.");
            return false;
        }
        
        if( !konfirmasiPassword.equals(password) ) {
            JOptionPane.showMessageDialog(null, "Password tidak cocok! Mohon periksa lagi password anda.");
            return false;
        }
        
        return true;
    }
    
    public boolean isEmailNotValid(String email) {
        return !Pattern.compile("^(.+)@(.+)$").matcher(email).matches();
    }
}
