package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * https://www.bilibili.com/video/BV1eg411w7gn?p=15&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 *
 */
public class LinkTest005 {
    private ListNode solution(ListNode headA,ListNode headB){
        Set<ListNode> tempSet = new HashSet<>();
        ListNode aIndex = headA;
        ListNode bIndex = headB;

        if (headA == null || headB == null) {

            return null;
        }
        if (headA == headB) {
            return headA;
        }
        while (aIndex!= null) {
            tempSet.add(aIndex);
            aIndex = aIndex.next;
        }
        while (bIndex != null) {
            if (!tempSet.add(bIndex)) {
                return bIndex;
            }
            bIndex = bIndex.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        ListNode solution = new LinkTest005().solution(node1, node1);

        solution.print();
    }
}
