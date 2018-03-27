package org.fancycalculator.functions;

public class Square implements CalculatorFunction {

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("Incorrect parameters");
		} else {
			return Math.pow(functionParameters[0], 2);
		}
	}

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "square";
	}

}
