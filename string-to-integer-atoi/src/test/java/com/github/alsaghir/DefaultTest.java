package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    // Given
    String s1 = "42";
    int expected1 = 42;

    String s2 = "   -42";
    int expected2 = -42;

    String s3 = "4193 with words";
    int expected3 = 4193;

    String s4 = "words and 987";
    int expected4 = 0;

    String s5 = "-91283472332";
    int expected5 = Integer.MIN_VALUE;

    @Test
    void whenValidInputThenCorrectResponse() {
        // When
        int result1 = new Solution().myAtoi(s1);
        int result2 = new Solution().myAtoi(s2);
        int result3 = new Solution().myAtoi(s3);
        int result4 = new Solution().myAtoi(s4);
        int result5 = new Solution().myAtoi(s5);

        // Then
        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
        Assertions.assertEquals(expected3, result3);
        Assertions.assertEquals(expected4, result4);
        Assertions.assertEquals(expected5, result5);
    }
}
