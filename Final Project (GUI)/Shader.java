public class Shader {
    Pass[] passes;
    boolean[] attributes = {
        // RenderMode = ["Opaque" | "Transparent" | "TransparentCutout"]
        // 
        // 
        // 
        // 
    };
    boolean zWrite = true;
    

    Shader(Pass[] passes, boolean[] attributes) {
        this.passes = passes;
        this.attributes = attributes;
    }

    Vertex vShader(Vertex v) {

        return v;
    }
}