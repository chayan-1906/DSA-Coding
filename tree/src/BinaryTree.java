import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
    
    private static TreeNode root;
    
    public static void main (String[] args) {
        int choice;
        Scanner scanner = new Scanner (System.in);
        do {
            System.out.print ("Enter your choice: ");
            choice = scanner.nextInt ();
            if (choice == 1) {
                createBinaryTree ();
            } else if (choice == 2) {
                preorderTraversal (root);
                System.out.println ();
            } else if (choice == 3) {
                iterativePreorder (root);
                System.out.println ();
            } else if (choice == 4) {
                inorderTraversal (root);
                System.out.println ();
            } else if (choice == 5) {
                iterativeInorder (root);
                System.out.println ();
            } else if (choice == 6) {
                postorderTraversal (root);
                System.out.println ();
            } else if (choice == 7) {
                iterativePostorder (root);
                System.out.println ();
            } else if (choice == 8) {
                levelOrderTraversal (root);
                System.out.println ();
            } else if (choice == 9) {
                System.out.println ("Height of Tree: " + height (root));
            }
        } while (choice != 100);
    }
    
    /// choice 1
    private static void createBinaryTree () {
        TreeNode first = new TreeNode (9);
        TreeNode second = new TreeNode (2);
        TreeNode third = new TreeNode (3);
        TreeNode fourth = new TreeNode (4);
//        TreeNode fifth = new TreeNode ( 5 );
        
        root = first;
        
        first.left = second;
        first.right = third;
        
        second.left = fourth;
//        second.right = fifth;
    }
    
    /// choice 2
    private static void preorderTraversal (TreeNode root) {
        if (root == null) return;
        System.out.print (root.data + " ");
        preorderTraversal (root.left);
        preorderTraversal (root.right);
    }
    
    /// choice 3
    private static void iterativePreorder (TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<> ();
        stack.push (root);
        while (! stack.isEmpty ()) {
            TreeNode temp = stack.pop ();
            System.out.print (temp.data + " ");
            if (temp.right != null) stack.push (temp.right);
            if (temp.left != null) stack.push (temp.left);
        }
    }
    
    /// choice 4
    private static void inorderTraversal (TreeNode root) {
        if (root == null) return;
        inorderTraversal (root.left);
        System.out.print (root.data + " ");
        inorderTraversal (root.right);
    }
    
    /// choice 5
    private static void iterativeInorder (TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode temp = root;
        while (! stack.isEmpty () || temp != null) {
            if (temp != null) {
                stack.push (temp);
                temp = temp.left;
            } else {
                temp = stack.pop ();
                System.out.print (temp.data + " ");
                temp = temp.right;
            }
        }
    }
    
    /// choice 6
    private static void postorderTraversal (TreeNode root) {
        if (root == null) return;
        postorderTraversal (root.left);
        postorderTraversal (root.right);
        System.out.print (root.data + " ");
    }
    
    /// choice 7
    // couldn't understand logic
    private static void iterativePostorder (TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<> ();
        while (current != null || ! stack.isEmpty ()) {
            if (current != null) {
                stack.push (current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek ().right;
                if (temp == null) {
                    temp = stack.pop ();
                    System.out.print (temp.data + " ");
                    while (! stack.isEmpty () && temp == stack.peek ().right) {
                        temp = stack.pop ();
                        System.out.print (temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
    
    /// choice 8
    private static void levelOrderTraversal (TreeNode root) {
        for (int level = 0; level <= height (root); level++) printCurrentLevel (root, level);
    }
    
    /// choice 9
    private static int height (TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height (root.left);
        int rightHeight = height (root.right);
        if (leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;
    }
    
    private static void printCurrentLevel (TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print (root.data + " ");
        else if (level > 1) {
            printCurrentLevel (root.left, level - 1);
            printCurrentLevel (root.right, level - 1);
        }
    }
    
    private static int maximumElement (TreeNode root) {
        return 0;
    }
    
    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;
        
        public TreeNode (int data) {
            this.data = data;
        }
    }
}
