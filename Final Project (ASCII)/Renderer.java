import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedOutputStream;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Renderer {
    private static JFrame frame;
    private static BufferedOutputStream out = new BufferedOutputStream( System.out );
    public static Pixel[][] render(Scene scene, Camera cam) {
        // project to 2D
        GameObject[] objects = new GameObject[scene.children.size()];
        for (int i = 0; i < scene.children.size(); i++) {
            Triangle[] tris = new Triangle[scene.children.get(i).mesh.tris.length];
            for (int j = 0; j < scene.children.get(i).mesh.tris.length; j++) {
                tris[j] = project2D(scene.children.get(i).mesh.tris[j], cam.fov); // fov useless rn
            }
            GameObject object = new GameObject(new Mesh(tris), scene.children.get(i).mats);
            objects[i] = object;
        }

        // rasterize into pixels
        Pixel[][] fbuf = new Pixel[80][24];
        // for (int y = 0; y < 24; y++) {
        //     for (int x = 0; x < 80; x++) {

        //     }
        // }

        for (Pixel[] row: fbuf) {
            Arrays.fill(row, new Pixel());
        }

        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].mesh.tris.length; j++) {
                List<Vector2> a = findLine(objects[i].mesh.tris[j].vertices2D[0].position, objects[i].mesh.tris[j].vertices2D[1].position);
                List<Vector2> b = findLine(objects[i].mesh.tris[j].vertices2D[1].position, objects[i].mesh.tris[j].vertices2D[2].position);
                List<Vector2> c = findLine(objects[i].mesh.tris[j].vertices2D[2].position, objects[i].mesh.tris[j].vertices2D[0].position);

                for (int k = 0; k < a.size(); k++) {
                    try {
                        fbuf[(int)a.get(k).x + 40][(int)a.get(k).y + 12] = new Pixel(new Vector3(), new Color(1, 1, 1));
                    } catch (Exception e) {}
                }
                for (int k = 0; k < a.size(); k++) {
                    try {
                        fbuf[(int)b.get(k).x + 40][(int)b.get(k).y + 12] = new Pixel(new Vector3(), new Color(1, 1, 1));
                    } catch (Exception e) {}
                }
                for (int k = 0; k < a.size(); k++) {
                    try {
                        fbuf[(int)c.get(k).x + 40][(int)c.get(k).y + 12] = new Pixel(new Vector3(), new Color(1, 1, 1));
                    } catch (Exception e) {}
                }
            }
        }
        return fbuf;
    }

    static void draw(Pixel[][] fbuf) {
        char[] screen = new char[(81 * 24)];

        for (int v = 0; v < 24; v++) {
            for (int u = 0; u < 80; u++) {
                screen[u + v * 81] = Color.brightnesses[(int)(1 - fbuf[u][v].color.brightness * (Color.brightnesses.length - 1))];
            }
            screen[v * 81] = '\n';
        }
        try {
            out.write("\033[2J\033[3J\033[H".getBytes());
            out.write(new String(screen).getBytes());
            out.flush();
        } catch (Exception e) {
            return;
        }
    }

    private static Triangle project2D(Triangle tri, float fov) {
        Vertex2D[] vertices = new Vertex2D[3];
        for (int i = 0; i < 3; i++) {
            vertices[i] = new Vertex2D(new Vector2(tri.vertices[i].worldPos.x, tri.vertices[i].worldPos.y));
        }

        return new Triangle(vertices, tri.worldNormal);
    }

    private static List<Vector2> findLine(Vector2 A, Vector2 B)
    {
        // bresenham's line drawing algorithm, reused from triangle assignment
        List<Vector2> line = new ArrayList<Vector2>();
 
        int dx = (int)Math.round(Math.abs(B.x - A.x));
        int dy = (int)Math.round(Math.abs(B.y - A.y));

        A.x = Math.round(A.x);
        A.y = Math.round(A.y);
        B.x = Math.round(B.x);
        B.y = Math.round(B.y);

        int sx = A.x < B.x ? 1 : -1; 
        int sy = A.y < B.y ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
 
        while (true) 
        {
            line.add(new Vector2(A.x, A.y));
 
            if (Math.round(A.x) == Math.round(B.x) && Math.round(A.y) == Math.round(B.y)) break;
 
            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                A.x = A.x + sx;
            }
 
            if (e2 < dx) {
                err = err + dx;
                A.y = A.y + sy;
            }
        }                                
        return line;
    }

    public static boolean init() {
        try {
            frame = new JFrame("3D Renderer Project");
            Container pane = frame.getContentPane();
            pane.setLayout(new BorderLayout());

            JPanel renderPanel = new JPanel() {
                public void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    g2.setColor(java.awt.Color.BLACK);
                    g2.fillRect(0, 0, getWidth(), getHeight());
                    g2.translate(getWidth() * 0.5, getHeight() * 0.5);
                    g2.setColor(java.awt.Color.WHITE);
                    
                }
            };

            pane.add(renderPanel, BorderLayout.CENTER);
            frame.setSize(600, 600);
            frame.setVisible(true);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
