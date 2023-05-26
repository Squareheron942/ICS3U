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
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                float x = this.position.x + mesh.tris[i].vertices[j].worldPos.x;
                float y = this.position.y + mesh.tris[i].vertices[j].worldPos.y;
                float z = this.position.z + mesh.tris[i].vertices[j].worldPos.z;
                float u = rotation.x - this.rotation.x;
                float v = rotation.y - this.rotation.y;
                float w = rotation.z - this.rotation.z;

                // yaw = y, roll = z, pitch = x
                mesh.tris[i].vertices[j].worldPos = new Vector3(
                    (x * (LUTs.cos(v) * LUTs.cos(w))) + (y * (LUTs.sin(u) * LUTs.sin(v) * LUTs.cos(w) - LUTs.cos(u) * LUTs.sin(w))) + (z * (LUTs.sin(u) * LUTs.sin(w) + LUTs.cos(u) * LUTs.sin(v) * LUTs.cos(w))), 
                    (x * (LUTs.cos(v) * LUTs.sin(w))) + (y * (LUTs.cos(u) * LUTs.cos(w) + LUTs.sin(u) * LUTs.sin(v) * LUTs.sin(w))) + (z * (LUTs.cos(u) * LUTs.sin(v) * LUTs.sin(w) - LUTs.sin(u) * LUTs.cos(w))),
                    (x * (-LUTs.sin(v))) + (y * (LUTs.sin(u) * LUTs.cos(v))) + (z * (LUTs.cos(u) * LUTs.cos(v)))
                );
            }
        }
        this.rotation = rotation;
    }

    public void setRotation(Vector3 rotation, boolean local) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                float x = (local ? this.position.x - mesh.tris[i].vertices[j].worldPos.x : mesh.tris[i].vertices[j].worldPos.x);
                float y = (local ? this.position.y - mesh.tris[i].vertices[j].worldPos.y : mesh.tris[i].vertices[j].worldPos.y);
                float z = (local ? this.position.z - mesh.tris[i].vertices[j].worldPos.z : mesh.tris[i].vertices[j].worldPos.z);
                float u = rotation.x - this.rotation.x;
                float v = rotation.y - this.rotation.y;
                float w = rotation.z - this.rotation.z;

                // yaw = y, roll = z, pitch = x
                mesh.tris[i].vertices[j].worldPos = new Vector3(
                    (x * (LUTs.cos(v) * LUTs.cos(w))) + (y * (LUTs.sin(u) * LUTs.sin(v) * LUTs.cos(w) - LUTs.cos(u) * LUTs.sin(w))) + (z * (LUTs.sin(u) * LUTs.sin(w) + LUTs.cos(u) * LUTs.sin(v) * LUTs.cos(w))), 
                    (x * (LUTs.cos(v) * LUTs.sin(w))) + (y * (LUTs.cos(u) * LUTs.cos(w) + LUTs.sin(u) * LUTs.sin(v) * LUTs.sin(w))) + (z * (LUTs.cos(u) * LUTs.sin(v) * LUTs.sin(w) - LUTs.sin(u) * LUTs.cos(w))),
                    (x * (-LUTs.sin(v))) + (y * (LUTs.sin(u) * LUTs.cos(v))) + (z * (LUTs.cos(u) * LUTs.cos(v)))
                );
            }
        }
        this.rotation = rotation;
    }

    // public void update() { // change this obviously, doing nothing rn // also not gonna be used prob
        
    // }

    public Vector3 position() {
        return this.position;
    }

    public void setPosition(Vector3 position) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                mesh.tris[i].vertices[j].worldPos.x += position.x - this.position.x;
                mesh.tris[i].vertices[j].worldPos.y += position.y - this.position.y;
                mesh.tris[i].vertices[j].worldPos.z += position.z - this.position.z;
            }
        }
        this.position = position;
    }

    public void setX(float x) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                mesh.tris[i].vertices[j].worldPos.x += x - this.position.x;
            }
        }
        this.position.x = x;
    }

    public void setY(float y) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                mesh.tris[i].vertices[j].worldPos.y += y - this.position.y;
            }
        }
        this.position.y = y;
    }

    public void setZ(float z) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                mesh.tris[i].vertices[j].worldPos.z += z - this.position.z;
            }
        }
        this.position.z = z;
    }
}