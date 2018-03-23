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
		calculatorFunctions.put("substract", new Substract());
		calculatorFunctions.put("multiply", new Multiply());
		calculatorFunctions.put("divide", new Divide());
		calculatorFunctions.put("sin", new Sin());
		calculatorFunctions.put("cos", new Cos());
		calculatorFunctions.put("tan", new Tan());
		calculatorFunctions.put("square", new Square());
		calculatorFunctions.put("sqrt", new Sqrt());
		this.result = 0;
	}
	public double calculate(String type, double[] parameters)throws TypeCalculateException{
		type = type.toLowerCase();
		if(isCorrectString(type)) {
		this.result = calculatorFunctions.get(type).calculate(parameters);
		return this.result;}
		else {
			throw new TypeCalculateException("Error type of calculator");
		}
	}
	private boolean isCorrectString(String typeCalculator) {
		for(Map.Entry<String, CalculatorFunction> entry: calculatorFunctions.entrySet()) {
			if(entry.getKey().equals(typeCalculator)) {
				return true;
			}
		}
		return false;
	}
	public double result() {
		return this.result;
	}
}