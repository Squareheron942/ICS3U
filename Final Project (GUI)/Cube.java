import java.io.File;

public class Cube extends GameObject {

    protected Vector3 dimensions;
    protected Color verticesColor;

    Cube(Vector3 position, Vector3 dimensions, Vector3 rotation, Color verticesColor) {
        super(
            new Mesh(
                new Triangle[] {
                    new Triangle(
                        new Vertex[] { // front face
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1))
                        },
                        new Color(1, 0, 0)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1))
                        },
                        new Color(1, 0, 0)
                    ),
                    new Triangle( // right face
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1))
                        },
                        new Color(0, 1, 0)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1))
                        },
                        new Color(0, 1, 0)
                    ),
                    new Triangle( // top face
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0))
                        },
                        new Color(0, 0, 1)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0))
                        },
                        new Color(0, 0, 1)
                    ),
                    new Triangle( // back face
                        new Vertex[] {
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1))
                        },
                        new Color(1, 0, 1)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1))
                        },
                        new Color(1, 0, 1)
                    ),
                    new Triangle( // bottom face
                        new Vertex[] {
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0))
                        },
                        new Color(0, 1, 1)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0))
                        },
                        new Color(0, 1, 1)
                    ),
                    new Triangle( // left face
                        new Vertex[] {
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0))
                        },
                        new Color(1, 1, 0)
                    ),
                    new Triangle(
                        new Vertex[] {
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 0)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor, new Vector2(1, 1)),
                            new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor, new Vector2(0, 1))
                        },
                        new Color(1, 1, 0)
                    ),
                }
            ),
            new Material(
                new Texture(new File("textures/checker.bmp")),
                new Color()
            )
        );
        this.dimensions = dimensions;
        this.position = position;
        this.rotation = rotation;
        this.verticesColor = verticesColor;
    }

    void setDimensions(Vector3 dimensions) {
        this.dimensions = dimensions;
        this.mesh = new Mesh(
            new Triangle[] {
                new Triangle(
                    new Vertex[] { // front face
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 0, 0)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 0, 0)
                ),
                new Triangle( // right face
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 1, 0)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 1, 0)
                ),
                new Triangle( // bottom face
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 0, 1)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 0, 1)
                ),
                new Triangle( // back face
                    new Vertex[] {
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 0, 1)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 0, 1)
                ),
                new Triangle( // top face
                    new Vertex[] {
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 1, 1)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(0, 1, 1)
                ),
                new Triangle( // left face
                    new Vertex[] {
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 1, 0)
                ),
                new Triangle(
                    new Vertex[] {
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, -dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, dimensions.z * 0.5f + position.z), verticesColor),
                        new Vertex(new Vector3(-dimensions.x * 0.5f + position.x, dimensions.y * 0.5f + position.y, -dimensions.z * 0.5f + position.z), verticesColor)
                    },
                    new Color(1, 1, 0)
                ),
            }
        );
    }

    public Vector3 dimensions() {
        return this.dimensions;
    }

    public String toString() {
        return "{position: " + position + "}";
    }
}