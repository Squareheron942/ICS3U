package util;
public class Vector3 {
    public float x, y, z;
    public Vector3() {
        x = 1;
        y = 1;
        z = 1;
    };

    public Vector3(float x, float y, float z) {
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
    public static Vector3 mul(Vector3 v, float[][] m) {
        return new Vector3(
            v.x * m[0][0] + v.y * m[0][1] + v.z * m[0][2],
            v.x * m[1][0] + v.y * m[1][1] + v.z * m[1][2], 
            v.x * m[2][0] + v.y * m[2][1] + v.z * m[2][2]
        );
    }

    public static Vector3 mul(Vector3 v, float m) {
        return new Vector3(
            v.x * m,
            v.y * m,
            v.z * m
        );
    }

    public void mul(float v) {
        this.x *= v;
        this.y *= v;
        this.z *= v;
    }
    public void add(Vector3 v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }
    public void div(float v) { this.mul(1 / v);} // faster bc only 1 division instead of 3
    public void sub(Vector3 v) {this.add(Vector3.mul(v, -1));}

    public static float dot(Vector3 a, Vector3 b) {
        return Math.fma(a.x, b.x, Math.fma(a.y, b.y, a.z * b.z));
        // return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public static Vector3 cross(Vector3 a, Vector3 b) {
        return new Vector3(Math.fma(a.y, b.z, - a.z * b.y), Math.fma(a.z, b.x, - a.x * b.z), Math.fma(a.x, b.y, - a.y * b.x));
    }

    public static Vector3 diff(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static Vector3 normalize(Vector3 v) {
        if (Vector3.magnitude(v) > 0) return Vector3.mul(v, 1 / Vector3.magnitude(v));
        return new Vector3();
    }

    public static float magnitude(Vector3 v) {
        return (float)Math.sqrt(Math.fma(v.x, v.x, Math.fma(v.y, v.y, v.z * v.z)));
    }

    @Override
    public String toString() {
        return "Vector3(" + x + ", " + y + ", " + z + ")";
    }
}