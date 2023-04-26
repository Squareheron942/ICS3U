public class Main {
    public static void main(String[] args) {

        Scene scene = new Scene();       

        scene.add(
            new GameObject(
                new Mesh(
                    new Triangle[] {
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(10, 10, 10)),
                                new Vertex(new Vector3(-10, -10, 10)),
                                new Vertex(new Vector3(-10, 10, -10))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(10, 10, 10)),
                                new Vertex(new Vector3(-10, -10, 10)),
                                new Vertex(new Vector3(10, -10, -10))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-10, 10, -10)),
                                new Vertex(new Vector3(10, -10, -10)),
                                new Vertex(new Vector3(10, 10, 10))
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-10, 10, -10)),
                                new Vertex(new Vector3(10, -10, -10)),
                                new Vertex(new Vector3(-10, -10, 10))
                            }
                        )
                    }), 
                    new Material(new Color())));

        Camera cam = new Camera();
        Renderer.init();
        // do {
        //     Pixel[][] fbuf = Renderer.render(scene, cam);
        //     Renderer.draw(fbuf);
        // } while (false);
    }
}