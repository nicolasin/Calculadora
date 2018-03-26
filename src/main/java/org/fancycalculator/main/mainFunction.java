package org.fancycalculator.main;

import java.util.Scanner;

import org.fancycalculator.entitys.*;

public class mainFunction {
	private static ReaderMathematicalExpression reader;
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		reader = new ReaderMathematicalExpression();
		String operacion = "";
		try {
			do {
				System.out.println("Gibt Operacion: ");
				operacion = s.nextLine();
				if (ReaderMathematicalExpression.validatedOperacion(operacion)) {
					System.out.println("Resultado:"+ reader.readerExpresion(operacion));
				} else {
					System.out.println("Error in the Mathematical expresion");
				}

			} while (!operacion.equals("exit"));

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
