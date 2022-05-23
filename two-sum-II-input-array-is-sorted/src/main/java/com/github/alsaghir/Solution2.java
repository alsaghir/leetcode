package com.github.alsaghir;

class Solution2 {

    // O(n) runtime, O(1) space
    // Two pointers
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[] { i+1, j+1};
            }
        }

        return new int[0];
    }

}