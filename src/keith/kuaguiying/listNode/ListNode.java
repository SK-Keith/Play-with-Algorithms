package com.keith.listNode;

import lombok.Data;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/08/6 0006 19:16
 */
@Data
public class ListNode {

    public Integer val;

    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }
}
