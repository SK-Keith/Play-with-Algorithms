package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author MX.Y
 * @DATE 2023-01-09 21:22
 */
public class PrintUtils {
    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //根节点入队
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//队首元素出队
                //以下代码是不打印null节点
//                temp.add(node.val);
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
                //以下代码是打印null节点
                if (node != null) {
                    temp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    temp.add(-1);
                }
            }
        }
        for (int x : temp) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("-------------------");
    }


}
