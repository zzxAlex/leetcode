package linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * https://www.bilibili.com/video/BV1eg411w7gn?p=11&vd_source=3e80f41ba1bd675fc2cf6a0826786160
 */
public class LinkTest001 {

    private ListNode solution(ListNode node1, ListNode node2) {

        ListNode result = new ListNode(0);
        ListNode p = result;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if (node1 != null) {
            p.next = node1;
        }
        if (node2 != null) {
            p.next = node2;
        }

        return result.next;
    }

    /**
     * 递归实现
     * @param node1
     * @param node2
     * @return
     */
    private ListNode solution2(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            node1.next = solution2(node1.next, node2);
            return node1;
        }
        node2.next = solution2(node1, node2.next);
        return node2;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.add(2);
        node1.add(4);
        node1.print();
        System.out.println(";");
        ListNode node2 = new ListNode(1);
        node2.add(3);
        node2.add(4);
        node2.add(7);
        node2.add(10);
        node2.print();

        ListNode solution = new LinkTest001().solution2(node1, node2);
        System.out.println(";");
        solution.print();

    }
}
