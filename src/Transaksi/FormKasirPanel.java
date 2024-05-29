/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Transaksi;

import Koneksi.Koneksi;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diaz Nuraji
 */
public class FormKasirPanel extends javax.swing.JPanel {

    private static Connection cn;
    private static ResultSet rs;
    private static Statement st;
    private static PreparedStatement pst;
    public static String[] barang = new String[10];

    
    /**
     * Creates new form FormEventPanel
     */
    public FormKasirPanel() {
        initComponents();
        transparan();
        txtIDPegawai.setText(Login.FormLoginFrame.namaPegawai);
        txtTransaksi.setText(GenerateID()[0]);
        txtDTransaksi.setText(GenerateID()[1]);
        pnKasir.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:12;" // Sudut
                + "background:$Login.background");
        lbTitleKasir.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+bold +20");
    }
    public void transparan(){
        btnPilih.setBackground(new Color(0,0,0,0));
        BTNHITUNG.setBackground(new Color(0,0,0,0));
        BTNPROSES.setBackground(new Color(0,0,0,0));
    }
    public String[] GenerateID() {
        String id[] = new String[2];
        Random random = new Random();
        // Random number 10000000 to 99999999
        int number = random.nextInt(89999999) + 10000000;
        id[0] = "TRX_" + number;
        id[1] = "DTRX_" + number;
        return id;
    }
    public void GenerateStruk() {
        File reportFile = new File(".");
        try {
            cn = Koneksi.koneksiDB();
            st = cn.createStatement();

            // Query to calculate monthly profitability
            String sql = "SELECT t.*, dt.* " +
                         "FROM transaksi t " +
                         "JOIN detail_transaksi dt ON t.id_transaksi = dt.id_transaksi " +
                         "WHERE dt.id_detail_transaksi = ( " +
                         "    SELECT dt_inner.id_detail_transaksi " +
                         "    FROM detail_transaksi dt_inner " +
                         "    ORDER BY dt_inner.tanggal DESC " +
                         "    LIMIT 1" +
                         ");";


            String dir = reportFile.getCanonicalPath() + "/src/Report/";
            JasperDesign design = JRXmlLoader.load(dir + "struk.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            rs = st.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), rsDataSource);
            JasperViewer.viewReport(jp);
        } catch (IOException | SQLException | JRException e) {
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

        pnKasir = new javax.swing.JPanel();
        lbTitleKasir = new javax.swing.JLabel();
        txtIDPegawai = new javax.swing.JTextField();
        txtTransaksi = new javax.swing.JTextField();
        txtDTransaksi = new javax.swing.JTextField();
        BTNPROSES = new javax.swing.JButton();
        BTNHITUNG = new javax.swing.JButton();
        btnPilih = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(215, 223, 235));
        setPreferredSize(new java.awt.Dimension(453, 453));

        pnKasir.setPreferredSize(new java.awt.Dimension(960, 600));
        pnKasir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleKasir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnKasir.add(lbTitleKasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 621, 70));

        txtIDPegawai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDPegawai.setBorder(null);
        txtIDPegawai.setEnabled(false);
        txtIDPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPegawaiActionPerformed(evt);
            }
        });
        pnKasir.add(txtIDPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 163, -1));

        txtTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTransaksi.setBorder(null);
        txtTransaksi.setEnabled(false);
        pnKasir.add(txtTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 163, -1));

        txtDTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDTransaksi.setBorder(null);
        txtDTransaksi.setEnabled(false);
        pnKasir.add(txtDTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 163, -1));

        BTNPROSES.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BTNPROSES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPROSESActionPerformed(evt);
            }
        });
        pnKasir.add(BTNPROSES, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, 100, 40));

        BTNHITUNG.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BTNHITUNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHITUNGActionPerformed(evt);
            }
        });
        pnKasir.add(BTNHITUNG, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 100, 40));

        btnPilih.setBorder(null);
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });
        pnKasir.add(btnPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 170, 30));
        pnKasir.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 325, 150, 30));
        pnKasir.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 82, -1, -1));

        txtKeterangan.setColumns(20);
        txtKeterangan.setRows(5);
        jScrollPane1.setViewportView(txtKeterangan);

        pnKasir.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 400, 190));
        pnKasir.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, -1, -1));

        jLabel6.setBackground(new java.awt.Color(119, 120, 118));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONTA/kasir_1.png"))); // NOI18N
        pnKasir.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel6.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        new FormPilihBarangFrame().setVisible(true);
    }//GEN-LAST:event_btnPilihActionPerformed

    private void txtIDPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPegawaiActionPerformed

    private void BTNHITUNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHITUNGActionPerformed
//       int totalPrice = 0; // Total harga
//        HashMap<String, Integer> itemCount = new HashMap<>(); // Map untuk menyimpan jumlah barang
//        HashMap<String, String> namaMap = new HashMap<>(); // Map untuk menyimpan pemetaan id_barang -> nama
//
//        // Hitung kemunculan setiap item dalam array barang dan ambil nama dari database
//        for (String item : barang) {
//            if (item != null) {
//                // Periksa apakah item sudah ada dalam map itemCount
//                if (itemCount.containsKey(item)) {
//                    // Jika ya, tambahkan jumlahnya
//                    itemCount.put(item, itemCount.get(item) + 1);
//                } else {
//                    // Jika tidak, inisialisasi jumlah dengan 1
//                    itemCount.put(item, 1);
//                    try {
//                        // Ambil koneksi ke database
//                        cn = Koneksi.koneksiDB();
//                        String query = "SELECT * FROM barang WHERE id_barang = ?";
//                        pst = cn.prepareStatement(query);
//                        pst.setString(1, item);
//                        rs = pst.executeQuery();
//                        if (rs.next()) {
//                            // Ambil nama dari hasil pencarian
//                            String nama = rs.getString("nama");
//                            // Simpan pemetaan id_barang -> nama dalam namaMap
//                            namaMap.put(item, nama);
//                        }
//                    } catch (SQLException e) {
//                        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//                    }
//                }
//            }
//        }
//
//        // Buat StringBuilder untuk menyusun hasil akhir
//        StringBuilder result = new StringBuilder();
//
//        // Iterasi melalui array barang untuk menyisipkan item dengan jumlah
//        Set<String> uniqueItems = new HashSet<>();
//        for (String item : barang) {
//            if (item != null && !uniqueItems.contains(item)) { // Jika item belum ditambahkan sebelumnya
//                uniqueItems.add(item); // Tandai item sebagai sudah ditambahkan
//                // Ambil nama dari namaMap menggunakan id_barang
//                String nama = namaMap.get(item);
//                // Periksa apakah jumlahnya lebih dari 1, tambahkan "x[jumlah]"
//                if (itemCount.get(item) > 1) {
//                    result.append(nama).append(" x").append(itemCount.get(item));
//                } else {
//                    result.append(nama);
//                }
//                result.append("\n"); // Tambahkan baris baru
//            }
//        }
//        txtKeterangan.setText(result.toString());
//
//        // Calculate the total price
//        for (String barangs : barang) {
//            if (barangs != null) {
//                try {
//                    cn = Koneksi.koneksiDB();
//                    String query = "SELECT * FROM barang WHERE id_barang = ?";
//                    pst = cn.prepareStatement(query);
//                    pst.setString(1, barangs);
//                    rs = pst.executeQuery();
//                    if (rs.next()) {
//                        int harga = rs.getInt("harga");
//                        // Ambil keuntungan 2000
//                        totalPrice += harga + 2000;
//                    }
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//                }
//            }
//        }
//
//        lbTotal.setText(String.valueOf(totalPrice));
//        BTNHITUNG.setEnabled(true);private void BTNHITUNGActionPerformed(java.awt.event.ActionEvent evt) {                                          
    int totalPrice = 0; // Total harga
    HashMap<String, Integer> itemCount = new HashMap<>(); // Map untuk menyimpan jumlah barang
    HashMap<String, String> namaMap = new HashMap<>(); // Map untuk menyimpan pemetaan id_barang -> nama
    // Hitung kemunculan setiap item dalam array barang dan ambil nama dari database
    for (String item : barang) {
        if (item != null) {
            // Periksa apakah item sudah ada dalam map itemCount
            if (itemCount.containsKey(item)) {
                // Jika ya, tambahkan jumlahnya
                itemCount.put(item, itemCount.get(item) + 1);
            } else {
                // Jika tidak, inisialisasi jumlah dengan 1
                itemCount.put(item, 1);
                try {
                    // Ambil koneksi ke database
                    cn = Koneksi.koneksiDB();
                    String query = "SELECT * FROM barang WHERE id_barang = ?";
                    pst = cn.prepareStatement(query);
                    pst.setString(1, item);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        // Ambil nama dari hasil pencarian
                        String nama = rs.getString("nama");
                        // Simpan pemetaan id_barang -> nama dalam namaMap
                        namaMap.put(item, nama);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                }
            }
        }
    }
    // Buat StringBuilder untuk menyusun hasil akhir
    StringBuilder result = new StringBuilder();
    // Iterasi melalui array barang untuk menyisipkan item dengan jumlah
    Set<String> uniqueItems = new HashSet<>();
    for (String item : barang) {
        if (item != null && !uniqueItems.contains(item)) { // Jika item belum ditambahkan sebelumnya
            uniqueItems.add(item); // Tandai item sebagai sudah ditambahkan
            // Ambil nama dari namaMap menggunakan id_barang
            String nama = namaMap.get(item);
            // Periksa apakah jumlahnya lebih dari 1, tambahkan "x[jumlah]"
            if (itemCount.get(item) > 1) {
                result.append(nama).append(" x").append(itemCount.get(item));
            } else {
                result.append(nama);
            }
            result.append("\n"); // Tambahkan baris baru
        }
    }
    txtKeterangan.setText(result.toString());
    // Calculate the total price
    for (String barangs : barang) {
        if (barangs != null) {
            try {
                cn = Koneksi.koneksiDB();
                String query = "SELECT * FROM barang WHERE id_barang = ?";
                pst = cn.prepareStatement(query);
                pst.setString(1, barangs);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int harga = rs.getInt("harga");
                    // Tambahkan keuntungan 2000 rupiah
                    totalPrice += harga + 2000;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }
    lbTotal.setText(String.valueOf(totalPrice));
    BTNHITUNG.setEnabled(true);
    }//GEN-LAST:event_BTNHITUNGActionPerformed
    
    private void BTNPROSESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPROSESActionPerformed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datetime = LocalDateTime.now().format(formatter);

        // Insert into tabel transaksi
        try {
            cn = Koneksi.koneksiDB();
            String query1 = "INSERT INTO transaksi (id_transaksi, keterangan";
            String query2 = "INSERT INTO detail_transaksi (id_detail_transaksi, id_transaksi, id_pegawai, tanggal, total) VALUES (?, ?, ?, ?, ?)";


            // for id_barang_0 to id_barang_9
            for (int i = 0; i < 10; i++) {
                query1 += ", id_barang_" + i;
            }

            // id_transaksi, id_pegawai, keterangan, tanggal
            query1 += ") VALUES (?, ?";

            // for id_barang_0 to id_barang_9
            for (int i = 0; i < 10; i++) {
                query1 += ", ?";
            }

            query1 += ")";

            pst = cn.prepareStatement(query1);
            pst.setString(1, txtTransaksi.getText()); // id_transaksi
            pst.setString(2, txtKeterangan.getText()); // keterangan

            // Add id_barang values from barang array
            for (int i = 0; i < 10; i++) {
                if (barang[i] != null) {
                    pst.setString(3 + i, barang[i]);
                } else {
                    pst.setNull(3 + i, Types.VARCHAR);
                }
            }

            pst.executeUpdate();
            pst = cn.prepareStatement(query2);
            pst.setString(1, txtDTransaksi.getText()); // id_detail_transaksi
            pst.setString(2, txtTransaksi.getText()); // id_transaksi
            pst.setString(3, txtIDPegawai.getText()); // id_pegawai
            pst.setString(4, datetime); // tanggal
            pst.setString(5, lbTotal.getText()); // total

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Transaksi gagal, " + e.getMessage());
        }

        BTNPROSES.hide();
        btnPilih.setEnabled(true);
        BTNHITUNG.hide();
        GenerateStruk();
    }//GEN-LAST:event_BTNPROSESActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BTNHITUNG;
    private javax.swing.JButton BTNPROSES;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitleKasir;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JPanel pnKasir;
    private javax.swing.JTextField txtDTransaksi;
    private javax.swing.JTextField txtIDPegawai;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtTransaksi;
    // End of variables declaration//GEN-END:variables
}
