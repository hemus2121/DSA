package StriverSDE.Trees.BST;

/** Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 */
public class PopulatingNextRightPointers {

    class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public TreeLinkNode connect (TreeLinkNode root){
        if (root == null) return null;

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        TreeLinkNode leftMost = root;
        // Iterate the "linked list" starting from the head
        // node and using the next pointers, establish the
        // corresponding links for the next level
        while (leftMost.left !=null){
            TreeLinkNode head = leftMost;

            while (head != null){
                head.left.next = head.right;

                if (head.next != null){
                    head.right.next = head.next.left;
                }
                //progress along the list (nodes of the current level)
                head = head.next;
            }
            leftMost = leftMost.left;

        }
        return root;
    }
}
