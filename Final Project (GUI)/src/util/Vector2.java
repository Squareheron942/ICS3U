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

<<<<<<< HEAD:Final Project (GUI)/src/util/Vector2.java
    public Vector2 normalized() {
        float m = 1 / this.magnitude();
        return new Vector2(x * m, y * m);
    }

    public float magnitude() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public static float dot(Vector2 a, Vector2 b) {
=======
    static float dot(Vector2 a, Vector2 b) {
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/Vector2.java
        return a.x * b.x + a.y * b.y;
    }

    public static Vector2 diff(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
