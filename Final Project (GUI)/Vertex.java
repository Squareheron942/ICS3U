public class Vertex {
    public Vector3 normal;
    public Vector3 worldPos;
    public Color color;
    Vertex() {
        worldPos = new Vector3(0f, 0f, 0f);
        color = new Color(1, 1, 1);
        normal = new Vector3(0, 0, 0);
    }

    Vertex(Vector3 position) {
        this.worldPos = position;
        color = new Color(1, 1, 1);
        normal = new Vector3(0, 0, 0); // change to actually calculate
    }

    Vertex(Vector3 position, Color color) {
        this.worldPos = position;
        this.color = color;
        normal = new Vector3(0, 0, 0); // change to actually calculate
    }

    @Override
    public String toString() {
        return "{\nnormal: " + normal.toString() + ", \nposition: " + worldPos.toString() + ", \ncolor: " + color.toString() + "\n}";
    }
}
