/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Transaksi;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diaz Nuraji
 */
public class FormPilihBarangFrame extends javax.swing.JFrame {

    private static Connection cn;
    private static ResultSet rs;
    private static Statement st;
    private static PreparedStatement pst;

    /**
     * Creates new form FormPilihBarangFrame
     */
    public FormPilihBarangFrame() {
        initComponents();
        UpdateTable();
        SetupTable();
    }

    public void SetupTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Barang Terpilih");
        TableSelect.setModel(tbl);
    }

    public void UpdateTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Barang");
        tbl.addColumn("Nama");
        TableSearch.setModel(tbl);
        try {
            cn = Koneksi.koneksiDB();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM barang");

            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama")});
                TableSearch.setModel(tbl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSearch = new javax.swing.JTable();
        btnCari = new javax.swing.JTextField();
        txtTerpilih = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPilih = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableSelect = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(840, 400));

        jLabel1.setText("Tabel Barang Tersedia");

        TableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSearch);

        btnCari.setText("Cari barang . . .");
        btnCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnCariFocusLost(evt);
            }
        });
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariMouseExited(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtTerpilih.setEnabled(false);

        jLabel2.setText("Masukan kata kunci disini");

        jLabel3.setText("Barang terpilih");
        jLabel3.setToolTipText("");

        btnPilih.setText("Gunakan Pilihan & Keluar");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        TableSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TableSelect);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus Pilihan");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel4.setText("Tabel Barang Terpilih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtTerpilih))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPilih)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTerpilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPilih)
                .addGap(79, 79, 79))
        );

        setSize(new java.awt.Dimension(908, 449));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseEntered

    }//GEN-LAST:event_btnCariMouseEntered

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String keyword = btnCari.getText().trim(); // Get the search keyword

        if (keyword.isEmpty() || keyword.equals("Cari barang . . .")) {
            JOptionPane.showMessageDialog(this, "Masukan nama atau ID barang.");
            return;
        }

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Barang");
        tbl.addColumn("Nama");
        TableSearch.setModel(tbl);

        try {
            cn = Koneksi.koneksiDB();
            String query = "SELECT id_barang, nama FROM barang WHERE id_barang LIKE ? OR nama LIKE ?";
            pst = cn.prepareStatement(query);
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited

    }//GEN-LAST:event_btnCariMouseExited

    private void btnCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCariFocusGained
        if (btnCari.getText().equals("Cari barang . . ."))
            btnCari.setText("");
    }//GEN-LAST:event_btnCariFocusGained

    private void btnCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnCariFocusLost
        if (btnCari.getText().isEmpty())
            btnCari.setText("Cari barang . . .");
    }//GEN-LAST:event_btnCariFocusLost

    private void TableSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSearchMouseClicked
        int row = TableSearch.getSelectedRow();
        String barang = TableSearch.getValueAt(row, 0).toString();
        txtTerpilih.setText(barang);
    }//GEN-LAST:event_TableSearchMouseClicked

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // Reset value
        FormKasirPanel.barang = new String[10];
        FormKasirPanel.btnHitung.setEnabled(true);
        int rowCount = TableSelect.getRowCount();
        if (rowCount > 10) {
            JOptionPane.showMessageDialog(this, "Error: Barang terpilih maksimal 10");
        }
        for (int i = 0; i < rowCount; i++) {
            Object value = TableSelect.getValueAt(i, 0);

            // Check if the value is not null
            if (value != null) {
                // Convert the value to a String and store it in the barang array
                FormKasirPanel.barang[i] = value.toString();
                try {
                    // Connect
                    String sql = "UPDATE barang SET stok = stok - 1 WHERE id_barang = ?";
                    cn = Koneksi.koneksiDB();
                    pst = cn.prepareStatement(sql);

                    // Set paramater
                    pst.setString(1, value.toString());

                    // Execute the statement
                    pst.executeUpdate();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
                }
            } else {
                // If the value is null, set the corresponding element in the barang array to null
                FormKasirPanel.barang[i] = null;
            }
        }
        dispose();
        FormKasirPanel.btnHitung.setEnabled(true);
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // Get the text from txtTerpilih
        String select = txtTerpilih.getText();
        // Check if the selectedBarang is not empty
        if (!select.isEmpty()) {
            // Get the DefaultTableModel of TableSelect
            DefaultTableModel model = (DefaultTableModel) TableSelect.getModel();
            // Add the selectedBarang to a new row in TableSelect
            model.addRow(new Object[]{select});
        } else {
            // If selectedBarang is empty, show a message to prompt the user to select a barang
            JOptionPane.showMessageDialog(this, "Pilih barang terlebih dahulu.");
        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // Get the selected row index
        int selectedRow = TableSelect.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Remove the selected row from the table model
            DefaultTableModel model = (DefaultTableModel) TableSelect.getModel();
            model.removeRow(selectedRow);
        } else {
            // If no row is selected, display a message to prompt the user to select a row
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu.");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FormPilihBarangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPilihBarangFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableSearch;
    private javax.swing.JTable TableSelect;
    private javax.swing.JTextField btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtTerpilih;
    // End of variables declaration//GEN-END:variables
}
