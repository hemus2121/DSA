package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Print Root to Node Path in a Binary Tree
 * Problem Statement: Print Root to Node Path In A Binary Tree. Write a program to print path from root to a given node in a binary tree.
 */
public class RootToNodePath {

    private static boolean  getPath (Node root, List<Integer> resultList, int k){
        //base case
        if (root == null) return false;

        // push the node's value into result
        resultList.add(root.data);

        // if it is the required node return true
        if (root.data == k ){
            return true;
        }
        // else check whether the required node lies  in the left subtree or right subtree of the current node
        if (getPath(root.left, resultList, k) || getPath(root.right, resultList, k)){
            return  true;
        }

        // required node does not lie either in the left or right subtree of the current nod Thus, remove current node's value from result and then return false
        resultList.remove(resultList.size()-1);
        return  false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        List < Integer > arr = new ArrayList();
        getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }
    }

}
