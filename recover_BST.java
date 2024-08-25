class recover {
    private TreeNode first = null, second = null, prev = null;

    // Method to perform in-order traversal and detect swapped nodes
    private void inorder(TreeNode root) {
        if (root == null) return;

        // Traverse the left subtree
        inorder(root.left);

        // Detect the swapped nodes
        if (prev != null && root.val < prev.val) {
            // If this is the first encounter of an anomaly
            if (first == null) {
                first = prev;
            }
            // Second encounter of an anomaly
            second = root;
        }
        // Update prev to the current node
        prev = root;

        // Traverse the right subtree
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);  // Perform in-order traversal to find the swapped nodes

        // Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
public class recover_BST {

    public static void main(String[] args) {

    }
}
