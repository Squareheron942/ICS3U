package objects.gameobjects;
import objects.Object3D;
import rendering.graphics.Material;
import util.LUTs;
import util.Vector3;

public class GameObject extends Object3D {
    public Mesh mesh;
    public Material[] mats = new Material[1];
    protected Vector3 scale = new Vector3(1, 1, 1);
    public final boolean isGameObject = true;

    public Vector3 scale() { return this.scale;}

    public GameObject(Mesh mesh, Material mat) {
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

    public GameObject(Mesh mesh, Material[] mats) {
        this.mesh = mesh;
        this.mats = mats;
        // for (Triangle t : mesh.tris) {
        //     if (t == null) continue;
        //     for (Vertex v : t.vertices) {
        //         position.add(v.worldPos);
        //     }
        // }
        // position.div(3);
    }

    @Override public void setRotation(final Vector3 rotation) {
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
            final float x = mesh.vertices[i].worldPos.x - this.position().x;
            final float y = mesh.vertices[i].worldPos.y - this.position().y;
            final float z = mesh.vertices[i].worldPos.z - this.position().z;
            // final float x = mesh.tris[i].vertices[j].worldPos.x;
            // final float y = mesh.tris[i].vertices[j].worldPos.y;
            // final float z = mesh.tris[i].vertices[j].worldPos.z;
            // final float u = rotation.x;
            // final float v = rotation.y;
            // final float w = rotation.z;

            // Vector3 pos = this.position();  
            // pos.add(); // add in this order to prevent sussness

            // yaw = y, roll = z, pitch = x
            mesh.vertices[i].worldPos = Vector3.mul(Vector3.mul(Vector3.mul(new Vector3(x, y, z), yRot), xRot), zRot);
            mesh.vertices[i].normal = Vector3.mul(Vector3.mul(Vector3.mul(mesh.vertices[i].normal, zRot), xRot), yRot);
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
            float x = (local ? this.position.x - mesh.vertices[i].worldPos.x : mesh.vertices[i].worldPos.x);
            float y = (local ? this.position.y - mesh.vertices[i].worldPos.y : mesh.vertices[i].worldPos.y);
            float z = (local ? this.position.z - mesh.vertices[i].worldPos.z : mesh.vertices[i].worldPos.z);

            Vector3 pos = new Vector3(x, y, z);

            // yaw = y, roll = z, pitch = x
            mesh.vertices[i].worldPos = Vector3.mul(Vector3.mul(Vector3.mul(pos, yRot), xRot), zRot);
        }
        this.rotation = rotation;
    }

    @Override public void setPosition(Vector3 position) {
        for (int i = 0; i < mesh.tris.length; i++) {
            // mesh.tris[i].vertices[j].worldPos.x += position.x - this.position.x;
            // mesh.tris[i].vertices[j].worldPos.y += position.y - this.position.y;
            // mesh.tris[i].vertices[j].worldPos.z += position.z - this.position.z;
            mesh.vertices[i].worldPos.x += position.x - this.position().x;
            mesh.vertices[i].worldPos.y += position.y - this.position().y;
            mesh.vertices[i].worldPos.z += position.z - this.position().z;
        }
        this.position = position;
    }

    public void setX(float x) {
        for (int i = 0; i < mesh.tris.length; i++) {
            mesh.vertices[i].worldPos.x += x - this.position.x;
        }
        this.position.x = x;
    }

    public void setY(float y) {
        for (int i = 0; i < mesh.tris.length; i++) {
            mesh.vertices[i].worldPos.y += y - this.position.y;
        }
        this.position.y = y;
    }

    public void setZ(float z) {
        for (int i = 0; i < mesh.tris.length; i++) {
            mesh.vertices[i].worldPos.z += z - this.position.z;
        }
        this.position.z = z;
    }

    @Override public String toString() {
        return "{mesh:" + mesh.toString() + ", material:" + ((mats[0] == null) ? null : mats[0].toString()) + "}";
    }
}