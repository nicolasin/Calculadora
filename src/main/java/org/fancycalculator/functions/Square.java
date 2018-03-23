package org.fancycalculator.functions;

public class Square implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("Incorrect parameters");
		} else {
			return Math.pow(functionParameters[0], 2);
		}
	}

	@Override
	public String getFunctionName() {
		return "square";
	}

}
