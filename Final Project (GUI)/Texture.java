import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Texture {
    BufferedImage img = null;
    Texture() {};
    Texture(File img) {
        try {
            this.img = ImageIO.read(img);
        } catch (IOException e) {

        }
    }
    Color get(Vector2 uv) {
        return img == null ? new Color() : new Color(img.getRGB((int)(uv.x * img.getWidth()), (int)(uv.y * img.getHeight())));
    }
}
