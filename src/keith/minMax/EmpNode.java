package minMax;

/**
 * @author MX.Y
 * @DATE 2021/11/24 19:22
 * @qq 2690399241
 */
public class EmpNode {

    // 节点值
    public int value;

    //节点下标
    public int index;

    //下一个节点
    public EmpNode next;

    //上一个节点
    public EmpNode pre;

    @Override
    public String toString() {
        return "EmpNode{" +
                "value=" + value +
                ", index=" + index +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public EmpNode getNext() {
        return next;
    }

    public void setNext(EmpNode next) {
        this.next = next;
    }

    public EmpNode getPre() {
        return pre;
    }

    public void setPre(EmpNode pre) {
        this.pre = pre;
    }
}
