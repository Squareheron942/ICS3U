public class Color {
    float r, g, b; /*[0, 1] */
    float brightness; /*[0, 1] */
    float hue; /*[0, 1] */
    static char[] brightnesses = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`\'. ".toCharArray();
    static String[] hues = {

    };
    Color() {
        r = 0;
        g = 0;
        b = 0;
        brightness = 0;
        hue = 0;
    }

    Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        brightness = Math.max(Math.max(r, g), b);
        hue = hue(r, g, b);
    }

    Color(float brightness, float hue) {
        this.brightness = brightness;
        this.hue = hue;
    }

    private static float hue(float r, float g, float b) {
        float cmax = Math.max(Math.max(r, g), b);
        float cmin = Math.min(Math.min(r, g), b);

        float delta = cmax - cmin;

        if (cmax == r) return (((g - b) / delta) % 6) / 6f;
        else if (cmax == g) return (((b - r) / delta) + 2) / 6f;
        else return (((r - g) / delta) + 4) / 6f;
    }

    @Override
    public String toString() {
        return "{r: " + r + ", g: " + g + ", b: " + b + ", brightness: " + brightness + ", hue: " + hue + "}";
    }
}
