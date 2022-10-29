package edu.uoc.mecm.eda.tests

import edu.uoc.mecm.eda.pac1.exercise5.Rearrange
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Spock Class that tests all Anagram methods
 *
 * BEWARE - This class is written in the Groovy language, which is slightly different from Java
 *
 * @author Carles Pairot Gavaldà
 */
class RearrangeTest extends Specification {

    /**
     * rearrange() unit test when NullPointerException is thrown
     */
    @Unroll
    def "rearrangeNullInputException"() {
        given:
            def m = new Rearrange()

        when: "expect method to throw an Exception when null input"
            m.rearrange (null)

        then:
            def e = thrown (IllegalArgumentException)
            e.message == "Input queue cannot be null."
    }

    /**
     * rearrange() unit test
     * @param String Input word
     * @param res Expected result
     */
    @Unroll
    def "rearrangeTest()" (Queue<Integer> q, Queue<Integer> res) {
        given:
            def m = new Rearrange()

        expect: "expect method to perform correctly"
            m.rearrange (q) == (res)

        // We test the method with these values
        // value is the input expression
        // res is the expected result
        // Therefore, this test is performed n times, each using these values
        where:
            q                                                                 || res
            [-1, -2, -3, 3, 10, -8] as Queue<Integer>                         || [-8, -3, -2, -1, 3, 10] as Queue<Integer>
            [3, -6, -8, 12, -15, 28, -28, 30, -31, 33] as Queue<Integer>      || [-31, -28, -15, -8, -6, 3, 12, 28, 30, 33] as Queue<Integer>
            [1, 2, -2, 4, -5, 8, -8, 12, -15, 23] as Queue<Integer>           || [-15, -8, -5, -2, 1, 2, 4, 8, 12, 23] as Queue<Integer>
    }
}