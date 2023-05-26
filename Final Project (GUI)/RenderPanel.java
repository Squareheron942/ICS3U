import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class RenderPanel extends JPanel implements KeyListener {
    List<Integer> keysHeld = new ArrayList<Integer>();
    BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(img, 0, 0, null);
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override public void keyPressed(KeyEvent e) {
        if (!keysHeld.contains(e.getKeyCode())) keysHeld.add(e.getKeyCode());
    } 
    @Override public void keyReleased(KeyEvent e) {
        keysHeld.remove(keysHeld.indexOf(e.getKeyCode()));
    } 
    @Override public void keyTyped(KeyEvent e) {}
}
