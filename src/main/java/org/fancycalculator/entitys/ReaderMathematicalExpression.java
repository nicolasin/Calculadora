package org.fancycalculator.entitys;

import java.util.ArrayList;
import java.util.List;

import org.fancycalculator.exceptions.TypeCalculateException;

public class ReaderMathematicalExpression {
	String expresion;
	ScientificCalculator calculator;

	public ReaderMathematicalExpression() {
		calculator = new ScientificCalculator();
	}

	public double readerExpresion(String expresion) throws TypeCalculateException {
		this.expresion = expresion;
		removeSpaces();
		return calculateExpresion(this.expresion);
	}

	private double calculateExpresion(String expresion) throws TypeCalculateException {
		if (isFinal(expresion)) {
			return Double.parseDouble(expresion);
		} else {
			String typeCalc = expresion.substring(0, expresion.indexOf("("));
			if (typeCalc.equals("result")) {
				return calculator.result();
			}
			String params = expresion;
			if (expresion.contains("(") || expresion.contains(")")) {
				params = expresion.substring(expresion.indexOf("(") + 1, expresion.lastIndexOf(")"));
			}
			List<String> parameters = DivideExpresion(params);
			double[] results = new double[parameters.size()];

			for (int i = 0; i < parameters.size(); i++) {
				results[i] = calculateExpresion(parameters.get(i));
			}
			return calculator.calculate(typeCalc, results);
		}
	}

	public static boolean validatedOperacion(String operacion) {
		return countCountains(operacion, '(')-countCountains(operacion, ')') == 0;
	}

	private List<String> DivideExpresion(String expresion) {
		int isExpresion = 0;
		String[] divide = expresion.split(",");
		String auxsiliarExpresion = "";
		List<String> finalDivide = new ArrayList<String>();

		for (int i = 0; i < divide.length; i++) {
			auxsiliarExpresion = auxsiliarExpresion + divide[i];
			if (divide[i].contains("(")) {

				isExpresion = (countCountains(auxsiliarExpresion, '(') - countCountains(auxsiliarExpresion, ')'));
			}
			if (divide[i].contains(")")) {
				isExpresion = (countCountains(auxsiliarExpresion, '(') - countCountains(auxsiliarExpresion, ')'));
			}
			if (isExpresion != 0) {
				if (divide[i].contains(")")) {
					auxsiliarExpresion = auxsiliarExpresion.concat(",");

				} else {
					auxsiliarExpresion = auxsiliarExpresion.concat(",");

				}

			} else {
				finalDivide.add(auxsiliarExpresion);
				auxsiliarExpresion = "";
			}

		}
		return finalDivide;
	}

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

	private void removeSpaces() {
		this.expresion = this.expresion.replaceAll(" ", "");
	}

	private boolean isFinal(String expresion) {
		return !(expresion.contains("(") && expresion.contains(")"));
	}

}
