public class Triangle {
    Vertex[] vertices = new Vertex[3];
    Vertex2D[] vertices2D = new Vertex2D[3];
    Vector3 worldNormal = new Vector3();
    boolean _2d = false;
    Color color;

    Triangle(Vertex[] vertices) {
        this.color = new Color(0.5f, 0.5f, 0.5f);
        this.vertices = vertices;
        this.worldNormal = Vector3.cross(Vector3.diff(vertices[1].worldPos, vertices[0].worldPos), Vector3.diff(vertices[2].worldPos, vertices[0].worldPos));
    }

    Triangle(Vertex[] vertices, Color color) {
        this.color = color;
        this.vertices = vertices;
        this.worldNormal = Vector3.cross(Vector3.diff(vertices[1].worldPos, vertices[0].worldPos), Vector3.diff(vertices[2].worldPos, vertices[0].worldPos));
    }

    Triangle(Vertex2D[] vertices, Vector3 normal) {
        vertices2D = vertices;
        worldNormal = normal;
        _2d = true;
    }

    @Override
    public String toString() {
        return _2d ? "{\n" + vertices2D[0] + ", \n" + vertices2D[1] + ", \n" + vertices2D[2] + "\n}" : "{\n" + vertices[0] + ", \n" + vertices[1] + ", \n" + vertices[2] + "\n}";
    }
}
