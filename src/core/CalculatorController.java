package core;

import java.text.DecimalFormat;
import operation.Operation;

public class CalculatorController {
    private DecimalFormat df;

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    private String currentDisplay = "0";

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        df = new DecimalFormat("#.######");
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void handleNumber(String digit) {
        if(calculatorModel.isNewInput()) {
            currentDisplay = digit;
            calculatorModel.setNewInput(false);
        } else {
            if(currentDisplay.equals("0") && !digit.equals(".")) {
                currentDisplay = digit;
            } else if(digit.equals(".") && currentDisplay.contains(".")) {
                return;
            } else {
                currentDisplay += digit;
            }
        }
        calculatorView.setText(currentDisplay);
    }

    public void handleOperation(Operation op) {
        double value = parseInput();

        if((calculatorModel.getOperation() != null) && !calculatorModel.isNewInput()) {
            double result = calculatorModel.calculateResult();
            calculatorModel.setFirstOperand(result);
            calculatorModel.setSecondOperand(value);
            currentDisplay = format(result);
            calculatorView.setText(currentDisplay);
        } else {
            calculatorModel.setFirstOperand(value);
        }

        calculatorModel.setOperation(op);
        calculatorModel.setNewInput(true);
    }

    public void handleEquals() {
        if(calculatorModel.getOperation() == null) {
            return;
        }

        double value = parseInput();
        calculatorModel.setSecondOperand(value);

        double result = calculatorModel.calculateResult();
        currentDisplay = Double.isNaN(result) ? "Error" : format(result);
        calculatorView.setText(currentDisplay);

        calculatorModel.setFirstOperand(result);
        calculatorModel.setOperation(null);
        calculatorModel.setNewInput(true);
    }

    public void handleClear() {
        calculatorModel.reset();
        currentDisplay = "0";
        calculatorView.setText("0");
    }

    public void handleBackspace() {
        if(calculatorModel.isNewInput()) {
            return;
        }
        if(currentDisplay.length() <= 1 || (currentDisplay.startsWith("-") && currentDisplay.length() == 2)) {
            currentDisplay = "0";
            calculatorView.setText(currentDisplay);
            return;
        }
        currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
        calculatorView.setText(currentDisplay);
    }

    private double parseInput() {
        try {
            return Double.parseDouble(currentDisplay);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    private String format(double val) {
        if(Double.isNaN(val)) {
            return "Error";
        }
        if(val == 0.0) {
            return "0";
        }
        if(val == Math.floor(val)) {
            if(val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE) {
                return String.valueOf((int)val);
            } else {
                return "Overflow";
            }
        }
        return df.format(val);
    }
}
