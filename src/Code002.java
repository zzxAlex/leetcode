/**
 * 乐扣002
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 */
public class Code002 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curNode = result;
        int addNum;//位数
        int carry = 0;//进位数

        while (null != l1 || null != l2) {
            addNum = carry + l1.val + l2.val;
            System.out.println("addNum=" + addNum);
            if (addNum >= 10) {
                carry = addNum /10;
                addNum = addNum %10;
            }
            l1 = l1.next;
            l2 = l2.next;

            if (null == curNode) {
                curNode = new ListNode(addNum);
            } else {
                curNode.next = new ListNode(addNum);
            }
            curNode = curNode.next;

        }
        return result.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode4.next = listNode5;
        listNode5.next = listNode6;


        ListNode p = listNode1;
        ListNode q = listNode4;
        do {
            System.out.print(p.val + " ");
            p = p.next;
        } while (p != null);
        System.out.println(" ");
        do {
            System.out.print(q.val + " ");
            q = q.next;
        } while (q != null);
        System.out.println(" ");

        ListNode resultNode = new Code002().addTwoNumbers(listNode1, listNode4);

        do {
            System.out.print(" "+resultNode.val);
            resultNode = resultNode.next;
        }while (resultNode != null);

    }


}