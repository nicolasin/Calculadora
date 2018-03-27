package org.fancycalculator.entitys;

import java.util.ArrayList;
import java.util.List;

import org.fancycalculator.exceptions.TypeCalculateException;

public class ReaderMathematicalExpression {
	String expression;
	ScientificCalculator calculator;
	static final String  RESULT = "result";

	public ReaderMathematicalExpression() {
		calculator = new ScientificCalculator();
	}

	/**
	 * @param String expression to calculate
	 * @return double result that calculated the expression
	 * @throws TypeCalculateException
	 */
	public double readerExpression(String expression) throws TypeCalculateException {
		this.expression = expression;
		removeSpaces();
		return calculateExpression(this.expression);
	}

	/**
	 * @param String expression to calculate recursive mode
	 * @return double with the final result to the expression
	 * @throws TypeCalculateException
	 */
	private double calculateExpression(String expression) throws TypeCalculateException {
		if (isFinal(expression)) {
			return Double.parseDouble(expression);
		} else {
			String typeCalc = expression.substring(0, expression.indexOf("("));
			if (typeCalc.equals(RESULT)) {
				return calculator.result();
			}
			String params = expression;
			if (expression.contains("(") || expression.contains(")")) {
				params = expression.substring(expression.indexOf("(") + 1, expression.lastIndexOf(")"));
			}
			List<String> parameters = divideExpression(params);
			double[] results = new double[parameters.size()];

			for (int i = 0; i < parameters.size(); i++) {
				results[i] = calculateExpression(parameters.get(i));
			}
			return calculator.calculate(typeCalc, results);
		}
	}

	/**
	 * @param String operation expression to validate
	 * @return boolean if the expression is correct
	 */
	public static boolean isCorrect(String operacion) {
		return countCountains(operacion, '(') - countCountains(operacion, ')') == 0;
	}
	/**
	 * @param String with the parameters to divide 
	 * @return List String with separated parameters 
	 */
	private List<String> divideExpression(String expression) {
		int isExpression = 0;
		String[] divide = expression.split(",");
		String auxsiliarexpression = "";
		List<String> finalDivide = new ArrayList<String>();

		for (int i = 0; i < divide.length; i++) {
			auxsiliarexpression = auxsiliarexpression + divide[i];
			if (divide[i].contains("(") || divide[i].contains(")")) {
				isExpression = (countCountains(auxsiliarexpression, '(') - countCountains(auxsiliarexpression, ')'));
			}
			if (isExpression != 0) {
				if (divide[i].contains(")")) {
					auxsiliarexpression = auxsiliarexpression.concat(",");
				} else {
					auxsiliarexpression = auxsiliarexpression.concat(",");
				}
			} else {
				finalDivide.add(auxsiliarexpression);
				auxsiliarexpression = "";
			}
		}
		return finalDivide;
	}
	/**
	 * Count how many times is the parameter in the string 
	 * @param s String for search the parameter
	 * @param c the parameter to search
	 * @return number of times that this chars is in the string
	 */
	private static int countCountains(String s, char c) {
		char[] caracters = s.toCharArray();
		int count = 0;
		for (char x : caracters) {
			if (x == c) {
				count++;
			}
		}
		return count;

	}
	/**
	 * Remove the spaces to the expression
	 */
	private void removeSpaces() {
		this.expression = this.expression.replaceAll(" ", "");
	}
	/**
	 * @param expression String with the expression to compare
	 * @return return if this expression is final or not
	 */
	private boolean isFinal(String expression) {
		return !(expression.contains("(") && expression.contains(")"));
	}

}
