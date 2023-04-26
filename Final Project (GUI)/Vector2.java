public class Vector2 {
    public float x, y;
    Vector2() {
        x = 1;
        y = 1;
    };

    Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    static float dot(Vector2 a, Vector2 b) {
        return a.x * b.x + a.y * b.y;
    }

    static Vector2 diff(Vector2 a, Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
