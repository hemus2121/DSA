package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/** Kth Smallest Element in BST
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElement {

    private List <Integer> inordertraversal(Node root, List<Integer> resultList){
        if (root== null ) return resultList;
        inordertraversal(root.left, resultList);
        resultList.add(root.data);
        inordertraversal(root.right, resultList);
        return resultList;
    }

    //Recursive approach - TC:O(N) SC: O(N)
    public int kthSmallest(Node root, int k) {
    List<Integer> resultList = inordertraversal(root, new ArrayList<>());
    return resultList.get(k-1);
    }


    //Iterative Approach using Stack TC: O(N) and SC:O(N)
    public  int kthSmallestIterative(Node root, int k){
        Stack<Node> stack = new Stack<>();
        while (true){
            //traverse to left most element
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k==0) return root.data;
            root = root.right;
        }

    }

    public int kthLargest(Node root, int k){
        Stack<Node> stack = new Stack<>();
        //int count =0;
        while (true){
            // traverse to right most element
            while (root != null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            //count++;
            if (--k ==0) return root.data;
            root = root.left;
        }
    }
}
