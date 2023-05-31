public class Material {
    Shader shader = new Shader();
    Texture _MainTex = new Texture();
    Color color = null;

    // Material(MaterialProperty[] props, Shader shader) {
    //     this.shader = shader;
    // }

    Material(Color color) {
        this.color = color;
    }

    Material(Texture _MainTex) {
        this._MainTex = _MainTex;
        color = new Color();
    }

    Material(Texture _MainTex, Color color) {
        this._MainTex = _MainTex;
        this.color = color;
    }
}
