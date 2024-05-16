
public class Polynomial {
    double[] coef;

    public Polynomial() {
        this.coef = new double[0];
    }

    public Polynomial(double[] coef) {
        this.coef = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            this.coef[i] = coef[i];
        }
    }

    public Polynomial add(Polynomial poly) {
        int minLen;
        Polynomial result;
        if (poly.coef.length > coef.length) {
            minLen = coef.length;
            result = new Polynomial(poly.coef);
        } else {
            minLen = poly.coef.length;
            result = new Polynomial(coef);
        }
        for (int i = 0; i < minLen; i++) {
            result.coef[i] = coef[i] + poly.coef[i];
        }
        return result;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coef.length; i++) {
            result += coef[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double root) {
        return evaluate(root) == 0;
    }
}