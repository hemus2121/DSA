package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Two Sum IV- Input is BSE
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * TC: O(N)
 * SC: O(1)
 */

class BSTIteratorN{
    private Stack<Node> st = new Stack<Node>();
    boolean reverse = true;
    //constructor
    BSTIteratorN(Node root, boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next(){
        Node tmp = st.pop();
        if (reverse == false) pushAll(tmp.right);
        else pushAll(tmp.left);
        return tmp.data;
    }

    void pushAll(Node node){
        while (node != null){
            st.push(node);
            if (reverse == false) node = node.right;
            else node = node.left;
        }
    }
}
public class TwoSumIVBST {

    //Solution using SC = O(N)

    void inorder(Node root, List<Integer> list){
        if (root == null) return ;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    public  boolean findTargetWithSpace(Node root, int k){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int l = 0, r = list.size()-1;
        // Normal 2 point approach in array to search for target
        while (l <r){
            int sum = list.get(l) + list.get(r);
            if (sum ==k){
                return true;
            }
            if (sum <k){
                l++;
            }else r--;
        }
        return false;
    }



    //Solution using SC = O(1)
    public boolean findTarget(Node root, int k) {
        if (root == null ) return false;
        BSTIteratorN l = new BSTIteratorN(root, false);
        BSTIteratorN r = new BSTIteratorN(root, true);
        int i = l.next();
        int j = r.next();

        while (i<j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
