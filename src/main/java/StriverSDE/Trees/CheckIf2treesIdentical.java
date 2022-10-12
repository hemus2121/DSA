package StriverSDE.Trees;

/** Check if two trees are identical
 * Problem Statement: Given two Binary Tree. Write a program to check if two trees are identical or not.
 *
 */
public class CheckIf2treesIdentical {

    //Any traversal would work
    public boolean checkIdentical (Node p, Node q){
        //base case
        if (p==null || q== null) {
            return (p == q);
        }
        //check for left and right sides
        return (p.data ==q.data) && checkIdentical(p.left, q.left) && checkIdentical(p.right, q.right);
    }
}
