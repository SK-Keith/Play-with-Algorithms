package kgyy.com.keith.tree.inorder;

import kgyy.com.keith.tree.Preorder;
import kgyy.com.keith.tree.TreeNode;

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

        // 20251117
        System.out.println("-------------------20251117--------------------");
        Inorder20251117 inorder20251117 = new Inorder20251117();
        List<Integer> inorder = inorder20251117.inorder(root);
        System.out.println(inorder);

        System.out.println("------------------------递归---------------------------");
        System.out.println("-------------------202511172--------------------");
        Inorder202511172 inorder202511172 = new Inorder202511172();
        List<Integer> inorder2 = inorder202511172.inorder(root);
        System.out.println(inorder2);

        System.out.println("--------preorder-----------202511172--------------------");
        List<Integer> inorder2p = inorder202511172.preorder(root);
        System.out.println(inorder2p);

        System.out.println("------------------------迭代---------------------------");
        System.out.println("-------------------202511173--------------------");
        Inorder202511173 inorder202511173 = new Inorder202511173();
        List<Integer> inorder3 = inorder202511173.inorder(root);
        System.out.println(inorder3);

        System.out.println("--------------preorder-----202511173--------------------");
        List<Integer> inorder3p = inorder202511173.preorder(root);
        System.out.println(inorder3p);

    }
}
