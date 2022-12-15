package StriverSDE.Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** Serialize And Deserialize a Binary Tree
 * Problem Statement: Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeDeSerialize {

    public String serialize(Node root) {
        if (root == null) return null;

        StringBuilder sb = new StringBuilder();
        //using Level order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                sb.append("n "); // acts as DELIMITER
                continue;
            }
            sb.append(node.data + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    public Node deserialize(String data) {
        if (data == "") return null;
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // iterate for all the elements
        for (int i = 1; i < values.length; i++) {
            Node parent = q.poll();
            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
