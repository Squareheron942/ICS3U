public class Pixel {
    Color color;
    Vector3 worldNormal;
    Vector2 uv;
    Vector3 bary;
    Material mat;
    Vector2 fragCoord;
    boolean frontFacing;

    Pixel(Color color, Vector3 worldNormal, Vector2 uv, Vector3 bary, Material mat, Vector2 fragCoord, boolean frontFacing) {
        this.worldNormal = worldNormal;
        this.uv = uv;
        this.bary = bary;
        this.mat = mat;
        this.fragCoord = fragCoord;
        this.frontFacing = frontFacing;
        this.color = color;
    }

    Pixel() {}

    @Override
    public String toString() {
        return "{normal: " + worldNormal + "}";
    }
}
