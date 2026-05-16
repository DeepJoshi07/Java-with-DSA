import java.util.NoSuchElementException;

public class LinkedList_Java {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public static Node head;
    public static Node tail;
    public int size;

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
        while(i < size-2){
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
        // LinkedList_Java ll2 = new LinkedList_Java();
        // ll2.addFirst(3);
        // ll2.addFirst(2);
        // ll2.addFirst(1);
        // System.out.println(ll2.size);
        System.out.println(ll.removeFirst());
        ll.printList();
        System.out.println(ll.removeLast());
        ll.printList();

    }
}
