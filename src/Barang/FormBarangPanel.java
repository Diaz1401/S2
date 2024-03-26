/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Barang;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;

/**
 *
 * @author Diaz Nuraji
 */
public class FormBarangPanel extends javax.swing.JPanel {

    private static Connection cn;
    private static ResultSet rs;
    private static Statement st;
    private static PreparedStatement pst;

    /**
     * Creates new form FormEventPanel
     */
    public FormBarangPanel() {
        initComponents();
        UpdateTable();
        txtBarang.setText(GenerateID());
        pnEvent.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:12;" // Sudut
                + "background:$Login.background");
        lbTitleEvent.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+bold +20");
    }

    public void UpdateTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Barang");
        tbl.addColumn("Nama");
        tbl.addColumn("Harga");
        tbl.addColumn("Stok");
        Table.setModel(tbl);
        try {
            cn = Koneksi.koneksiDB();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM barang");

            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama"),
                    rs.getString("harga"),
                    rs.getString("stok"),});
                Table.setModel(tbl);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
        txtBarang.setText(GenerateID());
    }

    public String GenerateID() {
        Random random = new Random();
        // Random number 10000000 to 99999999
        int number = random.nextInt(89999999) + 10000000;
        String id = "BARANG_" + number;
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnEvent = new javax.swing.JPanel();
        lbTitleEvent = new javax.swing.JLabel();
        txtBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txtNama = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUbah = new javax.swing.JButton();
        txtStok = new javax.swing.JTextField();

        lbTitleEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleEvent.setText("Barang");

        txtBarang.setEnabled(false);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID Barang");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nama Barang");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Harga Barang");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Stok");

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnEventLayout = new javax.swing.GroupLayout(pnEvent);
        pnEvent.setLayout(pnEventLayout);
        pnEventLayout.setHorizontalGroup(
            pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEventLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtStok)
                    .addGroup(pnEventLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(lbTitleEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnEventLayout.setVerticalGroup(
            pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbTitleEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEventLayout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah))
                    .addGroup(pnEventLayout.createSequentialGroup()
                        .addComponent(txtBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (txtBarang.getText().isEmpty()
                || txtNama.getText().isEmpty()
                || txtHarga.getText().isEmpty()
                || txtStok.getText().isEmpty()) {
            // Show an error message
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }
        String id_barang = txtBarang.getText();
        String nama = txtNama.getText();
        String harga = txtHarga.getText();
        String stok = txtStok.getText();

        try {
            // Connect
            String sql = "INSERT INTO barang (id_barang, nama, harga, stok) VALUES (?, ?, ?, ?)";
            cn = Koneksi.koneksiDB();
            pst = cn.prepareStatement(sql);

            // Set paramater
            pst.setString(1, id_barang);
            pst.setString(2, nama);
            pst.setString(3, harga);
            pst.setString(4, stok);

            // Execute
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
        }
        // Update table
        UpdateTable();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = Table.getSelectedRow();

        if (row < 0) {
            // Error if row not selected
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus");
            return;
        }
        // get value from first row
        String id_barang = txtBarang.getText();

        try {
            String sql_del = "DELETE from barang WHERE id_barang = ?";
            cn = Koneksi.koneksiDB();
            pst = cn.prepareStatement(sql_del);

            // Set parameter
            pst.setString(1, id_barang);

            // Execute
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
        UpdateTable();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String id_barang = txtBarang.getText();
        String nama = txtNama.getText();
        String harga = txtHarga.getText();
        String stok = txtStok.getText();
        try {
            // Connect
            String sql = "UPDATE barang SET nama = ?, harga = ?, stok = ? WHERE id_barang = ?";
            cn = Koneksi.koneksiDB();
            pst = cn.prepareStatement(sql);

            // Set the parameter values
            pst.setString(1, nama);
            pst.setString(2, harga);
            pst.setString(3, stok);
            pst.setString(4, id_barang);

            // Execute the statement
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
        }

        // Clear text
        txtBarang.setText(null);
        txtNama.setText(null);
        txtHarga.setText(null);
        txtStok.setText(null);

        // Update table
        UpdateTable();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        String id_barang = Table.getValueAt(row, 0).toString();
        String nama = null;
        String harga = null;
        String stok = null;
        try {
            cn = Koneksi.koneksiDB();
            pst = cn.prepareStatement("SELECT * FROM barang WHERE id_barang = ?");
            pst.setString(1, id_barang);
            rs = pst.executeQuery();
            rs.next(); // Move cursor to first row
            nama = rs.getString("nama");
            harga = rs.getString("harga");
            stok = rs.getString("stok");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
        txtBarang.setText(id_barang);
        txtNama.setText(nama);
        txtHarga.setText(harga);
        txtStok.setText(stok);
    }//GEN-LAST:event_TableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitleEvent;
    private javax.swing.JPanel pnEvent;
    private javax.swing.JTextField txtBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}