package Scal.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
        Given a binary tree,
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.
        Assume perfect binary tree and try to solve this in constant extra space.

 */
public class NextPointerBinaryTreeWithSpace {
    class TreeLinkNode{
        int val;
        TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    //Iterative solution
    public void connect (TreeLinkNode treeLinkNode){

        if (treeLinkNode ==null) return ;

        Queue<TreeLinkNode> que = new LinkedList();
        que.add(treeLinkNode);

        while (que.size()>0){

            int qsize = que.size();
            //iterate for all Q elements

            for (int i =0;i<qsize;i++){
                //take element from Q
                TreeLinkNode temp =que.poll();
                // Q contains elements at specific level any time so we need
                // establish connection to next next node thats all
                if ( i< qsize-1)
                    temp.next = que.peek();

                if (temp.left != null) que.add(temp.left);
                if (temp.right !=null) que.add(temp.right);
            }
        }
    }
}
