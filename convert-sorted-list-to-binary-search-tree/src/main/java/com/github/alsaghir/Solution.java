package com.github.alsaghir;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return helper(0, getLength(head) - 1);
    }

    private ListNode head;

    private TreeNode helper(int l, int r) {
        if (l > r)
            return null;

        final int m = (l + r) / 2;

        // simulate inorder traversal: recursively form the left half
        TreeNode left = helper(l, m - 1);

        // once left half is traversed, process the current node
        TreeNode root = new TreeNode(head.val);
        root.left = left;

        // maintain the invariance
        head = head.next;

        // simulate inorder traversal: recursively form the right half
        root.right = helper(m + 1, r);

        return root;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            ++length;
        return length;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(input));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyAt = Integer.MAX_VALUE;

        for (final int price : prices) {
            profit = Math.max(profit, price - buyAt);
            buyAt = Math.min(buyAt, price);
        }

        return profit;
    }
}