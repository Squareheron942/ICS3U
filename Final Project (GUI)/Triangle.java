public class Triangle {
    Vertex[] vertices = new Vertex[3];
    Vector3 worldNormal = new Vector3();

    Triangle(Vertex[] vertices) {
        this.vertices = vertices;
        this.worldNormal = Vector3.normalize(Vector3.cross(Vector3.diff(vertices[1].worldPos, vertices[0].worldPos), Vector3.diff(vertices[2].worldPos, vertices[0].worldPos)));
    }

    Triangle(Vertex[] vertices, Vector3 normal) {
        this.vertices = vertices;
        this.worldNormal = normal;
    }

    @Override
    public String toString() {
        return "Triangle{" + vertices[0] + ", " + vertices[1] + ", " + vertices[2] + ", normal:" + worldNormal + "}";
    }
}
