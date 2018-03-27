package org.fancycalculator.tests;

import static org.junit.Assert.*;

import org.fancycalculator.entitys.ScientificCalculator;
import org.fancycalculator.exceptions.FewParametersExceptions;
import org.fancycalculator.exceptions.ManyParametersExceptions;
import org.fancycalculator.exceptions.TypeCalculateException;
import org.fancycalculator.functions.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScientificCalculatorTest {
	static ScientificCalculator calculadora;
	static double[] parameters;

	@BeforeClass
	public static void setUp() throws Exception {
		calculadora = new ScientificCalculator();
		parameters = new double[] { 1, 2, 3, 4, 5, 6, 7 };
	}

	@Test
	public void testfunctionAdd() throws TypeCalculateException {
		assertEquals(28, calculadora.calculate("add", parameters), 0);
	}

	@Test
	public void testFunctionsubstract() throws TypeCalculateException {
		assertEquals(-26, calculadora.calculate("subtract", parameters), 0);
	}

	@Test
	public void testfunctionmultiply() throws TypeCalculateException {
		assertEquals(5040, calculadora.calculate("multiply", parameters), 0);
	}

	@Test
	public void testfunctionDivide() throws TypeCalculateException {
		assertEquals(3, calculadora.calculate("divide", new double[] { 6, 2 }), 0);
	}

	@Test
	public void testfunctionSin() throws TypeCalculateException {
		assertEquals(-0.9589, calculadora.calculate("sin", new double[] { 5 }), 0.01);
	}

	@Test
	public void testFunctionCos() throws TypeCalculateException {
		assertEquals(0.2836, calculadora.calculate("cos", new double[] { 5 }), 0.01);
	}

	@Test
	public void testFunctionTan() throws TypeCalculateException {
		assertEquals(-3.3805, calculadora.calculate("tan", new double[] { 5 }), 0.01);
	}

	@Test
	public void testFunctionSquare() throws TypeCalculateException {
		assertEquals(25, calculadora.calculate("square", new double[] { 5 }), 0.01);
	}

	@Test
	public void testFunctionSqrt() throws TypeCalculateException {
		assertEquals(3, calculadora.calculate("sqrt", new double[] { 9 }), 0.01);
	}

	@Test
	public void testFunctionNameCalculate() throws TypeCalculateException {
		assertEquals(3, calculadora.calculate("SQRT", new double[] { 9 }), 0.01);
		assertEquals(3, calculadora.calculate("sQrT", new double[] { 9 }), 0.01);
		assertEquals(3, calculadora.calculate("sQRT", new double[] { 9 }), 0.01);

	}

	@Test(expected = TypeCalculateException.class)
	public void testFunctionNameCalculateExceptionExpected() throws TypeCalculateException {
		assertEquals(3, calculadora.calculate("aSQRT", new double[] { 9 }), 0.01);

	}

	@Test
	public void testFunctionResult() throws TypeCalculateException {
		calculadora.calculate("add", new double[] { 1, 2, 3, 4 });
		assertEquals(10, calculadora.result(), 0);
	}
	//TEST EXCEPTIONS
	@Test(expected = FewParametersExceptions.class)
	public void testAddFewParameters() throws TypeCalculateException {
		calculadora.calculate("add", new double[] {});
	}

	@Test(expected = ManyParametersExceptions.class)
	public void testCosManyParameters() throws TypeCalculateException {
		calculadora.calculate("cos", new double[] { 1, 2 });
	}

	@Test(expected = ArithmeticException.class)
	public void testDivideZero() throws ArithmeticException, TypeCalculateException {
		calculadora.calculate("divide", new double[] { 1, 0 });
	}

	@Test(expected = FewParametersExceptions.class)
	public void testDivideFewParameters() throws TypeCalculateException {
		calculadora.calculate("divide", new double[] { 1 });
	}

	@Test(expected = ManyParametersExceptions.class)
	public void testDivideManyParameters() throws TypeCalculateException {
		calculadora.calculate("divide", new double[] { 1, 2, 3 });
	}
	@Test(expected = FewParametersExceptions.class)
	public void testMultiplyFewParameters()throws ArithmeticException, TypeCalculateException{
		calculadora.calculate("multiply",new double[]{});
	}
	@Test
	public void addNewFunction() throws TypeCalculateException{
		try {
			calculadora.calculate("pow", new double[] { 3,3});
			fail("Throw Excepted");
		}catch(TypeCalculateException e) {
			assertEquals("Error type of calculator",e.getMessage());
		}
		calculadora.addFunction(new pow());
		assertEquals(27,calculadora.calculate("pow",new double[] {3,3}), 0);
		assertEquals(64,calculadora.calculate("pow",new double[] {4,3}), 0);
		
	}
	@Test(expected=TypeCalculateException.class)
	public void newFunctionErrorExpected() throws TypeCalculateException{
		calculadora.addFunction(new Add());
	}
}
