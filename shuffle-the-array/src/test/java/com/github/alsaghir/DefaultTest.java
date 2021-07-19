package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidArrayInputThenCorrectResponse() {
        // Given
        int[] nums1 = new int[] {2,5,1,3,4,7};
        int n1 = 3;
        int[] expected1 = new int[]{2,3,5,4,1,7};

        int[] nums2 = new int[] {1,2,3,4,4,3,2,1};
        int n2 = 4;
        int[] expected2 = new int[]{1,4,2,3,3,2,4,1};

        int[] nums3 = new int[] {1,1,2,2};
        int n3 = 2;
        int[] expected3 = new int[]{1,2,1,2};

        // When
        int[] result1 = new Solution1().shuffle(nums1, n1);
        int[] result2 = new Solution1().shuffle(nums2, n2);
        int[] result3 = new Solution1().shuffle(nums3, n3);

        // Then
        Assertions.assertArrayEquals(expected1, result1);
        Assertions.assertArrayEquals(expected2, result2);
        Assertions.assertArrayEquals(expected3, result3);
    }

    @Test
    void whenValidArrayInputUsingSolution2ThenCorrectResponse() {
        // Given
        int[] nums1 = new int[] {2,5,1,3,4,7};
        int n1 = 3;
        int[] expected1 = new int[]{2,3,5,4,1,7};

        int[] nums2 = new int[] {1,2,3,4,4,3,2,1};
        int n2 = 4;
        int[] expected2 = new int[]{1,4,2,3,3,2,4,1};

        int[] nums3 = new int[] {1,1,2,2};
        int n3 = 2;
        int[] expected3 = new int[]{1,2,1,2};

        // When
        int[] result1 = new Solution2().shuffle(nums1, n1);
        int[] result2 = new Solution2().shuffle(nums2, n2);
        int[] result3 = new Solution2().shuffle(nums3, n3);

        // Then
        Assertions.assertArrayEquals(expected1, result1);
        Assertions.assertArrayEquals(expected2, result2);
        Assertions.assertArrayEquals(expected3, result3);
    }

}
