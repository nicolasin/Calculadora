package org.fancycalculator.functions;

import org.fancycalculator.exceptions.FewParametersExceptions;

public class Multiply implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length == 0) {
			throw new FewParametersExceptions("Few Parameters");
		}
		double acum = 1;
		for (Double x : functionParameters) {
			acum = acum * x;
		}
		return acum;
	}

	@Override
	public String getFunctionName() {
		return "multiply";
	}

}
