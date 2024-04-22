package Main;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Diaz Nuraji
 */
public class Main {

    public static boolean theme = true;

    public static int[] SetSize(double scale) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) (screenSize.getWidth() * scale);
        int screenHeight = (int) (screenSize.getHeight() * scale);
        int[] size = {screenWidth, screenHeight};
        return size;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Setup FlatLaf
        setupFlatLaf(true);
        new Login.FormLoginFrame().setVisible(true);
    }

    private static void setupFlatLaf(boolean light) {
        // Register custom defaults source
        FlatLaf.registerCustomDefaultsSource("Theme");
        try {
            // Set the look and feel based on the specified theme
            if (light) {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }
            // Update the UI to reflect the theme change
            SwingUtilities.updateComponentTreeUI(new JFrame());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeMode(boolean light) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            if (light) {
                FlatLightLaf.setup();
            } else {
                FlatDarkLaf.setup();
            }
            FlatLaf.updateUI();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }
}
