package com.github.alsaghir;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Solution {

    public void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2; // mid is included in the right array
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start; // tracks left array
        int j = mid; // tracks right array
        int tempIndex = 0; // tracks target array

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // copy remaining elements in the left/right array from input to input
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        // copy temp to our input
        System.arraycopy(temp, 0, input, start, tempIndex);

    }
}