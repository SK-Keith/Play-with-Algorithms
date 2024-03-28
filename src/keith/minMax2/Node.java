package minMax2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author MX.Y
 * @DATE 2021/11/24 23:12
 * @qq 2690399241
 */
public class Node {
    private int Id;    //节点Id
    private String data; //节点数据
    public List<Node> nodes = new ArrayList<Node>(); //多个子节点，利用List实现

    public Node(int id) {
        Id = id;
    }

    public Node(int id, String data) {
        Id = id;
        this.data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
