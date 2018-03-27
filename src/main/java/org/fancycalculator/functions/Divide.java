package org.fancycalculator.functions;

import org.fancycalculator.exceptions.*;

public class Divide implements CalculatorFunction {

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
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

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "divide";
	}

}
