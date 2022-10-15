package StriverSDE.Trees;
/** Check for Children Sum Property in a Binary Tree
 * Problem Statement: Children Sum Property in a Binary Tree. Write a program that converts any binary tree to one that follows the children sum property.
 * The children sum property is defined as, For every node of the tree, the value of a node is equal to the sum of values of its children(left child and right child).
 * Note:
 * The node values can be increased by 1 any number of times but decrement of any node value is not allowed.
 * A value for a NULL node can be assumed as 0.
 * You are not allowed to change the structure of the given binary tree.
 * TC: O(N)
 * SC : O(N)  Reason: In the worst case( skewed tree), space complexity can be O(N).
 **/
public class ChildSumProperty {
    static void reorder(Node root) {
        if (root == null) return;
        int sum = 0;
        // add left and right values
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        //check if root data is less than sum
        // yes -- assign root data to left and right
        if (sum < root.data) {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }
        // call recursively for left and right
        reorder(root.left);
        reorder(root.right);

        int total = 0;
        // sum up left and right node values  at each level
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        // if its not leaf node- assign back total of left and right nodes
        if (root.left != null || root.right != null) root.data = total;
    }

    static void changeTree(Node root){
        reorder(root);
    }

    public static void main(String[] args) {
        Node  root = new Node(2);
        root . left = new Node(35);
        root . left . left = new Node(2);
        root . left . right = new Node(3);
        root . right = new Node(10);
        root . right . left = new Node(5);
        root . right . right = new Node(2);
        changeTree(root);
    }
}
