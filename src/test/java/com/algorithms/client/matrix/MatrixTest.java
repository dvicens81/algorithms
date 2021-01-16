package com.algorithms.client.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixTest {
	
	@Test
	public void getMaxValueFromMatrix() {
		Integer[][] matrixPositive = {
	            {10, 100, 3},
	            {12, 200, 154},
	            {3, 30, 2}
	    };
		
		int response = Matrix.getMatrixMaxValue(matrixPositive);
		assertEquals(200, response);
	}
	
	@Test
	public void getMaxValueFromMatrixMixed() {
		Integer[][]  matrixMixed = {
	            {-10, 100, 3},
	            {12, -200, 154},
	            {3, 30, -2}
	    };
		
		int response = Matrix.getMatrixMaxValue(matrixMixed);
		assertEquals(154, response);
	}
	
	@Test
	public void getMaxValueFromMatrixNegative() {
		Integer[][]  matrixNegative = {
	            {-10, -100, -3},
	            {-12, -200, -154},
	            {-3, -30, -2}
	    };
		
		int response = Matrix.getMatrixMaxValue(matrixNegative);
		assertEquals(-2, response);
	}

}
