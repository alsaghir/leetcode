package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    // Given
    String instructions1 = "GGLLGG";
    boolean expected1 = true;

    String instructions2 = "GG";
    boolean expected2 = false;

    String instructions3 = "GL";
    boolean expected3 = true;


    @Test
    void whenValidInputThenCorrectResponse() {
        // When
        boolean result1 = new Solution().isRobotBounded(instructions1);
        boolean result2 = new Solution().isRobotBounded(instructions2);
        boolean result3 = new Solution().isRobotBounded(instructions3);

        // Then
        Assertions.assertEquals(expected1, result1);
        Assertions.assertEquals(expected2, result2);
        Assertions.assertEquals(expected3, result3);
    }



}
