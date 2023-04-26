public class Color {
    float r, g, b; /*[0, 1] */
    Color() {
        r = 0;
        g = 0;
        b = 0;
    }

    Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;;
    }

    static Color lerp(Color a, Color b, float ratio) {
        return new Color(
            a.r + ratio * (b.r - a.r),
            a.g + ratio * (b.g - a.g),
            a.b + ratio * (b.b - a.b)
        );
    }

    void lerp(Color o, float ratio) {
        this.r = this.r + ratio * (o.r - this.r);
        this.g = this.g + ratio * (o.g - this.g);
        this.b = this.b + ratio * (o.b - this.b);
    }

    @Override
    public String toString() {
        return "{r: " + r + ", g: " + g + ", b: " + b + "}";
    }
}
