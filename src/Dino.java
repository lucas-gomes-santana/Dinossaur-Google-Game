import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dino extends JPanel implements ActionListener {
    private Image dinoImg;
    private Background background;
    private Cactus cactus;
    private int screenWidth, screenHeight;

    // FPS Settings
    private Timer timer;
    private final int fps = 60;
    private final int delay = 1000 / fps;

    public Dino(int screenWidth, int screenHeight, Image dinoImg, Image backgroundImg, Image cactusImg) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.dinoImg = dinoImg;

        setPreferredSize(new Dimension(screenWidth, screenHeight));

        background = new Background(backgroundImg, screenHeight - 75);
        cactus = new Cactus(cactusImg, 700, screenHeight - 100);

        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g, screenWidth, screenHeight); // Desenha fundo
        cactus.draw(g); // Desenha cacto
        g.drawImage(dinoImg, 50, screenHeight - 100, null); // Desenha dinossauro
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateGame();
        repaint();
    }

    private void updateGame(){
        cactus.moveLeft();
    }
}
