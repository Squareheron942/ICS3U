package rendering;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class RenderPanel extends JPanel implements KeyListener {
    List<Integer> keysHeld = new ArrayList<Integer>();
    BufferedImage img = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
<<<<<<< HEAD:Final Project (GUI)/src/rendering/RenderPanel.java
        g2.drawImage(scale(img, getHeight() * 0.005f, AffineTransformOp.TYPE_NEAREST_NEIGHBOR), ((int)(getHeight() / (float)getWidth()) * 300), 0, null);
        // g2.drawImage(img, 0, 0, null);
        // img = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
=======
        g2.drawImage(scale(img, 4, AffineTransformOp.TYPE_NEAREST_NEIGHBOR), 0, 0, null);
        // g2.drawImage(img, 0, 0, null);
        img = new BufferedImage(getWidth() >> 2, getHeight() >> 2, BufferedImage.TYPE_INT_RGB);
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/RenderPanel.java
    }

    @Override public void keyPressed(KeyEvent e) {
        if (!keysHeld.contains(e.getKeyCode())) keysHeld.add(e.getKeyCode());
    } 
    @Override public void keyReleased(KeyEvent e) {
        keysHeld.remove(keysHeld.indexOf(e.getKeyCode()));
    } 
    @Override public void keyTyped(KeyEvent e) {}

    private static 
    BufferedImage scale(final BufferedImage before, final double scale, final int type) {
        int w = before.getWidth();
        int h = before.getHeight();
        int w2 = (int) (w * scale);
        int h2 = (int) (h * scale);
        BufferedImage after = new BufferedImage(w2, h2, before.getType());
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(scaleInstance, type);
        scaleOp.filter(before, after);
        return after;
    }
}
