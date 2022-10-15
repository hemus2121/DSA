package StriverSDE.Trees;

/**  Mirror Tree - https://practice.geeksforgeeks.org/problems/mirror-tree/1
 * Given a Binary Tree, convert it into its mirror.
 */
public class MirrorTree {
    Node mirror(Node node) {
        return generateMirror(node);
    }
    Node generateMirror (Node node){
        //base case
        if (node == null) return null;
        // Main logic - recursively call in post order
        generateMirror(node.left);
        generateMirror(node.right);

        // POST order Traversal
        Node temp = node.left;
        node.left = node.right;
        node.right= temp;
        return node;
    }
}
