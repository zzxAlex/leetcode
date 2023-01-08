package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *https://www.bilibili.com/video/BV1eg411w7gn?p=17&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 */
public class LinkTest007 {

    private boolean solution(ListNode head) {
        if (head == null) {
            return false;
        }
        List temp = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            temp.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = temp.size() - 1;
        while (left < right) {
            if (!temp.get(left).equals(temp.get(right))) {

                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(2);
        node1.add(1);
        node1.print();

        System.out.println(new LinkTest007().solution(node1));

    }
}
