/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author Novil F
 */
public class Koneksi {
    public Connection getKoneksi() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventaris_barang", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }
}
