package com.github.alsaghir;

class Solution1 {

    // O(n log n) runtime, O(1) space
    // Binary search
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int result = binarySearch(nums, target - nums[i], i + 1);
            if (result != -1) {
                return new int[]{i + 1, result + 1};
            }
        }
        return new int[0];
    }

    /**
     * @param array to search inside
     * @param value the target value that we are searching for
     * @param start from left the start index
     * @return either index of found element or -1
     */
    private int binarySearch(int[] array, int value, int start) {
        int left = start;
        int right = array.length - 1;
        while (left < right) {
            int m = (left + right) / 2;
            if (array[m] < value) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return (left == right && array[left] == value) ? left : -1;
    }
}