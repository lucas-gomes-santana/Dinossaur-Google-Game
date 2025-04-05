import java.awt.*;

public class Cactus {
    private Image image;
    private int cactusX, cactusY; // Cactus position
    private final int speed = 5; // Cactus speed

    private boolean isMoving = true;

    public Cactus(Image image, int startX, int startY) {
        this.image = image;
        this.cactusX = startX;
        this.cactusY = startY;
    }

    public Rectangle getHitBox() {
        return new Rectangle(cactusX,cactusY,60,60);
    }

    public void stop() {
        isMoving = false;
    }

    public void draw(Graphics g) {
        g.drawImage(image, cactusX, cactusY, null);
    }

    public void moveLeft(){
        if(isMoving) {
            cactusX -= speed;

            if(cactusX < -50){ // If the cactus exit of screen, it returns to right side
                cactusX = 800;
            }
        }
    }
}
