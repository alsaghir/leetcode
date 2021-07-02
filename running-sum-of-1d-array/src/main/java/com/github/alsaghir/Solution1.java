package com.github.alsaghir;

class Solution1 {
    public int[] runningSum(int[] nums) {
        var result = new int[nums.length];

        // Initialize first element of result array with first element in nums.
        result[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}