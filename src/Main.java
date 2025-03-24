import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int screenWidth = 800;
        int screenHeight = 450;

        // Screen Settings
        JFrame frame = new JFrame("Dinosaur Google Chrome Game");
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dino dino = new Dino(screenWidth, screenHeight);
        frame.add(dino);
        frame.pack();
        frame.setVisible(true);
    }
}
