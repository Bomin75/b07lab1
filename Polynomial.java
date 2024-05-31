import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class Polynomial {
    double[] coef;
    int[] exp;

    public Polynomial() {
        this.coef = new double[] { 0 };
        this.exp = new int[] { 0 };
    }

    public Polynomial(double[] coef, int[] exp) {
        this.coef = new double[coef.length];
        this.exp = new int[exp.length];
        for (int i = 0; i < coef.length; i++) {
            this.coef[i] = coef[i];
            this.exp[i] = exp[i];
        }
    }

    public Polynomial(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String poly = sc.nextLine();
        sc.close();
        String[] terms = poly.split("(?=[\\+\\-])");
        this.coef = new double[terms.length];
        this.exp = new int[terms.length];
        // for (int i = 0; i < terms.length; i++) {
        // System.out.println(i + ": term " + terms[i]);
        // }
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].equals("x")) {
                this.coef[i] = 1;
                this.exp[i] = 1;
            } else if (terms[i].contains("x")) {
                String[] nums = terms[i].split("x");
                if (nums[0].equals("+") || nums[0].equals("")) {
                    this.coef[i] = 1;
                } else if (nums[0].equals("-")) {
                    this.coef[i] = -1;
                } else {
                    this.coef[i] = Double.parseDouble(nums[0]);
                }
                if (nums.length == 1) {
                    this.exp[i] = 1;
                } else {
                    this.exp[i] = Integer.parseInt(nums[1]);
                }
            } else {
                this.coef[i] = Double.parseDouble(terms[i]);
                this.exp[i] = 0;
            }
        }
    }

    public void saveToFile(String fileName) throws IOException {
        String poly = "";
        String tmpCoef = "";
        boolean isLeadingZero = true;
        for (int i = 0; i < coef.length; i++) {
            if (coef[i] > 0 && !isLeadingZero) {
                tmpCoef = "+";
            } else {
                tmpCoef = "";
            }

            if (coef[i] == 0) {
                continue;
            } else {
                isLeadingZero = false;
            }

            tmpCoef += Double.toString(coef[i]);
            if (exp[i] == 0) {
                poly = poly + tmpCoef;
            } else {
                poly = poly + tmpCoef + "x" + Integer.toString(exp[i]);
            }
        }
        FileWriter writer = new FileWriter(fileName);
        writer.write(poly);
        writer.close();
    }

    public Polynomial add(Polynomial poly) {
        int maxLen = exp.length + poly.exp.length;
        double[] newCoef = new double[maxLen];
        int[] newExp = new int[maxLen];

        for (int i = 0; i < exp.length; i++) {
            newCoef[i] = coef[i];
            newExp[i] = exp[i];
        }

        int k = coef.length;
        boolean inExpArray;
        for (int i = 0; i < poly.exp.length; i++) {
            inExpArray = false;
            for (int j = 0; j < exp.length; j++) {
                if (poly.exp[i] == newExp[j]) {
                    newCoef[j] += poly.coef[i];
                    inExpArray = true;
                    break;
                }
            }
            if (!inExpArray) {
                newExp[k] = poly.exp[i];
                newCoef[k] = poly.coef[i];
                k++;
            }
        }

        return removeZeros(new Polynomial(newCoef, newExp));

    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coef.length; i++) {
            result += coef[i] * Math.pow(x, exp[i]);
        }
        return result;
    }

    public boolean hasRoot(double root) {
        return evaluate(root) == 0;
    }

    public Polynomial multiply(Polynomial poly) {
        Polynomial result = new Polynomial();
        double[] tmpCoef = new double[poly.exp.length];
        int[] tmpExp = new int[poly.exp.length];
        for (int i = 0; i < exp.length; i++) {
            for (int j = 0; j < poly.exp.length; j++) {
                tmpCoef[j] = coef[i] * poly.coef[j];
                tmpExp[j] = exp[i] + poly.exp[j];
            }
            result = result.add(new Polynomial(tmpCoef, tmpExp));
        }

        return removeZeros(result);
    }

    public Polynomial removeZeros(Polynomial poly) {
        int finalLen = 0;
        for (int i = 0; i < poly.coef.length; i++) {
            if (poly.coef[i] != 0) {
                finalLen++;
            }
        }
        double[] newCoef = new double[finalLen];
        int[] newExp = new int[finalLen];

        int j = 0; // index of the new arrays
        for (int i = 0; i < poly.coef.length; i++) {
            if (poly.coef[i] != 0) {
                newCoef[j] = poly.coef[i];
                newExp[j] = poly.exp[i];
                j++;
            }
        }
        return new Polynomial(newCoef, newExp);
    }
}