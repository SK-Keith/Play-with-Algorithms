package kgyy.com.keith.tree.checkSymmetricTree;

import kgyy.com.keith.tree.TreeNode;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/17 0017 20:05
 */
public class Demo {

    public static void main(String[] args) {
        // 对称二叉树例子：
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 4  3
        TreeNode symmetricTree = new TreeNode(1);
        symmetricTree.left = new TreeNode(2);
        symmetricTree.right = new TreeNode(2);
        symmetricTree.left.left = new TreeNode(3);
        symmetricTree.left.right = new TreeNode(4);
        symmetricTree.right.left = new TreeNode(4);
        symmetricTree.right.right = new TreeNode(3);
        CheckSymmetricTree c = new CheckSymmetricTree();
        System.out.println(c.checkSymmetricTree(symmetricTree)); // true

        // 不对称二叉树例子：
        //       1
        //      / \
        //     2   2
        //      \   \
        //       3   3
        TreeNode asymmetricTree = new TreeNode(1);
        asymmetricTree.left = new TreeNode(2);
        asymmetricTree.right = new TreeNode(2);
        asymmetricTree.left.right = new TreeNode(3);
        asymmetricTree.right.right = new TreeNode(3);

        System.out.println(c.checkSymmetricTree(asymmetricTree)); // false
    }
}
