package rendering.graphics;
import rendering.Pixel;
import rendering.Renderer;
import rendering.cameras.Camera;
import util.Color;
import util.LUTs;
import util.Vector2;
import util.Vector3;
import util.Vertex;

public interface Shader {
    public Vertex vert(Vertex i);
    public Color frag(Pixel i);

    public static Color tex2D(Texture t, Vector2 uv) {
        return t == null ? new Color() : t.get(uv);
    }

    public static Vertex ObjectToClipPos(Vertex i) {
        Camera cam = Renderer._cam;
        Vector3 vp = new Vector3(
            i.worldPos.x - cam.position().x,
            i.worldPos.y - cam.position().y,
            i.worldPos.z - cam.position().z
        );

        float u = cam.rotation().x, v = cam.rotation().y, w = cam.rotation().z;

        float[][] xRot = {
            {1, 0, 0},
            {0, LUTs.cos(u), -LUTs.sin(u)},
            {0, LUTs.sin(u), LUTs.cos(u)}
        };

        float[][] yRot = {
            {LUTs.cos(v), 0, LUTs.sin(v)},
            {0, 1, 0},
            {-LUTs.sin(v), 0, LUTs.cos(v)}
        };

        float[][] zRot = {
            {LUTs.cos(w), -LUTs.sin(w), 0},
            {LUTs.sin(w), LUTs.cos(w), 0},
            {0, 0, 1}
        };

        Vector3 vPos = Vector3.mul(Vector3.mul(Vector3.mul(Vector3.mul(vp, yRot), xRot), zRot), cam.matrix);

        float zratio = 1f / vPos.z;
        
        // float x = (vPos.x) * zratio * cam.focalX * -Renderer.renderPanel.img.getWidth();
        // float y = (vPos.y) * zratio * cam.focalY * -Renderer.renderPanel.img.getHeight();
        return new Vertex(new Vector3(vPos.x * zratio, vPos.y * zratio, vPos.z), i.color, i.uv, i.normal);
        // i.color = new Color(0xff0000);
        // return i;
    }

    public static Vector3 getMainLightDirection() {
        return Renderer._scene.sun.direction();
    }

}