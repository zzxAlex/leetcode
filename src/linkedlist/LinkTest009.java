package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * https://www.bilibili.com/video/BV1eg411w7gn?p=19&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 *给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class LinkTest009 {
    private ListNode solution(ListNode head, int k) {
        List<ListNode> temp = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            temp.add(cur);
            cur = cur.next;
        }
        int x = temp.size()  - k;
        return temp.get(x);
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(3);
        node1.add(4);
        node1.add(5);
        node1.add(6);

        int k = 3;
        new LinkTest009().solution(node1, k).print();
    }
}
