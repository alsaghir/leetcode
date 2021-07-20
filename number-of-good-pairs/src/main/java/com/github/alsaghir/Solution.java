package com.github.alsaghir;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] count = new int[101];
        for (int n : nums) {
            res += count[n]++;
        }
        return res;
    }

    public int numIdenticalPairsMap(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            res += map.get(n) - 1;  // number of pairs ont occurrences. So -1 gives no of pairs.
        }
        return res;
    }
}

