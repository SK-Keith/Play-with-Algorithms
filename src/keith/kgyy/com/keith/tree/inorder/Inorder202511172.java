package kgyy.com.keith.tree.inorder;

import kgyy.com.keith.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/17 0017 19:30
 */
public class Inorder202511172 {

    public List<Integer> inorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        inorders(node, res);
        return res;
    }

    private void inorders(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorders(node.left, res);
        res.add(node.val);
        inorders(node.right, res);
    }

    public List<Integer> preorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        preorders(node, res);
        return res;
    }

    private void preorders(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorders(node.left, res);
        preorders(node.right, res);
    }
}
