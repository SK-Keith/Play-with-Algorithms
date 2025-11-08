package com.keith.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/7 0007 14:23
 */
public class Merge {

    public static Node mergeList(Node node1, Node node2) {
        Node node = new Node(-1);
        Node temp = node;
        while(node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        node.next = node1 == null ? node2 : node1;
        return temp.next;
    }
}
