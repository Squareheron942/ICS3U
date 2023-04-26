import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class Renderer {
    private static JFrame frame;
    private static JPanel renderPanel;
    private static BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
    public static Pixel[][] render(Scene scene, PerspectiveCamera cam) {
        // project to 2D
        GameObject[] objects = new GameObject[scene.children.size()];
        for (int i = 0; i < scene.children.size(); i++) {
            Triangle[] tris = new Triangle[scene.children.get(i).mesh.tris.length];
            for (int j = 0; j < tris.length; j++) {
                tris[j] = project2D(scene.children.get(i).mesh.tris[j], cam);
            }
            GameObject object = new GameObject(new Mesh(tris), scene.children.get(i).mats);
            objects[i] = object;
        }

        // rasterize into pixels
        Pixel[][] fbuf = new Pixel[img.getWidth()][img.getHeight()];

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
                        fbuf[(int)a.get(k).x + img.getWidth() >> 1][(int)a.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[0].color, objects[i].mesh.tris[j].vertices2D[1].color, k / (float)a.size()));
                    } catch (Exception e) {System.out.println("A has a problem");}
                }
                for (int k = 0; k < b.size(); k++) {
                    try {
                        fbuf[(int)b.get(k).x + img.getWidth() >> 1][(int)b.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[1].color, objects[i].mesh.tris[j].vertices2D[2].color, k / (float)b.size()));
                    } catch (Exception e) {System.out.println("B has a problem");}
                }
                for (int k = 0; k < c.size(); k++) {
                    try {
                        fbuf[(int)c.get(k).x + img.getWidth() >> 1][(int)c.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[2].color, objects[i].mesh.tris[j].vertices2D[0].color, k / (float)c.size()));
                    } catch (Exception e) {
                        System.out.println("C has a problem");
                    }
                }
            }
        }
        return fbuf;
    }

    public static Pixel[][] render(Scene scene, OrthogonalCamera cam) {
        // project to 2D
        GameObject[] objects = new GameObject[scene.children.size()];
        for (int i = 0; i < scene.children.size(); i++) {
            Triangle[] tris = new Triangle[scene.children.get(i).mesh.tris.length];
            for (int j = 0; j < tris.length; j++) {
                tris[j] = project2D(scene.children.get(i).mesh.tris[j], cam);
            }
            GameObject object = new GameObject(new Mesh(tris), scene.children.get(i).mats);
            objects[i] = object;
        }

        // rasterize into pixels
        Pixel[][] fbuf = new Pixel[img.getWidth()][img.getHeight()];

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
                        fbuf[(int)a.get(k).x + img.getWidth() >> 1][(int)a.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[0].color, objects[i].mesh.tris[j].vertices2D[1].color, k / (float)a.size()));
                    } catch (Exception e) {System.out.println("A has a problem");}
                }
                for (int k = 0; k < b.size(); k++) {
                    try {
                        fbuf[(int)b.get(k).x + img.getWidth() >> 1][(int)b.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[1].color, objects[i].mesh.tris[j].vertices2D[2].color, k / (float)b.size()));
                    } catch (Exception e) {System.out.println("B has a problem");}
                }
                for (int k = 0; k < c.size(); k++) {
                    try {
                        fbuf[(int)c.get(k).x + img.getWidth() >> 1][(int)c.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(objects[i].mesh.tris[j].vertices2D[2].color, objects[i].mesh.tris[j].vertices2D[0].color, k / (float)c.size()));
                    } catch (Exception e) {
                        System.out.println("C has a problem");
                    }
                }
            }
        }
        return fbuf;
    }

    static void draw(Pixel[][] fbuf) {
        for (int u = 0; u < fbuf.length; u++) {
            for (int v = 0; v < fbuf[0].length; v++) {
                try {
                    img.setRGB(u, v, new java.awt.Color(fbuf[u][v].color.r, fbuf[u][v].color.g, fbuf[u][v].color.b).getRGB());
                } catch (Exception e) {}
            }
        }
        frame.repaint();
    }

    private static Triangle project2D(Triangle tri, PerspectiveCamera cam) {
        Vertex2D[] vertices = new Vertex2D[3];
        for (int i = 0; i < 3; i++) {
            float zratio = cam.focalLength / (tri.vertices[i].worldPos.z + cam.focalLength);
            vertices[i] = new Vertex2D(new Vector2(tri.vertices[i].worldPos.x * zratio, tri.vertices[i].worldPos.y * zratio), tri.vertices[i].color);
        }

        return new Triangle(vertices, tri.worldNormal);
    }

    private static Triangle project2D(Triangle tri, OrthogonalCamera cam) {
        Vertex2D[] vertices = new Vertex2D[3];
        for (int i = 0; i < 3; i++) {
            vertices[i] = new Vertex2D(new Vector2(tri.vertices[i].worldPos.x / cam.size.x, tri.vertices[i].worldPos.y / cam.size.y), tri.vertices[i].color);
        }

        return new Triangle(vertices, tri.worldNormal);
    }

    private static List<Vector2> findLine(Vector2 p1, Vector2 p2)
    {
        // bresenham's line drawing algorithm, reused from triangle assignment
        List<Vector2> line = new ArrayList<Vector2>();

        Vector2 A = new Vector2(p1.x, p1.y), B = new Vector2(p2.x, p2.y);
 
        int dx = (int)Math.round(Math.abs(B.x - A.x));
        int dy = (int)Math.round(Math.abs(B.y - A.y));

        A.x = Math.round(A.x);
        A.y = Math.round(A.y);
        B.x = Math.round(B.x);
        B.y = Math.round(B.y);

        int sx = A.x < B.x ? 1 : -1; // works with negative directions
        int sy = A.y < B.y ? 1 : -1; 
 
        int err = dx - dy;
        int e2;
 
        while (true) 
        {
            line.add(new Vector2(A.x, A.y));
 
            if (Math.round(A.x) == Math.round(B.x) && Math.round(A.y) == Math.round(B.y)) break; // if positions are the same stop
 
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

    public static boolean init(Scene scene, Camera cam) {
        try {
            frame = new JFrame("3D Renderer Project");
            Container pane = frame.getContentPane();
            pane.setLayout(new BorderLayout());

            renderPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g;
                    img.setRGB(67 + getWidth() >> 1, 67 + getHeight() >> 1, 0xff0000);
                    img.setRGB(-67 + getWidth() >> 1, -67 + getHeight() >> 1, 0x00ff00);
                    img.setRGB(-200 + getWidth() >> 1, 200 + getHeight() >> 1, 0x0000ff);
                    g2.drawImage(img, 0, 0, null);
                    img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                }
            };

            pane.add(renderPanel, BorderLayout.CENTER);
            frame.setSize(600, 600);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
