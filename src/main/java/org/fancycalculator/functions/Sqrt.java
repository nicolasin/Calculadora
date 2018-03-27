package org.fancycalculator.functions;

public class Sqrt implements CalculatorFunction {

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("Incorrect Parameters");
		} else if (functionParameters[0] < 0) {
			throw new ArithmeticException("the number is less than 0 ");
		} else {
			return Math.sqrt(functionParameters[0]);
		}
	}

	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "sqrt";
	}

}
