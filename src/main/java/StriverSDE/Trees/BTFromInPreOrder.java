package StriverSDE.Trees;

/** Construct A Binary Tree from Inorder and Preorder Traversal
 * Construct A Binary Tree from Inorder and Preorder Traversal.
 * TC: SC: O(N)
 */

import java.util.HashMap;
import java.util.Map;

public class BTFromInPreOrder {
    static Node buildTree(int[] preorder, int[] inorder){
        //Create map to store inorder elements along with index
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i =0;i< inorder.length;i++){
            inOrderMap.put(inorder[i], i);
        }
        Node root = buildTree(preorder,0, preorder.length-1, inorder, 0, inorder.length-1, inOrderMap);
        return root;
    }

    private static Node buildTree( int [] preOrder , int ps, int pe, int [] inOrder, int is, int ie, Map<Integer, Integer> inOrderMap){
        //base case
        if ( ps > pe || is > ie) return null ;

        Node root = new Node( preOrder[ps]); //root of the tree
        int rootIndex = inOrderMap.get(root.data); // get root index
        int leftIndex = rootIndex-is;

        root.left = buildTree(preOrder, ps+1, ps+leftIndex, inOrder, is, rootIndex-1, inOrderMap);
        root.right = buildTree(preOrder, ps+leftIndex+1, pe, inOrder, rootIndex+1, ie, inOrderMap);
        return  root;
    }

    public static void main(String[] args) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        Node root = buildTree(preorder, inorder);
    }
}
