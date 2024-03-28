package guangdusousuo.tree;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MX.Y
 * @DATE 2023-01-10 17:21
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 初始化队列同时将第一层节点加入到队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的while循环迭代的是层数
        while(!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for(int i = 0;i<size;i++) {

                // 从队首取出元素
                Node node = queue.poll();// 取出而且会删 1 2 3 4 5 6 7

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();// 取出但不会删 3 5 6 7
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);// 2 4 6
                }
                if (node.right != null) {
                    queue.add(node.right);// 3 5 7
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        Connect c = new Connect();
        Node connect = c.connect(node1);
        System.out.println(connect);
    }
}
