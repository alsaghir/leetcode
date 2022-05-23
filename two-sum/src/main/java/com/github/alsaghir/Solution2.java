package com.github.alsaghir;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

    // O(n) runtime, O(n) space
    // Hash table
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalStateException();
    }
}