import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] sides = new int[3];
    static String cancel = Arrays.toString(new int[] {0, 0, 0});
    static String sidesList;
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("-------------------------\n|  Triangle Calculator  |\n-------------------------\n");

        sides = getInput();

        while (!sidesList.equals(cancel)) {
            // check for invalid triangle
            if (sides.length != 3) {System.out.println(sidesList + " Invalid: please enter three sides. (" + sides.length + " value" + (sides.length != 1 ? 's' : "") + " entered)");sides = getInput();continue;}
            if (!isTriangle(sides)) {System.out.println(sidesList + " Triangle cannot be formed.");sides = getInput();continue;}

            output(sides);

            sides = getInput();
        }

        System.out.println(sidesList + " Program was terminated by user.");
        cin.close();
    }

    static int[] getInput() {
        System.out.println("Enter the three sides of the triangle (on one line, separated by spaces):\n");
        int[] sides = Arrays.stream(cin.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println();
        sidesList = Arrays.toString(sides);
        return sides;
    }

    static boolean isTriangle(int[] sides) {
        for (int i = 0; i < 3; i++) {
            if (sides[i] <= 0) return false;
            if ((sides[(0 + i > 2 ? (0 + i) % 3 : 0 + i)] + sides[(1 + i > 2 ? (1 + i) % 3 : 1 + i)]) <= sides[(2 + i > 2 ? (2 + i) % 3 : 2 + i)]) return false;
        }

        // if ((sides[0] + sides[1]) <= sides[2]) return false;
        // if ((sides[1] + sides[2]) <= sides[0]) return false;
        // if ((sides[2] + sides[0]) <= sides[1]) return false;

        return true;
    }

    static String[] classifyTriangle(int[] s) {
        String[] angles = {"acute", "right", "obtuse"}, shapes = {"scalene", "isoceles", "equilateral"};

        Arrays.sort(s);
        
        return new String[] {shapes[triangleType(s)], angles[simpleAngles(s)]};
    }

    static int triangleType(int[] sides) {
        // check for obtuse
        if (sides[0] == sides[1] && sides[1] == sides[2]) return 2;
        // check for scalene
        if (sides[0] != sides[1] && sides[1] != sides[2] && sides[2] != sides[0]) return 0;
        // only other possible one is isoceles
        return 1;
    }

    static int simpleAngles(int[] sides) {
        // a^2 + b^2 = c^2 when right triangle, meaning it will be less or more when a different angle is present
        int dSides = sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1]);

        // if it is c^2 is less then acute, if equal then right, if more then obtuse
        return dSides < 0 ? 0 : dSides == 0 ? 1 : 2;
    }

    static double[] calcAngles(int[] sides) {
        // used to convert radians to degrees
        double convertF = 180 / Math.PI;

        int a = sides[0], b = sides[1], c = sides[2];
        double A, B, C;

        // cosine law
        A = Math.acos((b * b + c * c - a * a) / (2.0 * b * c)) * convertF;
        B = Math.acos((c * c + a * a - b * b) / (2.0 * c * a)) * convertF;
        C = Math.acos((a * a + b * b - c * c) / (2.0 * a * b)) * convertF;

        // round to 1 decimal
        A = Math.round(A * 10) / 10.0;
        B = Math.round(B * 10) / 10.0;
        C = Math.round(C * 10) / 10.0;

        return new double[] {A, B, C};
    }

    static int perim(int[] sides) {
        int p = 0;
        for (int i = 0; i < 3; i++) p += sides[i];
        return p;
    }

    static double area(int[] sides) {
        int p = perim(sides);
        int a = sides[0], b = sides[1], c = sides[2];

        double s = p / 2.0;

        // heron formula to calculate area from sides
        return Math.round(Math.sqrt(s * (s - a) * (s - b) * (s - c)) * 10) / 10.0;
    }

    static void output(int[] sides) {
        String[] classification = classifyTriangle(sides);
        double[] angles = calcAngles(sides);
        System.out.println("Information:\n");
        System.out.println("shape: " + classification[0]);
        System.out.println("type: " + classification[1]);
        System.out.println();
        System.out.println("sides: \n  a: " + sides[0] + "\n  b: " + sides[1] + "\n  c: " + sides[2]);
        System.out.println("angles: \n  A: " + angles[0] + "\n  B: " + angles[1] + "\n  C: " + angles[2]);
        System.out.println();
        System.out.println("perimeter: " + perim(sides));
        System.out.println("area: " + area(sides));
        drawTriangle(sides);
        System.out.println();
    }

    static void drawTriangle(int[] sides) {
        int b = sides[1], c = sides[2];
        Vector2 A = new Vector2(0, 0, 'a'), B = new Vector2(c, 0, 'b'), C = new Vector2(b * Math.cos(calcAngles(sides)[0] * Math.PI / 180), 2 * area(sides) / c, 'c');

        // correct for if c is further left than b (probably not possible but just in case)
        if (C.x < A.x) {
            A.x += A.x - C.x;
            B.x += A.x - C.x;
            C.x = 0;
        }

        Vector2[] newPoints = resizeGrid(A, B, C, 40);
        A = newPoints[0];
        B = newPoints[1];
        C = newPoints[2];

        // create grid wide enough to fit, check if b is further right than c
        char[][] arr = new char[(int)Math.round(C.y + 1)][(int)Math.round(Math.max(B.x, C.x) + 1)];

        // fill each array with spaces
        Arrays.stream(arr).forEach(v -> Arrays.fill(v, ' '));
        System.out.println("Point positions:\n  A: " + A.toString() + "\n  B: " + B.toString() + "\n  C: " + C.toString() + "\n");

        System.out.println("Diagram of triangle:");

        // draw line from A to C, algorithm only works when going forwards so start from furthest Vector2 left
        if (C.x < A.x) findLine(C, A, 'b').forEach(v -> arr[(int)Math.round(v.y)][(int)Math.round(v.x)] = v.character);
        else findLine(A, C, 'b').forEach(v -> arr[(int)Math.round(v.y)][(int)Math.round(v.x)] = v.character);

        // same for line between C and B
        if (C.x > B.x) findLine(B, C, 'a').forEach(v -> arr[(int)Math.round(v.y)][(int)Math.round(v.x)] = v.character);
        else findLine(C, B, 'a').forEach(v -> arr[(int)Math.round(v.y)][(int)Math.round(v.x)] = v.character);

        // longest side is always on the bottom so this is possible, essentially drawing the bottom side
        for (int i = 0; i < arr[0].length; i++) arr[0][i] = (i == Math.round(arr[0].length / 2)) ? 'c' : '*';

        // prints the image
        displayGrid(arr);        
    }

    static void displayGrid(char[][] arr) {
        for (int i = 0; i < arr[0].length * 2 + 3; i++) System.out.print('_');
        System.out.println();
        // print the display based on the character array that represents the image, starting from the top
        for (int y = arr.length - 1; y >= 0; y--) {
            System.out.print("| ");
            for (int x = 0; x < arr[y].length; x++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.print('|');
            System.out.println();
        }
        for (int i = 0; i < arr[0].length * 2 + 3; i++) System.out.print(((char)175));
        System.out.println();
    }

    // scales all of the point positions so that the triangle appears to have a certain width (for readability)
    static Vector2[] resizeGrid(Vector2 A, Vector2 B, Vector2 C, double fWidth) {
        // MAKE SURE TO ADJUST X AND Y OF EACH POINT SO EVERYTHING IS IN THE GRID FIRST
        // get width of pre, calculate scale factor
        double width = Math.max(B.x, C.x);
        double scaleF = fWidth / width;
        // multiply x and y of each by that factor
        A.x *= scaleF;
        A.y *= scaleF;
        B.x *= scaleF;
        B.y *= scaleF;
        C.x *= scaleF;
        C.y *= scaleF;
        return new Vector2[] {A, B, C};
    }

    static List<Vector2> findLine(Vector2 A, Vector2 B, char c)
    {
        // bresenham's line drawing algorithm
        List<Vector2> line = new ArrayList<Vector2>();
 
        int dx = (int)Math.round(Math.abs(B.x - A.x));
        int dy = (int)Math.round(Math.abs(B.y - A.y));

        A.x = Math.round(A.x);
        A.y = Math.round(A.y);
        B.x = Math.round(B.x);
        B.y = Math.round(B.y);

        int sx = A.x < B.x ? 1 : -1; 
        int sy = A.y < B.y ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
 
        while (true) 
        {
            line.add(new Vector2(A.x, A.y, (Math.round(A.x) == Math.round(dx / 2) || (Math.round(A.y) == Math.round(dy / 2))) ? c : '*'));
 
            if (Math.round(A.x) == Math.round(B.x) && Math.round(A.y) == Math.round(B.y)) break;
 
            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                A.x = A.x + sx;
            }
 
            if (e2 < dx) {
                err = err + dx;
                A.y = A.y + sy;
            }
        }                                
        return line;
    }
}

class Vector2 {
    // x and y of the Vector2
    double x, y;
    char character;

    public Vector2(double xscale, double yscale, char c) {
        x = xscale;
        y = yscale;
        character = c;
    }

    public Vector2 normalize() {
        return new Vector2(Math.max(x, y) == 0 ? 0 : (x / Math.max(x, y)), Math.max(x, y) == 0 ? 0 : (y / Math.max(x, y)), character);
    }
    // overrides the standard toString function which prints the class id, prints the x and y instead
    public @Override String toString() {
        return "(" + Math.round(x * 100) / 100.0 + ", " + Math.round(y * 100) / 100.0 + ")";
    }
}