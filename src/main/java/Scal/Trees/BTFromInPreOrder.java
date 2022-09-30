package Scal.Trees;

/** Problem Description
 Given preorder and inorder traversal of a tree, construct the binary tree.
 NOTE: You may assume that duplicates do not exist in the tree.

Input
 First argument is an integer array A denoting the preorder traversal of the tree.
 Second argument is an integer array B denoting the inorder traversal of the tree.
 */
import Scal.Trees.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class BTFromInPreOrder {

    static Map<Integer, Integer> inorderMap = new HashMap<>();
     static TreeNode buildTree(int[] A, int[] B) {
        //copy the element from Inorder array so that we get root index faster
        //copy  element from Inorder array to MAp so that we get root index faster
        constructMap(B);
        int is=0;
        int ie=B.length-1;
        int ps=0;
        int pe=A.length-1;

        return buildTreeFromTraversal(A,ps, pe, B, is, ie);
    }
    // build map of inorder elements
    static void constructMap(int []B){
        for (int i=0;i< B.length;i++){
            inorderMap.put(B[i],i);
        }
    }

    static TreeNode buildTreeFromTraversal(int [] A,int ps, int pe, int [] B, int is, int ie){
        //Base case
        if (ps > pe) return null;

        //MainLogic

        //Get the index from inorder array
        int rootIndex = inorderMap.get(A[ps]);

        // get count of elements on LST
        int countOfElements = rootIndex-is;

        //construct Root
        TreeNode root = new TreeNode( A[ps]);
        root.left = buildTreeFromTraversal(A, ps+1, ps+countOfElements, B, is, rootIndex-1);
        root.right = buildTreeFromTraversal(A, ps+1+countOfElements, pe, B, rootIndex+1, ie);
        return root;
    }

    public static void main(String[] args) {
        int [] A= {1, 2, 3};
        int [] B= {2, 1, 3};
        System.out.println(buildTree(A, B));
    }
}
