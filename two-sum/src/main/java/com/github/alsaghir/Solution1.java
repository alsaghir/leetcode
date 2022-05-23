package com.github.alsaghir;

class Solution1 {

    // O(n^2) runtime, O(1) space
    // Brute force
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalStateException();
    }
}