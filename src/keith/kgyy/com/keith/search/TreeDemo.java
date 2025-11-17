package kgyy.com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/20 0020 14:29
 */
public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 插入节点
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // 中序遍历：输出排序的元素
        System.out.print("Inorder traversal: ");
        bst.inorderTraversal();  // 输出: 20 30 40 50 60 70 80

        System.out.println();

        // 查找元素
        System.out.println("Search 40: " + bst.search(40));  // true
        System.out.println("Search 100: " + bst.search(100));  // false

        // 删除元素
        bst.delete(20);  // 删除叶子节点
        bst.delete(30);  // 删除有一个子节点的节点
        bst.delete(50);  // 删除有两个子节点的节点

        System.out.print("Inorder traversal after deletion: ");
        bst.inorderTraversal();  // 输出: 40 60 70 80
    }
}
