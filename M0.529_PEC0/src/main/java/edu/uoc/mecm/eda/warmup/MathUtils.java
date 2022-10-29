package edu.uoc.mecm.eda.warmup;

import java.util.Arrays;

/**
 * Warmup class to start programming in Java
 *
 * @author Carles Pairot Gavaldà
 */
public class MathUtils {

	/**
	 * Sums all elements of the array and returns the result
	 *
	 * @param array the array which we want to sum all of its elements
	 * @return the array accumulated sum
	 * @throws Exception if the array is null
	 */
	public static double sum (double[] array) throws Exception {
		if (array == null) {
			throw new Exception ("The array must be not null.");
		}

		return Arrays.stream(array).sum();
	}
	
	/**
	 * Determines whether the sum of the elements of the first array is greater than the sum of the elements of the second
	 * @param arrayA the first array
	 * @param arrayB the second array
	 * @return true if the sum of the elements of the first array is greater, false otherwise
	 * @throws Exception if any of the vectors is null
	 */
	public static boolean arrayIsGreater (double[] arrayA, double[] arrayB) throws Exception {
		if (arrayA == null || arrayB == null) {
			throw new Exception ("Arrays must be other than null");
		}

		return Arrays.stream(arrayA).sum() > Arrays.stream(arrayB).sum();
	}
	
	/**
	 * Determines whether the first array dominates the second. This means that,
	 * for each dimension of the array, the value of array A is greater than or equal to the
	 * value of array B
	 * @param arrayA the first array
	 * @param arrayB the second array
	 * @return true if array A dominates array B, false otherwise
	 * @throws Exception if any of the arrays is null or if dimensions do not match
	 */
	public static boolean dominates (double[] arrayA, double[] arrayB) throws Exception {
		if (arrayA == null || arrayB == null) {
			throw new Exception ("Arrays must be other than null");
		}
		if (arrayA.length != arrayB.length) {
			throw new Exception ("Both arrays must have the same dimensions");
		}

		for (int i = 0; i < arrayA.length; i++)
		{
			if (arrayA[i] < arrayB[i])
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates a new array as a copy of the argument array
	 * @param array the array to copy
	 * @return the reference to then new object created or null if the input argument is null
	 */
	public static double[] copyArray (double[] array) {
		return array.clone();
	}
	
	/**
	 * Creates a new array which is the sum of both argument vectors
	 * @param arrayA the first array
	 * @param arrayB the second array
	 * @return a new array which is the sum of both arrays
	 * @throws Exception if sizes of both arrays do not match or if any of the input arguments is null
	 */
	public static double[] sumArrays (double[] arrayA, double[] arrayB) throws Exception {
		double[] ret = arrayA.clone();
		for (int i = 0; i < arrayA.length; i++)
		{
			ret[i] += arrayB[i];
		}

		return ret;
	}
}