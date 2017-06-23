package main.java.category;

/**
 * 两个链表相加，大于0则进位
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Created by angela on 17/6/18.
 */
public class AddTwoNumbers_02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0); // 头结点
        ListNode tail = head;

        int carry = 0; // 初始进位
        int sum = 0;
        while (true) {
            int val1 = current(l1);
            l1 = nextNode(l1);
            int val2 = current(l2);
            l2 = nextNode(l2);
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode currentNode = new ListNode(sum);
            tail.next = currentNode;
            tail = tail.next;

            if (l1 == null && l2 == null && carry == 0) {
                break;
            }

        }
        return head.next;

    }

    public static int current(ListNode node) {
        if (node == null) {
            return 0;
        }

        int val = node.val;
        return val;
    }

    public static ListNode nextNode(ListNode l) {
        if (l == null) {
            return null;
        }

        return l.next;
    }


}
