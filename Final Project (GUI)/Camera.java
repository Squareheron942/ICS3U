public class Camera {
    Vector3 position;
    Vector3 rotation;
    boolean isCamera = true;
    float nearClip, farClip;

    Camera(Vector3 position, Vector3 rotation, float nearClip, float farClip) {
        this.position = position;
        this.rotation = rotation;
        this.nearClip = nearClip;
        this.farClip = farClip;
    }
}
