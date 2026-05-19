public class Dobbly_Linkedlist {
    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }

    public Node head;
    public Node tail;
    public int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if(isEmpty()){
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static void main(String[] args) {

    }
}
