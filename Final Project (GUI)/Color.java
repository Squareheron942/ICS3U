public class Color {
    private final float inv255 = 1 / 255f;
    float r, g, b, a; /*[0, 1] */
    Color() {
        r = 1;
        g = 1;
        b = 1;
        a = 1;
    }

    Color(int rgb) {
        r = ((rgb & 0xff0000) >> 16) * inv255;
        g = ((rgb & 0x00ff00) >> 8) * inv255;
        b = ((rgb & 0x0000ff)) * inv255;
        a = 1;
    }

    Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
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

    Color mul(Color c) {
        return new Color(
            this.r * c.r,
            this.g * c.g,
            this.b * c.b
        );
    }

    Color mul(float f) {
        return new Color(
            this.r * f,
            this.g * f,
            this.b * f
        );
    }

    @Override
    public String toString() {
        return "Color{r: " + r + ", g: " + g + ", b: " + b + "}";
    }
}
