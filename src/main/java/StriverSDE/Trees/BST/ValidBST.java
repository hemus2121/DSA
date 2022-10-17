package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidBST {

    // Using range stuff
    public boolean isValidBST(Node node){
        return isValid(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Min and Max ranges specified which varies as we traverse left or right
    boolean isValid(Node root, int min, int max){
        if (root == null) return  false;
        if (root.data >= max || root.data <= min) return false;
        return isValid(root.left, min, root.data ) || isValid(root.right, root.data, max);
    }
}
