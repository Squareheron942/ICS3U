import java.util.*;

public class Main {
    static boolean l1 = true;
    public static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        // String inputs = cin.nextLine();
        if (true) {
            int num1 = cin.nextInt();
            int num2 = cin.nextInt();
            int num3 = cin.nextInt();
            // int num1 = Integer.parseInt(inputs.split(" ")[0]);
            // int num2 = Integer.parseInt(inputs.split(" ")[1]);
            // int num3 = Integer.parseInt(inputs.split(" ")[2]);
            int g = gcd(gcd(num1, num2), num3);
            if (num1/g < 0) {
                g *= -1;
            }
            String ans = String.valueOf(factor(num1, num2, num3, 1, g));
            if (ans == "false") {
                num1 /= g;
                num2 /= g;
                num3 /= g;
                if (g == 1) {
                    System.out.println(g + factor(num1, num2, num3, 2, g));
                }
                return;
            } else if (l1) {
                String part1 = "(" + ans.split("\\(")[1];
                String part2 = "(" + ans.split("\\(")[2];
                // System.out.println(part1 + part2 + " " + part1.split("\\(")[1].split("x")[0].length());
                // System.out.println(part1 + part2 + part1.split("\\(")[1].split("x")[0].length());
                // int part1_1 = 1, part1_2 = 1, part2_1 = 1, part2_2 = 1;
                // System.out.println("part1_1: " + part1.split("\\(")[1].split("x")[0] + " part1_2: " + part1.split("\\(")[1].split("x")[1].split("\\)")[0] + " part2_1: " + part2.split("\\(")[1].split("x")[0] + " part2_2: " + part2.split("\\(")[1].split("x")[1].split("\\)")[0]);
                int part1_1 = Integer.parseInt(((((int) part1.split("\\(")[1].split("x")[0].length()) == 0) || (((int) part1.split("\\(")[1].split("x")[0].charAt(0)) == 0)) ? "1" : part1.split("\\(")[1].split("x")[0]);
                int part1_2 = Integer.parseInt(part1.split("\\(")[1].split("x")[1].split("\\)")[0]);
                int part2_1 = Integer.parseInt(((((int) part2.split("\\(")[1].split("x")[0].length()) == 0) || (((int) part2.split("\\(")[1].split("x")[0].charAt(0)) == 0)) ? "1" : part2.split("\\(")[1].split("x")[0]);
                int part2_2 = Integer.parseInt(part2.split("\\(")[1].split("x")[1].split("\\)")[0]);

                int g1 = (gcd(part1_1, part1_2));
                int g2 = (gcd(part2_1, part2_2));
                if (part1_1 * g1 < 0) {
                    g1 *= -1;
                }
                if (part2_1 * g2 < 0) {
                    g2 *= -1;
                }
                if (g1 * g2 == 1) { 
                    if (part1_1/g1 == 1) {
                        if (part2_1/g2 == 1) {
                            ans = "(x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        } else {
                            ans = "(x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(" + String.valueOf(part2_1/g2 > 0 ? "+" + part2_1/g2 : part2_1/g2) + "x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        }
                    } else {
                        if (part2_1/g2 == 1) { //(x + )(x
                            ans = "(" + String.valueOf(part1_1/g1 > 0 ? "+" + part1_1 : part1_1) + "x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        } else {
                            ans = "(" + String.valueOf(part1_1/g1 > 0 ? "+" + part1_1 : part1_1) + "x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(" + String.valueOf(part2_1/g2 > 0 ? "+" + part2_1/g2 : part2_1/g2) + "x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        }
                    }
                } else {
                    if (part1_1/g1 == 1) { //(x
                        if (part2_1/g2 == 1) { //(x + )(x
                            ans = String.valueOf(g2*g1) + "(x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        } else {
                            ans = String.valueOf(g2*g1) + "(x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(" + String.valueOf(part2_1/g2 > 0 ? "+" + part2_1/g2 : part2_1/g2) + "x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        }
                    } else {
                        if (part2_1/g2 == 1) { //(x + )(x
                            ans = String.valueOf(g2*g1) + "(" + String.valueOf(part1_1/g1 > 0 ? "+" + part1_1 : part1_1) + "x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        } else {
                            ans = String.valueOf(g2*g1) + "(" + String.valueOf(part1_1/g1 > 0 ? "+" + part1_1 : part1_1) + "x" + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(" + String.valueOf(part2_1/g2 > 0 ? "+" + part2_1/g2 : part2_1/g2) + "x" + String.valueOf(part2_2/g1 > 0 ? "+" + part2_2/g1 : part2_2/g1) + ")";
                        }
                    }
                }
                // ans = String.valueOf(g1 * g2 == 1 ? "\0" : g1*g2) + "(" + String.valueOf(part1_1/g1 == 1 ? "x" : part1_1/g1 + "x") + String.valueOf(part1_2/g1 > 0 ? "+" + part1_2/g1 : part1_2/g1) + ")(" + String.valueOf(part2_1 / g2 == 1 ? "x" : part2_1/g2 + "x") + String.valueOf(part2_2/g2 > 0 ? "+" + part2_2/g2 : part2_2/g2) + ")";
                // System.out.println(part1_1 + " " + part1_2);
                // System.out.println(ans.equals("(x+3)(x+2)"));
            }
            // int g = 1;
            System.out.println(ans);
        }
    }
    public static String factor(int a, int b, int c, int tries, int gx) {
        // System.out.println(a + " " + b + " " + c + " " + tries);
        int f1 = 1, f2 = 1;
        if (c > 0 && b > 0) {
            // System.out.println("Case 1");
            for (int i = 0; i < Math.max(b, c) * a; i++) {
                for (int j = 0; j < Math.max(b, c) * a; j++) {
                    // System.out.println(i + " " + j + " " + b + " " + c);
                    if (j * i == c * a && j + i == b) {
                        for (int k = 1; k <= a; k++) {
                            if (a % k == 0) {
                                int l = a/k;
                                if ((i/k)*(j/l) == c) {
                                    f1 = k;
                                    f2 = l;
                                    i /= k;
                                    j /= l;
                                }
                            }
                        }
                        if (f1 == 1) {
                            if (f2 == 1) {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        } else {
                            if (f2 == 1) {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        }
                    }
                }
            }
        } else if (c > 0 && b < 0) {
            // System.out.println("Case 2");
            for (int i = b; i < c * a; i++) {
                for (int j = b; j < c * a; j++) {
                    // System.out.println(i + " " + j + " ");
                    if ((i * a) + j == b && i * j == c) {
                        // System.out.println(i);
                        // System.out.println(j);
                        for (int k = 1; k <= a; k++) {
                            if (a % k == 0) {
                                int l = a/k;
                                if ((i/k)*(j/l) == c) {
                                    f1 = k;
                                    f2 = l;
                                    i /= k;
                                    j /= l;
                                }
                            }
                        }
                        if (f1 == 1) {
                            if (f2 == 1) {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        } else {
                            if (f2 == 1) {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        }
                        // return (String) "(" + String.valueOf((f1 == 1) ? "\0" : f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + String.valueOf((f2 == 1) ? "\0" : f2) + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                    }
                }
            }
        } else if (c < 0 && b > 0) {
            // System.out.println(a + " " + b + " " + c);
            for (int i = c * a; i < -c; i++) {
                for (int j = c * a; j < -c; j++) {
                    if (i + j * a == b && i * j == c) {
                        for (int k = 1; k <= a; k++) {
                            if (a % k == 0) {
                                int l = a/k;
                                if ((i/k)*(j/l) == c) {
                                    f1 = k;
                                    f2 = l;
                                    i /= k;
                                    j /= l;
                                }
                            }
                        }
                        if (f1 == 1) {
                            if (f2 == 1) {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        } else {
                            if (f2 == 1) {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        }
                    }
                }
            }
        } else if (c < 0 && b < 0) {
            for (int i = Math.min(b, c) * a; i < -Math.min(b, c * a); i++) {
                for (int j = Math.min(b, c) * a; j < -Math.min(b, c * a); j++) {
                    if (i + j == b && i * j == c * a) {
                        for (int k = 1; k <= a; k++) {
                            if (a % k == 0) {
                                int l = a/k;
                                if ((i/k)*(j/l) == c) {
                                    f1 = k;
                                    f2 = l;
                                    i /= k;
                                    j /= l;
                                }
                            }
                        }
                        if (f1 == 1) {
                            if (f2 == 1) {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        } else {
                            if (f2 == 1) {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            } else {
                                return (String) "(" + String.valueOf(f1) + "x" + String.valueOf((j > 0)? "+" + j : j) + ")(" + f2 + "x" + String.valueOf(i > 0 ? "+" + i : i) + ")";
                            }
                        }
                    }
                }
            }
        } else if (c == 0) {
            l1 = false;
            int gc = gcd(a, b);
            if (a * gc < 0) {
                gc *= -1;
            }
            if (gc == 1) {
                if (a/gc == 1) {
                    return (String) "x(x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                } else {
                    return (String) "x(" + String.valueOf(a/gc) + "x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                }
            } else if (gc == -1) {
                if (a/gc == 1) {
                    return (String) "-x(x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                } else {
                    return (String) "-x(" + String.valueOf(a/gc) + "x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                }
            } else {
                if (a/gc == 1) {
                    return (String) String.valueOf(gc) + "x(x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                } else {
                    return (String) String.valueOf(gc) + "x(" + String.valueOf(a/gc) + "x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
                }
            }
            // return (String) String.valueOf((gc == 1) ? "" : gc == -1 ? "-" : gc) + "x(" + String.valueOf(a/gc == 1 ? "" : a/gc) + "x" + String.valueOf(b/gc > 0 ? "+" + b/gc : b/gc) + ")";
        } else if (b == 0) {
            if (Math.sqrt(Math.abs(c)) % 1 == 0 && Math.sqrt(Math.abs(a)) % 1 == 0) {
                return (String) "(" + (int) Math.sqrt(Math.abs(a)) + "x+" + (int) Math.sqrt(Math.abs(c)) + ")(" + (int) Math.sqrt(Math.abs(a)) + "x-" + (int) Math.sqrt(Math.abs(c)) + ")";
            }
        }
        // System.out.println(a + " " + b + " " + c + " " + tries);
        if (tries == 1) {
            return "false";
        } else if (tries == 2) {
            return "(" + String.valueOf(a == 1 ? "\0" : a) + "x^2" + String.valueOf(b == 1 ? "\0" : (b > 0)? "+" + b : b) + "x" + String.valueOf((c > 0)? "+" + c : c) + ")";
        }
        return "false";
    }
    public static int gcd(int a, int b) {return b==0 ? a : gcd(b, a%b);}
}