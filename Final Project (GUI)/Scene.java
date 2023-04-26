import java.util.ArrayList;

public class Scene {
    ArrayList<GameObject> children = new ArrayList<GameObject>();

    boolean add(GameObject object) {
        try {
            children.add(object);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}