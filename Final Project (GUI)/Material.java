public class Material {
    Shader shader;
    Material(MaterialProperty[] props, Shader shader) {
        this.shader = shader;
    }
    Color color;
    Material(Color color) {
        this.color = color;
    }
}
