package edu.uoc.mecm.eda.tests

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import edu.uoc.mecm.eda.warmup.MathUtils

/**
 * Spock Class that tests all MathUtils methods
 *
 * BEWARE - This class is written in the Groovy language, which is slightly different from Java
 *
 * @author Carles Pairot Gavaldà
 */
class MathUtilsTest extends Specification {

    // Define variables that will be used throughout all tests
    // It is compulsory to annotate them with @Shared

    @Shared
    double[] a = [1, 2, 3, 4, 5, 6]
    @Shared
    double[] b = [10, 3, 8, 4, 5, 8]
    @Shared
    double[] c = [3, 5, 7, 9]

    /**
     * sum() unit test
     * @param arr Input array to be summed
     * @param res Expected result
     */
    @Unroll
    def "sum" (double[] arr, int res) {
        expect: "expect all array elements to be added"
            MathUtils.sum (arr) == res

        // We test the method with these values
        // arr is the input array
        // res is the expected result
        // Therefore, this test is performed 3 times, each using these values
        where:
            arr || res
            a   || 21
            b   || 38
            c   || 24
    }

    /**
     * arrayIsGreater() unit test
     * @param arr1 Input array 1
     * @param arr2 Input array 2
     * @param res Expected result
     */
    @Unroll
    def "arrayIsGreater" (double[] arr1, double[] arr2, boolean res) {
        expect: "expect one array to be greater than the other"
            MathUtils.arrayIsGreater (arr1, arr2) == res

        // We test the method with these values
        // arr1 is the input array 1
        // arr2 is the input array 2
        // res is the expected result
        // Therefore, this test is performed 5 times, each using these values
        where:
            arr1 | arr2 || res
            a    | b    || false
            b    | c    || true
            c    | a    || true
            a    | a    || false
            b    | a    || true
    }

    /**
     * dominates() unit test
     * @param arr1 Input array 1
     * @param arr2 Input array 2
     * @param res Expected result
     */
    @Unroll
    def "dominates" (double[] arr1, double[] arr2, boolean res) {
        expect: "expect one array to dominate the other"
            MathUtils.dominates (arr1, arr2) == res

        // We test the method with these values
        // arr1 is the input array 1
        // arr2 is the input array 2
        // res is the expected result
        // Therefore, this test is performed 3 times, each using these values
        where:
            arr1 | arr2 || res
            b    | a    || true
            a    | b    || false
            b    | a    || true
    }

    /**
     * dominates() unit test when exceptions are expected
     * @param arr1 Input array 1
     * @param arr2 Input array 2
     * @param res Expected result
     * @return
     */
    @Unroll
    def "dominatesException" (double[] arr1, double[] arr2, boolean res) {
        when: "expect domination of arrays of different dimensions to throw Exception"
            MathUtils.dominates (arr1, arr2)

        then:
            thrown (Exception)

        // We test the method with these values
        // arr1 is the input array 1
        // arr2 is the input array 2
        // res is the expected result
        // Therefore, this test is performed 5 times, each using these values
        where:
            arr1 | arr2 || res
            c    | a    || Exception
            b    | c    || Exception
            null | null || Exception
            a    | null || Exception
            null | b    || Exception
    }

    /**
     * copyArray() unit test
     */
    @Unroll
    def "copyArray"() {
        when: "expect array to be copied correctly"
            double[] res = MathUtils.copyArray (a)

        // This method is only tested once, but we expect that the copied array (res) is a different Object from a,
        // and its inner values are equal to those of a
        then:
            !res.is (a)
            Arrays.equals (res, a)
    }

    /**
     * sumArrays unit test
     * @param arr1 Input array 1
     * @param arr2 Input array 2
     * @param res Expected result
     */
    @Unroll
    def "sumArrays" (double[] arr1, double[] arr2, double[] res) {
        expect: "expect the arrays to be summed"
            MathUtils.sumArrays (arr1, arr2) == res

        // We test the method with these values
        // arr1 is the input array 1
        // arr2 is the input array 2
        // res is the expected result
        // Therefore, this test is performed 2 times, each using these values
        where:
            arr1 | arr2 || res
            a    | b    || [11, 5, 11, 8, 10, 14] as double[]
            b    | a    || [11, 5, 11, 8, 10, 14] as double[]
    }

    /**
     * sumArrays() unit test when exceptions are expected
     * @param arr1 Input array 1
     * @param arr2 Input array 2
     * @param res Expected result
     */
    @Unroll
    def "sumArraysException" (double[] arr1, double[] arr2, boolean res) {
        when: "expect sum of arrays of different dimensions to throw Exception"
            MathUtils.sumArrays (arr1, arr2)

        then:
            thrown (Exception)

        // We test the method with these values
        // arr1 is the input array 1
        // arr2 is the input array 2
        // res is the expected result
        // Therefore, this test is performed 3 times, each using these values
        where:
            arr1 | arr2 || res
            null | b    || Exception
            b    | null || Exception
            b    | c    || Exception
    }
}