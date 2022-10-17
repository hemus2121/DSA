package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/**  Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *  TC: O(H) - Height of the Tree
 *  SC: O(1)
 */
public class LCAofTwoNodesinBST {

    //Recursive
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        //base case
        if (root == null ) return null;
        int cur = root.data ;
        // traverse left or right based on root value comparison
        if(cur < p.data && cur <q.data){
            lowestCommonAncestor(root.right, p, q);
        }
        if (cur > p.data && cur > q.data){
            lowestCommonAncestor(root.left, p,q);
        }
        // if not found in left and right root is common element
        return root;
    }

    //Iterative TC:O(N) SC:O(1)
    public Node LCS (Node root, Node p, Node q){
        if (root == null) return null;
        while (root != null){
            if ( root.data < p.data && root.data < q.data) root = root.right;
            else if ( root.data > p.data && root.data > q.data) root = root.left;
            else return root;
        }
        return null;
    }
}
