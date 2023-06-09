package objects.gameobjects;
import java.io.File;

import filereaders.OBJReader;
import util.Color;
import util.Vector3;

public class Cube extends GameObject {

    protected Vector3 dimensions;
    protected Color verticesColor;

    public Cube(Vector3 position, Vector3 dimensions, Vector3 rotation, Color verticesColor) {
        super(OBJReader.read(new File("assets/models/cube/cube.obj"), dimensions)[0].mesh, OBJReader.read(new File("assets/models/cube/cube.obj"), dimensions)[0].mats);
        this.dimensions = dimensions;
        this.position = position;
        this.rotation = rotation;
        this.verticesColor = verticesColor;
    }

    public void setDimensions(Vector3 dimensions) {
        this.dimensions = dimensions;
        this.mesh = OBJReader.read(new File("assets/models/cube/cube.obj"), dimensions)[0].mesh;
    }

    public Vector3 dimensions() { return this.dimensions; }

    // public String toString() {
    //     return "Cube{position: " + position + "}";
    // }
}