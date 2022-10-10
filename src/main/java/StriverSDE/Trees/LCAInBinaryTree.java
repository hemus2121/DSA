package StriverSDE.Trees;

/**
 * Lowest Common Ancestor for two given Nodes
 *
 * Problem Statement: Given a binary tree, Find the Lowest Common Ancestor for two given Nodes (x,y).
 *
 * Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes x and y as the lowest node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.
 * TC: O(N) where n is the number of nodes.
 * SC: O(N), auxiliary space.
 */
public class LCAInBinaryTree {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        // basea case
        if (root== null || root ==p || root == q)
            return root;

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right,p, q);

        if (null== left)return right;
        if (null== right)return left;
        else { //both left and right are not null, we found our result
            return root;
        }
    }
    public static void main(String[] args) {

    }
}
