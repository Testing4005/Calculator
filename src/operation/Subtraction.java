package operation;

public class Subtraction implements Calc {
    @Override
    public double calculate(double a, double b) {
        return return a - b;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
