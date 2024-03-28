package minMax;

import java.util.List;

/**
 * @author MX.Y
 * @DATE 2021/11/24 22:38
 * @qq 2690399241
 */
public class Node {
    private String id;          //结点id
    private String name;        //结点名称
    private List<Node> sonList; //该结点的 子结点集合
    private String msg;         //叶子结点上拼接的数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
