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
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("theme");
        FormLoginFrame.Form();
    }
}
