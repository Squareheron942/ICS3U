package rendering;
import java.util.ArrayList;

import objects.Object3D;
import objects.gameobjects.GameObject;
import objects.gameobjects.Line;
import objects.helpers.Helper;
import objects.lights.DirectionalLight;
import objects.lights.Light;

public class Scene {
    public ArrayList<GameObject> children = new ArrayList<>();
    public ArrayList<Light> lights = new ArrayList<>();
    public ArrayList<Line> lines = new ArrayList<>();

    public DirectionalLight sun = new DirectionalLight();

    public boolean add(Object3D object) {
        try {
            if (object instanceof Light) lights.add((Light)object);
            if (object instanceof Line) lines.add((Line)object);
            if (object instanceof Helper) for (Line l : ((Helper)object).lines) lines.add(l);
            if (object instanceof GameObject) children.add((GameObject)object);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void setMainLight(DirectionalLight light) {
        sun = light;
    }
}