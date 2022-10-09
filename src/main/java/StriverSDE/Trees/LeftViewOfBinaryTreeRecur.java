package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/** Left view of Binary Tree
 * Right/Left view of binary tree
 * Problem Statement: Given a Binary Tree, find the Right/Left view of it. The right view of a Binary Tree is a set of nodes visible when the tree is viewed from the right side. The left view of a Binary Tree is a set of nodes visible when the tree is viewed from the left side.
 *
 * TC: O(N)
 * SC: O(H)  Height of the Tree
 */
public class LeftViewOfBinaryTreeRecur {

    //For every level, the first node (on the left side) will be our left side view
    //if the level of the tree == my list size, I need to push it into my list
    //if at any point we reach a null node, we just need to return (base case)
    public List<Integer> leftSideViewRecursive(Node node){
        List<Integer> resultList = new ArrayList<>();
        leftView(node, resultList,0);
        return resultList;
    }

    //USing concept of REVERSE PRE ORDER stuff Root,left right instead use Root, right, left
    private void leftView(Node node, List<Integer> resultList, int currentDepth){
        //base case
        if (node == null ) return ;

        if (currentDepth == resultList.size()){
            resultList.add(node.data);
        }
        leftView(node.left, resultList, currentDepth+1);
        leftView(node.right, resultList, currentDepth+1);
    }
}
