package learnAlg;


public class DoubleListCross {

    public static ListNode getIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        int i = 0;
        while (!node1.equals(node2)) {
            node1 = node1.next;
            node2 = node2.next;

            if (node1 == null) {
                i++;
                node1 = headB;
                if (i > 1) {
                    node1 = null;
                    break;
                }
            }


            if (node2 == null)
                node2 = headA;

            if (node1.equals(node2))
                return node1;

        }

        return node1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        ListNode head = head1;

        for (int i = 6; i < 15; i++) {
            head.setNext(new ListNode(i));
            head = head.next;
        }
        head = head1;
        do {
            System.out.println(head.data);
            head = head.next;
        } while (head != null);


        ListNode head2 = new ListNode(3);
        head = head2;
        for (int i = 10; i < 30; i = i+7) {
            head.setNext(new ListNode(i));
            head = head.next;
        }
        head = head2;
        do {
            System.out.println(head.data);
            head = head.next;
        } while (head != null);


        ListNode node = getIntersection(head1, head2);
        
        if (node != null)
            System.out.println(node.data);
    }

}


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListNode)
            return this.data == ((ListNode) obj).data;
        return false;

    }
}
