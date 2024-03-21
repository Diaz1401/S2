package main;

import com.formdev.flatlaf.FlatLaf;
import com.jthemedetecor.OsThemeDetector;
import java.awt.*;
import java.util.function.Consumer;
import login.FormLoginFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Diaz Nuraji
 */
public class Main {

    public static OsThemeDetector Detector = OsThemeDetector.getDetector();
    public static Consumer<Boolean> ThemeListener;

    public static int SetSize (double scale) 
        [] {
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
        FlatLaf.registerCustomDefaultsSource("theme");
        FormLoginFrame.Form();
    }
}
