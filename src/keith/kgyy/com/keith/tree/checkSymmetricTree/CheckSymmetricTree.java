package kgyy.com.keith.tree.checkSymmetricTree;

import kgyy.com.keith.tree.TreeNode;

/**
 * 145. https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * @author yaomianxian
 * @date 2025/11/17 0017 13:58
 */
public class CheckSymmetricTree {
    public boolean checkSymmetricTree(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
