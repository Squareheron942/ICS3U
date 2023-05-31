import java.util.HashMap;

public class Shader {
    // Pass[] passes;
    HashMap<String, String> tags = new HashMap<String, String>() {{
        put("RenderType", "Opaque");
    }};
    boolean zWrite = true;
    boolean zTest = true;
    

    // Shader(Pass[] passes, boolean[] attributes) {
    //     this.passes = passes;
    //     this.attributes = attributes;
    // }

    Vertex vert(Vertex i) {
        return i;
    }

    Color frag(Pixel i) {
        Vector3 sunDir = new Vector3(1, 1, 1);
        // return new Color(0xff00ff);
        // return i.mat._MainTex.get(i.uv);
        return i.color.mul(i.mat._MainTex.get(i.uv)).mul(Vector3.dot(Vector3.normalize(sunDir), Vector3.normalize(i.worldNormal)) / 2f + 0.5f);
    }
}