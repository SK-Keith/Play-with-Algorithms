package kgyy.com.keith.listNode.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 13:31
 */
public class Merge {
    /**
     * 创建一个哨兵节点：
     * 初始化临时变量：
     * 遍历两个链表：
     *  比较两个节点的值：
     * 移动哨兵节点：
     * 循环结束后处理剩余的节点：
     * 返回合并后的链表：
     * @param list1
     * @param list2
     * @return
     */
    public static Node merge(Node list1, Node list2) {
        Node node = new Node(-1);
        Node temp = node;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2 : list1;
        return temp.next;
    }

    public static Node merge2(Node list1, Node list2) {
        Node node = new Node(-1);
        Node temp = node;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2 : list1;
        return temp.next;
    }
}
