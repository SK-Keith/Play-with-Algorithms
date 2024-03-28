package minMax;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author MX.Y
 * @DATE 2021/11/24 22:38
 * @qq 2690399241
 */
public class TreeUtils {

    /**
     * 插入新结点          输入父结点id进行定位 ，将新结点 插入到父结点的 sonList 中
     *
     * @param changeNode 传入根结点,传入前需判断:若根结点不存在，待插入结点成为根结点，不必进入此方法
     * @param fatherId   新结点的 父结点id
     * @param newNode    新结点
     */
    public void insert(Node changeNode, String fatherId, Node newNode) {
        if (fatherId.equals(changeNode.getId())) {
            changeNode.getSonList().add(newNode);
            return;
        }

        List<Node> sonList = changeNode.getSonList();
        if (sonList == null || sonList.isEmpty()) {
            return;                            //若该结点 的子结点集合为空 返回
        } else {

            for (int i = 0; i < sonList.size(); i++) {
                insert(sonList.get(i), fatherId, newNode);
            }
        }

    }

    /**
     * 遍历结点 并打印. 同时按每个结点所在深度 在结点前打印不同长度的空格
     *
     * @param changeNode 根结点
     * @param depth      结点深度：1
     */
    public void queryAll(Node changeNode) {
        List<Node> sonList = changeNode.getSonList();
//        String space = generateSpace(depth);    //根据深度depth,返回(depth*3)长度的空格

        if (sonList == null || sonList.isEmpty()) {
            System.out.println(changeNode.getMsg());
            return;
        }
        for (int i = 0; i < sonList.size(); i++) {
            String msg = Optional.ofNullable(changeNode.getMsg()).orElse("");
            msg += changeNode.getId() +"->" + sonList.get(i).getId()+";";
            sonList.get(i).setMsg(msg);
            queryAll(sonList.get(i));
        }

    }

    /**
     * 删除结点   注意:先判断 是否在删除 根结点. 若删除根结点,不必进入此方法 直接为null即可
     *
     * @param changeNode 根结点
     * @param id         待删除结点id
     */
    public void delete(Node changeNode, String id) {
        List<Node> sonList = changeNode.getSonList();

        if (sonList == null || sonList.isEmpty()) {
            return;
        } else {

            for (int i = 0; i < sonList.size(); i++) {

                if (id.equals(sonList.get(i).getId())) {
                    sonList.remove(i);
                    delete(new Node(), id);
                    break;
                } else {
                    delete(sonList.get(i), id);
                }

            }
        }

    }

    /**
     * 根据结点id  修改结点 name       //同理可根据结点name修改结点id
     *
     * @param changeNode 根结点
     * @param id         结点id
     * @param name       修改后的 新name
     */
    public void update(Node changeNode, String id, String name) {
        if (changeNode.getId().equals(id)) {
            changeNode.setName(name);
            return;
        }

        List<Node> sonList = changeNode.getSonList();
        if (sonList == null || sonList.isEmpty()) {
            return;
        } else {

            for (int i = 0; i < sonList.size(); i++) {
                update(sonList.get(i), id, name);
            }
        }

    }

    /**
     * 查询 某个结点 到根结点的路径
     *
     * @param changeNode 根结点
     * @param name       待查找的结点 name
     * @param wayList    路径
     */
    public void queryWayById(Node changeNode, String name, ArrayList<String> wayList) {
        List<Node> sonList = changeNode.getSonList();

        wayList.add(changeNode.getName());
        if (sonList == null || sonList.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < sonList.size(); i++) {

                if (name.equals(sonList.get(i).getName())) {
                    for (int j = 0; j < wayList.size(); j++) {
                        System.out.print(wayList.get(j) + "->");
                    }
                    System.out.println(sonList.get(i).getName());
                    break;
                }
                queryWayById(sonList.get(i), name, wayList);

            }
        }

    }



    //打印空格
    public static String generateSpace(int count) {
        count = count * 3;
        char[] chs = new char[count];
        for (int i = 0; i < count; i++) {
            chs[i] = ' ';
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        TreeUtils t = new TreeUtils();
        List<Node> list = new ArrayList<>();
        Node node = new Node();
        node.setId("1");
        node.setName("aaa");
        node.setSonList(list);
        Node node1 = new Node();
        node1.setId("2");
        node1.setName("bbb");
        node1.setSonList(new ArrayList<>());

        Node node2 = new Node();
        node2.setId("3");
        node2.setName("ccc");
        node2.setSonList(new ArrayList<>());

        Node node3 = new Node();
        node3.setId("4");
        node3.setName("ddd");
        node3.setSonList(new ArrayList<>());

        Node node4 = new Node();
        node4.setId("5");
        node4.setName("eee");
        node4.setSonList(new ArrayList<>());

        Node node5 = new Node();
        node5.setId("6");
        node5.setName("fff");
        node5.setSonList(new ArrayList<>());

        t.insert(node, "1", node1);
        t.insert(node, "1", node2);
        t.insert(node1, "2", node3);
        t.insert(node1, "2", node4);
        t.insert(node1, "2", node5);

        t.queryAll(node);
    }
}
