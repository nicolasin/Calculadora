package org.fancycalculator.functions;

public interface CalculatorFunction {
	/**
	 * Perform the calculation of a function
	 * 
	 * @param functionParameters
	 *            an array of double as function arguments
	 * @return the result of the computation as a double value
	 * @throws ArithmeticException
	 */
	public double calculate(double[] functionParameters) throws ArithmeticException;

	/**
	 * @return Return the name of the implemented function
	 */
	public String getFunctionName();

}
