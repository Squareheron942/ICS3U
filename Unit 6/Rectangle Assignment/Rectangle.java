public class Rectangle {
    private int left, bottom, width, height;
    Rectangle() {
        left = 0;
        bottom = 0;
        width = 0;
        height = 0;
    }
    Rectangle(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.height = height;
        this.width = width;
    }
    void set(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
    }
    @Override public String toString() { return "base: (" + left + "," + bottom + ") w:" + width + " h:" + height; }
    int area() { return width * height; }
    int perimeter() {
        if (width == 0) return height;
        if (height == 0) return width;
        return 2 * width + 2 * height;
    }
    boolean contains(Rectangle o) { return (left <= o.left && bottom <= o.bottom && bottom + height >= o.bottom + o.height && left + width >= o.left + o.width); }
    static Rectangle intersection(Rectangle a, Rectangle b) {
        if (colliding(a, b)) {
            if (a.contains(b)) return b;
            else if (b.contains(a)) return a;
            else {
                if (a.bottom < b.bottom && a.left < b.left) return 
                    (a.height > b.height) ? new Rectangle(b.left, b.bottom, a.left + a.width - b.left, b.height) : 
                    (a.width > b.width) ? new Rectangle(b.left, b.bottom, b.width, a.bottom + a.height - b.bottom) : 
                    new Rectangle(b.left, b.bottom, a.left + a.width - b.left, a.bottom + a.height - b.bottom);
                else return 
                    (b.height > a.height) ? new Rectangle(a.left, a.bottom, b.left + b.width - a.left, a.height) : 
                    (b.width > a.width) ? new Rectangle(a.left, a.bottom, a.width, b.bottom + b.height - a.bottom) : 
                    new Rectangle(a.left, a.bottom, b.left + b.width - a.left, b.bottom + b.height - a.bottom);
            }
        }
        return new Rectangle();
    }
    private static boolean colliding(Rectangle a, Rectangle b) { return a.left + a.width >= b.left && b.left + b.width >= a.left && a.bottom + a.height >= b.bottom && b.bottom + b.height >= a.bottom; }
    static int totalPerimeter(Rectangle a, Rectangle b) { return a.perimeter() + b.perimeter() - Rectangle.intersection(a, b).perimeter(); }
}