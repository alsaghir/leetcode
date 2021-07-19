package com.github.alsaghir;

public class Solution2 {
    public int[] shuffle(int[] nums, int n) {
        int i = n - 1;
        for (int j = nums.length - 1; j >= n; j--) {
            nums[j] <<= 10; // Shift left adding 10 zeros on the right
            nums[j] |= nums[i]; // store both number using OR operator in nums[j]. So 2 numbers stored on one binary representation
            // i.e. 5 with 5 will be 00000000 00000000 00010100 00000101 which is 32 bit size of int
            i--;
        }

        i = 0;
        for (int j = n; j < nums.length; j++) {
            int num1 = nums[j] & 1023; // or 0x3FF which is 10 bits of 1 to get the original first number
            int num2 = nums[j] >> 10; // Shift back to right to get the original number
            nums[i] = num1;
            nums[i + 1] = num2;
            i += 2;
        }

        return nums;
    }
}