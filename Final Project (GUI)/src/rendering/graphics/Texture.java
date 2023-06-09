package rendering.graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import util.Color;
import util.Vector2;

import java.io.File;
import java.io.IOException;

public class Texture {
    private BufferedImage img = null;
    public Texture() {};
    public Texture(File img) {

        try {
            this.img = ImageIO.read(img);
        } catch (IOException e) {
            System.out.println("\033[0;93m" + "[!!] Could not find texture " + img + "\033[0m");
        }
    }
    public Color get(Vector2 uv) {
        return img == null ? new Color() : new Color(img.getRGB((int)((uv.x * img.getWidth()) % 1), (int)((uv.y * img.getHeight()) % 1)));
    }
}
