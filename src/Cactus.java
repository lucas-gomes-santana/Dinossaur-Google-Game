import java.awt.*;

public class Cactus {
    private Image image;
    private int x, y; // Cactus position
    private final int speed = 5; // Cactus speed

    public Cactus(Image image, int startX, int startY) {
        this.image = image;
        this.x = startX;
        this.y = startY;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public void moveLeft(){
        x -= speed;

        if(x < -50){ // If the cactus exit of screen, it returns to right side
            x = 800;
        }
    }
}
