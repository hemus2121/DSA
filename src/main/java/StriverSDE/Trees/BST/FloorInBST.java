package StriverSDE.Trees.BST;

import StriverSDE.Trees.Node;

/** Floor in BST
 * You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST  which is smaller than or equal to  ‘X’.
 */
public class FloorInBST {
    public static int floorInBST(Node root, int key){
        int floor =-1;
        while (root != null){
            //check root is required
            if (root.data == key ){
                floor = root.data;
                return  floor;
            }

            if (key > root.data){
                floor = root.data; // most probable answer till now
                root = root.right;
            }else root = root.left;

        }
        return  floor;


    }
}
