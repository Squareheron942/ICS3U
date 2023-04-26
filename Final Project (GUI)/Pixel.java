public class Pixel {
    Color color;
    Vector3 worldNormal;

    Pixel(Vector3 worldNormal, Color color) {
        this.color = color;
        this.worldNormal = worldNormal;
    }

    Pixel() {
        this.color = new Color(0, 0, 0);
        this.worldNormal = new Vector3(0, 0, 0);
    }

    @Override
    public String toString() {
        return "{normal: " + worldNormal + ", color: " + color + "}";
    }
}
