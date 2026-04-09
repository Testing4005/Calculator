package operation;

public class Addition implements Calc {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

    @Override
    public String getSymbol() {
        return "+";
    }
}
