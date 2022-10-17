package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Construct BST from preOrder Traversal
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 * TC : O(N) - Refer - https://www.youtube.com/watch?v=UmJT3j26t1I
 * SC : O(1)
 */
public class ConstructBSTFromPreOrder {

    // just playing with upper bound only
    // going left --> left, node.val (bound)
    // going right -->  right, upper bound transferred

    int index =0;

    public Node bstFromPreorder(int[] preorder) {
        //return constructTree(preorder, Integer.MAX_VALUE, new int []{0});
        return consPreOrder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //Using only upper bound variable
    Node constructTree ( int [] preorder, int bound, int [] index){
        if (index[0]== preorder.length || preorder[index[0]] > bound) return null;
        Node root = new Node( preorder[index[0]]++);
        root.left = constructTree(preorder, root.data, index);
        root.right = constructTree(preorder, bound, index);
        return root;
    }

    // Using both upper and lower bound values
    Node consPreOrder (int [] preorder, int lower, int upper){
        if (index == preorder.length) return null ;
        int val = preorder[index];

        if (val > upper || val < lower) return null;
        // place the current element
        // and recursively construct subtrees
        index++;
        Node root = new Node(val);
        root.left = consPreOrder(preorder, lower, val);
        root.right = consPreOrder(preorder, val, upper);
        return root;
     }
}
