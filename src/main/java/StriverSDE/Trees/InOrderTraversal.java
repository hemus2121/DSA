package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Inorder Traversal
 * Given a Binary Tree. Find and print the inorder traversal of Binary Tree.
 *
 */
public class InOrderTraversal {

    static  void InorderIterative(Node root, List<Integer> resultList){
        Stack<Node> st = new Stack<>();
         Node node = root;
         while (true){

             if (node !=null){
                 st.add(node);
                 node = node.left;
             }else {
                 if (st.isEmpty() == true) break;
                 node = st.pop(); // pop from stack and next iterate to right child of node
                 resultList.add(node.data);
                 node = node.right;
             }
         }

    }
   //TC,SC: O(N)
    static  void InorderRecur(Node node, List<Integer> resultList){

        // base case
        if (node == null){
            return ;
        }

        //main logic
        InorderRecur(node.left, resultList);
        resultList.add(node.data);
        InorderRecur(node.right,resultList);
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

        List <Integer> inOrderList = new ArrayList< >();
        InorderRecur(root, inOrderList);
        System.out.println(inOrderList);  //expected  4 2 8 5 1 6 3 9 7 10
        inOrderList.clear();
        InorderRecur(root, inOrderList);
        System.out.println(inOrderList);
    }
}
