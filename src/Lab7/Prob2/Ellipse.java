package Lab7.Prob2;

public class Ellipse implements ClosedCurve {
    private double a;
    private double E;
    public Ellipse(double semiAxis, double eLateral) {
        this.a = semiAxis;
        this.E = eLateral;
    }

    public double getA() {
        return a;
    }
    public double getE() {
        return E;
    }
    public void setA(double semiAxis) {
        this.a = semiAxis;
    }
    public void setE(double eLateral) {
        this.E = eLateral;
    }
    @Override
    public double computePerimeter() {
        return 4 * a * E;
    }
}
