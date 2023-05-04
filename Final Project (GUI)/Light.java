public class Light {
    public boolean isLight = true;

    protected Color color;
    protected Vector3 position;

    Light(Vector3 position, Color color) {
        this.position = position;
        this.color = color;
    }

    public void setColor(Color color) { this.color = color; }
    public Color color() { return color; }
}