import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Dino extends JPanel {
    int screenWidth, screenHeight;
    Image backgroundImg, dinoImg, cactusImg;

    Dino(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setOpaque(false); // Permite fundo transparente

        try {
            // Carrega imagens (caminho relativo, sem /)
            backgroundImg = ImageIO.read(getClass().getResource("background.png"));
            dinoImg = ImageIO.read(getClass().getResource("dino.png"));
            cactusImg = ImageIO.read(getClass().getResource("cactus.png"));

            System.out.println("Background carregado? " + (backgroundImg != null));
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("ERRO: Imagem não encontrada!");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha o background (redimensiona para preencher a tela)
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this);
        } else {
            // Debug: fundo vermelho se a imagem não carregar
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // Desenha o dino e o cacto (exemplo)
        if (dinoImg != null) {
            g.drawImage(dinoImg, 50, screenHeight - 100, this);
        }
        if (cactusImg != null) {
            g.drawImage(cactusImg, 300, screenHeight - 80, this);
        }
    }
}