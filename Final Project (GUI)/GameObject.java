public class GameObject {
    Mesh mesh;
    Material[] mats = new Material[1];
    protected Vector3 rotation = new Vector3();
    protected Vector3 position = new Vector3();
    protected Vector3 scale = new Vector3(1, 1, 1);

    public Vector3 position() { return this.position;}
    public Vector3 rotation() { return this.rotation;}
    public Vector3 scale() { return this.scale;}

    GameObject(Mesh mesh, Material mat) {
        this.mesh = mesh;
        this.mats[0] = mat;
        // for (Triangle t : mesh.tris) {
        //     if (t == null) continue;
        //     for (Vertex v : t.vertices) {
        //         position.add(v.worldPos);
        //     }
        // }
        // position.div(3f);
    }

    GameObject(Mesh _mesh, Material[] _mats) {
        mesh = _mesh;
        mats = _mats;
        // for (Triangle t : mesh.tris) {
        //     if (t == null) continue;
        //     for (Vertex v : t.vertices) {
        //         position.add(v.worldPos);
        //     }
        // }
        // position.div(3);
    }

    public void setRotation(Vector3 rotation) {
        final float u = rotation.x - this.rotation.x;
        final float v = rotation.y - this.rotation.y;
        final float w = rotation.z - this.rotation.z;
        float[][] xRot = {
            {1, 0, 0},
            {0, LUTs.cos(u), -LUTs.sin(u)},
            {0, LUTs.sin(u), LUTs.cos(u)}
        };

        float[][] yRot = {
            {LUTs.cos(v), 0, LUTs.sin(v)},
            {0, 1, 0},
            {-LUTs.sin(v), 0, LUTs.cos(v)}
        };

        float[][] zRot = {
            {LUTs.cos(w), -LUTs.sin(w), 0},
            {LUTs.sin(w), LUTs.cos(w), 0},
            {0, 0, 1}
        };

        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                // final float x = this.position.x + mesh.tris[i].vertices[j].worldPos.x;
                // final float y = this.position.y + mesh.tris[i].vertices[j].worldPos.y;
                // final float z = this.position.z + mesh.tris[i].vertices[j].worldPos.z;
                final float x = mesh.tris[i].vertices[j].worldPos.x;
                final float y = mesh.tris[i].vertices[j].worldPos.y;
                final float z = mesh.tris[i].vertices[j].worldPos.z;
                // final float u = rotation.x;
                // final float v = rotation.y;
                // final float w = rotation.z;

                Vector3 pos = new Vector3(x, y, z);

                // yaw = y, roll = z, pitch = x
                mesh.tris[i].vertices[j].worldPos = Vector3.mul(Vector3.mul(Vector3.mul(pos, yRot), xRot), zRot);
                mesh.tris[i].vertices[j].normal = Vector3.mul(Vector3.mul(Vector3.mul(mesh.tris[i].vertices[j].normal, zRot), xRot), yRot);
                // new Vector3(
                //     (x * (LUTs.cos(v) * LUTs.cos(w))) + (y * (LUTs.sin(u) * LUTs.sin(v) * LUTs.cos(w) - LUTs.cos(u) * LUTs.sin(w))) + (z * (LUTs.sin(u) * LUTs.sin(w) + LUTs.cos(u) * LUTs.sin(v) * LUTs.cos(w))), 
                //     (x * (LUTs.cos(v) * LUTs.sin(w))) + (y * (LUTs.cos(u) * LUTs.cos(w) + LUTs.sin(u) * LUTs.sin(v) * LUTs.sin(w))) + (z * (LUTs.cos(u) * LUTs.sin(v) * LUTs.sin(w) - LUTs.sin(u) * LUTs.cos(w))),
                //     (x * (-LUTs.sin(v))) + (y * (LUTs.sin(u) * LUTs.cos(v))) + (z * (LUTs.cos(u) * LUTs.cos(v)))
                // );
            }
        }
        this.rotation = rotation;
    }

    public void setRotation(Vector3 rotation, boolean local) {
        final float u = rotation.x - this.rotation.x;
        final float v = rotation.y - this.rotation.y;
        final float w = rotation.z - this.rotation.z;
        float[][] xRot = {
            {1, 0, 0},
            {0, LUTs.cos(u), -LUTs.sin(u)},
            {0, LUTs.sin(u), LUTs.cos(u)}
        };

        float[][] yRot = {
            {LUTs.cos(v), 0, LUTs.sin(v)},
            {0, 1, 0},
            {-LUTs.sin(v), 0, LUTs.cos(v)}
        };

        float[][] zRot = {
            {LUTs.cos(w), -LUTs.sin(w), 0},
            {LUTs.sin(w), LUTs.cos(w), 0},
            {0, 0, 1}
        };
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                float x = (local ? this.position.x - mesh.tris[i].vertices[j].worldPos.x : mesh.tris[i].vertices[j].worldPos.x);
                float y = (local ? this.position.y - mesh.tris[i].vertices[j].worldPos.y : mesh.tris[i].vertices[j].worldPos.y);
                float z = (local ? this.position.z - mesh.tris[i].vertices[j].worldPos.z : mesh.tris[i].vertices[j].worldPos.z);

                Vector3 pos = new Vector3(x, y, z);

                // yaw = y, roll = z, pitch = x
                mesh.tris[i].vertices[j].worldPos = Vector3.mul(Vector3.mul(Vector3.mul(pos, yRot), xRot), zRot);
            }
        }
        this.rotation = rotation;
    }

    // public void update() { // change this obviously, doing nothing rn // also not gonna be used prob
        
    // }

    public void setPosition(Vector3 position) {
        for (int i = 0; i < mesh.tris.length; i++) {
            for (int j = 0; j < 3; j++) {
                // mesh.tris[i].vertices[j].worldPos.x += position.x - this.position.x;
                // mesh.tris[i].vertices[j].worldPos.y += position.y - this.position.y;
                // mesh.tris[i].vertices[j].worldPos.z += position.z - this.position.z;
                mesh.tris[i].vertices[j].worldPos.x += position.x;
                mesh.tris[i].vertices[j].worldPos.y += position.y;
                mesh.tris[i].vertices[j].worldPos.z += position.z;
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

    @Override public String toString() {
        return "{mesh:" + mesh.toString() + ", material:" + ((mats[0] == null) ? null : mats[0].toString()) + "}";
    }
}