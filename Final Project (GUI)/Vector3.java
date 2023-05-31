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
    /**
     * Multiplies a Vector3 by a 3x3 matrix
     * @param v The Vector3
     * @param m The matrix
     * @return A new Vector3 multiplied by the matrix
     */
    static Vector3 mul(Vector3 v, float[][] m) {
        return new Vector3(
            v.x * m[0][0] + v.y * m[0][1] + v.z * m[0][2],
            v.x * m[1][0] + v.y * m[1][1] + v.z * m[1][2], 
            v.x * m[2][0] + v.y * m[2][1] + v.z * m[2][2]
        );
    }

    static Vector3 mul(Vector3 v, float m) {
        return new Vector3(
            v.x * m,
            v.y * m,
            v.z * m
        );
    }

    void mul(float v) {
        this.x *= v;
        this.y *= v;
        this.z *= v;
    }
    void add(Vector3 v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }
    void div(float v) { this.mul(1 / v);}
    void sub(Vector3 v) {this.add(Vector3.mul(this, -1));}

    static float dot(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    static Vector3 cross(Vector3 a, Vector3 b) {
        return new Vector3(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }

    static Vector3 diff(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    static Vector3 normalize(Vector3 v) {
        if (Vector3.magnitude(v) > 0) return Vector3.mul(v, 1 / Vector3.magnitude(v));
        return new Vector3();
    }

    static float magnitude(Vector3 v) {
        return (float)Math.abs(Math.sqrt(v.x * v.x + v.y * v.y * v.z * v.z));
    }

    @Override
    public String toString() {
        return "Vector3(" + x + ", " + y + ", " + z + ")";
    }
}