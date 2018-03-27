package org.fancycalculator.functions;

import org.fancycalculator.exceptions.FewParametersExceptions;

public class Subtract implements CalculatorFunction{

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
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

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "subtract";
	}

}
