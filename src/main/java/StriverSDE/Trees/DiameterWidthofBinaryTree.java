package StriverSDE.Trees;

import java.util.LinkedList;
import java.util.Queue;

/** Maximum Width of a Binary Tree
 * Problem Statement: Write a program to find the Maximum Width of A Binary Tree.
 */
public class DiameterWidthofBinaryTree {

    static class Pair{
        Node node;
        int num;
        Pair(Node node, int num){
            this.node = node;
            this.num = num;
        }
    }


    //Using Level order traversal- bit tricky one - refer - https://www.youtube.com/watch?v=ZbybYvcVLks
    // using 2i+1 for left and 2i+2 for right node in array
    private static int getWidthOfTree (Node root){
        if (root == null) return 0;
        int ans =0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero- get current minimun
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num-mmin; // reset count to begin with ZERO
                Node node = q.peek().node;
                q.poll();

                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;

                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null)
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node  root = new Node(1);
        root . left = new Node(3);
        root . left . left = new Node(5);
        root . left . left . left = new Node(7);
        root . right = new Node(2);
        root . right . right = new Node(4);
        root . right . right . right = new Node(6);

        int maxWidth = getWidthOfTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);
    }
}
