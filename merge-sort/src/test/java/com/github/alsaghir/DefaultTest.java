package com.github.alsaghir;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
class DefaultTest {

    // Given
    int[] input1 = new int[]{20, 35, -15, 7, 55, 1, -22};
    int[] expected1 = new int[]{-22, -15, 1, 7, 20, 35, 55};


    @Test
    void whenValidInputThenCorrectResponse() {
        // When
        log.info(Arrays.toString(input1));
        new Solution().mergeSort(input1, 0, input1.length);
        log.info(Arrays.toString(input1));

        // Then
        Assertions.assertArrayEquals(expected1, input1);
    }
}
