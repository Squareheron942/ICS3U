public class Main {
    static Scene scene = new Scene();  
    public static void main(String[] args) {     

        Cube cube = new Cube(
            new Vector3(), // position
            new Vector3(100, 100, 38), // dimensions
            new Vector3(), // rotation
            new Color(1, 0, 0) // vertex color
        );

        scene.add(cube);

        scene.add(
            new GameObject(
                new Mesh(
                    new Triangle[] {
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0)),
                                new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1)),
                                new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0)),
                                new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1)),
                                new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 0, 1))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1)),
                                new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 1, 0)),
                                new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1)),
                                new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 1, 0)),
                                new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1))
                            }
                        )
                    }), 
                    new Material(new Color())));

        PerspectiveCamera cam = new PerspectiveCamera(
            new Vector3(0, 0, 0), // position
            new Vector3(0, 0, 0), // rotation
            75,
            1,
            300
        );

        // for (int i = 1; i < 180; i++) {
        //     System.out.println(1 / Math.tan(i * Math.PI / 180f) + "f, ");
        // }

        Renderer.init(scene, cam);
        do {
            Pixel[][] fbuf = Renderer.render(scene, cam);
            Renderer.draw(fbuf);
        } while (true);
    }
}