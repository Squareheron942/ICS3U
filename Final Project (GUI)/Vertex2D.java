public class Vertex2D {
    Vector3 normal = new Vector3(0, 0, 0);
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

    Vertex2D(Vector2 position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public String toString() {
        return "{\nnormal: " + normal.toString() + ", \nposition: " + position.toString() + ", \ncolor: " + color.toString() + "\n}";
    }
}
