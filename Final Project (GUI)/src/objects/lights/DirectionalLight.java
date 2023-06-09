package objects.lights;
import util.Color;
import util.LUTs;
import util.Vector3;

public class DirectionalLight extends Light {
    public final boolean isDirectionalLight = true;
    protected Vector3 direction = null;

    public DirectionalLight() {
        color = new Color();
        intensity = 1;
        direction = new Vector3(0, -1, 0); // facing down
    };

    public DirectionalLight(Color color, float intensity) {
        super(null, color);
        direction = new Vector3(0, -1, 0); // facing down
        this.intensity = intensity;
    }

    public void setDirection(final Vector3 direction) {
        float u = direction.x, v = direction.y, w = direction.z;

        float[][] xRot = {
            {1, 0, 0},
            {0, LUTs.cos(u), -LUTs.sin(u)},
            {0, LUTs.sin(u), LUTs.cos(u)}
        };

        float[][] yRot = {
            {LUTs.cos(v), 0, LUTs.sin(v)},
            {0, 1, 0},
            {-LUTs.sin(v), 0, LUTs.cos(v)}
        };

        float[][] zRot = {
            {LUTs.cos(w), -LUTs.sin(w), 0},
            {LUTs.sin(w), LUTs.cos(w), 0},
            {0, 0, 1}
        };

        this.direction = Vector3.mul(Vector3.mul(Vector3.mul(direction, yRot), xRot), zRot);
    }

    public Vector3 direction() { return direction; }
}
