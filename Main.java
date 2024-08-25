
import java.util.*;
 class CorrectBST {
    private TreeNode first = null, second = null, prev = null;

    // Method to perform in-order traversal and detect swapped nodes
    private void inorder(TreeNode root) {
        if (root == null) return;

        // Traverse the left subtree
        inorder(root.left);

        // Detect the swapped nodes
        if (prev != null && root.val < prev.val) {
            // If this is the first encounter of an anomaly
            if (first == null) {
                first = prev;
            }
            // Second encounter of an anomaly
            second = root;
        }
        // Update prev to the current node
        prev = root;

        // Traverse the right subtree
        inorder(root.right);
    }

    // Method to correct the BST by swapping the values of the two identified nodes
    public void correctBST(TreeNode root) {
        inorder(root);  // Perform in-order traversal to find the swapped nodes

        // Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // In-order traversal to print the BST
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        CorrectBST tree = new CorrectBST();

        // Constructing a BST and then swapping two nodes
        // Initial BST:       10
        //                  /    \
        //                 5      20
        //                / \    /  \
        //               2   8  15  25
        //
        // Let's swap 8 and 10 to simulate the issue
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(10);  // Swapped node
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        System.out.print("In-order Traversal of BST with Swapped Nodes: ");
        tree.printInOrder(root);  // Output will show the tree is incorrect

        // Correct the BST
        tree.correctBST(root);

        System.out.print("\nIn-order Traversal of Corrected BST: ");
        tree.printInOrder(root);  // Output will show the corrected BST
    }
}

 class InOrderTraversal {
    public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    static void modifyIndex(int[] array){
//        array[0] += 2;
//    }
//    static void function(int i){
//        i += 2;
//    }
static void inOrderTraversal(TreeNode root,List<Integer> list){
    if (root == null)return;
    inOrderTraversal(root.left,list);
    list.add(root.val);
    inOrderTraversal(root.right,list);
}
    public static void main(String[] args) {

//        int[] index = new int[]{1};
//        System.out.println(index[0]);
//        modifyIndex(index);
//        System.out.println(index[0]);
//        modifyIndex(index);
//        System.out.println(index[0]);
//        int i = 2;
//        System.out.println(i);
//function(i);
//        System.out.println(i);
TreeNode root = new TreeNode(12);
TreeNode a = new TreeNode(9);
TreeNode b = new TreeNode(6);
TreeNode c = new TreeNode(11);
root.left = a;
a.left = b;
a.right = c;
List<Integer> list1 = new LinkedList<>();
inOrderTraversal(root,list1);
        System.out.println(list1);
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}