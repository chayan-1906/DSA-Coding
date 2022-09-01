public class BinaryTree {
    
    private static TreeNode root;
    
    public static void main (String[] args) {
    }
    
    private static void createBinaryTree () {
        TreeNode first = new TreeNode (1);
        TreeNode second = new TreeNode (2);
        TreeNode third = new TreeNode (3);
        TreeNode fourth = new TreeNode (4);
        TreeNode fifth = new TreeNode (5);
        
        root = first;
        
        first.left = second;
        first.right = third;
        
        second.left = fourth;
        second.right = fifth;
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
