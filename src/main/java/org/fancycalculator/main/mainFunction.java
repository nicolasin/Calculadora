package org.fancycalculator.main;

import java.util.Scanner;

import org.fancycalculator.entitys.*;

public class mainFunction {
	private static ReaderMathematicalExpression reader;

	public static void main(String[] args) {

		reader = new ReaderMathematicalExpression();

		try {
			System.out.println("Total: " + reader.readerExpresion("divide(16,add(1,2,3,multiply(1,2)))"));
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
