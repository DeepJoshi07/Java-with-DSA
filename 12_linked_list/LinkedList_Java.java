import java.util.NoSuchElementException;
import java.util.LinkedList;

public class LinkedList_Java {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public boolean isEmpty() {
        return head == null;
    }

    // O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
        return;
    }

    // O(1)
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        size++;
        return;
    }

    // O(n)
    public void add(int idx, int data) {
        if (isEmpty() || idx == 0) {
            addFirst(data);
            return;
        } else if (idx == size) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return;
    }

    // O(1)
    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty!");
        }
        if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    // O(n)
    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        Node temp = head;
        int i = 0;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int data = temp.next.data;
        tail = temp;
        tail.next = null;
        size--;
        return data;
    }

    // O(n)
    public void printList() {
        if (isEmpty())
            return;
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // O(n)
    public int findTarget(int target) {
        if (isEmpty()) {
            return -1;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int findTargetRecursive(Node head, int target) {
        if (head == null)
            return -1;

        if (head.data == target) {
            return 0;
        }

        int idx = findTargetRecursive(head.next, target);

        if (idx != -1)
            return idx + 1;

        return -1;

    }

    // O(n)
    public void reverseLinkedList() {
        if (isEmpty() || size == 1)
            return;

        Node next;
        Node curr = tail = head;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // O(n)
    public int removeNthNodeFromEnd(int n) {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        if (n > size || n <= 0) {
            throw new IllegalArgumentException("invalid n");
        }
        if (n == size) {
            return removeFirst();
        }
        if (n == 1) {
            return removeLast();
        }

        int idx = size - n;
        int i = 1;
        Node temp = head;
        while (i < idx) {
            i++;
            temp = temp.next;
        }

        Node nth = temp.next;
        temp.next = temp.next.next;
        nth.next = null;
        size--;
        return nth.data;
    }

    public boolean isPalindrome(Node head) {
        if (isEmpty() || size == 1)
            return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        Node curr = slow;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node head2 = prev;
        Node temp = head;
        while (head2 != null) {
            // System.out.println(head2.data + ","+temp.data);
            if (head2.data != temp.data) {
                return false;
            }
            temp = temp.next;
            head2 = head2.next;
        }
        return true;
    }

    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(Node head) {
        if (head == null)
            return;

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle)
            return;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node cycleStart = slow;

        Node temp = cycleStart;
        while (temp.next != cycleStart) {
            temp = temp.next;
        }
        temp.next = null;
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node mid = findMid(head);

        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    private static Node merge(Node head1, Node head2) {
        Node mergedList = new Node(-1);
        Node temp = mergedList;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedList.next;
    }

    public static void zigZag(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow;
        prev.next = null;
        prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node rightHead = prev, leftHead = head;

        while (rightHead != null && leftHead != null) {
            Node nextLeft = leftHead.next;
            Node nextRight = rightHead.next;

            leftHead.next = rightHead;
            if (nextLeft == null)
                break;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        }
    }

    public static Node intersactionInLinkedlist(LinkedList_Java l1,LinkedList_Java l2){
        Node head1 = l1.head;
        Node head2;

        while(head1 != null){
            head2 = l2.head;
            while(head2 != null){
                if(head1 == head2){
                    return head1;
                }
                head2 = head2.next;
            }
        head1 = head1.next;
        }
        return null;
    }
    public static void main(String[] args) {
        LinkedList_Java ll = new LinkedList_Java();
        // 3,2,1,5,4
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(5);
        ll.addLast(4);
        ll.addFirst(3);
        ll.printList();
        ll.add(2, 6);
        ll.printList();
        System.out.println(ll.size);
        System.out.println("------------------");
        LinkedList_Java ll2 = new LinkedList_Java();
        ll2.addFirst(3);
        ll2.addFirst(2);
        ll2.addFirst(1);
        System.out.println(ll2.size);
        ll2.printList();
        System.out.println("-----------------");
        System.out.println(ll.removeFirst());
        ll.printList();
        System.out.println(ll.removeLast());
        ll.printList();
        System.out.println("---------------------- Question 1 -----------------------");
        System.out.println(ll.findTarget(6));
        System.out.println(ll.findTargetRecursive(ll.head, 5));
        System.out.println("---------------------- Question 2 -----------------------");
        ll.reverseLinkedList();
        ll.printList();
        System.out.println("---------------------- Question 3 -----------------------");
        ll.addFirst(12);
        System.out.println(ll.removeNthNodeFromEnd(2));
        ll.printList();
        System.out.println("---------------------- Question 4 -----------------------");
        LinkedList_Java ll3 = new LinkedList_Java();
        ll3.addFirst(1);
        ll3.addFirst(2);
        ll3.addFirst(3);
        ll3.addFirst(3);
        ll3.addFirst(2);
        ll3.addFirst(1);
        ll3.printList();
        System.out.println(ll3.isPalindrome(ll3.head));
        System.out.println("---------------------- Question 5 -----------------------");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(isCycle(head));
        System.out.println("---------------------- Question 6 -----------------------");
        removeCycle(head);
        System.out.println(isCycle(head));
        System.out.println("---------------------- Question 7 -----------------------");
        LinkedList_Java list = new LinkedList_Java();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.printList();
        list.head = mergeSort(list.head);
        list.printList();
        System.out.println("---------------------- Question 8 -----------------------");
        LinkedList_Java list2 = new LinkedList_Java();
        list2.addFirst(6);
        list2.addFirst(5);
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(2);
        list2.addFirst(1);
        list2.printList();
        zigZag(list2.head);
        list2.printList();
        System.out.println("---------------------- Question 9 -----------------------");
        LinkedList_Java llj = new LinkedList_Java();
        llj.head = new Node(6);
        llj.head.next = new Node(5);
        llj.head.next.next = new Node(4);
        llj.head.next.next.next = new Node(3);
        llj.head.next.next.next.next= new Node(2);
        llj.head.next.next.next.next.next = new Node(1);
        LinkedList_Java llj2 = new LinkedList_Java();
        llj2.head = new Node(6);
        llj2.head.next = new Node(5);
        llj2.head.next.next = new Node(4);
        llj2.head.next.next.next = llj.head.next.next.next;
        Node intersection = intersactionInLinkedlist(llj,llj2);
        System.out.println(intersection.data);
        System.out.println("---------------------- Question 10 -----------------------");
        System.out.println("---------------------- Question 11 -----------------------");
        System.out.println("---------------------- Question 12 -----------------------");
        System.out.println("---------------------- Question 13 -----------------------");

    }
}
