public class Delete_Node_in_Binary_Search_Tree {
    static TreeNode function(TreeNode root,int key){
        if (root == null)return null;
        TreeNode curr = root;
        if (curr.val == key) return helper(curr);
        while (curr!= null){
            if (curr.val < key){
                if (curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                    break;
                }
                else curr = curr.right;
            }
            else {
                if (curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                }
                else curr = curr.left;
            }
        }
        return root;
    }
    static TreeNode helper(TreeNode root){
        TreeNode leftChildRoot = root.left;
        TreeNode rightChildRoot = root.right;
        if (leftChildRoot == null)return rightChildRoot;
        else if (rightChildRoot == null)return leftChildRoot;
        TreeNode temp = leftChildRoot;
        while (temp.right != null)temp = temp.right;
        temp.right = rightChildRoot;
        return leftChildRoot;
    }
    public static void main(String[] args) {

    }
}
