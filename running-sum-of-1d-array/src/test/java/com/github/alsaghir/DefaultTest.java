package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidArrayInputThenCorrectResponse() {
        // Given
        int[] input = new int[] {1, 2, 3, 4};
        int[] expected = new int[]{1,3,6,10};

        // When
        int[] result1 = new Solution1().runningSum(input);
        int[] result2 = new Solution2().runningSum(input);

        // Then
        Assertions.assertArrayEquals(expected, result1);
        Assertions.assertArrayEquals(expected, result2);
    }

}
