package linkedlist;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * https://www.bilibili.com/video/BV1eg411w7gn?p=12&spm_id_from=pageDriver&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class LinkTest002 {

    private ListNode solution(ListNode node) {
        ListNode p = node;
        if (node == null) {
            return null;
        }
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }

        }

        return node;
    }


    private ListNode solution2(ListNode node) {
        if (node == null || node.next == null) return node;
        node.next = solution2(node.next);
        return node.val == node.next.val ? node.next : node;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.add(1);
        node1.add(2);
        node1.add(3);
        node1.add(3);
        node1.add(4);
        node1.print();
        System.out.println(";");

        ListNode solution = new LinkTest002().solution2(node1);

        solution.print();

    }
}
