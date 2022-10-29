package edu.uoc.mecm.eda.tests

import edu.uoc.mecm.eda.pac1.exercise2.TextEditorBuffer
import spock.lang.Specification

/**
 * Spock Class that tests all DoubleLinkedList methods
 *
 * BEWARE - This class is written in the Groovy language, which is slightly different from Java
 *
 * @author Carles Pairot Gavaldà
 */
class TextEditorBufferTest extends Specification {

    /**
     * Queue unit test
     */
    def "test text editor buffer implementation" () {
        when: "expect methods to work fine"
            TextEditorBuffer<Character> teb1 = new TextEditorBuffer<>();
            boolean isEmpty1 = teb1.size() == 0
            teb1.insert ('P')
            teb1.insert ('r')
            teb1.insert ('o')
            teb1.insert ('c')
            teb1.insert ('e')
            teb1.insert ('s')
            teb1.insert ('s')
            boolean isEmpty11 = teb1.size() == 0
            String expectedResult1 = teb1.toString()
            expectedResult1 = expectedResult1.trim()

            teb1.left(3)
            String expectedResult2 = teb1.toString()
            expectedResult2 = expectedResult2.trim()

            teb1.right (2)
            String expectedResult3 = teb1.toString()
            expectedResult3 = expectedResult3.trim()

            String expectedResult4 = teb1.get()
            String expectedResult5 = teb1.get()

            teb1.delete()
            String expectedResult6 = teb1.toString()
            expectedResult6 = expectedResult6.trim()

        then: "check methods"
            isEmpty1
            !isEmpty11
            expectedResult1 == "Left Stack: s s e c o r P \nRight Stack:"
            expectedResult2 == "Left Stack: c o r P \nRight Stack: e s s"
            expectedResult3 == "Left Stack: s e c o r P \nRight Stack: s"
            expectedResult4 == "s"
            expectedResult5 == "s"
            expectedResult6 == "Left Stack: s e c o r P \nRight Stack:"
    }

    /**
     * Test text buffer delete exception
     */
    def "test exception on delete" () {
        when: "expect methods to work correctly"
            TextEditorBuffer<Character> teb = new TextEditorBuffer()
            teb.delete()

        then: "check exception is thrown"
            def e = thrown (java.util.NoSuchElementException)
            e.message == "Unable to delete character."
    }

    /**
     * Test text buffer get exception
     */
    def "test exception on get" () {
        when: "expect methods to work correctly"
           TextEditorBuffer<Character> teb = new TextEditorBuffer()
           teb.get()

        then: "check exception is thrown"
            def e = thrown (java.util.NoSuchElementException)
            e.message == "Unable to get character."
    }
}