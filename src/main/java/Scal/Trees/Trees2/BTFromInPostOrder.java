package Scal.Trees.Trees2;

/**  Binary Tree From Inorder And Postorder
 * Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 * Input
 * First argument is an integer array A denoting the inorder traversal of the tree.
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 */
import Scal.Trees.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class BTFromInPostOrder {

    static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode buildTree(int[] A, int[] B) {
        int is=0;
        int ie=A.length-1;
        int ps =0;
        int pe = B.length-1;
        constructMap(A);
        return buildTreeFromTraversal(B, ps,pe, A, ie, is);
    }
    static void constructMap(int []A){
        for (int i=0;i< A.length;i++){
            inorderMap.put(A[i],i);
        }
    }

    static TreeNode buildTreeFromTraversal(int [] post, int ps, int pe, int [] in, int is, int ie){
        //Base case
        if (is > ie) return  null;

        //Main Logic
        int rootIndex = inorderMap.get(post[pe]);
        int countOfElement = rootIndex-is;

        //construct Tree
        TreeNode treeNode = new TreeNode(post[pe]);
        treeNode.left =buildTreeFromTraversal(post, ps, ps+countOfElement-1, in, is, rootIndex-1 );
        treeNode.right = buildTreeFromTraversal(post, ps+countOfElement, pe,in, rootIndex+1, ie);
        return  treeNode;
    }

    public static void main(String[] args) {
        int [] A ={2,1,3};
        int [] B = {2, 3, 1};
        System.out.println(buildTree(A, B));
    }
}
