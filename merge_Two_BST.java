import java.util.*;
public class merge_Two_BST {
    static void inOrderTraversal(TreeNode root, List<Integer> list){
        if (root == null)return;
        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);
    }
    static List<Integer> merge(TreeNode root1, TreeNode root2) {
        // Write your code here
         List<Integer> list1 = new LinkedList<>();
         List<Integer> list2 = new LinkedList<>();
         inOrderTraversal(root1,list1);
         inOrderTraversal(root2,list2);
         List<Integer> ans = new LinkedList<>();
         int i = 0,j = 0;
         while (i < list1.size() && j < list2.size()){
             if (list1.get(i) < list2.get(j)) ans.add(list1.get(i++));
              else if (list2.get(j) < list1.get(i)) ans.add(list2.get(j++));
              else {
                  ans.add(list1.get(i++));
                  ans.add(list2.get(j++));
             }
         }
         while (i < list1.size()) ans.add(list1.get(i++));
         while (j < list2.size()) ans.add(list2.get(j++));
         return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(11);
        root.left = a;
        a.left = b;
        a.right = c;
        System.out.println(merge(root,root));

    }
}
