package StriverSDE.Trees;

import java.util.ArrayList;
import java.util.List;

/** Right  view of Binary Tree
 * Right/Left view of binary tree
 * Problem Statement: Given a Binary Tree, find the Right/Left view of it. The right view of a Binary Tree is a set of nodes visible when the tree is viewed from the right side. The left view of a Binary Tree is a set of nodes visible when the tree is viewed from the left side.
 *
 * TC: O(N)
 * SC: O(H)  Height of the Tree
 */
public class RightViewOfBinaryTreeRecur {

    //For every level, the first node (on the right side) will be our right side view
    //if the level of the tree == my list size, I need to push it into my list
    //if at any point we reach a null node, we just need to return (base case)

    public List<Integer> rightSideViewRecursive(Node node){
        List<Integer> resultList = new ArrayList<>();
        rightView(node, resultList,0);
        return resultList;
    }

    public void rightView(Node node, List<Integer> resultList,int currLevel){
        //base caes
        if (node == null) return;

        // check if size and level matches
        if (resultList.size() == currLevel){
            resultList.add(node.data);
        }
        rightView(node.right, resultList, currLevel+1);
        rightView(node.left, resultList, currLevel+1);
    }

    public void leftView (Node node, List<Integer> resultList,int currLevel ){
        if (node == null) return;
        //check if size and level matches
        if (resultList.size() == currLevel){
            resultList.add(node.data);
        }
        leftView(node.left, resultList, currLevel+1);
        leftView(node.right, resultList, currLevel+1);
    }

}
