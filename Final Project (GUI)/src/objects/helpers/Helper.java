package objects.helpers;
import objects.Object3D;
import objects.gameobjects.Line;

public class Helper extends Object3D {
    public Line[] lines;
    public Helper(Line l) {
        super();
        lines = new Line[0];
        lines[0] = l;
    };

    public Helper(Line[] lines) {
        super();
        this.lines = lines;
    }
}
