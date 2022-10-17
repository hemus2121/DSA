package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Search in a Binary Search Tree
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class SearchinBST {

    public Node searchBST(Node root, int val) {
        if (root == null) return null;
        return search(root, val);
    }

    private Node search (Node root, int val){
        if (root.data== val) return root;
        if (root.left != null){
            Node left = search(root.left, val);
            if (left !=null) return left;
        }
        if (root.right != null){
            Node right = search (root.right, val);
            if (right !=null) return right;
        }
        return null;
    }
}
