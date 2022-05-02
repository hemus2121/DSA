package LeetCode.Trees;


import java.util.Stack;

//TC : O(1) amortized (average) time complexity for next()  and SC : O(N)
public class BinarySearchTreeIteratorNoExtraSpace {

    // Stack for the recursion simulation
    Stack<TreeNode> st = new Stack<>();

    // add left branch elements into stack until leaf node
    private BinarySearchTreeIteratorNoExtraSpace(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    // check if stack is not empty then next element is found
    private boolean hasNext() {
        return !st.isEmpty();
    }

    private int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode result = st.pop();

        //push to stack if right is found
        TreeNode node = result.right;

        //Traverse to left while pushing right on to stack
        while (node != null){
            st.push(node);
            node = node.left;
        }
        return result.val;
    }
}
