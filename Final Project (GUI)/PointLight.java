public class PointLight extends Light {
    boolean isPointLight = true;
    
    PointLight(Vector3 position, Color color) {
        super(position, color);
    }
}
