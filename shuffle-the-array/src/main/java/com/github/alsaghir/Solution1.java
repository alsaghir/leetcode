package com.github.alsaghir;

class Solution1 {
    public int[] shuffle(int[] nums, int n) {
        var result = new int[nums.length];
        for (var i = 0; i < n ; i++) {
            result[i+i] = nums[i];
            result[i + i + 1] = nums[i + n];
        }
        return result;
    }
}