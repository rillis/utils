package com.github.rillis.Math;

import java.util.Random;

public class MathUtils {
	public static double k = 9e9;
	public static double pi = java.lang.Math.PI;
	
	public static int randomBetween(int min, int max) {
		return (int)(java.lang.Math.random() * ((max - min) + 1)) + min;
	}
	
	public static double randomDouble(int places) {
		Random rd = new Random();
	    Double d = rd.nextDouble();
	    return round(d, places);
	}
	
	public static double round(double value, int places) {
	    long factor = (long) java.lang.Math.pow(10, places);
	    value = value * factor;
	    long tmp = java.lang.Math.round(value);
	    return (double) tmp / factor;
	}
}
