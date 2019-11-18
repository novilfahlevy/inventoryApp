/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import Views.Home;
import Views.EditBarang;
import Views.TambahBarang;

import Models.BarangModel;
import Models.PemasokModel;
import Models.StaffModel;
import Models.JenisModel;
import java.util.Collection;

/**
 *
 * @author Novil F
 */
public class BarangController {
    
    BarangModel modelBarang = new BarangModel();
    PemasokModel modelPemasok = new PemasokModel();
    StaffModel modelStaff = new StaffModel();
    JenisModel modelJenis = new JenisModel();
    
    public void setKolomTabelBarang(Home form) {
        form.tabelModel = new DefaultTableModel();
        
        form.tabelModel.addColumn("Kode Barang");
        form.tabelModel.addColumn("Nama Barang");
        form.tabelModel.addColumn("Jenis");
        form.tabelModel.addColumn("Jumlah");
        form.tabelModel.addColumn("Harga");
        form.tabelModel.addColumn("Pemasok");
        form.tabelModel.addColumn("Staff");
        form.tabelModel.addColumn("Ditambahkan Saat");
        
        form.tableDataBarang.setModel(form.tabelModel);
    }
    
    public void tampilDataBarang(Home form) {
        form.tabelModel.getDataVector().removeAllElements();
        form.tabelModel.fireTableDataChanged();
        
        try {
            ResultSet data = modelBarang.getDataBarang();
        
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
    
    public void cariBarang(Home form) {
        form.tabelModel.getDataVector().removeAllElements();
        form.tabelModel.fireTableDataChanged();
        
        try {
            ResultSet data = modelBarang.getDataBarangByFilter(form.comboBoxFilterCariBarang.getSelectedItem().toString(), form.textCariBarang.getText());
        
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
    
    public void tampilKodeBarang(EditBarang form) {
        ResultSet data = modelBarang.getDataBarang();
        try {
            while( data.next() ) {
                form.comboBoxKodeBarang.addItem(data.getString("kode_barang"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilPemasok(EditBarang form) {
        ResultSet data = modelPemasok.getDataPemasok();
        try {
            while( data.next() ) {
                form.comboBoxPemasok.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilPemasok(TambahBarang form) {
        ResultSet data = modelPemasok.getDataPemasok();
        try {
            while( data.next() ) {
                form.comboBoxPemasok.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilJenis(EditBarang form) {
        ResultSet data = modelJenis.getDataJenis();
        try {
            while( data.next() ) {
                form.comboBoxJenis.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilJenis(TambahBarang form) {
        ResultSet data = modelJenis.getDataJenis();
        try {
            while( data.next() ) {
                form.comboBoxJenis.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilStaff(EditBarang form) {
        ResultSet data = modelStaff.getDataStaff();
        try {
            while( data.next() ) {
                form.comboBoxStaff.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilStaff(TambahBarang form) {
        ResultSet data = modelStaff.getDataStaff();
        try {
            while( data.next() ) {
                form.comboBoxStaff.addItem(data.getString("nama"));
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void tampilInfoBarang(EditBarang form) {
        ResultSet data = modelBarang.getDataBarangByKodeBarang(form.comboBoxKodeBarang.getSelectedItem().toString());
        try {
            if( data.next() ) {
                form.textMerkBarang.setText(data.getString("merk"));
                form.comboBoxPemasok.setSelectedItem(data.getString("pemasok"));
                form.spinnerJumlah.setValue(data.getInt("jumlah"));
                form.spinnerHarga.setValue(data.getInt("harga"));
                form.comboBoxJenis.setSelectedItem(data.getString("jenis"));
                form.comboBoxJenis.setSelectedItem(data.getString("staff"));
            } else {
                form.textMerkBarang.setText("");
                form.comboBoxPemasok.setSelectedIndex(0);
                form.spinnerJumlah.setValue(0);
                form.spinnerHarga.setValue(0);
                form.comboBoxJenis.setSelectedIndex(0);
                form.comboBoxJenis.setSelectedIndex(0);
            }
        } catch( Exception ex ) {
            
        }
    }
    
    public void editBarang(EditBarang form, Home home) {
        String[] dataBarang = {
            form.textMerkBarang.getText(),
            form.comboBoxPemasok.getSelectedItem().toString(),
            form.spinnerJumlah.getValue().toString(),
            form.spinnerHarga.getValue().toString(),
            form.comboBoxJenis.getSelectedItem().toString(),
            form.comboBoxStaff.getSelectedItem().toString(),
            form.comboBoxKodeBarang.getSelectedItem().toString()
        };
        
        if( modelBarang.edit(dataBarang) ) {
            JOptionPane.showMessageDialog(form, "Data berhasil diubah.");
            tampilDataBarang(home);
            return;
        }
        
        JOptionPane.showMessageDialog(form, "Gagal mengubah data.");
    }
    
    public void tambahBarang(TambahBarang form, Home home) {
        String[] data = {
            form.textMerkBarang.getText(),
            form.comboBoxJenis.getSelectedItem().toString(),
            form.spinnerJumlah.getValue().toString(),
            form.spinnerHarga.getValue().toString(),
            form.comboBoxPemasok.getSelectedItem().toString(),
            form.comboBoxStaff.getSelectedItem().toString()
        };
        
        if( validasiTambahBarang(data[0], data[2], data[3]) ) {
            if( modelBarang.tambahDataBarang(data) ) {
                JOptionPane.showMessageDialog(null, "Barang berhasil ditambah.");
                tampilDataBarang(home);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menambah barang.");
            }
        }
        
    }
    
    public boolean validasiTambahBarang(String merk, String harga, String jumlah) {
        if( merk.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi merk barang.");
            return false;
        }
        
        if( harga.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi harga barang.");
            return false;
        }
        
        if( jumlah.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi jumlah barang.");
            return false;
        }
        
        return true;
    }
}