import java.util.Arrays;

public class Mesh {
    Triangle[] tris;
    Vertex[] vertices;

    Mesh(Triangle[] tris) {
        this.tris = tris;
    }

    @Override public String toString() {
        return Arrays.deepToString(tris);
    }
}
