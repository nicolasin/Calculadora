package org.fancycalculator.functions;

import org.fancycalculator.exceptions.*;

public class Divide implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {

		if (functionParameters.length > 2) {
			throw new ManyParametersExceptions("Many parameters");
		} else if (functionParameters.length <= 1) {
			throw new FewParametersExceptions("Few Parameters");
		} else if (functionParameters[1] == 0) {
			throw new ArithmeticException("Can´t divide by Zero");
		} else {
			return functionParameters[0] / functionParameters[1];
		}

	}

	@Override
	public String getFunctionName() {
		return "divide";
	}

}
