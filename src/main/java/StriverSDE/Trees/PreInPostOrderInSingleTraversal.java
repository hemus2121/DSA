package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Preorder Inorder Postorder Traversals in One Traversal
 *
 * Problem Statement: Preorder Inorder Postorder Traversals in One Traversal. Write a program to print Preorder, Inorder, and Postorder traversal of the tree in a single traversal.
 * Time Complexity: O(N) Reason: visiting every node thrice therefore time complexity will be O(3*N), which can be assumed as linear time complexity.
 * Space Complexity: O(N) Reason: using three lists and a stack to store the nodes. The time complexity will be about O(4*N), which can be assumed as linear time complexity.
 */
public class PreInPostOrderInSingleTraversal {
    static class Pair {
        Node node;
        int counter;

        Pair(Node node, int counter) {
            this.node = node;
            this.counter = counter;
        }
    }

    public static void preInPostTraversal(Node root, List < Integer > preList , List < Integer > inList, List < Integer > postList ) {
        Stack<Pair> st = new Stack<>();
        //start with root node
        st.add(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair temp = st.pop();

            //check k3 cases 1- Pre order 2- Inorder 3 -post order
            //  this is part of pre increment 1 to 2
            //   push the left side of the tree
            if (temp.counter == 1) {
                preList.add(temp.node.data);
                temp.counter++;
                st.add(temp);

                if (temp.node.left != null) { // if left exists add with new count of 1 since its child node of current NODE
                    st.add(new Pair(temp.node.left, 1));
                }
            } else if (temp.counter == 2) {
                inList.add(temp.node.data);
                temp.counter++;
                st.add(temp);

                //pusht the right side fo tree
                if (temp.node.right != null) {
                    st.add(new Pair(temp.node.right, 1));
                }
            } else postList.add(temp.node.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List < Integer > pre = new ArrayList ();
        List < Integer > in = new ArrayList ();
        List < Integer > post = new ArrayList ();
        preInPostTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }

}
