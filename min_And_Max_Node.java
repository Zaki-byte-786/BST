public class min_And_Max_Node {
    int minValue(TreeNode root) {
        // code here
        if(root == null)return -1;
        while(root.left != null)root = root.left;
        return root.val;
    }
    int maxValue(TreeNode root) {
        // code here
        if(root == null)return -1;
        while(root.right != null)root = root.right;
        return root.val;
    }
    public static void main(String[] args) {

    }
}
