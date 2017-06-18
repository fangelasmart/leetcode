package category;

/**
 * linkedlist operation
 * Created by angela on 17/6/18.
 */
public class LinkedlistOperation {


    /**
     * append value after node
     *
     * @param node
     * @param value
     * @return
     */
    public static void append(ListNode node, int value) {
        if (node == null) {
            return;
        }
        ListNode next = new ListNode(value);
        node.next = next;
    }

    /**
     * remove node which contains value
     * (default one node)
     *
     * @param node
     * @param value
     */
    public static void remove(ListNode node, int value) {

        while (node.next != null) {
            if (node.next.val == value) {
                node = node.next.next;
            }
        }


    }

    /**
     * insert value after place
     *
     * @param node
     * @param place
     * @param value
     */
    public static void insert(ListNode node, int place, int value) {
        int i = 1;
        while (node != null) {
            if (i == place) {
                ListNode current = new ListNode(value);
                current.next = node.next;
                node.next = current;
                break;
            }
            i++;
        }


    }

    /**
     * return node which contains given value
     *
     * @param node
     * @param value
     * @return
     */
    public static ListNode find(ListNode node, int value) {
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

}
