package LeetCode.Gen.Arrays;
/*
Convert Sorted Array to Binary Search Tree -- https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

public class SortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return " " + val + " " + left +  " " + right ;
        }
    }

    private static TreeNode generateTreeNode(int [] nums){

        if (nums.length==0) return new TreeNode(nums[0]); // handle single element case
        return constructTreeNode(nums, 0 , nums.length-1);
    }

    static TreeNode constructTreeNode(int [] nums, int start, int end){

        //BASE CASE
        if (start > end) return null;

        //compute root which is at middle index of the array
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructTreeNode(nums, start, mid-1);
        root.right = constructTreeNode(nums, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int [] data = { -10,-3,0,5,9};
        System.out.println(generateTreeNode(data));
    }
}
