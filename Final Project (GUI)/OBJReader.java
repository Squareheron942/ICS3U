import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.List;

public class OBJReader {
    static GameObject read(File fl, Vector3 scale) {
        Material mat = new Material(new Texture(new File("textures/cube.png")), new Color());
        List<Vector3> v = new ArrayList<Vector3>();
        List<Vector2> vt = new ArrayList<Vector2>();
        List<Vector3> vn = new ArrayList<Vector3>();
        List<Triangle> f = new ArrayList<Triangle>();
        try {
            Scanner s = new Scanner(fl);
            while (s.hasNextLine()) {
                String l = s.nextLine();
                if (l.length() == 0) continue; // ignore empty lines
                switch (l.charAt(0)) {
                    case 'm': // mtl path
                        break;
                    case 'v': // vertex info
                        switch (l.charAt(1)) {
                            case ' ': // vertex position
                                v.add(new Vector3(Float.parseFloat(l.split(" ")[1]) * scale.x, Float.parseFloat(l.split(" ")[2]) * scale.y, Float.parseFloat(l.split(" ")[3]) * scale.z));
                                break;
                            case 't': // uv coords
                                vt.add(new Vector2(Float.parseFloat(l.split(" ")[1]), Float.parseFloat(l.split(" ")[2])));
                                break;
                            case 'n': // normals
                                vn.add(new Vector3(Float.parseFloat(l.split(" ")[1]), Float.parseFloat(l.split(" ")[2]), Float.parseFloat(l.split(" ")[3])));
                                break;
                        }
                        break;
                    case 'f': // triangle
                        String[] s1 = l.split(" ")[1].split("/");
                        String[] s2 = l.split(" ")[2].split("/");
                        String[] s3 = l.split(" ")[3].split("/");
                        
                        Vertex v1 = new Vertex(new Vector3(v.get(Integer.parseInt(s1[0]) - 1).x, v.get(Integer.parseInt(s1[0]) - 1).y, v.get(Integer.parseInt(s1[0]) - 1).z), new Color(), new Vector2(vt.get(Integer.parseInt(s1[1]) - 1).x, vt.get(Integer.parseInt(s1[2]) - 1).y), new Vector3(vn.get(Integer.parseInt(s1[2]) - 1).x, vn.get(Integer.parseInt(s1[2]) - 1).y, vn.get(Integer.parseInt(s1[2]) - 1).z));
                        Vertex v2 = new Vertex(new Vector3(v.get(Integer.parseInt(s2[0]) - 1).x, v.get(Integer.parseInt(s2[0]) - 1).y, v.get(Integer.parseInt(s2[0]) - 1).z), new Color(), new Vector2(vt.get(Integer.parseInt(s2[1]) - 1).x, vt.get(Integer.parseInt(s2[2]) - 1).y), new Vector3(vn.get(Integer.parseInt(s2[2]) - 1).x, vn.get(Integer.parseInt(s2[2]) - 1).y, vn.get(Integer.parseInt(s2[2]) - 1).z));
                        Vertex v3 = new Vertex(new Vector3(v.get(Integer.parseInt(s3[0]) - 1).x, v.get(Integer.parseInt(s3[0]) - 1).y, v.get(Integer.parseInt(s3[0]) - 1).z), new Color(), new Vector2(vt.get(Integer.parseInt(s3[1]) - 1).x, vt.get(Integer.parseInt(s3[2]) - 1).y), new Vector3(vn.get(Integer.parseInt(s3[2]) - 1).x, vn.get(Integer.parseInt(s3[2]) - 1).y, vn.get(Integer.parseInt(s3[2]) - 1).z));

                        f.add(new Triangle(new Vertex[] {v1, v2, v3}));
                        break;
                    default: // skip other stuff like comments
                        break;
                }
            }
            s.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };
        return new GameObject(new Mesh(f.toArray(new Triangle[f.size()])), mat);
    }
}
