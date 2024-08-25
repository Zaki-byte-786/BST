class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}
public class Search_in_a_Binary_Search_Tree {
static TreeNode method(TreeNode root,int x){
    TreeNode curr = root;
    while (curr != null){
        if (curr.val == x)return curr;
        else if (curr.val < x) curr = curr.right;
        else curr = curr.left;
    }
    return curr;
}
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(12);
        root.left = a;
        root.right = b;
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(7);
        a.left = c;
        a.right = d;
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(14);
        b.left = e;
        b.right = f;
        TreeNode g = new TreeNode(6);
        TreeNode h = new TreeNode(13);
        d.left = g;
        f.left = h;

    }
}
