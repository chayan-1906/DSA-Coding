import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    private static TreeNode root;

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner ( System.in );
        do {
            System.out.print ( "Enter your choice: " );
            choice = scanner.nextInt ( );
            if (choice == 1) {
                createBinaryTree ( );
            } else if (choice == 2) {
                preorderTraversal ( root );
                System.out.println ( );
            } else if (choice == 3) {
                iterativePreorder ( root );
                System.out.println ( );
            } else if (choice == 4) {
                inorderTraversal ( root );
                System.out.println ( );
            } else if (choice == 5) {
                postorderTraversal ( root );
                System.out.println ( );
            }
        } while (choice != 100);
    }

    /// choice 1
    private static void createBinaryTree() {
        TreeNode first = new TreeNode ( 9 );
        TreeNode second = new TreeNode ( 2 );
        TreeNode third = new TreeNode ( 3 );
        TreeNode fourth = new TreeNode ( 4 );
//        TreeNode fifth = new TreeNode ( 5 );

        root = first;

        first.left = second;
        first.right = third;

        second.left = fourth;
//        second.right = fifth;
    }

    /// choice 2
    private static void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print ( root.data + " " );
        preorderTraversal ( root.left );
        preorderTraversal ( root.right );
    }

    /// choice 3
    private static void iterativePreorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ( );
        stack.push ( root );
        while (!stack.isEmpty ( )) {
            TreeNode temp = stack.pop ( );
            System.out.print ( temp.data + " " );
            if (temp.right != null) stack.push ( temp.right );
            if (temp.left != null) stack.push ( temp.left );
        }
    }

    /// choice 4
    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal ( root.left );
        System.out.print ( root.data );
        inorderTraversal ( root.right );
    }

    /// choice 5
    private static void postorderTraversal(TreeNode root) {
        if (root == null) return;
        postorderTraversal ( root.left );
        postorderTraversal ( root.right );
        System.out.print ( root.data );
    }

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
