import java.util.Arrays;

public class Mesh {
    Triangle[] tris;
    Vertex[] vertices;

    Mesh(Triangle[] tris) {
        this.tris = tris;
    }

    @Override public String toString() {
        String o = "{";
        for (Triangle t : tris) {
            o += "  " + t + ",\n";
        }
        o += "},";
        return o;
    }
}
