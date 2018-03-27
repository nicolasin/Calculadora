package org.fancycalculator.functions;

public class Tan implements CalculatorFunction {
	/**
	 * @param double[] with one position to calculate his Tan
	 * @return double Tan from one number
	 */
	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#calculate(double[])
	 */
	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length != 1) {
			throw new ArithmeticException("many parameters");
		} else {
			return Math.tan(functionParameters[0]);
		}
	}
	/**
	 * @return String the name from the function class
	 */
	/* (non-Javadoc)
	 * @see org.fancycalculator.functions.CalculatorFunction#getFunctionName()
	 */
	@Override
	public String getFunctionName() {
		return "tan";
	}

}
