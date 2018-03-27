package org.fancycalculator.entitys;

import java.util.HashMap;
import java.util.Map;

import org.fancycalculator.exceptions.*;
import org.fancycalculator.functions.*;

public class ScientificCalculator {

	double result;
	private Map<String, CalculatorFunction> calculatorFunctions = new HashMap<String, CalculatorFunction>();

	public ScientificCalculator() {
		calculatorFunctions.put("add", new Add());
		calculatorFunctions.put("subtract", new Subtract());
		calculatorFunctions.put("multiply", new Multiply());
		calculatorFunctions.put("divide", new Divide());
		calculatorFunctions.put("sin", new Sin());
		calculatorFunctions.put("cos", new Cos());
		calculatorFunctions.put("tan", new Tan());
		calculatorFunctions.put("square", new Square());
		calculatorFunctions.put("sqrt", new Sqrt());
		this.result = 0;
	}

	/**
	 * @param type
	 *            String with the function to use
	 * @param double[]
	 *            parameters to the function
	 * @return the result to calculate the function with this parameters
	 * @throws TypeCalculateException
	 */
	public double calculate(String type, double[] parameters) throws TypeCalculateException {
		type = type.toLowerCase();
		if (type.equals("result")) {
			return this.result;
		} else if (isCorrectString(type)) {
			this.result = calculatorFunctions.get(type).calculate(parameters);
			return this.result;
		} else {
			throw new TypeCalculateException("Error type of calculator");
		}
	}

	/**
	 * @param typeCalculator
	 *            Type from function to checking
	 * @return boolean if the expression is correct
	 */
	private boolean isCorrectString(String typeCalculator) {
		for (Map.Entry<String, CalculatorFunction> entry : calculatorFunctions.entrySet()) {
			if (entry.getKey().equals(typeCalculator)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return double return the result for the last function used
	 */
	public double result() {
		return this.result;
	}

	/**
	 * Add new Function to the calculator
	 * 
	 * @param calculatorfunction
	 *            Object with the new Calculator
	 * @throws TypeCalculateException
	 *             if the functions is all ready exist
	 */
	public void addFunction(CalculatorFunction calculatorfunction) throws TypeCalculateException {
		if (!isCorrectString(calculatorfunction.getFunctionName())) {
			calculatorFunctions.put(calculatorfunction.getFunctionName(), calculatorfunction);
		} else {
			throw new TypeCalculateException("this Function is all ready into the calculator");
		}
	}

}
