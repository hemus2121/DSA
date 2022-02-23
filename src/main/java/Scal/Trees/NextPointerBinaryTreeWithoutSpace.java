package Scal.Trees;

/*
Problem Description
        Given a binary tree,
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.
        Assume perfect binary tree and try to solve this in constant extra space.
 */
public class NextPointerBinaryTreeWithoutSpace {

    class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    
    //Iterative solution without extra space
    public void connect (TreeLinkNode root){

        if (root ==null) return ;
        //One pointer which always moves left for each level
        TreeLinkNode curr=root;
        while (curr !=null){
            //One more pointer which moves across levels
            TreeLinkNode level =curr;
            while (level !=null && level.left !=null){
                // set 1st next pointer to current level right pointer
                level.left.next = level.right;
                if (level.next !=null) {
                    level.right.next = level.next.left;
                }
                //move next node in same level
                level =level.next;
            }
            //move to left pointer - starting node in each level
            curr = curr.left;
        }
   }
}
