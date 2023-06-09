import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;


import filereaders.OBJReader;
import objects.gameobjects.Cube;
import objects.gameobjects.GameObject;
import objects.gameobjects.Line;
import rendering.Renderer;
import rendering.Scene;
import rendering.cameras.PerspectiveCamera;
import util.Color;
import util.LUTs;
import util.Vector3;
import util.Vertex;

public class Main {
    static Scene scene = new Scene(); 
    static long lTime = System.currentTimeMillis();
    static float dTime; 
    static int counter = 0;
    public static void main(String[] args) {     
<<<<<<< HEAD:Final Project (GUI)/src/Main.java
        GameObject[] os = OBJReader.read(new File("assets/models/teapot/teapot_out.obj"), new Vector3(100f, 100f, 100f));
        for (GameObject gameObject : os) {
            scene.add(gameObject);
        }

        // scene.add(new Cube(new Vector3(), new Vector3(100, 100, 100), new Vector3(), new Color(0xff0000)));
=======

        // Cube cube = new Cube(
        //     new Vector3(0, 0, 0), // position
        //     new Vector3(100, 100, 100), // dimensions
        //     new Vector3(0, 0, 0), // rotation
        //     new Color(1, 0, 0) // vertex color
        // );

        // scene.add(cube);

        // Cube c2 = new Cube(
        //     new Vector3(-1000, 0, -1000), // position
        //     new Vector3(30, 30, 30), // dimensions
        //     new Vector3(), // rotation
        //     new Color(1, 0, 0) // vertex color
        // );

        // scene.add(c2);

        GameObject o = OBJReader.read(new File("sphere.obj"), new Vector3(100, 100, 100));
        scene.add(o);
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/Main.java

        // scene.add(new Cube(new Vector3(), new Vector3(100, 100, 100), new Vector3(), new Color()));

        scene.add(
<<<<<<< HEAD:Final Project (GUI)/src/Main.java
            new Line(
                new Vertex[] {
                    new Vertex(
                        new Vector3(0, 0, 0),
                        new Color(0xff0000)
                    ),
                    new Vertex(
                        new Vector3(1000, 0, 0), 
                        new Color(0xff0000)
                    )
                }
            )
        );

        scene.add(
            new Line(
                new Vertex[] {
                    new Vertex(
                        new Vector3(0, 0, 0),
                        new Color(0x00ff00)
                    ),
                    new Vertex(
                        new Vector3(0, 1000, 0), 
                        new Color(0x00ff00)
                    )
                }
            )
        );

        scene.add(
            new Line(
                new Vertex[] {
                    new Vertex(
                        new Vector3(0, 0, 0),
                        new Color(0x0000ff)
                    ),
                    new Vertex(
                        new Vector3(0, 0, 1000), 
                        new Color(0x0000ff)
                    )
                }
=======
            new GameObject(
                new Mesh(
                    new Triangle[] {
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 0, -1000), new Color(1, 0, 0)),
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(0, 0, -3), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 0, 3), new Color(1, 0, 0)),
                                new Vertex(new Vector3(1000, 0, 0), new Color(0, 1, 0)),
                            }
                        ),
                        new Triangle(
                            new Vertex[] {
                                new Vertex(new Vector3(-3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(3, 0, 0), new Color(1, 0, 0)),
                                new Vertex(new Vector3(0, 1000, 0), new Color(0, 0, 1)),
                            }
                        )
                    }
                ),
                new Material(new Color())
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/Main.java
            )
        );

        PerspectiveCamera cam = new PerspectiveCamera(
            new Vector3(0, 0, 0), // position
            new Vector3(0, 0, 0), // rotation
            75,
            1f,
            3000
        );

        Renderer.init(scene, cam);
        System.out.println();

        System.out.println(Vector3.normalize(new Vector3(1, 1, 1)));

        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            public void run() {
                counter++;
                dTime = (-lTime + (lTime = System.currentTimeMillis())) / (float)10;
<<<<<<< HEAD:Final Project (GUI)/src/Main.java
            if (Renderer.frame.keysHeld.contains((int)'W')) {cam.position().z -= 3 * dTime * LUTs.cos(cam.rotation().y);cam.position().x += 3 * dTime * LUTs.sin(cam.rotation().y);}
            if (Renderer.frame.keysHeld.contains((int)'S')) {cam.position().z += 3 * dTime * LUTs.cos(cam.rotation().y);cam.position().x -= 3 * dTime * LUTs.sin(cam.rotation().y);}
            if (Renderer.frame.keysHeld.contains((int)'A')) {cam.position().z -= 3 * dTime * LUTs.sin(cam.rotation().y);cam.position().x -= 3 * dTime * LUTs.cos(cam.rotation().y);}
            if (Renderer.frame.keysHeld.contains((int)'D')) {cam.position().z += 3 * dTime * LUTs.sin(cam.rotation().y);cam.position().x += 3 * dTime * LUTs.cos(cam.rotation().y);}
            if (Renderer.frame.keysHeld.contains((int)' ')) cam.position().y += 3 * dTime;
            if (Renderer.frame.keysHeld.contains(16)) cam.position().y -= 3 * dTime; // shift key character code
            if (Renderer.frame.keysHeld.contains(38)) cam.rotation().x -= 1 * dTime; // up arrow
            if (Renderer.frame.keysHeld.contains(40)) cam.rotation().x += 1 * dTime; // down arrow
            if (Renderer.frame.keysHeld.contains(37)) cam.rotation().y -= 1 * dTime; // left arrow
            if (Renderer.frame.keysHeld.contains(39)) cam.rotation().y += 1 * dTime; // right arrow
=======
            if (Renderer.frame.keysHeld.contains((int)'W')) {cam.position.z -= 3 * dTime * LUTs.cos(cam.rotation.y);cam.position.x += 3 * dTime * LUTs.sin(cam.rotation.y);}
            if (Renderer.frame.keysHeld.contains((int)'S')) {cam.position.z += 3 * dTime * LUTs.cos(cam.rotation.y);cam.position.x -= 3 * dTime * LUTs.sin(cam.rotation.y);}
            if (Renderer.frame.keysHeld.contains((int)'A')) {cam.position.z -= 3 * dTime * LUTs.sin(cam.rotation.y);cam.position.x -= 3 * dTime * LUTs.cos(cam.rotation.y);}
            if (Renderer.frame.keysHeld.contains((int)'D')) {cam.position.z += 3 * dTime * LUTs.sin(cam.rotation.y);cam.position.x += 3 * dTime * LUTs.cos(cam.rotation.y);}
            if (Renderer.frame.keysHeld.contains((int)' ')) cam.position.y += 3 * dTime;
            if (Renderer.frame.keysHeld.contains(16)) cam.position.y -= 3 * dTime; // shift key character code
            if (Renderer.frame.keysHeld.contains(38)) cam.rotation.x -= 1 * dTime; // up arrow
            if (Renderer.frame.keysHeld.contains(40)) cam.rotation.x += 1 * dTime; // down arrow
            if (Renderer.frame.keysHeld.contains(37)) cam.rotation.y -= 1 * dTime; // left arrow
            if (Renderer.frame.keysHeld.contains(39)) cam.rotation.y += 1 * dTime; // right arrow
            if (Renderer.frame.keysHeld.contains((int)'P')) o.setPosition(new Vector3(1, 1, 1));
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/Main.java
            if (Renderer.frame.keysHeld.contains((int)'F')) {
                if (Renderer.frame.keysHeld.contains((int)'0')) cam.setFov(0);
                if (Renderer.frame.keysHeld.contains((int)'1')) cam.setFov(10);
                if (Renderer.frame.keysHeld.contains((int)'2')) cam.setFov(20);
                if (Renderer.frame.keysHeld.contains((int)'3')) cam.setFov(30);
                if (Renderer.frame.keysHeld.contains((int)'4')) cam.setFov(40);
                if (Renderer.frame.keysHeld.contains((int)'5')) cam.setFov(50);
                if (Renderer.frame.keysHeld.contains((int)'6')) cam.setFov(60);
                if (Renderer.frame.keysHeld.contains((int)'7')) cam.setFov(70);
                if (Renderer.frame.keysHeld.contains((int)'8')) cam.setFov(80);
                if (Renderer.frame.keysHeld.contains((int)'9')) cam.setFov(90);
            } else if (Renderer.frame.keysHeld.contains((int)'M')) {
                if (Renderer.frame.keysHeld.contains((int)'0')) Renderer.renderMode = 0;
                if (Renderer.frame.keysHeld.contains((int)'1')) Renderer.renderMode = 1;
                if (Renderer.frame.keysHeld.contains((int)'2')) Renderer.renderMode = 2;
                if (Renderer.frame.keysHeld.contains((int)'3')) Renderer.renderMode = 3;
                if (Renderer.frame.keysHeld.contains((int)'4')) Renderer.renderMode = 4;
            } else {

            }
            // c2.setDimensions(new Vector3((LUTs.sin(counter) * 100), 100, 100));
<<<<<<< HEAD:Final Project (GUI)/src/Main.java
            // os[0].setPosition(new Vector3(0, LUTs.sin(counter) * 50 + 50, 0));
            // os[0].setRotation(new Vector3(0, counter, 0));
            scene.sun.setDirection(new Vector3(90, 99, 0));
=======
            // o.setPosition(new Vector3(0, 0, -5));
            o.setRotation(new Vector3(counter, 0, 0));
>>>>>>> parent of f155222 (Added vertex shader support):Final Project (GUI)/Main.java
            // scene.children.set(0, cube);
            Color[][] fbuf = Renderer.render(scene, cam);
            Renderer.draw(fbuf);
            del_line();
            System.out.println((int)(100 / dTime));
            }
        };
        timer.scheduleAtFixedRate(t, 0, 16);
    }

    static private void del_line() {
        System.out.print(String.format("\033[%dA",1)); // Move up cursor
        System.out.print("\033[2K"); // Erase line content
    }
}