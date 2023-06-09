package util;
public class Vector2 {
    public float x, y;
    public Vector2() {
        x = 1;
        y = 1;
    };

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public Vector2 normalized() {
        float m = 1 / this.magnitude();
        return new Vector2(x * m, y * m);
    }

    public float magnitude() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public static float dot(Vector2 a, Vector2 b) {
        return a.x * b.x + a.y * b.y;
    };

    public static Vector2 diff(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
