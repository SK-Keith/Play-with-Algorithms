package guangdusousuo.tree;

import tree.PrintUtils;
import tree.TreeNode;

/**
 * 深度优先搜索
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * @author MX.Y
 * @DATE 2023-01-09 21:17
 */
public class MergeTreee {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(3, new TreeNode(5), null);
        TreeNode node12 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node11, node12);
        PrintUtils.print(node1);

        TreeNode node21 = new TreeNode(1, null, new TreeNode(4));
        TreeNode node22 = new TreeNode(3, null, new TreeNode(7));
        TreeNode node2 = new TreeNode(2, node21, node22);
        PrintUtils.print(node2);

        MergeTreee m = new MergeTreee();
        TreeNode node = m.mergeTrees(node1, node2);
        PrintUtils.print(node);
    }
}
