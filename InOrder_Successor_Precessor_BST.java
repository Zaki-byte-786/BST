import java.util.*;
public class InOrder_Successor_Precessor_BST {
    static int predecessor(TreeNode root,int key){
        int predecessor = -1;
        while(root != null){
            if(root.val < key){
                predecessor = root.val;
                root = root.right;
            }
            else root = root.left;
        }
        return predecessor;
    }
    static int successor(TreeNode root,int key){
        int successor = -1;
        while(root != null){
            if(root.val > key){
                successor = root.val;
                root = root.left;
            }
            else root = root.right;
        }
        return successor;
    }
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer> list = new LinkedList<>();
        list.add(predecessor(root,key));
        list.add(successor(root,key));
        return list;
    }

}
