package org.fancycalculator.functions;

public class Cos implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("many parameters");
		} else {
			return Math.cos(functionParameters[0]);
		}
	}

	@Override
	public String getFunctionName() {
		return "cos";
	}

}
