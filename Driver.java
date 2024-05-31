import java.io.IOException;
import java.io.File;

public class Driver {

    public static void testFileIO() throws IOException {
        System.out.println("Testing file constructor and saveToFile method...");

        System.out.println("Case 1");
        File emptyPolyFile = new File("zeroPoly.txt");
        Polynomial emptyPoly = new Polynomial(emptyPolyFile);
        System.out.println("Expected: 0.0");
        System.out.println("Actual: " + emptyPoly.evaluate(0.1));
        emptyPoly.saveToFile("zeroPolyResult.txt");

        System.out.println("Case 2");
        File edgeCasePolyFile = new File("edgeCasePoly.txt");
        Polynomial edgeCasePoly = new Polynomial(edgeCasePolyFile);
        System.out.println("Expected: 7.099");
        System.out.println("Actual: " + edgeCasePoly.evaluate(0.1));
        edgeCasePoly.saveToFile("edgeCasePolyResult.txt");

        System.out.println("Case 3");
        File edgeCasePolyFile2 = new File("edgeCasePoly2.txt");
        Polynomial edgeCasePoly2 = new Polynomial(edgeCasePolyFile2);
        System.out.println("Expected: 7.099");
        System.out.println("Actual: " + edgeCasePoly2.evaluate(0.1));
        edgeCasePoly2.saveToFile("edgeCasePolyResult2.txt");

        System.out.println("Case 4");
        File edgeCasePolyFile3 = new File("edgeCasePoly3.txt");
        Polynomial edgeCasePoly3 = new Polynomial(edgeCasePolyFile3);
        System.out.println("Expected: 7.099");
        System.out.println("Actual: " + edgeCasePoly3.evaluate(0.1));
        edgeCasePoly3.saveToFile("edgeCasePolyResult3.txt");
    }

    public static void testAdd() {
        System.out.println("Testing add method...");

        double[] coef = { 0, 0, 1, 6, 3, 4, 5, 2 };
        int[] exp = { 7, 5, 3, 1, 6, 4, 2, 0 };
        Polynomial poly = new Polynomial(coef, exp);

        System.out.println("Case 1");

        double[] coef1 = { 1, 1, 1, 1 };
        int[] exp1 = { 1, 2, 3, 4 };
        Polynomial poly1 = new Polynomial(coef1, exp1);

        System.out.println("Expected: 2.762503");

        System.out.println("Actual:");
        System.out.println((poly1.add(poly)).evaluate(0.1));
        System.out.println((poly.add(poly1)).evaluate(0.1));

        System.out.println("Case 2");

        double[] coef2 = { -4, -3, -2, -1 };
        int[] exp2 = { 4, 6, 0, 3 };
        Polynomial poly2 = new Polynomial(coef2, exp2);

        System.out.println("Expected: 0.6500000000000001");

        System.out.println("Actual:");
        System.out.println((poly2.add(poly)).evaluate(0.1));
        System.out.println((poly.add(poly2)).evaluate(0.1));
    }

    public static void testMultiply() throws IOException {
        System.out.println("Testing multiply method...");

        double[] coef = { 5, 4, 3, 2, 1 };
        int[] exp = { 0, 2, 4, 1, 3 };
        Polynomial poly = new Polynomial(coef, exp);

        System.out.println("Case 1");

        double[] coef1 = { 1, 1 };
        int[] exp1 = { 1, 2 };
        Polynomial poly1 = new Polynomial(coef1, exp1);

        System.out.println("Expected: 0.576543");

        System.out.println("Actual:");
        System.out.println((poly1.multiply(poly)).evaluate(0.1));
        System.out.println((poly.multiply(poly1)).evaluate(0.1));

        System.out.println("Case 2");

        double[] coef2 = { 0, 0, 0, 0 };
        int[] exp2 = { 4, 6, 100, 3 };
        Polynomial poly2 = new Polynomial(coef2, exp2);

        System.out.println("Expected: 0.0");

        System.out.println("Actual:");
        System.out.println((poly2.multiply(poly)).evaluate(0.1));
        System.out.println((poly.multiply(poly2)).evaluate(0.1));
    }

    public static void main(String[] args) throws IOException {
        testFileIO();
        testAdd();
        testMultiply();
    }
}
