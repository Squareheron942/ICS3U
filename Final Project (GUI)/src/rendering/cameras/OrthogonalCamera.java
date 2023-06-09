package rendering.cameras;
import util.Vector2;
import util.Vector3;

public class OrthogonalCamera extends Camera {
    public Vector2 size;
    public boolean isOrthogonalCamera = true;

    public OrthogonalCamera(Vector3 position, Vector3 rotation, Vector2 size, float nearClip, float farClip) {
        super(position, rotation, nearClip, farClip);

        this.size = size;
    }
}
