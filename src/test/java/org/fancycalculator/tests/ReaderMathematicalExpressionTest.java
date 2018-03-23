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
		assertEquals(2,calculadora.readerExpresion("add(1,1)"),0);
		assertEquals(-1,calculadora.readerExpresion("substract(1,2)"),0);
		assertEquals(1,calculadora.readerExpresion("multiply(1,1)"),0);
		assertEquals(5,calculadora.readerExpresion("divide(10,2)"),0);
		assertEquals(5,calculadora.readerExpresion("sqrt(25)"),0);
		assertEquals(4,calculadora.readerExpresion("square(2)"),0);
		
	}
	@Test
	public void calcCompound() throws TypeCalculateException {
		assertEquals(6,calculadora.readerExpresion("multiply(3,add(1,1))"),0);
		assertEquals(12,calculadora.readerExpresion("add(3,4,divide(10,2))"),0);
		assertEquals(18,calculadora.readerExpresion("add(3,4,divide(multiply(5,2),2),6)"),0);
	
	}
	
}
