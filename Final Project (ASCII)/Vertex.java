public class Vertex {
    public Vector3 normal;
    public Vector3 worldPos;
    public Color color;
    Vertex() {
        worldPos = new Vector3(0f, 0f, 0f);
        color = new Color(1, 1, 1);
    }

    Vertex(Vector3 position) {
        this.worldPos = position;
        color = new Color(1, 1, 1);
    }

    @Override
    public String toString() {
        return "{normal: " + normal.toString() + ", position: " + worldPos.toString() + ", color: " + color.toString() + "}";
    }
}
