import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dino extends JPanel implements ActionListener, KeyListener {
    private Image dinoImg;
    private Background background;
    private Cactus cactus;
    private int screenWidth, screenHeight;
    private int score = 0;

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

    private boolean isMoving = true;
    private boolean gameOver = false;
    private boolean alreadyScored = false;


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

    public Rectangle getHitBox() {
        return new Rectangle(dinoX,dinoY,60,60);
    }

    public void stop() {
        isMoving = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g, screenWidth, screenHeight);
        cactus.draw(g);
        g.drawImage(dinoImg, dinoX,dinoY, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Score: " + score,20,30);

        if(gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.BOLD, 30));
            g.drawString("GAME OVER", screenWidth/2 - 100, screenHeight/2);

            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("Final Score: " + score, screenWidth/2 - 100, screenHeight/2 + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateGame();
        repaint();
    }

    private void updateGame() {
        if(!gameOver) {
            cactus.moveLeft();

            if(this.getHitBox().intersects(cactus.getHitBox())) {
                gameOver = true;
                cactus.stop();
            }

            if(cactus.getCactusX() < dinoX && !alreadyScored) {
                score++;
                alreadyScored = true;
            }

            if(cactus.getCactusX() < -50) {
                alreadyScored = false;
            }
        }

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
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOver && e.getKeyCode() == KeyEvent.VK_UP) {
            if (!isJumping) {
                isJumping = true;
                velocityY = jumpStrength;
            }
        }

        else if(gameOver && e.getKeyCode() == KeyEvent.VK_SPACE) {
            resetGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    private void resetGame() {
       gameOver = false;
       score = 0;
       alreadyScored = false;
       dinoY = groundY;
       isJumping = false;
       velocityY = 0;
       cactus.reset();
    }
}
