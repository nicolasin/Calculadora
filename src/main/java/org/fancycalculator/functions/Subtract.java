package org.fancycalculator.functions;

import org.fancycalculator.exceptions.FewParametersExceptions;

public class Subtract implements CalculatorFunction{

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		int length = functionParameters.length;
		double acum = functionParameters[0];
		if(length > 1) {
			for(int i = 1; i < length; i++) {
				acum = acum - functionParameters[i];
			}
			return acum;
		}else {
			throw new FewParametersExceptions("Few Parameters");
		}

	}

	@Override
	public String getFunctionName() {
		return "subtract";
	}

}
