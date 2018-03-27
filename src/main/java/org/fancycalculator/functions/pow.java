package org.fancycalculator.functions;

public class pow implements CalculatorFunction {

	@Override
	public double calculate(double[] functionParameters) throws ArithmeticException {
		if(functionParameters.length!=2) {
			throw new ArithmeticException("Incorrect num parameters");
		}
		else if(functionParameters[1]%1 != 0) {
			throw new ArithmeticException("The exponent must be Integer");
		}
		else if(functionParameters[1] < 0) {
			throw new ArithmeticException("The exponent must be >= 0");
		}
		else if(functionParameters[1] == 0) {
			return 1;
		}
		else {
			return Math.pow(functionParameters[0], functionParameters[1]);
		}
	}

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "pow";
	}

}
