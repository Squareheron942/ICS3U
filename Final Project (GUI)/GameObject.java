public class GameObject {
    Mesh mesh;
    Material[] mats = new Material[1];
    private Vector3 rotation;

    GameObject(Mesh mesh, Material mat) {
        this.mesh = mesh;
        this.mats[0] = mat;
    }

    GameObject(Mesh _mesh, Material[] _mats) {
        mesh = _mesh;
        mats = _mats;
    }

    public void setRotation(Vector3 rotation) {
        this.rotation = rotation;

    }

    public void update() {
        
    }
}