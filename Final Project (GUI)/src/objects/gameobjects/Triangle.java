package objects.gameobjects;
import util.Vector3;

public class Triangle {
    public int vertices[] = new int[3];
    public Vector3 worldNormal = new Vector3();

    public Triangle(int[] vertices) {
        this.vertices = vertices;
        // this.worldNormal = Vector3.normalize(Vector3.cross(Vector3.diff(vertices[1].worldPos, vertices[0].worldPos), Vector3.diff(vertices[2].worldPos, vertices[0].worldPos)));
    }

    public Triangle(int[] vertices, Vector3 normal) {
        this.vertices = vertices;
        this.worldNormal = normal;
    }

    @Override
    public String toString() {
        return "Triangle{\n   vertices: [\n      " + vertices[0] + ",\n      " + vertices[1] + ",\n      " + vertices[2] + "\n   ],\n   normal: " + worldNormal + "\n},";
    }
}
