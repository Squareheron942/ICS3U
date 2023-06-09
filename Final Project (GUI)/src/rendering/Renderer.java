package rendering;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;

import javax.swing.*;

import objects.gameobjects.GameObject;
import objects.gameobjects.Line;
import objects.gameobjects.Triangle;
import rendering.cameras.Camera;
import rendering.graphics.Material;
import rendering.graphics.Shader;
import util.Color;
import util.Vector2;
import util.Vector3;
import util.Vertex;

public class Renderer {
    private static boolean debug = false;
    public static int renderMode = 0;
    public static RenderFrame frame;
    private static RenderPanel renderPanel = new RenderPanel();
    private static float[][] zbuf; 
    public static Camera _cam = new Camera(new Vector3(0, 0, 200), new Vector3(), 1, 1000);
    public static Scene _scene = null;
    public static Color[][] render(Scene scene, Camera cam) {
        cam.updateMatrix(new Vector2(renderPanel.img.getWidth(), renderPanel.img.getHeight()));
        _cam.matrix = cam.matrix;
        _cam.setPosition(cam.position());
        _cam.setRotation(cam.rotation());
        _scene = scene;
        // project to 2D
        // GameObject[] objects = new GameObject[scene.children.size()];
        // for (int i = 0; i < scene.children.size(); i++) {
        //     Triangle[] tris = new Triangle[scene.children.get(i).mesh.tris.length];
        //     for (int j = 0; j < tris.length; j++) {
        //         Triangle t = project2D(scene.children.get(i).mesh.tris[j], cam);
        //         if (t.vertices[0].worldPos.z < 0 && t.vertices[1].worldPos.z < 0 && t.vertices[2].worldPos.z < 0) {
        //             tris[j] = t;
        //         } else tris[j] = null;
        //     }
        //     GameObject object = new GameObject(new Mesh(tris), scene.children.get(i).mats);
        //     objects[i] = object;
        // }

        // rasterize into pixels
        Color[][] fbuf = new Color[renderPanel.img.getWidth()][renderPanel.img.getHeight()];
        zbuf = new float[renderPanel.img.getWidth()][renderPanel.img.getHeight()];

        for (Color[] row: fbuf) Arrays.fill(row, new Color(0x8080ff));
        for (float[] row : zbuf) Arrays.fill(row, 0.0f);

        for (GameObject object : scene.children) {
            Vertex verts[] = new Vertex[object.mesh.vertices.length];
            for (Material m : object.mats) {
                for (int i = 0; i < verts.length; i++) verts[i] = m.shader().vert(object.mesh.vertices[i]);
                for (Triangle t : object.mesh.tris) {
                    if (m == null) {m = new Material();} 
                    Vertex v1 = verts[t.vertices[0]];
                    Vertex v2 = verts[t.vertices[1]];
                    Vertex v3 = verts[t.vertices[2]];

                    final int x1 = Math.round(16f * v1.worldPos.x);
                    final int x2 = Math.round(16f * v2.worldPos.x);
                    final int x3 = Math.round(16f * v3.worldPos.x);

                    final int y1 = Math.round(16f * v1.worldPos.y);
                    final int y2 = Math.round(16f * v2.worldPos.y);
                    final int y3 = Math.round(16f * v3.worldPos.y);

                    boolean cv1 = v1.worldPos.x > renderPanel.img.getWidth() || v1.worldPos.x < -renderPanel.img.getWidth() || v1.worldPos.y > fbuf.length || v1.worldPos.y < -fbuf.length;
                    boolean cv2 = v2.worldPos.x > renderPanel.img.getWidth() || v2.worldPos.x < -renderPanel.img.getWidth() || v2.worldPos.y > fbuf.length || v2.worldPos.y < -fbuf.length;
                    boolean cv3 = v3.worldPos.x > renderPanel.img.getWidth() || v3.worldPos.x < -renderPanel.img.getWidth() || v3.worldPos.y > fbuf.length || v3.worldPos.y < -fbuf.length;

                    if (!(v1.worldPos.z < 0 && v2.worldPos.z < 0 && v3.worldPos.z < 0) || (cv1 && cv2 && cv3)) continue; // skip culled triangles
    
                    Vector3 invZ = new Vector3(1 / v1.worldPos.z, 1 / v2.worldPos.z, 1 / v3.worldPos.z);
    
                    final int minX = (int) Math.round(Math.max(-renderPanel.img.getWidth(), Math.ceil(Math.min(x1 >> 4, Math.min(x2 >> 4, x3 >> 4)))));
                    final int maxX = (int) Math.round(Math.min(renderPanel.img.getWidth() >> 1 - 1, Math.floor(Math.max(x1 >> 4, Math.max(x2 >> 4, x3 >> 4)))));
                    final int minY = (int) Math.round(Math.max(-renderPanel.img.getHeight(), Math.ceil(Math.min(y1 >> 4, Math.min(y2 >> 4, y3 >> 4)))));
                    final int maxY = (int) Math.round(Math.min(renderPanel.img.getHeight() >> 1 - 1, Math.floor(Math.max(y1 >> 4, Math.max(y2 >> 4, y3 >> 4)))));
    
                    final int Dx12 = x1 - x2;
                    final int Dx23 = x2 - x3;
                    final int Dx31 = x3 - x1;

                    final int Dy12 = y1 - y2;
                    final int Dy23 = y2 - y3;
                    final int Dy31 = y3 - y1;

                    final int FDx12 = Dx12 << 4;
                    final int FDx23 = Dx23 << 4;
                    final int FDx31 = Dx31 << 4;

                    final int FDy12 = Dy12 << 4;
                    final int FDy23 = Dy23 << 4;
                    final int FDy31 = Dy31 << 4;

                    int C1 = Dy12 * x1 - Dx12 * y1;
                    int C2 = Dy23 * x2 - Dx23 * y2;
                    int C3 = Dy31 * x3 - Dx31 * y3;

                    if(Dy12 < 0 || (Dy12 == 0 && Dx12 > 0)) C1++;
                    if(Dy23 < 0 || (Dy23 == 0 && Dx23 > 0)) C2++;
                    if(Dy31 < 0 || (Dy31 == 0 && Dx31 > 0)) C3++;

                    int Cy1 = C1 + Dx12 * (minY << 4) - Dy12 * (minX <<4);
                    int Cy2 = C2 + Dx23 * (minY << 4) - Dy23 * (minX << 4);
                    int Cy3 = C3 + Dx31 * (minY << 4) - Dy31 * (minX << 4);

                    // Vector2 origin = new Vector2(minX, minY);
                    // Edge e01 = new Edge(), e12 = new Edge(), e20 = new Edge();
                    // IntVector w0_row = e12.init(v2.worldPos, v3.worldPos, origin);
                    // IntVector  w1_row = e20.init(v3.worldPos, v1.worldPos, origin);
                    // IntVector w2_row = e01.init(v1.worldPos, v2.worldPos, origin);

                    float invz1 = 1 / v1.worldPos.z;
                    float invz2 = 1 / v2.worldPos.z;
                    float invz3 = 1 / v3.worldPos.z;


                    for (int y = minY; y <= maxY; y++) {

                        // IntVector w0 = w0_row;
                        // IntVector w1 = w1_row;
                        // IntVector w2 = w2_row;

                        // Start value for horizontal scan
                        float Cx1 = Cy1;
                        float Cx2 = Cy2;
                        float Cx3 = Cy3;

                        for (int x = minX; x <= maxX; x++) {
                            // int mask[] = w0.lanewise(VectorOperators.OR, w1.lanewise(VectorOperators.OR, w2)).toArray();

                            boolean frontFace = Cx1 < 0 && Cx2 < 0 && Cx3 < 0;
                            boolean backFace = Cx1 > 0 && Cx2 > 0 && Cx3 > 0;
                            // 
                            
                            
                            // for (int i = 0; i < mask.length; i++) {
                            //     int in = mask[i];
                                if (m.shader == null ? frontFace || backFace : m.cull == Culling.Back ? frontFace : m.cull == Culling.Front ? backFace : (backFace || frontFace)) {
                                    try {
                                        Vector2 p = new Vector2(x,y);
                                        Vector3 bary = persp_bary(v1.worldPos, v2.worldPos, v3.worldPos, p, invZ);
                                        float zVal = 1 - ((cam.nearClip - 1 / (bary.x * invz1 + bary.y * invz2 + bary.z * invz3)) / (cam.farClip - cam.nearClip));
                                        Color o = null;
    
                                        if (zVal <= 1 && zVal >= 0) { // ignore if outside of camera view
                                            if (m.shader() != null) { // if no shader then make magenta
                                                if (!m.zTest || (m.zTest && zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] < zVal)) {
                                                    Vector2 uv = new Vector2((bary.x * v1.uv.x + bary.y * v2.uv.x + bary.z * v3.uv.x) % 1, (bary.x * v1.uv.y + bary.y * v2.uv.y + bary.z * v3.uv.y) % 1);
                                                    Vector3 normal = m.shadeSmooth ? new Vector3(bary.x * v1.normal.x + bary.y * v2.normal.x + bary.z * v3.normal.x, bary.x * v1.normal.y + bary.y * v2.normal.y + bary.z * v3.normal.y, bary.x * v1.normal.z + bary.y * v2.normal.z + bary.z * v3.normal.z) : t.worldNormal;
                                                    switch (renderMode) {
                                                        case 0: // regular shading
                                                            // Math.fma(bary.x, v1.color.r, Math.fma(bary.y, v2.color.r, Math.fma(bary.z, v3.color.r, 0)))
                                                            Color c = m.shader().frag(
                                                                new Pixel(
                                                                    new Color(Math.fma(bary.x, v1.color.r, Math.fma(bary.y, v2.color.r, Math.fma(bary.z, v3.color.r, 0))), Math.fma(bary.x, v1.color.g, Math.fma(bary.y, v2.color.g, Math.fma(bary.z, v3.color.g, 0))), Math.fma(bary.x, v1.color.b, Math.fma(bary.y, v2.color.b, Math.fma(bary.z, v3.color.b, 0)))), 
                                                                    normal, 
                                                                    uv, 
                                                                    bary, 
                                                                    m, 
                                                                    p, 
                                                                    true
                                                                ));
                                                            o = m.tags.get("RenderType").equals("Transparent") ? Color.lerp(fbuf[x + renderPanel.img.getWidth() >> 1][-y + renderPanel.img.getHeight() >> 1], c, c.a) : 
                                                                m.tags.get("RenderType").equals("TransparentCutout") ? Color.lerp(fbuf[x + renderPanel.img.getWidth() >> 1][-y + renderPanel.img.getHeight() >> 1], c, (int)(c.a)) : 
                                                                c;
                                                            // o = new Color();
                                                            break;
                                                        case 1: // depth buffer
                                                            o = new Color(zVal, zVal, zVal);
                                                            break;
                                                        case 2: // barycentric coords
                                                            o = new Color(bary.x, bary.y, bary.z);
                                                            break;
                                                        case 3: // uv coords
                                                            o = new Color();
                                                            break;
                                                        case 4: // normals
                                                            o = new Color(normal.x * 0.5f + 0.5f, normal.y * 0.5f + 0.5f, normal.z * 0.5f + 0.5f);
                                                            break;
                                                    }
                                                    fbuf[x + renderPanel.img.getWidth() >> 1][-y + renderPanel.img.getHeight() >> 1] = new Color(Math.min(o.r, 1), Math.min(o.g, 1), Math.min(o.b, 1));
                                                    if (m.zWrite) zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] = zVal;
                                                }
                                            } else {
                                                if (zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] < zVal) {
                                                    fbuf[x + renderPanel.img.getWidth() >> 1][-y + renderPanel.img.getHeight() >> 1] = new Color(0xff00ff);
                                                    zbuf[x + renderPanel.img.getWidth() >> 1][y + renderPanel.img.getHeight() >> 1] = zVal;
                                                }
                                            }
                                        }
                                    } catch (Exception e) {}
                                // }
                            }
                            // w0.add(e12.oneStepX);
                            // w1.add(e20.oneStepX);
                            // w2.add(e01.oneStepX);
                            Cx1 -= FDy12;
                            Cx2 -= FDy23;
                            Cx3 -= FDy31;
                        }
                        // w0_row.add(e12.oneStepY);
                        // w1_row.add(e20.oneStepY);
                        // w2_row.add(e01.oneStepY);
                        Cy1 += FDx12;
                        Cy2 += FDx23;
                        Cy3 += FDx31;
                    }
                    if (debug) {
                        List<Vector2> a = findLine(v1.worldPos, v2.worldPos);
                        List<Vector2> b = findLine(v2.worldPos, v3.worldPos);
                        List<Vector2> c = findLine(v3.worldPos, v1.worldPos);

                        try {
                            for (int k = 0; k < a.size(); k++) {
                                fbuf[(int)a.get(k).x + renderPanel.img.getWidth() >> 1][(int)-a.get(k).y + renderPanel.img.getHeight() >> 1] = new Color();
                            }
                        } catch (Exception e) {} 
                        try {
                            for (int k = 0; k < b.size(); k++) {                    
                                fbuf[(int)b.get(k).x + renderPanel.img.getWidth() >> 1][(int)-b.get(k).y + renderPanel.img.getHeight() >> 1] = new Color();
                            }
                        } catch (Exception e) {} 
                        try {
                            for (int k = 0; k < c.size(); k++) {
                                fbuf[(int)c.get(k).x + renderPanel.img.getWidth() >> 1][(int)-c.get(k).y + renderPanel.img.getHeight() >> 1] = new Color();
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }

        for (Line l : scene.lines) {
            int i = 0;
            //TODO Add line code here
            for (Vertex v : l.points) {
                if (i + 1 < l.points.length) { // if there is another point ahead
                    i++;
                    // get point positions 
                    Vertex v1 = Shader.ObjectToClipPos(v);
                    Vertex v2 = Shader.ObjectToClipPos(l.points[i]);

                    boolean cv1 = v1.worldPos.x > renderPanel.img.getWidth() || v1.worldPos.x < -renderPanel.img.getWidth() || v1.worldPos.y > fbuf.length || v1.worldPos.y < -fbuf.length;
                    boolean cv2 = v2.worldPos.x > renderPanel.img.getWidth() || v2.worldPos.x < -renderPanel.img.getWidth() || v2.worldPos.y > fbuf.length || v2.worldPos.y < -fbuf.length;
                    if ((cv1 && cv2) || !(v1.worldPos.z < 0 && v1.worldPos.z < 0)) continue;
                    int j = 0;
                    List<Vector2> vs = findLine(v1.worldPos, v2.worldPos);
                    for (Vector2 p : vs) {try {fbuf[(int)p.x + renderPanel.img.getWidth() >> 1][(int)-p.y + renderPanel.img.getHeight() >> 1] = Color.lerp(v1.color, v2.color, j / (float)vs.size());} catch (Exception e) {};j++;}
                }
            }
        }
        
        return fbuf;
    }

    public static void draw(Color[][] fbuf) {
        for (int u = 0; u < fbuf.length; u++) {
            for (int v = 0; v < fbuf[0].length; v++) {
                try {
                    renderPanel.img.setRGB(u, v, new java.awt.Color(fbuf[u][v].r, fbuf[u][v].g, fbuf[u][v].b).getRGB());
                } catch (Exception e) {}
            }
        }
        frame.repaint();
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

            frame.setSize(150, 150);
            frame.setVisible(true);
            frame.setResizable(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // private static Vector3 bary(Vector3 a, Vector3 b, Vector3 c, Vector2 p) {
    //     Vector2 v0 = new Vector2(b.x - a.x, b.y - a.y), v1 = new Vector2(c.x - a.x, c.y - a.y), v2 = new Vector2(p.x - a.x, p.y - a.y);

    //     float den = v0.x * v1.y - v1.x * v0.y;

    //     float v = (v2.x * v1.y - v1.x * v2.y) / den;
    //     float w = (v0.x * v2.y - v2.x * v0.y) / den;
    //     float u = 1.0f - v - w;

    //     return new Vector3(u, v, w);
    // }
    // Compute barycentric coordinates (u, v, w) for
    // point p with respect to triangle (a, b, c)

    private static Vector3 persp_bary(Vector3 a, Vector3 b, Vector3 c, Vector2 p, Vector3 invZ) {
        Vector2 v0 = new Vector2(b.x - a.x, b.y - a.y), v1 = new Vector2(c.x - a.x, c.y - a.y), v2 = new Vector2(p.x - a.x, p.y - a.y);

        float den = v0.x * v1.y - v1.x * v0.y;

        float v = (v2.x * v1.y - v1.x * v2.y) / den;
        float w = (v0.x * v2.y - v2.x * v0.y) / den;
        float u = 1.0f - v - w;

        //TODO optimize this
        float _u = u * invZ.x, _v = v * invZ.y, _w = w * invZ.z;
        return Vector3.mul(new Vector3(_u, _v, _w), 1 / (_u + _v + _w));
    }


}

// class Edge {
//     static final int stepXSize = 4;
//     static final int stepYSize = 1;

//     IntVector oneStepX = null;
//     IntVector oneStepY = null;

//     IntVector init(final Vector3 v0, final Vector3 v1, final Vector2 origin) {
//         int A = (int)(v0.y - v1.y), B = (int)(v1.x - v0.x);
//         int C = (int)(v0.x * v1.y - v0.y * v1.x);

//         IntVector x = IntVector.fromArray(IntVector.SPECIES_128, new int[] {(int)origin.x, (int)origin.x, (int)origin.x, (int)origin.x}, 0).add(IntVector.fromArray(IntVector.SPECIES_128, new int[] {0, 1, 2, 3}, 0));
//         IntVector y = IntVector.fromArray(IntVector.SPECIES_128, new int[] {(int)origin.y, (int)origin.y, (int)origin.y, (int)origin.y}, 0);
        


//         return IntVector.fromArray(IntVector.SPECIES_128, new int[] {A, A, A, A}, 0).mul(x).add(IntVector.fromArray(IntVector.SPECIES_128, new int[] {B, B, B, B}, 0).mul(y)).add(IntVector.fromArray(IntVector.SPECIES_128, new int[] {C, C, C, C}, 0));

//     }
// }