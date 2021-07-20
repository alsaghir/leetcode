package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidArrayInputThenCorrectResponse() {
        // Given
        int[] nums1 = new int[]{1, 2, 3, 1, 1, 3};
        int expectedResult1 = 4;

        int[] nums2 = new int[]{1, 1, 1, 1};
        int expectedResult2 = 6;

        int[] nums3 = new int[]{1, 2, 3};
        int expectedResult3 = 0;

        // When
        int actualResult1 = new Solution().numIdenticalPairs(nums1);
        int actualResult2 = new Solution().numIdenticalPairs(nums2);
        int actualResult3 = new Solution().numIdenticalPairs(nums3);

        // Then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);

        // When
        actualResult1 = new Solution().numIdenticalPairsMap(nums1);
        actualResult2 = new Solution().numIdenticalPairsMap(nums2);
        actualResult3 = new Solution().numIdenticalPairsMap(nums3);

        // Then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);
    }
}
