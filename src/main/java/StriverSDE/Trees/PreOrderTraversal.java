package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** PreOrder Traversal
 * Given a binary tree print the preorder traversal of binary tree.
 */
public class PreOrderTraversal {

    private static void preorderIter(Node root, List<Integer> resultList){

        if (root == null) return;
        Stack <Node> st = new Stack<>();
        st.add(root);

        while (!st.isEmpty()){
            root = st.pop();
            resultList.add(root.data);
            if (root.right != null) st.add(root.right); // ad right first to keep track of it
            if (root.left != null) st.add(root.left);
        }
    }

    private static void  preorderRecur(Node node, List<Integer> resultList){
        // base case
        if(node == null) return;
        resultList.add(node.data);
        preorderRecur(node.left, resultList);
        preorderRecur(node.right,resultList);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List < Integer > preOrderList = new ArrayList< >();
        preorderRecur(root, preOrderList);
        System.out.println("The preOrder Traversal is : " + preOrderList); //expected 1 2 4 5 8 3 6 7 9 10
        preOrderList.clear();
        preorderIter( root , preOrderList);
        System.out.print("The preOrder Traversal is : " + preOrderList); //expected 1 2 4 5 8 3 6 7 9 10
    }
}
