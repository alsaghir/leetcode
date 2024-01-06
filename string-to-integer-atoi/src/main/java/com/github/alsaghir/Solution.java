package com.github.alsaghir;

import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int total = 0;
        //1. Empty string
        if(s.length() == 0) return 0;

        //2. Remove Spaces
        while(s.charAt(index) == ' ')
            index ++;

        //3. Handle signs
        if(s.charAt(index) == '+' || s.charAt(index) == '-'){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < s.length()){
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}