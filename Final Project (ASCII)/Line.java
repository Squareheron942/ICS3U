import javax.swing.*;
import java.awt.*;


public class Line extends JComponent {
    Vector2 a, b;
    Line(Vertex2D a, Vertex2D b) {
        this.a = a.position;
        this.b = b.position;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(java.awt.Color.WHITE);
        g2.drawLine(a.position.x, a.position.y, b.position.x, b.position.y);
    }
}