package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

import java.util.Stack;

/** BST Iterator
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 */
public class BSTIterator {

    Stack<Node> st = new Stack<>();
    public BSTIterator(Node root) {
        pushAll(root);
    }

    public int next() {
        Node tmpNode = st.pop();
        //push everything of right
        pushAll(tmpNode.right);
        return tmpNode.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(Node root){
        while (root != null){
            st.push(root);
            root = root.left;
        }
    }
}
