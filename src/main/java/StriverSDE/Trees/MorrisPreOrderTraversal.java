package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/** Morris Pre Oder Traversal of a Binary tree
 * Problem Statement: Write a program for Morris Inorder Traversal of a Binary Tree.
 * TC :SC : O(N)
 */
public class MorrisPreOrderTraversal {

    public static List<Integer> morrisPreorderTraversal(Node root){

        //place holder for result
        List<Integer> preorderList = new ArrayList<>();

        Node curr =root; //start with root node

        while (curr != null){
            //case 1. - No left subtree present
            if (curr.left == null){
                preorderList.add(curr.data);  // add to result list
                curr = curr.right;  //traverse to right of curren tnode
            }
            else {
                // Case 2: Left  subtree is present
                Node prev = curr.left;
                // travers to extreme right of left subtree
                while (prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                //creating new link between extreme right and parent node
                if(prev.right==null){
                    prev.right= curr;
                    preorderList.add(curr.data); // add to result before moving over to left node
                    curr= curr.left;
                }
                else { // prev.right ==curr
                     // link between extreme right and parent is already present so break the previously created link
                    prev.right =null;
                    curr = curr.right;
                }
            }
        }
        return preorderList;
    }
}
