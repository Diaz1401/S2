/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import com.formdev.flatlaf.*;
import com.jthemedetecor.OsThemeDetector;
import java.awt.*;
import java.util.function.Consumer;
import javax.swing.*;
import login.FormLogin;

/**
 *
 * @author Diaz Nuraji
 */
public class FormMain extends javax.swing.JFrame {

    private static FormLogin formLogin;
    private static FormMain app;

    /**
     * Creates new form main
     */
    public FormMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        formLogin = new FormLogin();
        setContentPane(formLogin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        final OsThemeDetector detector = OsThemeDetector.getDetector();
        FlatLaf.registerCustomDefaultsSource("theme");
        Consumer<Boolean> darkThemeListener = isDark -> {
            SwingUtilities.invokeLater(() -> {
                if (!isDark) {
                    FlatLightLaf.setup();
                } else {
                    FlatDarkLaf.setup();
                }
                if (app != null) {
                    SwingUtilities.updateComponentTreeUI(app);
                } else {
                    app = new FormMain();
                    app.setVisible(true);
                }
            });
        };
        darkThemeListener.accept(detector.isDark());
        detector.registerListener(darkThemeListener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}