package com.github.alsaghir.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidArrayInputThenCorrectResponse() {
        // Given
        Integer[] nums1 = new Integer[]{1, 2, 3, 1};
        boolean expectedResult1 = true;

        Integer[] nums2 = new Integer[]{1, 2, 3, 4};
        boolean expectedResult2 = false;

        Integer[] nums3 = new Integer[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean expectedResult3 = true;

        // When
        boolean actualResult1 = new Solution().containsDuplicateBruteForce(nums1);
        boolean actualResult2 = new Solution().containsDuplicateBruteForce(nums2);
        boolean actualResult3 = new Solution().containsDuplicateBruteForce(nums3);

        // Then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);

        // When
        actualResult1 = new Solution().containsDuplicateSorting(nums1);
        actualResult2 = new Solution().containsDuplicateSorting(nums2);
        actualResult3 = new Solution().containsDuplicateSorting(nums3);

        // Then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);


        // When
        actualResult1 = new Solution().containsDuplicateSet(nums1);
        actualResult2 = new Solution().containsDuplicateSet(nums2);
        actualResult3 = new Solution().containsDuplicateSet(nums3);

        // Then
        Assertions.assertEquals(expectedResult1, actualResult1);
        Assertions.assertEquals(expectedResult2, actualResult2);
        Assertions.assertEquals(expectedResult3, actualResult3);
    }

}
