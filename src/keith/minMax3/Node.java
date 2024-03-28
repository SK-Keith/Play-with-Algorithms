package minMax3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MX.Y
 * @DATE 2021/11/24 22:38
 * @qq 2690399241
 */
public class Node {
    private Integer whichOne;
    private Integer currVal;        //当前值，即父节点
    private Integer lastVal;        //上个值
    private List<Node> sonList = new ArrayList<>(); //该结点的 子结点集合
    private String msg;         //叶子结点上拼接的数据
    private String indexs;   //叶子节点上存储的节点序号

    public Integer getWhichOne() {
        return whichOne;
    }

    public void setWhichOne(Integer whichOne) {
        this.whichOne = whichOne;
    }

    public Integer getCurrVal() {
        return currVal;
    }

    public void setCurrVal(Integer currVal) {
        this.currVal = currVal;
    }

    public Integer getLastVal() {
        return lastVal;
    }

    public void setLastVal(Integer lastVal) {
        this.lastVal = lastVal;
    }

    public List<Node> getSonList() {
        return sonList;
    }

    public void setSonList(List<Node> sonList) {
        this.sonList = sonList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIndexs() {
        return indexs;
    }

    public void setIndexs(String indexs) {
        this.indexs = indexs;
    }
}
