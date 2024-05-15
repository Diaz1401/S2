/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Barang;

//update = 8-may-2024

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.awt.Color;

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
        transparan();
        UpdateTable();
        txtBarang.setText(GenerateID());
        pnEvent.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:12;" // Sudut
                + "background:$Login.background");
        lbTitleEvent.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+bold +20");
    }

    /**
     *
     */
    public void transparan(){
        tambahbarang.setBackground(new Color(0,0,0,0));
        ubahtn.setBackground(new Color(0,0,0,0));
        
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
        String id = "BRG_" + number;
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
        ubahtn = new javax.swing.JButton();
        txtStok = new javax.swing.JTextField();
        tambahbarang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(215, 223, 235));

        pnEvent.setPreferredSize(new java.awt.Dimension(960, 600));
        pnEvent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnEvent.add(lbTitleEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 0, 627, 60));

        txtBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBarang.setBorder(null);
        txtBarang.setEnabled(false);
        pnEvent.add(txtBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 180, -1));

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

        pnEvent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 660, 370));

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNama.setBorder(null);
        pnEvent.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 180, -1));

        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHarga.setBorder(null);
        pnEvent.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 180, -1));

        ubahtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ubahtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahtnActionPerformed(evt);
            }
        });
        pnEvent.add(ubahtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 540, 90, 30));

        txtStok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStok.setText("0");
        txtStok.setBorder(null);
        txtStok.setEnabled(false);
        pnEvent.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, -1));

        tambahbarang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tambahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbarangActionPerformed(evt);
            }
        });
        pnEvent.add(tambahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 90, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONTA/BARANG.png"))); // NOI18N
        pnEvent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        String id_barang = Table.getValueAt(row, 0).toString();
        String nama = Table.getValueAt(row, 1).toString();
        String harga = Table.getValueAt(row, 2).toString();
        String stok = Table.getValueAt(row, 3).toString();
        txtBarang.setText(id_barang);
        txtNama.setText(nama);
        txtHarga.setText(harga);
        txtStok.setText(stok);
    }//GEN-LAST:event_TableMouseClicked

    private void tambahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbarangActionPerformed
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
    }//GEN-LAST:event_tambahbarangActionPerformed

    private void ubahtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahtnActionPerformed
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
    }//GEN-LAST:event_ubahtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitleEvent;
    private javax.swing.JPanel pnEvent;
    private javax.swing.JButton tambahbarang;
    private javax.swing.JTextField txtBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    private javax.swing.JButton ubahtn;
    // End of variables declaration//GEN-END:variables
}
