package org.fancycalculator.functions;

public class Sqrt implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("Incorrect Parameters");
		} else if (functionParameters[0] < 0) {
			throw new ArithmeticException("the number is less than 0 ");
		} else {
			return Math.sqrt(functionParameters[0]);
		}
	}

	@Override
	public String getFunctionName() {
		return "sqrt";
	}

}
