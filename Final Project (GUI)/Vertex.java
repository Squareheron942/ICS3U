public class Vertex {
    public Vector3 normal;
    public Vector3 worldPos;
    public Vector2 uv;
    public Color color;
    Vertex() {
        worldPos = new Vector3(0f, 0f, 0f);
        color = new Color(1, 1, 1);
        normal = new Vector3(0, 0, 0);
        uv = new Vector2(0, 0);
    }

    Vertex(Vector3 position) {
        this.worldPos = position;
        color = new Color(1, 1, 1);
        normal = new Vector3(0, 0, 0); // change to actually calculate
        uv = new Vector2(0, 0);
    }

    Vertex(Vector3 position, Color color) {
        this.worldPos = position;
        this.color = color;
        normal = new Vector3(0, 0, 0); // change to actually calculate
        uv = new Vector2(0, 0);
    }

    Vertex(Vector3 position, Color color, Vector2 uv) {
        this.worldPos = position;
        this.color = color;
        normal = new Vector3(0, 0, 0); // change to actually calculate
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "{\nnormal: " + normal.toString() + ", \nposition: " + worldPos.toString() + ", \ncolor: " + color.toString() + "\n}";
    }
}
