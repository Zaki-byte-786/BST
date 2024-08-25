import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class Find_K_th_smallest_largest_element_in_BST {
    static int ans = 0,count = 0;
    static void function(TreeNode root,int k){ // for smallest value
        if (root == null)return;
        function(root.left,k);
        count++;
        if (count == k){
            ans = root.val;
            return;
        }
        function(root.right,k);
    }       // TC->O(N)
            // SC->O(H)

    public void inorder2Traversal(TreeNode root,int K) { // method for Kth smallest element
        int count = 0,ans = 0;
        if(root == null)return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                count++;
                if (count == K){
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
                    if (count == K){
                        ans = curr.val;
                        //break -> if we use break here it will stop iterating over complete tree but the tree will be modified
                    }
                    currLeft.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    int count1 = 0, ans1 = 0,numberOfNode = 0;
    int NodeCount(TreeNode root){  // for largest Number
        if(root == null)return 0;
        return 1 + NodeCount(root.left) + NodeCount(root.right);
    }

    void helper(TreeNode root,int K){
        if(root == null)return;
        helper(root.left,K);
        count++;
        if(count == numberOfNode - K + 1){
            ans = root.val;
            return;
        }
        helper(root.right,K);
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(TreeNode root,int K)
    {
        //Your code here
        numberOfNode = NodeCount(root);
        helper(root,K);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(7);
        root.left = a;
        root.right = b;
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(4);
        a.left = c;
        a.right = d;
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        b.left = e;
        b.right = f;
        TreeNode g = new TreeNode(2);
        c.right = g;
//       inOrderTraversal(root);
//        System.out.println(list);
        function(root,6);
        System.out.println(ans);
    }
}
