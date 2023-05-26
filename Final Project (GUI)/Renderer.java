import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

public class Renderer {
    public static int renderMode = 0;
    public static RenderFrame frame;
    private static RenderPanel renderPanel = new RenderPanel();
    private static float[][] zbuf; 
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
        Pixel[][] fbuf = new Pixel[renderPanel.img.getWidth()][renderPanel.img.getHeight()];
        zbuf = new float[renderPanel.img.getWidth()][renderPanel.img.getHeight()];

        for (Pixel[] row: fbuf) Arrays.fill(row, new Pixel());
        for (float[] row : zbuf) Arrays.fill(row, 0.0f);

        

        for (GameObject object : objects) {
            for (Triangle t : object.mesh.tris) {
                Vertex v1 = t.vertices[0];
                Vertex v2 = t.vertices[1];
                Vertex v3 = t.vertices[2];

                int minX = (int) Math.round(Math.max(-renderPanel.img.getWidth(), Math.ceil(Math.min(v1.worldPos.x, Math.min(v2.worldPos.x, v3.worldPos.x)))));
                int maxX = (int) Math.round(Math.min(renderPanel.img.getWidth() >> 1 - 1, Math.floor(Math.max(v1.worldPos.x, Math.max(v2.worldPos.x, v3.worldPos.x)))));
                int minY = (int) Math.round(Math.max(-renderPanel.img.getHeight(), Math.ceil(Math.min(v1.worldPos.y, Math.min(v2.worldPos.y, v3.worldPos.y)))));
                int maxY = (int) Math.round(Math.min(renderPanel.img.getHeight() >> 1 - 1, Math.floor(Math.max(v1.worldPos.y, Math.max(v2.worldPos.y, v3.worldPos.y)))));

                for (int y = minY; y <= maxY; y++) {
                    for (int x = minX; x <= maxX; x++) {
                        Vector2 p = new Vector2(x,y);
                        // Judge once for each vertex
                        boolean V1 = sameSide(v1.worldPos, v2.worldPos, v3.worldPos, p);
                        boolean V2 = sameSide(v2.worldPos, v3.worldPos, v1.worldPos, p);
                        boolean V3 = sameSide(v3.worldPos, v1.worldPos, v2.worldPos, p);

                        if (V3 && V2 && V1) {
                            try {
                                Vector3 bary = bary(v1.worldPos, v2.worldPos, v3.worldPos, p);
                                float zVal = 1 - ((cam.nearClip - 1 / (bary.x / v1.worldPos.z + bary.y / v2.worldPos.z + bary.z / v3.worldPos.z)) / (cam.farClip - cam.nearClip));

                                if (zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] < zVal && zVal <= 1 && zVal >= 0) {
                                    fbuf[x + renderPanel.img.getWidth() >> 1][-y + renderPanel.img.getHeight() >> 1] = new Pixel(t.worldNormal, renderMode == 0 ? t.color : renderMode == 1 ? new Color(zVal, zVal, zVal) : new Color(bary.x, bary.y, bary.z));
                                    zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] = zVal;
                                }
                            } catch (Exception e) {}
                        }
                    }
                }
            }
        }

        // for (GameObject object : objects) {
        //     for (Triangle t : object.mesh.tris) {
        //         List<Vector2> a = findLine(t.vertices[0].worldPos, t.vertices[1].worldPos);
        //         List<Vector2> b = findLine(t.vertices[1].worldPos, t.vertices[2].worldPos);
        //         List<Vector2> c = findLine(t.vertices[2].worldPos, t.vertices[0].worldPos);

        //         try {
        //             for (int k = 0; k < a.size(); k++) {
        //                 fbuf[(int)a.get(k).x + img.getWidth() >> 1][(int)-a.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[0].color, t.vertices[1].color, k / (float)a.size()));
        //             }
        //         } catch (Exception e) {} 
        //         try {
        //             for (int k = 0; k < b.size(); k++) {                    
        //                 fbuf[(int)b.get(k).x + img.getWidth() >> 1][(int)-b.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[1].color, t.vertices[2].color, k / (float)b.size()));
        //             }
        //         } catch (Exception e) {} 
        //         try {
        //             for (int k = 0; k < c.size(); k++) {
        //                 fbuf[(int)c.get(k).x + img.getWidth() >> 1][(int)-c.get(k).y + img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[2].color, t.vertices[0].color, k / (float)c.size()));
        //             }
        //         } catch (Exception e) {} 
        //     }
        // }
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
        Pixel[][] fbuf = new Pixel[renderPanel.img.getWidth()][renderPanel.img.getHeight()];

        for (Pixel[] row: fbuf) {
            Arrays.fill(row, new Pixel());
        }

        for (GameObject object : objects) {
            for (Triangle t : object.mesh.tris) {
                List<Vector2> a = findLine(t.vertices[0].worldPos, t.vertices[1].worldPos);
                List<Vector2> b = findLine(t.vertices[1].worldPos, t.vertices[2].worldPos);
                List<Vector2> c = findLine(t.vertices[2].worldPos, t.vertices[0].worldPos);

                try {
                    for (int k = 0; k < a.size(); k++) {
                        fbuf[(int)a.get(k).x + renderPanel.img.getWidth() >> 1][(int)-a.get(k).y + renderPanel.img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[0].color, t.vertices[1].color, k / (float)a.size()));
                    }
                } catch (Exception e) {} 
                try {
                    for (int k = 0; k < b.size(); k++) {                    
                        fbuf[(int)b.get(k).x + renderPanel.img.getWidth() >> 1][(int)-b.get(k).y + renderPanel.img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[1].color, t.vertices[2].color, k / (float)b.size()));
                    }
                } catch (Exception e) {} 
                try {
                    for (int k = 0; k < c.size(); k++) {
                        fbuf[(int)c.get(k).x + renderPanel.img.getWidth() >> 1][(int)-c.get(k).y + renderPanel.img.getHeight() >> 1] = new Pixel(new Vector3(), Color.lerp(t.vertices[2].color, t.vertices[0].color, k / (float)c.size()));
                    }
                } catch (Exception e) {} 
            }
        }
        return fbuf;
    }

    static void draw(Pixel[][] fbuf) {
        for (int u = 0; u < fbuf.length; u++) {
            for (int v = 0; v < fbuf[0].length; v++) {
                try {
                    renderPanel.img.setRGB(u, v, new java.awt.Color(fbuf[u][v].color.r, fbuf[u][v].color.g, fbuf[u][v].color.b).getRGB());
                } catch (Exception e) {}
            }
        }
        frame.repaint();
    }

    private static Triangle project2D(Triangle tri, PerspectiveCamera cam) {
        Vertex[] vertices = new Vertex[3];
        float focalLength = (renderPanel.img.getWidth() >> 1) * LUTs.cot((int)cam.fov() >> 1); // f = (width/2) * ctg(HFOV/2)
        float n = focalLength;
        for (int i = 0; i < 3; i++) {
            Vector3 vp = new Vector3(
                tri.vertices[i].worldPos.x - cam.position.x,
                tri.vertices[i].worldPos.y - cam.position.y,
                tri.vertices[i].worldPos.z - cam.position.z
            );

            float u = cam.rotation.x, v = cam.rotation.y, w = cam.rotation.z;

            Vector3 vPos = new Vector3(
                (vp.x * (LUTs.cos(v) * LUTs.cos(w))) + (vp.y * (LUTs.sin(u) * LUTs.sin(v) * LUTs.cos(w) - LUTs.cos(u) * LUTs.sin(w))) + (vp.z * (LUTs.sin(u) * LUTs.sin(w) + LUTs.cos(u) * LUTs.sin(v) * LUTs.cos(w))), 
                (vp.x * (LUTs.cos(v) * LUTs.sin(w))) + (vp.y * (LUTs.cos(u) * LUTs.cos(w) + LUTs.sin(u) * LUTs.sin(v) * LUTs.sin(w))) + (vp.z * (LUTs.cos(u) * LUTs.sin(v) * LUTs.sin(w) - LUTs.sin(u) * LUTs.cos(w))),
                (vp.x * (-LUTs.sin(v))) + (vp.y * (LUTs.sin(u) * LUTs.cos(v))) + (vp.z * (LUTs.cos(u) * LUTs.cos(v)))
            );

            // vertices[i] = new Vertex(
            //     new Vector3(
            //         vPos.x * focalLength / ((renderPanel.img.getWidth() >> 1) * vPos.z),
            //         vPos.y * focalLength / ((renderPanel.img.getHeight() >> 1) * vPos.z),
            //         vPos.z
            //     )
            // );
            // float zratio = focalLength / (-(vPos.z) + focalLength);
            float zratio = 1 / vPos.z;
            // float zratio = 1;
            vertices[i] = new Vertex(new Vector3((vPos.x) * zratio * -(renderPanel.img.getWidth() >> 1), (vPos.y) * zratio * -(renderPanel.img.getHeight() >> 1), vPos.z), tri.vertices[i].color);
        }

        return new Triangle(vertices, tri.color);
    }

    private static Triangle project2D(Triangle tri, OrthogonalCamera cam) {
        Vertex[] vertices = new Vertex[3];
        for (int i = 0; i < 3; i++) {
            vertices[i] = new Vertex(new Vector3(tri.vertices[i].worldPos.x / cam.size.x, tri.vertices[i].worldPos.y / cam.size.y, tri.vertices[i].worldPos.z), tri.vertices[i].color);
        }

        return new Triangle(vertices, tri.color);
    }

    private static List<Vector2> findLine(Vector3 p1, Vector3 p2)
    {
        // bresenham's line drawing algorithm, reused from triangle assignment
        List<Vector2> line = new ArrayList<Vector2>();

        long maxSize = Math.round(Math.sqrt(2) * Math.sqrt(frame.getHeight() * frame.getHeight() + frame.getWidth() * frame.getWidth()));

        Vector2 A = new Vector2(p1.x, p1.y), B = new Vector2(p2.x, p2.y); // copy without weird reference bugginess
 
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
 
            if (Math.abs(B.x - A.x) < 2 && Math.abs(B.y - A.y) < 2 || line.size() > maxSize) break; // if positions are the same stop
 
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
            frame = new RenderFrame("3D Renderer Project");
            Container pane = frame.getContentPane();
            pane.setLayout(new BorderLayout());

            renderPanel = new RenderPanel();

            pane.add(renderPanel, BorderLayout.CENTER);

            frame.setSize(600, 600);
            frame.setVisible(true);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private static boolean sameSide(Vector3 a, Vector3 b, Vector3 c, Vector2 s) {

        int as_x = (int)(s.x - a.x);
        int as_y = (int)(s.y - a.y);

        boolean s_ab = (b.x - a.x) * as_y - (b.y - a.y) * as_x > 0;

        if ((c.x - a.x) * as_y - (c.y - a.y) * as_x > 0 == s_ab) 
            return false;
        if ((c.x - b.x) * (s.y - b.y) - (c.y - b.y) * (s.x - b.x) > 0 != s_ab) 
            return false;
        return true;

        // return ((B.x - A.x) * (B.y - A.y) - (C.x - A.x) * (C.y - A.y)) * ((B.x - A.x) * (p.y - A.y) - (p.x - A.x) * (B.y - A.y)) >= 0;
    }

    private static Vector3 bary(Vector3 a, Vector3 b, Vector3 c, Vector2 p) {
        Vector2 v0 = new Vector2(b.x - a.x, b.y - a.y), v1 = new Vector2(c.x - a.x, c.y - a.y), v2 = new Vector2(p.x - a.x, p.y - a.y);

        float den = v0.x * v1.y - v1.x * v0.y;

        float v = (v2.x * v1.y - v1.x * v2.y) / den;
        float w = (v0.x * v2.y - v2.x * v0.y) / den;
        float u = 1.0f - v - w;

        return new Vector3(u, v, w);
    }
    // Compute barycentric coordinates (u, v, w) for
    // point p with respect to triangle (a, b, c)

}