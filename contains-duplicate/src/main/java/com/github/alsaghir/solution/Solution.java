package com.github.alsaghir.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private final Set<Integer> seen = new HashSet<>();

    /**
     * Checking duplicate elements in the given array of integers using brute force.
     * This method iterates through the array and checks if any
     * element is equal to another element in the same array.
     * If a duplicate element is found, the method returns true.
     * If the iteration completes without finding any duplicate elements, the method returns false.
     */
    public boolean containsDuplicateBruteForce(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Integer current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (current.equals(nums[j]))
                    return true;
            }
        }
        return false;
    }

    /**
     * Checking duplicate elements in the given array of integers using sorting.
     * It sorts the array in ascending order
     * and then iterates through the sorted array to check if any adjacent elements are equal.
     * If two adjacent elements are equal, it means that there is a duplicate element in the
     * array, and the method returns true. If the iteration completes without
     * finding any duplicate elements, the method returns false.
     */
    public boolean containsDuplicateSorting(Integer[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i].equals(nums[i - 1]))
                return true;
        }
        return false;
    }

    /**
     * Using a HashSet to determine if there are any duplicate elements in the array.
     * A HashSet named seen is declared as a private field of the class. This HashSet will be used to keep track
     * of the elements that have already been encountered during the iteration.
     * The seen HashSet is cleared using the clear() method at the beginning of the method. This ensures
     * that the HashSet is empty before processing the array.
     * <p>
     * For each element, the following steps are performed:
     * <p>
     * The current element is checked against the elements already present in the seen HashSet.
     * If the seen HashSet contains the current element,
     * it means that a duplicate has been found, and the method returns true.
     * If the current element is not found in the seen HashSet, it is added to the HashSet using the add() method.
     * If the for-each loop completes without finding any duplicate elements, the method returns false.
     */
    public boolean containsDuplicateSet(Integer[] nums) {
        seen.clear();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }


}