public class Vertex2D {
    Vector3 normal;
    Vector2 position;
    Color color;

    Vertex2D() {
        position = new Vector2(0f, 0f);
        color = new Color(1, 1, 1);
    }

    Vertex2D(Vector2 position) {
        this.position = position;
        color = new Color(1, 1, 1);
    }

    @Override
    public String toString() {
        return "{normal: " + normal.toString() + ", position: " + position.toString() + ", color: " + color.toString() + "}";
    }
}
