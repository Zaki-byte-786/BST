class Solution
{
    int numberOfNode = 0,ans = 0;
    int NodeCount(TreeNode root){
        if(root == null)return 0;
        return 1 + NodeCount(root.left) + NodeCount(root.right);
    }

    public void inorder2Traversal(TreeNode root,int K) { // method for Kth smallest element
        int count = 0;
        if(root == null)return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                count++;
                if (count == numberOfNode - K + 1){
                    ans = curr.val;
                    //break -> if we use break here it will stop iterating over complete tree but the tree will be modified
                }
                curr = curr.right;
            }
            else{
                TreeNode currLeft = curr.left;
                while(currLeft.right != null && currLeft.right != curr){
                    currLeft = currLeft.right;
                }
                if(currLeft.right == null){
                    currLeft.right = curr;
                    curr = curr.left;
                }
                else{
                    count++;
                    if (count == numberOfNode - K + 1){
                        ans = curr.val;
                        //break -> if we use break here it will stop iterating over complete tree but the tree will be modified
                    }
                    currLeft.right = null;
                    curr = curr.right;
                }
            }
        }
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(TreeNode root,int K)
    {
        //Your code here
        numberOfNode = NodeCount(root);
        inorder2Traversal(root,K);
        return ans;
    }
}
public class find_Kth_Largest_Element_SC_Constant {
    public static void main(String[] args) {

    }
}
