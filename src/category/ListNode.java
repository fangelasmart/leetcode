package category;

/**
 * Created by angela on 17/6/17.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * get size
     *
     * @return
     */
    public int size() {
        int i = 1;
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
            i++;
        }
        return i;
    }


}
