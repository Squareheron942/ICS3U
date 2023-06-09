package rendering.cameras;
import util.Vector2;
import util.Vector3;

public class Camera {
    protected Vector3 position;
    protected Vector3 rotation;
    public float nearClip, farClip;
    public float[][] matrix = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    };

    public Vector3 position() { return position; }
    public Vector3 rotation() { return rotation; }
    public void setPosition(Vector3 position) { this.position = position; }
    public void setRotation(Vector3 rotation) { this.rotation = rotation; }

    public void updateMatrix(Vector2 screenSize) {
        this.matrix = new float[][] {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
    }

    public Camera(Vector3 position, Vector3 rotation, float nearClip, float farClip) {
        this.position = position;
        this.rotation = rotation;
        this.nearClip = nearClip;
        this.farClip = farClip;
    }
}
