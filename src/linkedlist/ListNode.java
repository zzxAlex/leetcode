package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(int num) {
        ListNode nextNode = new ListNode(num);
        if (this.next == null) {
            this.next = nextNode;
        } else
            this.next.add(num);

    }

    public void print() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("->");
            this.next.print();
        }
    }

}
