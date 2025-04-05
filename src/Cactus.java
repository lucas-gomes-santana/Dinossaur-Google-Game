import java.awt.*;

public class Cactus {
    private Image image;
    private int cactusX, cactusY;
    private double speed;

    private boolean isMoving = true;
    private boolean isOffScreen = false;

    private long lastSpawnTime;

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

            if(cactusX < -50) {
                long currentTime = System.currentTimeMillis();
                if(currentTime - lastSpawnTime > 500) {
                    isOffScreen = true;
                    cactusX = 800;
                    lastSpawnTime = currentTime;
                }

            } else {
                isOffScreen = false;
            }
        }
    }

    public int getCactusX() { return cactusX; }
    public boolean isOffScreen() { return isOffScreen; }
    public void setSpeed(double speed) { this.speed = speed; }

    public void reset() {
        cactusX = 800;
        isMoving = true;
        isOffScreen = false;
    }
}
