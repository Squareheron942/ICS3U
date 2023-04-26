public class PerspectiveCamera extends Camera {
    float fov;
    float focalLength;
    boolean isPerspectiveCamera = true;

    PerspectiveCamera(Vector3 position, Vector3 rotation, float fov, float focalLength) {
        super(position, rotation);

        this.fov = fov;
        this.focalLength = focalLength;
    }
}