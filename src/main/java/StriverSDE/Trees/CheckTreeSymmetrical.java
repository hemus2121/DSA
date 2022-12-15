package StriverSDE.Trees;

public class CheckTreeSymmetrical {


    static boolean isSymmetric(Node root1, Node root2){
        //base case
        if (root1 == null || root2 ==null)
            return root1 == root2;
        return (root1.data ==root2.data) && isSymmetric(root1.left, root2.right) &&
                isSymmetric(root1.right, root2.left);

    }
    public static boolean checkSymmetric(Node root){
        if (root == null) return true;
        return isSymmetric(root.left, root.right); // taking two pointers kind for 2` childer

    }
    public static void main(String[] args) {
        Node  root = new Node(1);
        root . left = new Node(2);
        root . left . left = new Node(3);
        root . left . right = new Node(4);
        root . right = new Node(2);
        root . right . left = new Node(4);
        root . right . right = new Node(3);

         if (checkSymmetric(root))
            System.out.println("The tree is symmetrical");
         else System.out.println("The tree is NOT symmetrical"); // expected Symmetrical answer
    }

}
