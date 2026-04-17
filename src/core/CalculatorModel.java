package core;

import operation.Operation;

public class CalculatorModel {
    private double firstOperand = 0;
    private double secondOperand = 0;
    private Operation operation;
    private boolean newInput = true;

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public boolean isNewInput() {
        return newInput;
    }

    public void setNewInput(boolean newInput) {
        this.newInput = newInput;
    }

    public double calculateResult() {
        if (operation == null) {
            return secondOperand;
        }
        return operation.calculate(firstOperand, secondOperand);
    }

    public void reset() {
        firstOperand = 0;
        secondOperand = 0;
        operation = null;
        newInput = true;
    }
}
