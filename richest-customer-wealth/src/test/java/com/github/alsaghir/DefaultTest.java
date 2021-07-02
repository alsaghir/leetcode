package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidInputThenCorrectResponse() {
        // Given
        int[][] input = {{1, 2, 3}, {3, 2, 1}};
        int expected = 6;

        int[][] input2 = {{1,5},{7,3},{3,5}};
        int expected2 = 10;

        // When
        int result = new Solution().maximumWealth(input);
        int result2 = new Solution().maximumWealth(input2);

        // Then
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expected2, result2);
    }

}
