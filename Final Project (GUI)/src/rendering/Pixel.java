package rendering;
import rendering.graphics.Material;
import util.Color;
import util.Vector2;
import util.Vector3;

public class Pixel {
    public Color color;
    public Vector3 worldNormal;
    public Vector2 uv;
    public Vector3 bary;
    public Material mat;
    public Vector2 fragCoord;
    public boolean frontFacing;

    public Pixel(Color color, Vector3 worldNormal, Vector2 uv, Vector3 bary, Material mat, Vector2 fragCoord, boolean frontFacing) {
        this.worldNormal = worldNormal;
        this.uv = uv;
        this.bary = bary;
        this.mat = mat;
        this.fragCoord = fragCoord;
        this.frontFacing = frontFacing;
        this.color = color;
    }

    public Pixel() {}

    @Override
    public String toString() {
        return "{normal: " + worldNormal + "}";
    }
}
