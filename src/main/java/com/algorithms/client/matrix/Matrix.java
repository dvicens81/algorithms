package com.algorithms.client.matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public abstract class Matrix {
	
	private Matrix() {}
	
    /*
     * Get max value of 2D array of Integers
     * 
     */

    public static Integer getMatrixMaxValue(Integer[][] matrix) {
    	int maximum = Integer.MIN_VALUE;        
        for(Integer[] number : matrix) {        	
        	int max = Collections.max(Arrays.asList(number));
        	maximum = Optional.of(maximum).filter(value->value>max).orElse(max);
        }
    	return maximum;
    }

}
