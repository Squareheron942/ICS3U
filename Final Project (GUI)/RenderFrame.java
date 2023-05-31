import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;

public class RenderFrame extends JFrame implements KeyListener {
    List<Integer> keysHeld = new ArrayList<Integer>();
    BufferedImage img = new BufferedImage(160, 120, BufferedImage.TYPE_INT_RGB);

    RenderFrame(String title) {
        super(title);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override public void keyPressed(KeyEvent e) {
        if (!keysHeld.contains(e.getKeyCode())) keysHeld.add(e.getKeyCode());
    } 
    @Override public void keyReleased(KeyEvent e) {
        keysHeld.remove(keysHeld.indexOf(e.getKeyCode()));
    } 
    @Override public void keyTyped(KeyEvent e) {}
}
