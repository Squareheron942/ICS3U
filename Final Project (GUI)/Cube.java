import java.io.File;

public class Cube extends GameObject {

    protected Vector3 dimensions;
    protected Color verticesColor;

    Cube(Vector3 position, Vector3 dimensions, Vector3 rotation, Color verticesColor) {
        super(OBJReader.read(new File("cube.obj"), dimensions).mesh, OBJReader.read(new File("cube.obj"), dimensions).mats);
        this.dimensions = dimensions;
        this.position = position;
        this.rotation = rotation;
        this.verticesColor = verticesColor;
    }

    void setDimensions(Vector3 dimensions) {
        this.dimensions = dimensions;
        this.mesh = OBJReader.read(new File("cube.obj"), dimensions).mesh;
    }

    public Vector3 dimensions() {
        return this.dimensions;
    }

    public String toString() {
        return "{position: " + position + "}";
    }
}