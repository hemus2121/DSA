package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Size of Largest BST in Binary Tree LT- 333
 * You are given a binary tree with 'N' nodes. Your task is to return the size of the largest subtree of the binary tree which is also a BST.
 */

class NodeValue{
    int maxNode, minNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize){
        this.minNode = minNode;
        this.maxNode  = maxNode;
        this.maxSize = maxSize;
    }
}
public class SizeOfLargestBST {

    public static NodeValue  largestBSTSubTreeHelper(Node root){
        if (root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        // using POST order traversal stuff

        // get value on left and right sub tree
        NodeValue left = largestBSTSubTreeHelper( root.left);
        NodeValue right = largestBSTSubTreeHelper(root.right);

        // current node is greater than MAX from left and smaller than min in right  ,its VALID BST
        if (left.maxNode < root.data && root.data< right.minNode){
            return new NodeValue( Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), left.maxSize+ right.maxSize+1);
        }

        //Otherwise its not valid BST at all-- return [-MAXMIN, MAX] so that parent cann't be  valid BST
        return  new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    public static int largestBST(Node root) {
        // Write your code here.
        return largestBSTSubTreeHelper(root).maxSize;
    }
}
