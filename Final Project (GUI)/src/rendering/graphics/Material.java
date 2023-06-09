package rendering.graphics;
import java.util.HashMap;

import rendering.Culling;
import rendering.Pixel;
import util.Color;
import util.Vertex;

public class Material {
    public HashMap<String, String> tags = new HashMap<String, String>() {{
        put("RenderType", "Opaque");
    }};
    public String name = "Default Material";
    public Texture _MainTex = null;
    public Color color = null;
    public boolean zWrite = true;
    public boolean zTest = true;
    public boolean shadeSmooth = true;
    public Culling cull = Culling.Off;
    public Shader shader = new Shader() {
        public Vertex vert(Vertex i) {
            return Shader.ObjectToClipPos(i);
        };

        public Color frag(Pixel i) {
            return new Color(0xff00ff);
        };
        @Override public String toString() {
            return "Missing Shader";
        }
    };

    public Shader shader() {
        return this.shader;
    }

    public String name() {
        return this.name;
    }

    public Material() {};

    public Material(Color color) {
        this.color = color;
    }

    public Material(Texture _MainTex) {
        this._MainTex = _MainTex;
        color = new Color();
    }

    public Material(Texture _MainTex, Color color) {
        this._MainTex = _MainTex;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Material{\n    shader: " + shader + ",\n    texture: " + _MainTex + ",\n    color: " + color + "\n}";
    }
}
