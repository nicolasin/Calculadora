package org.fancycalculator.functions;

import org.fancycalculator.exceptions.FewParametersExceptions;

public class Multiply implements CalculatorFunction {

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
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

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "multiply";
	}

}
