package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DefaultTest {

    @Test
    void whenValidInputThenCorrectResponse() {
        // Given
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] expectedResult1 = new int[]{5, 6, 7, 1, 2, 3, 4};

        int[] nums2 = new int[]{-1, -100, 3, 99};
        int k2 = 2;
        int[] expectedResult2 = new int[]{3, 99, -1, -100};

        // When
        new Solution().rotate(nums1, k1);
        new Solution().rotate(nums2, k2);

        // Then
        Assertions.assertArrayEquals(expectedResult1, nums1);
        Assertions.assertArrayEquals(expectedResult2, nums2);
    }

}
