package com.github.alsaghir;

class Solution2 {
    public int[] runningSum(int[] nums) {
        for (var i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}