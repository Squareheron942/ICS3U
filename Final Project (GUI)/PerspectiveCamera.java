public class PerspectiveCamera extends Camera {
    private float fov;
    boolean isPerspectiveCamera = true;

    PerspectiveCamera(Vector3 position, Vector3 rotation, float fov, float nearClip, float farClip) {
        super(position, rotation, nearClip, farClip);


        this.fov = Math.max(1, Math.min(179, fov));
    }

    public float fov() { return fov; }
}