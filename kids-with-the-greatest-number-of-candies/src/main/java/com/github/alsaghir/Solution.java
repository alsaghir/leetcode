package com.github.alsaghir;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        OptionalInt maxCandies = Arrays.stream(candies).max();
        if (maxCandies.isPresent()) {
            List<Boolean> result = new ArrayList<>(candies.length);
            for (int candy : candies) {
                result.add((candy + extraCandies) >= maxCandies.getAsInt());
            }
            return result;
        }
        return Collections.emptyList();
    }

    public List<Boolean> kidsWithCandiesRefactored(int[] candies, int extraCandies) {
        OptionalInt maxCandies = Arrays.stream(candies).max();
        return Arrays.stream(candies).mapToObj(value -> (value + extraCandies) >= maxCandies.getAsInt()).collect(Collectors.toList());
    }
}