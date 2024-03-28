package minMax3;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public void insert(Node changeNode, Integer fatherId, Node newNode) {
        if (fatherId == changeNode.getCurrVal()) {
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
     */
    public void queryAll(Node changeNode, int V, int M, int[] v, int[] m) {
        List<Node> sonList = changeNode.getSonList();
//        String space = generateSpace(depth);    //根据深度depth,返回(depth*3)长度的空格

        if (sonList == null || sonList.isEmpty()) {
            String[] split = changeNode.getIndexs().substring(1).split(",");
            int weightSum = 0, volumnSum = 0;
            for (String s : split) {
                Integer i = Integer.parseInt(s);
                volumnSum += v[i];
                weightSum += m[i];
            }
            System.out.print(changeNode.getMsg() + "\t物品序号为：" + changeNode.getIndexs().substring(1));
            System.out.print("\t，展开分析总体积为：" + volumnSum + "，总重量为：" + weightSum + "，总价值为：" + getValue(changeNode.getMsg()));
            if (volumnSum < V && weightSum < M) {
                System.out.println();
            } else {
                System.out.println("，超过重量或体积限定值");
            }
            return;
        }
        for (int i = 0; i < sonList.size(); i++) {
            String msg = Optional.ofNullable(changeNode.getMsg()).orElse("");
            msg += changeNode.getCurrVal() +"->" + sonList.get(i).getCurrVal()+";";
            String indexs = Optional.ofNullable(changeNode.getIndexs()).orElse("");
            indexs = indexs + "," + sonList.get(i).getWhichOne();

            sonList.get(i).setMsg(msg);
            sonList.get(i).setIndexs(indexs);
            queryAll(sonList.get(i), V, M, v, m);
        }

    }

    /**
     * 删除结点   注意:先判断 是否在删除 根结点. 若删除根结点,不必进入此方法 直接为null即可
     *
     * @param changeNode 根结点
     * @param id         待删除结点id
     */
    public void delete(Node changeNode, String id) {
//        List<Node> sonList = changeNode.getSonList();
//
//        if (sonList == null || sonList.isEmpty()) {
//            return;
//        } else {
//
//            for (int i = 0; i < sonList.size(); i++) {
//
//                if (id.equals(sonList.get(i).getId())) {
//                    sonList.remove(i);
//                    delete(new Node(), id);
//                    break;
//                } else {
//                    delete(sonList.get(i), id);
//                }
//
//            }
//        }

    }

    /**
     * 根据结点id  修改结点 name       //同理可根据结点name修改结点id
     *
     * @param changeNode 根结点
     * @param id         结点id
     * @param name       修改后的 新name
     */
    public void update(Node changeNode, String id, String name) {
        /*if (changeNode.getId().equals(id)) {
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
        }*/

    }

    /**
     * 查询 某个结点 到根结点的路径
     *
     * @param changeNode 根结点
     * @param name       待查找的结点 name
     * @param wayList    路径
     */
    public void queryWayById(Node changeNode, String name, ArrayList<String> wayList) {
        /*List<Node> sonList = changeNode.getSonList();

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
        }*/

    }

    private static int getValue(String msg) {
        String[] split = msg.split(";");
        int valueSum = 0;
        for (String s : split) {
            String[] split1 = s.split("->");
            valueSum += Integer.parseInt(split1[1]);
        }
        return valueSum;
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
        Node node = new Node();
        node.setCurrVal(0);
//        node.setName("aaa");

        Node node1 = new Node();
        node1.setWhichOne(1);
        node1.setLastVal(0);
        node1.setCurrVal(2);


        Node node2 = new Node();
        node2.setWhichOne(2);
        node2.setLastVal(2);
        node2.setCurrVal(4);

        Node node3 = new Node();
        node3.setWhichOne(2);
        node3.setLastVal(0);
        node3.setCurrVal(4);

        Node node4 = new Node();
        node4.setWhichOne(3);
        node4.setLastVal(2);
        node4.setCurrVal(6);

        Node node5 = new Node();
        node5.setWhichOne(3);
        node5.setLastVal(0);
        node5.setCurrVal(6);

        Node node6 = new Node();
        node6.setWhichOne(4);
        node6.setLastVal(6);
        node6.setCurrVal(3);

        Node node7 = new Node();
        node7.setWhichOne(4);
        node7.setLastVal(4);
        node7.setCurrVal(3);

        Node node8 = new Node();
        node8.setWhichOne(4);
        node8.setLastVal(0);
        node8.setCurrVal(3);

        t.insert(node, node1.getLastVal(), node1);
        t.insert(node, node2.getLastVal(), node2);
        t.insert(node, node3.getLastVal(), node3);
        t.insert(node, node4.getLastVal(), node4);
        t.insert(node, node5.getLastVal(), node5);
        t.insert(node, node6.getLastVal(), node6);
        t.insert(node, node7.getLastVal(), node7);
        t.insert(node, node8.getLastVal(), node8);
//        t.insert(node, node.getId(), node2);
//        t.insert(node1, "2", node3);
//        t.insert(node1, "2", node4);
//        t.insert(node1, "2", node5);

//        t.queryAll(node);// todo 重量体积等参数
    }



}
