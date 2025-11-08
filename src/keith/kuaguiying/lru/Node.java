package com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/03/27 0027 14:36
 */
public class Node {

    public Integer key, val;

    public Node prev, next;

    public Node(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }
}
