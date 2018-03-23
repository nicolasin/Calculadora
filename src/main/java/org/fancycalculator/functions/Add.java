package org.fancycalculator.functions;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import org.fancycalculator.exceptions.*;

public class Add implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if (functionParameters.length == 0) {
			throw new FewParametersExceptions("Few Parameters");
		}
		DoubleStream streamDoubles = Arrays.stream(functionParameters);
		return streamDoubles.sum();
	}

	@Override
	public String getFunctionName() {
		return "add";
	}

}
