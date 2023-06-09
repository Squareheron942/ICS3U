package objects.gameobjects;

import util.Vertex;

public class Mesh {
    public Triangle[] tris;
    public Vertex[] vertices;

    public Mesh(Vertex vertices[], Triangle[] tris) {
        this.vertices = vertices;
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
