package org.fancycalculator.functions;

import org.fancycalculator.exceptions.ManyParametersExceptions;

public class Cos implements CalculatorFunction {

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ManyParametersExceptions("many parameters");
		} else {
			return Math.cos(functionParameters[0]);
		}
	}

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "cos";
	}

}
