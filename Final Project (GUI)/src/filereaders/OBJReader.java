package filereaders;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import objects.gameobjects.GameObject;
import objects.gameobjects.Mesh;
import objects.gameobjects.Triangle;
import rendering.Culling;
import rendering.Pixel;
import rendering.graphics.Material;
import rendering.graphics.Shader;
import rendering.graphics.Texture;
import util.Color;
import util.Vector2;
import util.Vector3;
import util.Vertex;

import java.io.FileNotFoundException;
import java.util.List;

public class OBJReader {
    public static GameObject[] read(File fl, Vector3 scale) {
        List<GameObject> objects = new ArrayList<>();
        Material mat = null;
        Material out_mat = new Material();
        List<Vector3> v = new ArrayList<>(); // all vertex positions in model
        List<Vector2> vt = new ArrayList<>(); // all uv coords in model
        List<Vector3> vn = new ArrayList<>(); // all vertex normals in model
        List<Triangle> f = new ArrayList<>(); // all faces in object
        List<Vertex> ov = new ArrayList<>(); // all vertices in object
        HashMap<String, Material> mtllib = new HashMap<>();
        boolean wasLastFace = false, createNewObject = true;
        long tris = 0, vertices = 0, totalTris = 0, totalVertices = 0;
        int numobjects = 0;
        String name = null;
        try {
            Scanner s = new Scanner(fl);
            while (s.hasNextLine()) {
                String l = s.nextLine();
                if (l.length() == 0) continue; // ignore empty lines
                switch (l.charAt(0)) {
                    case 'o': // object name
                        name = l.substring(2);
                        break;
                    case 'm': // mtllib path
                        // create hashmap of materials and properties
                        boolean fmat = true;
                        String matName = "";
                        try {
                            File fm = new File(fl.getAbsoluteFile().getParent() + '/' + l.substring(7));
                            System.out.println(fm);
                            Scanner sm = new Scanner(fm);
                            Color m_Ka = null, m_Kd = null, m_Ks = null, m_Ke = null;
                            Texture map_Kd = null, map_Ke = null;
                            while (sm.hasNextLine()) {
                                String L = sm.nextLine();
                                switch (L.split(" ")[0]) {
                                    case "newmtl":
                                        if (fmat) fmat = false;
                                        else {
                                            final Color mat_Kd = m_Kd, mat_Ks = m_Ks;
                                            final Texture mat_map_Kd = map_Kd;
                                            final String m_name = matName;
                                            mat = new Material() {
                                                boolean zWrite = true;
                                                boolean zTest = true;
                                                boolean shadeSmooth = true;
                                                Culling cull = Culling.Back;
                                                Color Kd = mat_Kd, Ks = mat_Ks;
                                                Texture map_Kd = mat_map_Kd;
                                                String name = m_name;
                                                Shader shader = new Shader() {
                                                    String name = "OBJDefaultShader";
                                                    @Override
                                                    public Vertex vert(Vertex i) {
                                                        // TODO Auto-generated method stub
                                                        i.color = Kd;
                                                        return Shader.ObjectToClipPos(i);
                                                    }
                                                    @Override
                                                    public Color frag(Pixel i) {
                                                        // TODO Auto-generated method stub
                                                        return i.color.mul(Shader.tex2D(map_Kd, i.uv));//.mul(Vector3.dot(Vector3.normalize(Shader.getMainLightDirection()), i.worldNormal) * 0.5f + 0.5f);
                                                    }
                                                    @Override public String toString() {
                                                        return "Shader " + name;
                                                    }
                                                };

                                                @Override public Shader shader() {
                                                    return shader;
                                                }

                                                @Override public String toString() {
                                                    return "Material{name: " + name + ", Kd: " + Kd + ", shader: " + shader + ", color: " + Kd +"}";
                                                }
                                            };
                                            // System.out.println(mat.shader);
                                            System.out.println("Created material " + matName);
                                            mtllib.put(matName, mat);
                                        }
                                        matName = L.substring(7);
                                        break;
                                    case "Ka":
                                        m_Ka = new Color(Float.parseFloat(L.split(" ")[1]), Float.parseFloat(L.split(" ")[2]), Float.parseFloat(L.split(" ")[3]));
                                        break;
                                    case "Kd":
                                        m_Kd = new Color(Float.parseFloat(L.split(" ")[1]), Float.parseFloat(L.split(" ")[2]), Float.parseFloat(L.split(" ")[3]));
                                        break;
                                    case "Ks":
                                        m_Ks = new Color(Float.parseFloat(L.split(" ")[1]), Float.parseFloat(L.split(" ")[2]), Float.parseFloat(L.split(" ")[3]));
                                        break;
                                    case "Ke":
                                        m_Ke = new Color(Float.parseFloat(L.split(" ")[1]), Float.parseFloat(L.split(" ")[2]), Float.parseFloat(L.split(" ")[3]));
                                        break;
                                    case "d":
                                        float a = Float.parseFloat(L.split(" ")[1]);
                                        m_Kd.a = a;
                                        m_Ks.a = a;
                                        m_Ka.a = a;
                                        m_Ke.a = a;
                                        break;
                                    case "map_Kd":
                                        map_Kd = new Texture(new File(L.split(" ")[1]));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            final Color mat_Kd = m_Kd, mat_Ks = m_Ks;
                            final Texture mat_map_Kd = map_Kd;
                            final String m_Name = matName;
                            mat = new Material() {
                                String name = m_Name;
                                boolean zWrite = true;
                                boolean zTest = true;
                                boolean shadeSmooth = true;
                                Culling cull = Culling.Back;
                                Color Kd = mat_Kd, Ks = mat_Ks;
                                Texture map_Kd = mat_map_Kd;
                                Shader shader = new Shader() {
                                    String name = "OBJDefaultShader";
                                    Culling cull = Culling.Back;
                                    @Override
                                    public Vertex vert(Vertex i) {
                                        // TODO Auto-generated method stub
                                        i.color = Kd;
                                        return Shader.ObjectToClipPos(i);
                                    }
                                    @Override
                                    public Color frag(Pixel i) {
                                        // TODO Auto-generated method stub
                                        return i.color.mul(Shader.tex2D(map_Kd, i.uv)).mul(Vector3.dot(Vector3.normalize(Shader.getMainLightDirection()), i.worldNormal) * 0.5f + 0.5f);
                                    }
                                    @Override public String toString() {
                                        return "Shader{" + name + "}";
                                    }
                                };

                                @Override public String name() {
                                    return this.name;
                                }

                                @Override public Shader shader() {
                                    return shader;
                                }

                                @Override public String toString() {
                                    return "Material{name: " + name + ", shader: " + shader + "}";
                                }
                            };
                            // System.out.println(mat.shader);
                            System.out.println("Created material " + matName);
                            mtllib.put(matName, mat);
                            sm.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Could not find material lib:" + l.substring(6));
                        }
                        break;
                    case 'v': // vertex info
                        // if object ended (new vertices being declared instead of )
                        if (wasLastFace) {
                            objects.add(new GameObject(new Mesh(ov.toArray(new Vertex[ov.size()]), f.toArray(new Triangle[f.size()])), out_mat));
                            totalTris += tris;
                            totalVertices += vertices;
                            numobjects++;
                            tris = 0;
                            vertices = 0;
                            
                            
                            f = new ArrayList<Triangle>();
                        }
                        wasLastFace = false;
                        switch (l.charAt(1)) {
                            case ' ': // vertex position
                                v.add(new Vector3(Float.parseFloat(l.split(" ")[1]) * scale.x, Float.parseFloat(l.split(" ")[2]) * scale.y, Float.parseFloat(l.split(" ")[3]) * scale.z));
                                break;
                            case 't': // uv coords
                                vt.add(new Vector2(Float.parseFloat(l.split(" ")[1]), Float.parseFloat(l.split(" ")[2])));
                                break;
                            case 'n': // normals
                                vn.add(Vector3.normalize(new Vector3(Float.parseFloat(l.split(" ")[1]), Float.parseFloat(l.split(" ")[2]), Float.parseFloat(l.split(" ")[3]))));
                                break;
                        }
                        vertices++;
                        break;
                    case 'f': // triangle
                        if (createNewObject) {
                            objects.add(new GameObject(new Mesh(ov.toArray(new Vertex[ov.size()]), f.toArray(new Triangle[f.size()])), out_mat));
                            System.out.println("with " + tris + " tris and " + vertices + " vertices");
                            totalTris += tris;
                            totalVertices += vertices;
                            numobjects++;
                            tris = 0;
                            vertices = 0;
                            
                            
                            f = new ArrayList<Triangle>();
                            createNewObject = false;
                        } else {
                            String[] s1 = null, s2 = null, s3 = null;
                            try {
                                s1 = l.split(" ")[1].split("/");
                                s2 = l.split(" ")[2].split("/");
                                s3 = l.split(" ")[3].split("/");
                            } catch (Exception e) {
                                System.out.println(l);
                            }
                            
                            Vertex v1 = new Vertex(v.get(Integer.parseInt(s1[0]) - 1), new Color(), (s1.length == 1 || s1[1].equals("")) ? new Vector2() : vt.get(Integer.parseInt(s1[1]) - 1), (s1.length == 1 || s1[1].equals("")) ? new Vector3() : vn.get(Integer.parseInt(s1[2]) - 1));
                            Vertex v2 = new Vertex(v.get(Integer.parseInt(s2[0]) - 1), new Color(), (s2.length == 1 || s2[1].equals("")) ? new Vector2() : vt.get(Integer.parseInt(s2[1]) - 1), (s1.length == 1 || s2[1].equals("")) ? new Vector3() : vn.get(Integer.parseInt(s2[2]) - 1));
                            Vertex v3 = new Vertex(v.get(Integer.parseInt(s3[0]) - 1), new Color(), (s3.length == 1 || s3[1].equals("")) ? new Vector2() : vt.get(Integer.parseInt(s3[1]) - 1), (s1.length == 1 || s3[1].equals("")) ? new Vector3() : vn.get(Integer.parseInt(s3[2]) - 1));

                            
                            if (!ov.stream().anyMatch(o -> v1.equals(o))) ov.add(v1);
                            if (!ov.stream().anyMatch(o -> v2.equals(o))) ov.add(v2);
                            if (!ov.stream().anyMatch(o -> v3.equals(o))) ov.add(v3);

                            int v1i = ov.indexOf(v1);
                            int v2i = ov.indexOf(v2);
                            int v3i = ov.indexOf(v3);
    
                            f.add(new Triangle(new int[] {v1i, v2i, v3i}));
                            wasLastFace = true;
                            tris++;
                        }
                        break;
                    case 'g': // new polygon group (object)
                        System.out.print("Loaded polygon group " + l.substring(2) + " ");
                        tris = 0;
                        break;
                    case 'u': // usemtl
                        /*
                         * Set current material to one in material lib
                         */
                        out_mat = null;
                        createNewObject = true; // basically just says a new object is going to be made
                        out_mat = mtllib.get(l.substring(7));
                        System.out.println(l.substring(7) + " " + out_mat);
                        System.out.println((out_mat == null) ? "\033[0;91m" + "[!!!] Could not find material " + l.substring(7) + "\033[0m" : "Using material " + l.substring(7));
                        break;
                    default: // skip other stuff like comments
                        break;
                }
            }
            s.close();
            objects.add(new GameObject(new Mesh(ov.toArray(new Vertex[ov.size()]), f.toArray(new Triangle[f.size()])), out_mat));
            System.out.println("Loaded model \"" + name + "\" with " + numobjects + " objects " + Math.max(tris, totalTris) + " tris and " + Math.max(vertices, totalVertices) + " vertices.");

        } catch (FileNotFoundException e) {
            System.out.println("\033[0;91m" + "[!!!] Could not find file " + fl + "\033[0m");
        };
        return objects.toArray(new GameObject[objects.size()]);
    }


    <T> int indexOf(T[] arr, T val) {
        for (int i = 0; i < arr.length; i++) if (val.equals(arr[i])) return i;
        return -1;
    }
}