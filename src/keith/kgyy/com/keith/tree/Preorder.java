package kgyy.com.keith.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/10 0010 14:17
 */
public class Preorder {

    public static List<Integer> travelsal(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }
        int val = treeNode.val;
        list.add(val);
        list.addAll(travelsal(treeNode.left));
        list.addAll(travelsal(treeNode.right));
        return list;
    }

    public static List<Integer> travelsalWithStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            // 先右后左，保证左子树先遍历
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

}
