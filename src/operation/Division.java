package operation;

public class Division implements Operation {
    @Override
    public double calculate(double a, double b) {
        return (b != 0) ? a / b : Double.NaN;
    }
}
