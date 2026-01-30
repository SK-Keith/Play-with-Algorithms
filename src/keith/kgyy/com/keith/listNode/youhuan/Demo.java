package kgyy.com.keith.listNode.youhuan;

import kgyy.com.keith.listNode.ListNode;

public class Demo {
    /**
     * 工具方法：创建有环链表用于测试
     * @param values 节点值数组
     * @param pos 环的连接点位置（从0开始索引，-1表示无环）
     * @return 链表头节点
     */
    public static ListNode createLinkedListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        // 创建环
        if (pos >= 0 && pos < values.length) {
            nodes[values.length - 1].next = nodes[pos];
        }

        return nodes[0];
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        Youhuan Youhuan = new Youhuan();

        // 测试用例1：有环
        int[] values1 = {3, 2, 0, -4};
        int pos1 = 1; // 环的连接点在索引1（值为2的节点）
        ListNode head1 = createLinkedListWithCycle(values1, pos1);

        ListNode entry1 = Youhuan.cycle(head1);
        if (entry1 != null) {
            System.out.println("测试用例1 - 环的连接点值为: " + entry1.val);
        } else {
            System.out.println("测试用例1 - 链表无环");
        }

        // 测试用例2：有环，环连接点是头节点
        int[] values2 = {1, 2};
        int pos2 = 0; // 环的连接点在头节点
        ListNode head2 = createLinkedListWithCycle(values2, pos2);

        ListNode entry2 = Youhuan.cycle(head2);
        if (entry2 != null) {
            System.out.println("测试用例2 - 环的连接点值为: " + entry2.val);
        } else {
            System.out.println("测试用例2 - 链表无环");
        }

        // 测试用例3：无环
        int[] values3 = {1, 2, 3, 4};
        int pos3 = -1; // 无环
        ListNode head3 = createLinkedListWithCycle(values3, pos3);

        ListNode entry3 = Youhuan.cycle(head3);
        if (entry3 != null) {
            System.out.println("测试用例3 - 环的连接点值为: " + entry3.val);
        } else {
            System.out.println("测试用例3 - 链表无环");
        }
    }
    
}
