package org.fancycalculator.exceptions;

public class FewParametersExceptions extends ArithmeticException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3349266950486822673L;
	public FewParametersExceptions(String s) {
		super(s);
	}
	public FewParametersExceptions() {
		super();
	}
}
