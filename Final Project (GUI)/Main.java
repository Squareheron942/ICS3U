import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static Scene scene = new Scene(); 
    static long lTime = System.currentTimeMillis();
    static float dTime; 
    static int counter = 0;
    public static void main(String[] args) {     

        Cube cube = new Cube(
            new Vector3(0, 0, 0), // position
            new Vector3(100, 100, 100), // dimensions
            new Vector3(0, 0, 0), // rotation
            new Color(1, 0, 0) // vertex color
        );

        scene.add(cube);

        Cube c2 = new Cube(
            new Vector3(-1000, 0, -1000), // position
            new Vector3(100, 100, 100), // dimensions
            new Vector3(), // rotation
            new Color(1, 0, 0) // vertex color
        );

        scene.add(c2);

        scene.add(
            new GameObject(
                new Mesh(
                    new Triangle[] {
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 0, -1000), new Color(1, 0, 0)),
                            },
                            new Color(1, 0, 0)
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(0, 0, -3), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 0, 3), new Color(1, 0, 0)),
                                new Vertex(new Vector3(1000, 0, 0), new Color(0, 1, 0)),
                            },
                            new Color(0, 1, 0)
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 1000, 0), new Color(0, 0, 1)),
                            },
                            new Color(0, 0, 1)
                        )
                    }
                ),
                new Material(new Color())
            )
        );

        // scene.add(
        //     new GameObject(
        //         new Mesh(
        //             new Triangle[] {
        //                 new Triangle(
        //                     new Vertex[] {
        //                         new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0)),
        //                         new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1)),
        //                         new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1))
        //                     }
        //                 ),
        //                 new Triangle(
        //                     new Vertex[] {
        //                         new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0)),
        //                         new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1)),
        //                         new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 0, 1))
        //                     }
        //                 ),
        //                 new Triangle(
        //                     new Vertex[] {
        //                         new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1)),
        //                         new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 1, 0)),
        //                         new Vertex(new Vector3(100, 100, 100 - 200), new Color(1, 0, 0))
        //                     }
        //                 ),
        //                 new Triangle(
        //                     new Vertex[] {
        //                         new Vertex(new Vector3(-100, 100, -100 - 200), new Color(1, 1, 1)),
        //                         new Vertex(new Vector3(100, -100, -100 - 200), new Color(0, 1, 0)),
        //                         new Vertex(new Vector3(-100, -100, 100 - 200), new Color(0, 0, 1))
        //                     }
        //                 )
        //             }), 
        //             new Material(new Color())));

        PerspectiveCamera cam = new PerspectiveCamera(
            new Vector3(0, 0, 0), // position
            new Vector3(0, 0, 0), // rotation
            75,
            0.01f,
            3000
        );

        // for (int i = 1; i < 180; i++) {
        //     System.out.println(1 / Math.tan(i * Math.PI / 180f) + "f, ");
        // }

        Renderer.init(scene, cam);

        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            public void run() {
                counter++;
                dTime = (-lTime + (lTime = System.currentTimeMillis())) / (float)10;
            if (Renderer.frame.keysHeld.contains((int)'W')) cam.position.z -= 3 * dTime;
            if (Renderer.frame.keysHeld.contains((int)'S')) cam.position.z += 3 * dTime;
            if (Renderer.frame.keysHeld.contains((int)'A')) cam.position.x -= 3 * dTime;
            if (Renderer.frame.keysHeld.contains((int)'D')) cam.position.x += 3 * dTime;
            if (Renderer.frame.keysHeld.contains((int)' ')) cam.position.y += 3 * dTime;
            if (Renderer.frame.keysHeld.contains(16)) cam.position.y -= 3 * dTime; // shift key character code
            if (Renderer.frame.keysHeld.contains(38)) cam.rotation.x -= 1 * dTime;
            if (Renderer.frame.keysHeld.contains(40)) cam.rotation.x += 1 * dTime;
            if (Renderer.frame.keysHeld.contains(37)) cam.rotation.y -= 1 * dTime;
            if (Renderer.frame.keysHeld.contains(39)) cam.rotation.y += 1 * dTime;
            if (Renderer.frame.keysHeld.contains((int)'F')) {
                if (Renderer.frame.keysHeld.contains((int)'0')) cam.setFov(10);
                if (Renderer.frame.keysHeld.contains((int)'1')) cam.setFov(20);
                if (Renderer.frame.keysHeld.contains((int)'2')) cam.setFov(30);
                if (Renderer.frame.keysHeld.contains((int)'3')) cam.setFov(40);
                if (Renderer.frame.keysHeld.contains((int)'4')) cam.setFov(50);
                if (Renderer.frame.keysHeld.contains((int)'5')) cam.setFov(60);
                if (Renderer.frame.keysHeld.contains((int)'6')) cam.setFov(70);
                if (Renderer.frame.keysHeld.contains((int)'7')) cam.setFov(80);
                if (Renderer.frame.keysHeld.contains((int)'8')) cam.setFov(90);
                if (Renderer.frame.keysHeld.contains((int)'9')) cam.setFov(100);
            } else if (Renderer.frame.keysHeld.contains((int)'M')) {
                if (Renderer.frame.keysHeld.contains((int)'0')) Renderer.renderMode = 0;
                if (Renderer.frame.keysHeld.contains((int)'1')) Renderer.renderMode = 1;
                if (Renderer.frame.keysHeld.contains((int)'2')) Renderer.renderMode = 2;
            } else {

            }
            // cube.setPosition(new Vector3((LUTs.sin(counter) * 300), 0, -100));
            cube.setRotation(new Vector3(0, counter, 0));
            // scene.children.set(0, cube);
            Pixel[][] fbuf = Renderer.render(scene, cam);
            Renderer.draw(fbuf);
            // del_line();
            // del_line();
            del_line();
            // System.out.println(1000 / (dTime * 10));
            // System.out.println(cam.position);
            System.out.println(Renderer.frame.keysHeld);
            }
        };
        timer.scheduleAtFixedRate(t, 0, 16);
    }

    static private void del_line() {
        System.out.print(String.format("\033[%dA",1)); // Move up cursor
        System.out.print("\033[2K"); // Erase line content
    }
}