package minMax2;

import java.util.List;

/**
 * @author MX.Y
 * @DATE 2021/11/24 23:13
 * @qq 2690399241
 */
public class TreeUtils {

    private Node root = new Node(0);    //树的根节点
    public int identifying = 1;  //用于记录树上的节点
    public int index = 0;		//用于遍历树的指针路过节点的个数
    //获取根节点
    public Node getRoot(){
        return this.root;
    }
    //添加方法重载
    public void add(int parentId,String data){
        this.add(parentId,data,this.getRoot().nodes);
    }
    //添加
    public void add(int parentId,String data,List<Node> list){
        if(parentId==0){	//如果父节点Id为0
            Node newNode = new Node(identifying++,data);
            this.root.nodes.add(newNode);
        }else {  //判空
            if(list.size()==0){
                return;
            }
            for(Node item:list){
                if(item.getId() == parentId){  //找到父节点
                    Node newNode = new Node(identifying++, data);
                    item.nodes.add(newNode); //节点添加
                    break;
                }else {
                    add(parentId,data,item.nodes);
                }
            }
        }

    }
    //遍历方法的重载
    public void list(){
        this.list(this.getRoot().nodes);
    }
    //循环Tree
    public void list(List<Node> list){
        index++;  //遍历次数，用于退出循环
        if(index == identifying){
            return;
        }
        for(Node item:list){
            System.out.print(item.getData() + "->");
            if(item.nodes.size() == 0){
                continue;
            }else {
                list(item.nodes);
            }
            System.out.println("\t");
        }
    }

    public static void main(String[] args) {
        TreeUtils tree = new TreeUtils();
        tree.add(0, "一级树杈1");
        tree.add(1, "二级树杈1");
        tree.add(1, "二级树杈2");
        tree.add(2, "二级树杈3");
        tree.add(6, "三级树杈1");
        tree.add(6, "三级树杈2");
        tree.list();

    }
}
