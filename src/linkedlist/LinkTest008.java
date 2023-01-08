package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * https://www.bilibili.com/video/BV1eg411w7gn?p=18&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class LinkTest008 {

    private ListNode solution(ListNode head) {
        List<ListNode> temp = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            temp.add(cur);
            cur = cur.next;
        }
        return temp.get(temp.size() / 2);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        node1.add(1);
        node1.add(2);
        node1.add(3);
        node1.add(4);
        System.out.println(new LinkTest008().solution(node1).val);

        System.out.println(4/2);
        System.out.println(5/2);

    }
}
