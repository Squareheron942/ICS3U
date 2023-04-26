public class Vector3 {
    public float x, y, z;
    Vector3() {
        x = 1;
        y = 1;
        z = 1;
    };

    Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    static float dot(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    static Vector3 cross(Vector3 a, Vector3 b) {
        return new Vector3(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }

    static Vector3 diff(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}