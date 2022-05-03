package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

//TC : O(n) and SC : O(n)
public class BinarySearchTreeIteratorWithExtraSpace {

    // Explicit store
    static List<Integer> dataList= new ArrayList();
    int index=0;

    public BinarySearchTreeIteratorWithExtraSpace(TreeNode root) {
        inOrderStore(root);
    }

    //Persisting tree elements INORDER into list
    static void inOrderStore(TreeNode root){
        while (root != null){
            inOrderStore(root.left);
            dataList.add(root.val);
            inOrderStore(root.right);
        }
    }

    // check in list elements are still present
    public boolean hasNext(){
        return (index < dataList.size()) ? true: false;
    }

    //return current index value and increment index to next index
    public int next(){
            return dataList.get(index++);
    }
}
