package org.fancycalculator.functions;

public class Sin implements CalculatorFunction{

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("many parameters");
		} else {
			return Math.sin(functionParameters[0]);
		}
	}

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "sin";
	}

}
