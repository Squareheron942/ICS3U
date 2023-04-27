public class GameObject {
    Mesh mesh;
    Material[] mats = new Material[1];
    protected Vector3 rotation = new Vector3();
    protected Vector3 position = new Vector3();

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

    public void update() { // change this obviously, useless
        Vector3 text = rotation;
        text = position;
        position = text;
    }

    public Vector3 position() {
        return this.position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }
}