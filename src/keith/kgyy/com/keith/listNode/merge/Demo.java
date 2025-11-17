package kgyy.com.keith.listNode.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/7 0007 14:30
 */
public class Demo {
    public static void main(String[] args) {
        // Create two sorted linked lists
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(5);

        Node node2 = new Node(2);
        node2.next = new Node(4);
        node2.next.next = new Node(6);

        // Merge the two lists
        Node mergedList = MergeListNode20250210.merge2(node1, node2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
