package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DefaultTest {

    @Test
    void whenValidInputThenCorrectResponse() {
        // Given
        int[] candies1 = new int[]{2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        List<Boolean> expectedResult1 = Arrays.asList(true, true, true, false, true);

        int[] candies2 = new int[]{4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        List<Boolean> expectedResult2 = Arrays.asList(true, false, false, false, false);

        int[] candies3 = new int[]{12, 1, 12};
        int extraCandies3 = 10;
        List<Boolean> expectedResult3 = Arrays.asList(true, false, true);

        // When
        List<Boolean> result1 = new Solution().kidsWithCandies(candies1, extraCandies1);
        List<Boolean> result2 = new Solution().kidsWithCandies(candies2, extraCandies2);
        List<Boolean> result3 = new Solution().kidsWithCandies(candies3, extraCandies3);

        // Then
        Assertions.assertEquals(expectedResult1, result1);
        Assertions.assertEquals(expectedResult2, result2);
        Assertions.assertEquals(expectedResult3, result3);
    }

    @Test
    void whenValidInputThenCorrectResponse_Refactored() {
        // Given
        int[] candies1 = new int[]{2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        List<Boolean> expectedResult1 = Arrays.asList(true, true, true, false, true);

        int[] candies2 = new int[]{4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        List<Boolean> expectedResult2 = Arrays.asList(true, false, false, false, false);

        int[] candies3 = new int[]{12, 1, 12};
        int extraCandies3 = 10;
        List<Boolean> expectedResult3 = Arrays.asList(true, false, true);

        // When
        List<Boolean> result1 = new Solution().kidsWithCandiesRefactored(candies1, extraCandies1);
        List<Boolean> result2 = new Solution().kidsWithCandiesRefactored(candies2, extraCandies2);
        List<Boolean> result3 = new Solution().kidsWithCandiesRefactored(candies3, extraCandies3);

        // Then
        Assertions.assertEquals(expectedResult1, result1);
        Assertions.assertEquals(expectedResult2, result2);
        Assertions.assertEquals(expectedResult3, result3);
    }

    @Test
    void performance() {

        // Given
        int[] candies1 = new int[]{2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        List<Boolean> expectedResult1 = Arrays.asList(true, true, true, false, true);

        int[] candies2 = new int[]{4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        List<Boolean> expectedResult2 = Arrays.asList(true, false, false, false, false);

        int[] candies3 = new int[]{12, 1, 12};
        int extraCandies3 = 10;
        List<Boolean> expectedResult3 = Arrays.asList(true, false, true);

        // When
        System.out.println("first");
        long startTime = System.nanoTime();
        List<Boolean> result1 = new Solution().kidsWithCandies(candies1, extraCandies1);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        List<Boolean> resultRefactored1 = new Solution().kidsWithCandiesRefactored(candies1, extraCandies1);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("second");
        startTime = System.nanoTime();
        List<Boolean> result2 = new Solution().kidsWithCandies(candies2, extraCandies2);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        List<Boolean> resultRefactored2 = new Solution().kidsWithCandiesRefactored(candies2, extraCandies2);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println("third");
        startTime = System.nanoTime();
        List<Boolean> result3 = new Solution().kidsWithCandies(candies3, extraCandies3);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        List<Boolean> resultRefactored3 = new Solution().kidsWithCandiesRefactored(candies3, extraCandies3);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // Then
        Assertions.assertEquals(expectedResult1, result1);
        Assertions.assertEquals(expectedResult1, resultRefactored1);

        Assertions.assertEquals(expectedResult2, result2);
        Assertions.assertEquals(expectedResult2, resultRefactored2);

        Assertions.assertEquals(expectedResult3, result3);
        Assertions.assertEquals(expectedResult3, resultRefactored3);
    }


}
