import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int screenWidth = 800;
        int screenHeight = 450;

        // Load images here
        Image dinoImg = new ImageIcon("images/dino.png").getImage();
        Image backgroundImg = new ImageIcon("images/background.png").getImage();
        Image cactusImg = new ImageIcon("images/cactus.png").getImage();

        // Game Screen Settings
        JFrame frame = new JFrame("Dinosaur Google Chrome Game");
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create game panel with the images
        Dino dino = new Dino(screenWidth, screenHeight, dinoImg, backgroundImg, cactusImg);
        frame.add(dino);
        frame.pack();
        frame.setVisible(true);
    }
}
