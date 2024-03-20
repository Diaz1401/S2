/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Diaz Nuraji
 */
public class Koneksi  {

    public static Connection koneksi;

    public static Connection koneksiDB() {
        String url = "jdbc:mysql://localhost:3306/mancing_mania";
        String user = "root";
        String pass = "";
        try {
            koneksi = DriverManager.getConnection(url, user, pass);
            return koneksi;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}
