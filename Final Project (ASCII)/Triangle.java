public class Triangle {
    Vertex[] vertices = new Vertex[3];
    Vertex2D[] vertices2D = new Vertex2D[3];
    Vector3 worldNormal = new Vector3();
    Triangle(Vertex[] vertices) {
        this.vertices = vertices;
        this.worldNormal = Vector3.cross(Vector3.diff(vertices[1].worldPos, vertices[0].worldPos), Vector3.diff(vertices[2].worldPos, vertices[0].worldPos));
    }

    Triangle(Vertex2D[] vertices, Vector3 normal) {
        vertices2D = vertices;
        worldNormal = normal;
    }
}
