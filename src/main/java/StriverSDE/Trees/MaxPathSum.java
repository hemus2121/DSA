package StriverSDE.Trees;

/** Maximum Sum Path in Binary Tree
 * Problem Statement: Write a program to find the maximum sum path in a binary tree. A path in a binary tree is a sequence of nodes where every adjacent pair of nodes are connected by an edge. A node can only appear in the sequence at most once.
 * A path need not pass from the root. We need to find the path with the maximum sum in the binary tree.
 */
public class MaxPathSum {

    public static int maxPathSum(Node root){
        int []maxValue = new int[1];
        maxValue [0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int  maxPathDown(Node node, int[]  maxValue){
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue)); // consider 0 for negative values
        int right = Math.max(0, maxPathDown(node.right, maxValue)); // consider 0 for negative values
        maxValue[0] = Math.max(maxValue[0], left + right + node.data); // max of both LEFT / RIGHT paths
        return Math.max(left, right) + node.data; // current value + either left or right
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);
    }
}
