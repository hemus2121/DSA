package StriverSDE.Trees;

/** Construct Binary Tree from Inorder and Postorder Traversal
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 */

import java.util.HashMap;
import java.util.Map;


public class BTFromInPostOrder {

    public Node buildTree(int [] inorder , int [] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private Node build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> inorderMap) {
        if (ps >pe || is >ie){
            return  null;
        }

        Node root = new Node(postorder[pe]);

        int rootIndex = inorderMap.get(postorder[pe]);
        int leftNums = rootIndex -is;

        root.left = build(inorder, is, rootIndex-1, postorder, ps, ps+leftNums-1, inorderMap);
        root.right = build(inorder, rootIndex+1, ie, postorder, ps+leftNums, pe-1, inorderMap);
        return root;
    }
}
