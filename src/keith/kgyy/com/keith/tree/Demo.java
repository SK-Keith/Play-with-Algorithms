package kgyy.com.keith.tree;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/10 0010 14:24
 */
public class Demo {

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Perform inorder traversal
        List<Integer> result = Inorder.travelsal3(root);

        // Print the result
        System.out.println("Inorder Traversal Result: " + result);

        // Perform inorder traversal
        result = Preorder.travelsal(root);

        // Print the result
        System.out.println("Preorder Traversal Result: " + result);

        result = Inorder.travelsal2(root);
        System.out.println("Inorder Traversal Result: " + result);

        // preOrder with stack
        result = Preorder.travelsalWithStack(root);
        System.out.println("Preorder Traversal with stack Result: " + result);



    }
}
