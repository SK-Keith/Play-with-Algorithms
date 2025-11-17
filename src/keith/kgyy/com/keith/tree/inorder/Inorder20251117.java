package kgyy.com.keith.tree.inorder;

import kgyy.com.keith.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/17 0017 14:02
 */
public class Inorder20251117 {

    public List<Integer> inorder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        inorderRes(node, res);
        return res;
    }

    private void inorderRes(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderRes(node.left, res);
        res.add(node.val);
        inorderRes(node.right, res);
    }


}
