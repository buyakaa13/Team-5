package Lab7.Prob2;

public interface Polygon extends ClosedCurve {
    @Override
    default double computePerimeter() {
        double perimeter = 0;
        for (double side : getSides()) {
            perimeter += side;
        }
        return perimeter;
    }

    double[] getSides();
}
