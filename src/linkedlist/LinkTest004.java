package linkedlist;

import javax.print.attribute.standard.NumberUp;
import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表2
 *给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 */
public class LinkTest004 {

    private ListNode solution(ListNode head) {
        Map<ListNode, Integer> tempMap = new HashMap<>();

        if (head==null) return null;
        int index = 0;

        while (head.next != null) {
            if (null!=tempMap.get(head)) {
                return head;
            }
            tempMap.put(head, index);
            head = head.next;
        }
        return null;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode solution = new LinkTest004().solution(node1);

        System.out.println(solution.val);
    }
}
