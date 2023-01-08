package linkedlist;

/**
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LinkTest006 {

    private ListNode solution(ListNode head) {
        ListNode cur = head;
        ListNode preNode = null;
        ListNode curNext = new ListNode();
        while (cur != null) {
             curNext = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = curNext;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.add(1);
        node1.add(2);
        node1.add(3);
        node1.add(3);
        node1.add(4);
        node1.print();

        ListNode solution = new LinkTest006().solution(node1);

        solution.print();
    }
}
