import java.util.LinkedList;
import java.util.List;

public class BST_From_its_PreOrder {
     TreeNode bstFromPreorder(int[] A) {
        int[] i = new int[]{0}; // here we have made index as an array of single element initialized with 0
         // since in java everything is pass by value it means a variable passed in a function will not be updated
         // outside but here we need to update it hence we did this
        return bstFromPreorder(A,Integer.MAX_VALUE,i);
    }
     TreeNode bstFromPreorder(int[] A,int bound,int[] i){
        if(i[0] == A.length || A[i[0]] > bound)return null;
        TreeNode root = new TreeNode(A[i[0]]);
        i[0]++;
        root.left = bstFromPreorder(A,root.val,i);
        root.right = bstFromPreorder(A,bound,i);
        return root;
    }

//using index as global variable
    int index = 0;
     TreeNode bstFromPreorder2(int[] A) {
        return bstFromPreorder(A,Integer.MAX_VALUE);
    }
     TreeNode bstFromPreorder(int[] A,int bound){
        if(index == A.length || A[index] > bound)return null;
        TreeNode root = new TreeNode(A[index]);
         index++;
        root.left = bstFromPreorder(A,root.val);
        root.right = bstFromPreorder(A,bound);
        return root;
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
    }
}
