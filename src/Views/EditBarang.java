/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.BarangController;
import Views.Home;

/**
 *
 * @author Novil F
 */
public class EditBarang extends javax.swing.JFrame {
    
    BarangController controller = new BarangController();
    static Home home;

    /**
     * Creates new form TambahBarang
     */
    public EditBarang(Home homeForm) {
        home = homeForm;
        
        initComponents();
        
        controller.tampilKodeBarang(this);
        controller.tampilPemasok(this);
        controller.tampilStaff(this);
        controller.tampilJenis(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelJudul = new javax.swing.JLabel();
        labelMerkBarang = new javax.swing.JLabel();
        comboBoxKodeBarang = new javax.swing.JComboBox();
        labelJumlah = new javax.swing.JLabel();
        spinnerJumlah = new javax.swing.JSpinner();
        spinnerHarga = new javax.swing.JSpinner();
        labelHarga = new javax.swing.JLabel();
        comboBoxJenis = new javax.swing.JComboBox();
        labelJenis = new javax.swing.JLabel();
        buttonEditBarang = new javax.swing.JButton();
        buttonBatal = new javax.swing.JButton();
        labelKodeBarang = new javax.swing.JLabel();
        textMerkBarang = new javax.swing.JTextField();
        comboBoxPemasok = new javax.swing.JComboBox();
        labelPemasok = new javax.swing.JLabel();
        comboBoxStaff = new javax.swing.JComboBox();
        labelStaf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelJudul.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelJudul.setText("Edit Barang");

        labelMerkBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMerkBarang.setText("Nama / Merk");

        comboBoxKodeBarang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih barang (kode) yang ingin diubah..." }));
        comboBoxKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxKodeBarangActionPerformed(evt);
            }
        });

        labelJumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelJumlah.setText("Jumlah");

        labelHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHarga.setText("Harga");

        labelJenis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelJenis.setText("Jenis");

        buttonEditBarang.setText("Edit");
        buttonEditBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditBarangActionPerformed(evt);
            }
        });

        buttonBatal.setText("Batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        labelKodeBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKodeBarang.setText("Kode Barang");

        labelPemasok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPemasok.setText("Pemasok");

        labelStaf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelStaf.setText("Staff");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxJenis, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerHarga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerJumlah, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(buttonEditBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textMerkBarang)
                    .addComponent(comboBoxPemasok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(labelJudul))
                            .addComponent(labelMerkBarang)
                            .addComponent(labelJumlah)
                            .addComponent(labelHarga)
                            .addComponent(labelJenis)
                            .addComponent(labelKodeBarang)
                            .addComponent(labelPemasok)
                            .addComponent(labelStaf))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboBoxKodeBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxStaff, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelKodeBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMerkBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMerkBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPemasok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelJumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelHarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelJenis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelStaf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditBarangActionPerformed
        // TODO add your handling code here:
        controller.editBarang(this, home);
    }//GEN-LAST:event_buttonEditBarangActionPerformed

    private void comboBoxKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxKodeBarangActionPerformed
        // TODO add your handling code here:
        controller.tampilInfoBarang(this);
    }//GEN-LAST:event_comboBoxKodeBarangActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonBatalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditBarang(home).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonEditBarang;
    public javax.swing.JComboBox comboBoxJenis;
    public javax.swing.JComboBox comboBoxKodeBarang;
    public javax.swing.JComboBox comboBoxPemasok;
    public javax.swing.JComboBox comboBoxStaff;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelJenis;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelJumlah;
    private javax.swing.JLabel labelKodeBarang;
    private javax.swing.JLabel labelMerkBarang;
    private javax.swing.JLabel labelPemasok;
    private javax.swing.JLabel labelStaf;
    public javax.swing.JSpinner spinnerHarga;
    public javax.swing.JSpinner spinnerJumlah;
    public javax.swing.JTextField textMerkBarang;
    // End of variables declaration//GEN-END:variables
}
