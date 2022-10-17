package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Predecessor And Successor In BST
 * There is BST given with root node with key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.
 * TC: O(H)
 * SC: O(1)
 */
public class PredecessorSuccessor {

    public static Node findInOrderSuccessor(Node root, Node p) {
        if (root == null) return null;
        Node successor = null;
        // using BST property
        while (root !=null){
             if (p.data >= root.data){
                 root = root.right;
             }else {
                 // store the current value and check further
                 successor = root;
                 root = root.left;
             }
        }
        return successor;
    }

    public static Node findInOderPredecessor(Node root, Node p) {
        if (root == null) return null;
        Node predecessor = null;
        // using BST property
        while (root !=null){
            if (p.data > root.data){
                predecessor = root;
                root = root.right;

            }else {
                // store the current value and check further
                predecessor = root;
            }
        }
        return predecessor;
    }
}
