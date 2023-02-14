package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: BoundaryTraversal of a binary tree. Write a program for the Anti-Clockwise Boundary traversal of a binary tree.
 * TC: O(N). Reason: The time complexity will be O(H) + O(H) + O(N) which is ≈ O(N)
 * SC: O(N) Reason: Space is needed for the recursion stack while adding leaves. In the worst case (skewed tree), space complexity can be O(N).
 */
public class BoundaryTraversal {

    private static  boolean isLeafNode(Node node){

        return (node.left == null) && (node.right == null);
    }
   static void addLeftBoundary(Node node, List<Integer> resultList){
        Node curr = node.left ;
        while (curr != null){
            if (isLeafNode(curr)== false)
                resultList.add(curr.data);
            if (curr.left != null)
                curr = curr.left;
            else curr = curr.right;
        }
    }

    static void addLeafNodes(Node node, List<Integer> resultList) {
        if (isLeafNode(node)) {
            resultList.add(node.data);
            return;
        }
        if (node.left != null) addLeafNodes(node.left, resultList);
        if (node.right != null) addLeafNodes(node.right, resultList);
    }

    static void addRightBoundary(Node node, List<Integer>resultList){
        List<Integer> rightList = new ArrayList<>();
        Node curr = node.right;
        while (curr != null ){
            if (isLeafNode(curr)==false) rightList.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        //copy element from rightList to resultList in reverse way
        for (int i = rightList.size()-1; i >=0;i--){
            resultList.add(rightList.get(i));
        }
    }

    static List< Integer > printBoundary(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (isLeafNode(root)== false) resultList.add(root.data);
        addLeftBoundary(root,  resultList);
        addLeafNodes(root, resultList);
        addRightBoundary(root, resultList);
        return resultList;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        List < Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }
}
