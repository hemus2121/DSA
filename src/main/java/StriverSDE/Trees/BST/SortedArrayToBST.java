package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class SortedArrayToBST {

    public Node sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length-1);
    }

    Node buildNode(int [] nums, int start, int end){
        if (start > end ) return null;

        int mid = (start +end)/2;
        Node root = new Node(nums[mid]);
        root.left = buildNode(nums, start,mid-1);
        root.right = buildNode(nums, mid+1, end);
        return root;
    }
}
