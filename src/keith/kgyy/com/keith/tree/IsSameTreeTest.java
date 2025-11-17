package kgyy.com.keith.tree;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/10 0010 14:40
 */
public class IsSameTreeTest {

    public static void main(String[] args) {
        // Test case with identical trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
//        TreeNode tree44 = new TreeNode(4);
//        tree2.left.left = tree44;

        System.out.println("Test Case 1: Identical Trees");
        System.out.println("Are the trees the same? " + SameTree.isSameTree(tree1, tree2));

        // Test case with different trees
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(3);

        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(4);

        System.out.println("\nTest Case 2: Different Trees");
        System.out.println("Are the trees the same? " + SameTree.isSameTree(tree3, tree4));
    }

}
