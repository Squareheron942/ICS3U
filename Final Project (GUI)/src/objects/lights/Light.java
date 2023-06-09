package objects.lights;

import objects.Object3D;
import util.Color;
import util.Vector3;

public class Light extends Object3D {
    protected float intensity = 0;
    protected Color color = new Color();

    public Light() {};

    public Light(Vector3 position, Color color) {
        this.position = position;
        this.color = color;
    }

    public void setColor(Color color) { this.color = color; }
    public Color color() { return color; }
    public float intensity() { return intensity; }
}