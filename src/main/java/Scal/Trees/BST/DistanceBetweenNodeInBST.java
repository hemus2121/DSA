package Scal.Trees.BST;

import Scal.Trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*Problem Description

Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

NOTE: Distance between two nodes is number of edges between them.

 */
public class DistanceBetweenNodeInBST {

    public int solve(TreeNode A, int B, int C) {
        return findDistanceBetweenNodes(A, B, C);
    }
    //using Dque since we can insert and remove from both ends
    Deque<Integer> bPathQue = new LinkedList<>();
    Deque<Integer> cPathQue = new LinkedList<>();

    //HINT- using concept of LCA  find total distance using 2 paths
    public int findDistanceBetweenNodes(TreeNode A, int B, int C){

        //find path for both nodes from Root
        findPath(A, B, bPathQue);
        findPath(A, C, cPathQue);

        //traverse when elements differ
        while (!bPathQue.isEmpty() && !cPathQue.isEmpty() && bPathQue.getLast() != cPathQue.getLast()){
            bPathQue.removeLast();
            cPathQue.removeLast();
        }
        //remaining elements denote length between nodes
        return  bPathQue.size()+ cPathQue.size();
    }

    //standard path generation method
    public boolean findPath(TreeNode root, int key, Deque path){
        if (root==null) return false;
        if (root.val == key){
            path.add(root.val);
            return true;
        }
        if (findPath(root.left, key, path) || findPath(root.right,key,path)){
            path.add(root.val);
            return true;
        }
        return false;
    }
}
