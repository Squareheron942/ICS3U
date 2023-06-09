package objects.gameobjects;
import objects.Object3D;
import util.Vertex;

public class Line extends Object3D {
    public Vertex[] points = new Vertex[2];

    public Line(Vertex[] points) {
        super();
        this.points = points;
    }
}
