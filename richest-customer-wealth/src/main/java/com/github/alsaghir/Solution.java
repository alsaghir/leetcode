package com.github.alsaghir;

import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = Integer.MIN_VALUE;

        for (int[] account : accounts)
            maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());

        return maxWealth;
    }

    public int maximumWealthUsingStreams(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customerAccount -> Arrays.stream(customerAccount).sum())
                .max()
                .getAsInt();
    }
}