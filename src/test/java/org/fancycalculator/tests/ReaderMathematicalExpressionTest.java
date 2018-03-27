package org.fancycalculator.tests;

import org.fancycalculator.exceptions.TypeCalculateException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.fancycalculator.entitys.*;

public class ReaderMathematicalExpressionTest {
	static ReaderMathematicalExpression calculadora;
	static String calc1, calc2, calc3;

	@BeforeClass
	public static void setUp() throws Exception {
		calculadora = new ReaderMathematicalExpression();
	}

	@Test
	public void calcSimple() throws TypeCalculateException {
		assertEquals(2,calculadora.readerExpression("add(1,1)"),0);
		assertEquals(-1,calculadora.readerExpression("subtract(1,2)"),0);
		assertEquals(1,calculadora.readerExpression("multiply(1,1)"),0);
		assertEquals(5,calculadora.readerExpression("divide(10,2)"),0);
		assertEquals(5,calculadora.readerExpression("sqrt(25)"),0);
		assertEquals(4,calculadora.readerExpression("square(2)"),0);
		
	}
	@Test
	public void calcCompound() throws TypeCalculateException {
		assertEquals(6, calculadora.readerExpression("multiply(3,add(1,1))"),0);
		assertEquals(12,calculadora.readerExpression("add(3,4,divide(10,2))"),0);
		assertEquals(18,calculadora.readerExpression("add(3,4,divide(multiply(5,2),2),6)"),0);
	
	}
	@Test
	public void calcWithResult() throws TypeCalculateException{
		assertEquals(6,calculadora.readerExpression("multiply(3,add(1,1))"),0);
		assertEquals(15,calculadora.readerExpression("add(result(),4,divide(10,2))"),0);
		assertEquals(30,calculadora.readerExpression("add(result(),4,divide(multiply(5,2),2),6)"),0);
	}

}
