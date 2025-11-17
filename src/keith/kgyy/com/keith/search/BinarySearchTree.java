package kgyy.com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/20 0020 14:28
 */
public class BinarySearchTree {
    // 根节点
    private TreeNode root;

    // 插入节点
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        // 如果树为空，返回一个新节点
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        // 否则，递归下去
        if (val < root.val) {
            root.left = insertRec(root.left, val);  // 插入到左子树
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);  // 插入到右子树
        }

        return root;  // 返回当前节点
    }

    // 查找节点
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode root, int val) {
        // 基本情况：如果树为空或节点值等于目标值
        if (root == null) {
            return false;
        }
        if (val == root.val) {
            return true;
        }

        // 如果目标值小于当前节点值，则搜索左子树
        if (val < root.val) {
            return searchRec(root.left, val);
        }

        // 如果目标值大于当前节点值，则搜索右子树
        return searchRec(root.right, val);
    }

    // 删除节点
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode root, int val) {
        // 如果树为空
        if (root == null) {
            return root;
        }

        // 查找要删除的节点
        if (val < root.val) {
            root.left = deleteRec(root.left, val);  // 递归查找左子树
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);  // 递归查找右子树
        } else {
            // 找到了要删除的节点
            if (root.left == null) {
                return root.right;  // 只有右子树或无子树
            } else if (root.right == null) {
                return root.left;  // 只有左子树
            }

            // 如果节点有两个子节点，找到右子树的最小值（即中序后继）
            root.val = minValue(root.right);
            root.right = deleteRec(root.right, root.val);  // 删除最小值节点
        }

        return root;
    }

    // 获取右子树的最小值（用于删除节点时替换节点值）
    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    // 中序遍历
    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);  // 遍历左子树
            System.out.print(root.val + " ");  // 打印当前节点值
            inorderRec(root.right);  // 遍历右子树
        }
    }
}

