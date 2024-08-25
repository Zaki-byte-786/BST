public class Insert_a_given_Node_in_Binary_Search_Tree {
    static TreeNode function(TreeNode root,int val){
        TreeNode temp = root;
        TreeNode x = new TreeNode(val);
        if(root == null){
            root = x;
            return root;
        }
        TreeNode curr = root;
        while (curr != null){
            temp = curr;
            if (curr.val < val)curr = curr.right;
            else curr = curr.left;
        }
        if (temp.val < val)temp.right = x;
        else temp.left = x;
        return root;
    }
    public static void main(String[] args) {

    }
}
