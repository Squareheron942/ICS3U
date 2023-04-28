public class OrthogonalCamera extends Camera {
    Vector2 size;
    boolean isOrthogonalCamera = true;

    OrthogonalCamera(Vector3 position, Vector3 rotation, Vector2 size, float nearClip, float farClip) {
        super(position, rotation, nearClip, farClip);

        this.size = size;
    }
}
