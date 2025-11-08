package com.keith.listNode.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 13:30
 */
public class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}
