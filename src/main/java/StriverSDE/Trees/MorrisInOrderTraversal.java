package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/** Morris Inorder Traversal of a Binary tree
 * Problem Statement: Write a program for Morris Inorder Traversal of a Binary Tree.
 * TC :SC : O(N)
 */
public class MorrisInOrderTraversal {

    public static List<Integer> morrisInorderTraversal(Node root){

        //place holder for result
        List<Integer> inorderList = new ArrayList<>();

        Node curr =root; //start with root node

        while (curr != null){
            //case 1. - No left subtree present
            if (curr.left == null){
                inorderList.add(curr.data);  // add to result list
                curr = curr.right;  //traverse to right of curren node
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
                    curr= curr.left;
                }
                else { // prev.right ==curr
                     // link between extreme right and parent is already present so break the previously created link
                    prev.right =null;
                    inorderList.add(curr.data );
                    curr = curr.right;
                }
            }
        }
        return inorderList;
    }
}
