package operation;

public class Division implements Calc {
    @Override
    public double calculate(double a, double b) {
        return (b != 0) ? a / b : Double.NaN;
    }

    @Override
    public String getSymbol() {
        return "÷";
    }
}
