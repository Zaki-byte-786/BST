public class validateBST {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        boolean leftSubTree = isValidBST(root.left);
        if(leftSubTree == false)return false;
        if(prev != null && root.val <= prev.val)return false;
        prev = root;
        return isValidBST(root.right);
    }
    // range method

    boolean helper(TreeNode root,long min,long max){
        if(root == null)return true;
        if(root.val <= min || root.val >= max)return false;
        boolean leftSubTree = helper(root.left,min,root.val);
        if(!leftSubTree)return false;
        return helper(root.right,root.val,max);
    }
    public boolean isValidBST2(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
