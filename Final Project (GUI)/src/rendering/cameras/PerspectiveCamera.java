package rendering.cameras;
import util.LUTs;
import util.Vector2;
import util.Vector3;

public class PerspectiveCamera extends Camera {
    private float fov;

    public PerspectiveCamera(Vector3 position, Vector3 rotation, float fov, float nearClip, float farClip) {
        super(position, rotation, nearClip, farClip);


        this.fov = Math.max(1, Math.min(179, fov));
    }

<<<<<<< HEAD:Final Project (GUI)/src/rendering/cameras/PerspectiveCamera.java
    public void updateMatrix(Vector2 screenSize) {
        float focalLength = ((int)screenSize.x >> 1) * LUTs.cot((int)fov >> 1);
        this.matrix = new float[][] {
            {-focalLength, 0, 0},
            {0, -focalLength, 0},
            {0, 0, 1}
        };
    }

=======
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/PerspectiveCamera.java
    public float fov() { return fov; }
    public void setFov(float fov) { this.fov = Math.max(0.01f, Math.min(179, fov)); }
}