package objects;
import util.Vector3;

public class Object3D {
    public final boolean isGameObject = false, isLight = false, isDirectionalLight = false;
    protected Vector3 rotation = new Vector3(0, 0, 0), position = new Vector3(0, 0, 0);

    public Object3D() {};

    public Object3D(Vector3 position, Vector3 rotation) {

    };

    public Vector3 position() { return position; }
    public Vector3 rotation() { return this.rotation;}

    public void setPosition(Vector3 position) { this.position = position; }
    public void setRotation(Vector3 rotation) { this.rotation = rotation; }
}
