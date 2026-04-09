package core;

import operation.Operation;

public class CalculatorModel {
    private double firstOperand = 0;
    private double secondOperand = 0;
    private Operation operation;
    private boolean newInput = true;

    // Getters
    public void setFirstOperand(double v) {
        firstOperand  = v;
    }

    public void setSecondOperand(double v) {
        secondOperand = v;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setNewInput(boolean flag) {
        newInput = flag;
    }

    // Setters
    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isNewInput() {
        return newInput;
    }

    // Calculate
    public double calculateResult() {
        if(operation == null) {
            return secondOperand;
        }
        return operation.calculate(firstOperand, secondOperand);
    }

    // Reset
    public void reset() {
        firstOperand = 0;
        secondOperand =  0;
        operation = null;
        newInput = true;
    }
}
