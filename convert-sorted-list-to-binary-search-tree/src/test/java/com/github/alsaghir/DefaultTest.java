package com.github.alsaghir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultTest {

    @Test
    void whenValidInputThenCorrectResponse() {
        // Given
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(5, n1);
        ListNode n3 = new ListNode(0, n2);
        ListNode n4 = new ListNode(-3, n3);
        ListNode n5 = new ListNode(-10, n4);
        ListNode inputCase1 = n5;

        TreeNode tn5 = new TreeNode(9);
        TreeNode tn4 = new TreeNode(-3);
        TreeNode tn3 = new TreeNode(5, null, tn5);
        TreeNode tn2 = new TreeNode(-10, null, tn4);
        TreeNode tn1 = new TreeNode(0, tn2, tn3);
        TreeNode expectedCase1 = tn1;

        // When
        TreeNode result1 = new Solution().sortedListToBST(inputCase1);


        // Then
        Assertions.assertTrue(expectedCase1.equals(result1));
    }
}
