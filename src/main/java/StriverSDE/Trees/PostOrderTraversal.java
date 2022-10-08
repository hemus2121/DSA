package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** PostOrder Traversal
 * TC: SC: O(N)
 */
public class PostOrderTraversal {

    //using 2 stacks
    public static void postOrderIter(Node root, List<Integer> resultList){
        if (root == null ) return;
        Stack<Node> st1 = new Stack<>(); // holds left and right pointers of current node
        Stack<Node> st2 = new Stack<>(); // place holder after u post from stack 1

        //add to 1st stack root
        st1.add(root);
        while (!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if (root.left!= null){
                st1.add(root.left);
            }
            if (root.right!= null){
                st1.add(root.right);
            }
        }

        while (!st2.isEmpty()){
            resultList.add(st2.pop().data);
        }
    }

    public static void postOrderRecur(Node root, List<Integer> resultList){

        if (root == null) return;
        postOrderRecur(root.left, resultList);
        postOrderRecur(root.right, resultList);
        resultList.add(root.data);
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

        List < Integer > postOrderList = new ArrayList< >();
        postOrderRecur(root, postOrderList);

        System.out.println("The postOrder Traversal is : " + postOrderList); //expected - 4 8 5 2 6 9 10 7 3 1
        postOrderList.clear();
        postOrderIter(root, postOrderList);
        System.out.println("The postOrder Traversal is : " + postOrderList); //expected - 4 8 5 2 6 9 10 7 3 1

    }
}
