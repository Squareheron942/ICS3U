package objects.lights;
import util.Color;
import util.Vector3;

public class PointLight extends Light {
    public PointLight(Vector3 position, Color color) {
        super(position, color);
    }
}
