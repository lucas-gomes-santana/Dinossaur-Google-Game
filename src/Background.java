import java.awt.*;

public class Background {
    private Image image;
    private int screenHeight;

    public Background(Image image, int screenHeight) {
        this.image = image;
        this.screenHeight = screenHeight;
    }

    public void draw(Graphics g, int width, int height) {
        g.drawImage(image, 0, 0, width, height, null);
    }
}
