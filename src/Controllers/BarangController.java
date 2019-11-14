/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.swing.table.DefaultTableModel;
import Views.Home;

/**
 *
 * @author Novil F
 */
public class BarangController {
    public void setKolomTabelBarang(Home form) {
        form.tabelModel = new DefaultTableModel();
        
        form.tabelModel.addColumn("Kode Barang");
        form.tabelModel.addColumn("Nama Barang");
        form.tabelModel.addColumn("Jenis");
        form.tabelModel.addColumn("Quantity");
        form.tabelModel.addColumn("Harga");
        form.tabelModel.addColumn("Supplier");
        form.tabelModel.addColumn("Ditambahkan Saat");
        
        form.tableDataBarang.setModel(form.tabelModel);
    }
}