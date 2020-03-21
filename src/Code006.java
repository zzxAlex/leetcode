/**
 * 链表的反转
 */

public class Code006 {
    public class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public static Node ReverseList(Node head) {
        if (head == null) {
            return null;
        }

        Node reverseHead = null;


        // 指针1：当前节点
        Node currentNode = head;
        // 指针2：当前节点的前一个节点
        Node prevNode = null;

        while (currentNode != null) {
            // 指针3：当前节点的后一个节点
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                reverseHead = currentNode;
            }
            // 将当前节点的后一个节点指向前一个节点
            currentNode.next = prevNode;
            // 将前一个节点指向当前节点
            prevNode = currentNode;
            // 将当前节点指向后一个节点
            currentNode = nextNode;
        }

        return reverseHead;
    }

}
