package main.java.category;

/**
 * Created by angela on 17/6/18.
 */
public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node1;
        node1.next =node2;
        LinkedlistOperation.insert(node,2,5);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
