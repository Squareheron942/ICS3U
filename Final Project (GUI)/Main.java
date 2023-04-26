public class Main {
    public static void main(String[] args) {

        Scene scene = new Scene();       

        scene.add(
            new GameObject(
                new Mesh(
                    new Triangle[] {
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(100, 100, 100), new Color(1, 0, 0)),
                                new Vertex(new Vector3(-100, -100, 100), new Color(0, 0, 1)),
                                new Vertex(new Vector3(-100, 100, -100), new Color(1, 1, 1))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(100, 100, 100), new Color(1, 0, 0)),
                                new Vertex(new Vector3(-100, -100, 100), new Color(0, 0, 1)),
                                new Vertex(new Vector3(100, -100, -100), new Color(0, 0, 1))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-100, 100, -100), new Color(1, 1, 1)),
                                new Vertex(new Vector3(100, -100, -100), new Color(0, 1, 0)),
                                new Vertex(new Vector3(100, 100, 100), new Color(1, 0, 0))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-100, 100, -100), new Color(1, 1, 1)),
                                new Vertex(new Vector3(100, -100, -100), new Color(0, 1, 0)),
                                new Vertex(new Vector3(-100, -100, 100), new Color(0, 0, 1))
                            }
                        )
                    }), 
                    new Material(new Color())));

        PerspectiveCamera cam = new PerspectiveCamera(
            new Vector3(0, 0, 0), // position
            new Vector3(0, 0, 0), // rotation
            75,
            200
        );

        Renderer.init(scene, cam);
        do {
            Pixel[][] fbuf = Renderer.render(scene, cam);
            Renderer.draw(fbuf);
        } while (true);
    }
}