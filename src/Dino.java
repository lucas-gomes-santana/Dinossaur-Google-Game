import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dino extends JPanel implements ActionListener, KeyListener {
    private Image dinoImg;
    private Background background;
    private Cactus cactus;
    private int screenWidth, screenHeight;

    // FPS Settings
    private Timer timer;
    private final int fps = 70;
    private final int delay = 730 / fps;

    // Dinosaur Position
    private int dinoX = 50;
    private int dinoY;
    private int groundY;

    // Jump Physics
    private boolean isJumping = false;
    private double velocityY = 0;
    private final double gravity = 0.5;
    private final double jumpStrength = -12;


    public Dino(int screenWidth, int screenHeight, Image dinoImg, Image backgroundImg, Image cactusImg) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.dinoImg = dinoImg;

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setFocusable(true);
        addKeyListener(this);

        groundY = screenHeight - 100;
        dinoY = groundY;

        background = new Background(backgroundImg, screenHeight - 75);
        cactus = new Cactus(cactusImg, 700, screenHeight - 100);

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g, screenWidth, screenHeight);
        cactus.draw(g);
        g.drawImage(dinoImg, dinoX,dinoY, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateGame();
        repaint();
    }

    private void updateGame() {
        cactus.moveLeft();

        if (isJumping) {
            dinoY += velocityY;
            velocityY += gravity;

            if (dinoY >= groundY) {
                dinoY = groundY;
                isJumping = false;
                velocityY = 0;
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (!isJumping) {
                isJumping = true;
                velocityY = jumpStrength;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
