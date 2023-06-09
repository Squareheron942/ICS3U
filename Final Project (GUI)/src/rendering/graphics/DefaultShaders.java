package rendering.graphics;
import rendering.Pixel;
import util.Color;
import util.Vertex;

public class DefaultShaders {
    public Shader vertexLit = new Shader() {
        public Vertex vert(Vertex i) {
            i.color = i.color.mul(Shader.getMainLightDirection().x);
            return Shader.ObjectToClipPos(i);
        };
        public Color frag(Pixel i) {
            return i.color;
        };
    };
}
