package StriverSDE.Trees;

import java.util.Stack;

/** Flatten Binary Tree to Linked List
 * Problem Statement: Flatten Binary Tree To Linked List. Write a program that flattens a given binary tree to a linked list.
 *
 * The sequence of nodes in the linked list should be the same as that of the preorder traversal of the binary tree.
 * The linked list nodes are the same binary tree nodes. You are not allowed to create extra nodes.
 * The right child of a node points to the next node of the linked list whereas the left child points to NULL.
 */
public class FlattenBTLL {

    static Node prev = null;
    static void flattenRecursion(Node root){
        if (root == null) return;;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left =null;
        prev = root;
    }


    // EXTRA SPACE - using Stack Approach  - Sc:O(N)
    static void flatten(Node  root) {
        if (root == null)
            return;

        //using Stack extra DS
        Stack<Node> st = new Stack();
        st.add(root);

        // Add right, left
        // pop and connect curr to st.peek()
        while (!st.isEmpty()){
            Node cur = st.pop();

            if (cur.right != null){
                st.add(cur.right);
            }
            if (cur.left !=null){
                st.add(cur.left);
            }
            if(!st.isEmpty()){
                cur.right = st.peek(); // connect element on top of stack
            }
            cur.left = null; //  set the left poiner to null
        }
    }
    //NO EXTRA SPACE - similar to Morris Inorder linking flow
    static void flattenNoExtraSpace(Node root){
        Node cur = root;
        while (cur !=null){
            if (cur.left !=null){
                Node pre = cur.left ;
                //traverse until we get right most element  on left sub stree
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left= null;
            }
            cur = cur.right;
        }
    }
    public static void main(String[] args) {

        Node  root = new Node(1);
        root . left = new Node(2);
        root . left . left = new Node(3);
        root . left . right = new Node(4);
        root . right = new Node(5);
        root . right . right = new Node(6);
        root . right . right . left = new Node(7);
        //flatten(root);
        flattenNoExtraSpace(root);

        while(root.right!=null) {
            System.out.print(root.data+"->");
            root=root.right;}
        System.out.print(root.data);
    }
}
