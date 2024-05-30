import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double[] c3 = { 6, 0, 0, 5 };
        int[] e3 = { 0, 1, 2, 3 };
        Polynomial p3 = new Polynomial(c3, e3);
        double[] c4 = { 0, -2, 0, 0, -9 };
        int[] e4 = { 0, 1, 2, 3, 4 };
        Polynomial p4 = new Polynomial(c4, e4);
        Polynomial s = p3.add(p4);
        System.out.println("s(0.1)=" + s.evaluate(0.1));
        if (s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");
        Polynomial s1 = p4.add(p3);
        System.out.println("s1(0.1)=" + s1.evaluate(0.1));
        if (s1.hasRoot(1))
            System.out.println("1 is a root of s1");
        else
            System.out.println("1 is not a root of s1");

        double[] c1 = { 6, 3, -2, 5 };
        int[] e1 = { 0, 2, 1, 3 };
        Polynomial p1 = new Polynomial(c1, e1);

        double[] c2 = { 5, -3, 7 };
        int[] e2 = { 0, 2, 8 };
        Polynomial p2 = new Polynomial(c2, e2);

        Polynomial result = p1.add(p2);

        System.out.println("Print the resulting polynomial");
        for (int i = 0; i < result.coef.length; i++) {
            System.out.println(result.coef[i] + "x^" + result.exp[i]);
        }

        Polynomial result2 = p1.multiply(p2);

        System.out.println("Print the resulting polynomial");
        for (int i = 0; i < result2.coef.length; i++) {
            System.out.println(result2.coef[i] + "x^" + result2.exp[i]);
        }

        s.saveToFile("bomin.txt");
        result.saveToFile("result.txt");
        result2.saveToFile("result2.txt");
    }
}