/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import Views.Home;
import Models.BarangModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Novil F
 */
public class BarangController {
    
    BarangModel model = new BarangModel();
    
    public void setKolomTabelBarang(Home form) {
        form.tabelModel = new DefaultTableModel();
        
        form.tabelModel.addColumn("Kode Barang");
        form.tabelModel.addColumn("Nama Barang");
        form.tabelModel.addColumn("Jenis");
        form.tabelModel.addColumn("Quantity");
        form.tabelModel.addColumn("Harga");
        form.tabelModel.addColumn("Supplier");
        form.tabelModel.addColumn("Staff");
        form.tabelModel.addColumn("Ditambahkan Saat");
        
        form.tableDataBarang.setModel(form.tabelModel);
    }
    
    public void tampilDataBarang(Home form) {
        form.tabelModel.getDataVector().removeAllElements();
        form.tabelModel.fireTableDataChanged();
        
        try {
            ResultSet data = model.getDataBarang();
        
            while( data.next() ) {
                Object[] obj = new Object[8];
                obj[0] = data.getString("kode_barang");
                obj[1] = data.getString("merk");
                obj[2] = data.getString("jenis");
                obj[3] = data.getString("jumlah");
                obj[4] = data.getString("harga");
                obj[5] = data.getString("pemasok");
                obj[6] = data.getString("staff");
                obj[7] = data.getString("created_at");

                form.tabelModel.addRow(obj);
            }
        } catch( Exception ex ) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}