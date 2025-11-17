package kgyy.com.keith.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/10 0010 14:17
 */
public class Inorder {

    /**
     * 在逻辑上是正确的，但会因为递归的特性导致一定的效率问题。具体来说，它的时间复杂度会受到 addAll 方法的影响。
     * 这里 addAll 在每次递归时都会创建新的 List 并把它合并到结果列表中，增加了不必要的内存开销和操作次数，使得整体复杂度超过了O(n)。
     * @param root
     * @return
     */
    public static List<Integer> travelsal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(travelsal(root.left));
        res.add(root.val);
        res.addAll(travelsal(root.right));
        return res;
    }


    public static List<Integer> travelsal3(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        inorder(treeNode, res);
        return res;
    }

    private static void inorder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left, res);
        res.add(treeNode.val);
        inorder(treeNode.right, res);
    }

    static LinkedList<Integer> res = new LinkedList<>();

    public static List<Integer> travelsal2(TreeNode root) {
        travelse(root);
        return res;
    }

    public static void travelse(TreeNode root) {
        if (root == null) {
            return;
        }
        travelse(root.left);
        res.add(root.val);
        travelse(root.right);
    }

}
