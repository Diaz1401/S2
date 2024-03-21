import java.awt.Dimension;
import java.awt.Toolkit;

public class Reso {
    public static void main(String[] args) {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        // Get the screen size as a dimension object
        Dimension screenSize = toolkit.getScreenSize();
        
        // Extract width and height from the dimension object
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        // Print the screen resolution
        System.out.println("Screen Width: " + screenWidth + " pixels");
        System.out.println("Screen Height: " + screenHeight + " pixels");
    }
}
