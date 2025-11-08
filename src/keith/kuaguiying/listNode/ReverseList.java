package com.keith.listNode;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/08/6 0006 19:52
 */
public class ReverseList {

    /**
     * 迭代方法反转链表
     * 初始化两个指针，
     *  prev:初始化为null，用于跟踪已反转部分链表的尾部,
     *  curr:初始化为head，用于遍历链表的当前节点
     * 遍历链表直至curr为null
     * 反转链表的核心
     *  1. 保存下一个节点
     *  2. 反转当前节点的指针
     *  3. 移动prev指针
     *  4. 移动curr指针
     * 返回反转后的新头结点prev
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
