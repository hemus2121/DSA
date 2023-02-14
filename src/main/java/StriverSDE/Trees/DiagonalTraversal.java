package StriverSDE.Trees;
//https://www.techiedelight.com/print-diagonal-traversal-binary-tree/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 Print diagonal traversal of a binary tree
 Given a binary tree, print all nodes for each diagonal having negative slope (\). Assume that the left and right child of a node makes a 45–degree angle with the parent.
 For example, consider the following binary tree having three diagonals. The diagonal’s traversal is:

 1 3 6
 2 5 8
 4 7
 */
public class DiagonalTraversal {
    class Node {
        int data;
        Node left,right;

        Node (int data){
            this.data = data;
        }
    }
    private static void printDiagonal(Node node, int diagonal, Map<Integer, List<Integer>> map){
            //base case
         if (node == null ) return ;

         //insert int current node into the current diagonal
        map.put(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.data);

        // recur for the left subtree by increasing diagonal by 1
        printDiagonal(node.left, diagonal+1, map);

        // recur for the right subtree with the same diagonal
        printDiagonal(node.right, diagonal, map);
    }
  //Recursive approach

}
