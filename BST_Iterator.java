import java.util.Stack;

public class BST_Iterator {
    Stack<TreeNode> stack = new Stack<>();
    public void BSTIterator(TreeNode root) {
        pushAll(root);
    }
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    void pushAll(TreeNode root){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }
    public static void main(String[] args) {

    }
}
